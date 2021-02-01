package com.baidu.live.adp.lib.lbs;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.R;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class BdLocationMananger {
    private static final int APP_STOP_LOCATION_SERVICE = 0;
    public static final String BAIDU_MAP_API_FORMAT = "http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s";
    private static final long DEFAULT_LOCATION_EXPIRATION = 300000;
    public static final int HUN_METERS = 100;
    public static final int LOC_ALL_OFF = 3;
    public static final int LOC_GPS_OFF = 1;
    public static final int LOC_NET_OFF = 2;
    public static final int LOC_NO_LOCATION_PROVIDER = 6;
    public static final int LOC_OK = 0;
    public static final int LOC_OUT_TIME = 4;
    public static final int LOC_UNKONWN_ERROR = 5;
    private static final int MAX_CALLBACK_NUM = 100;
    public static final int TEN_SECONDS = 10000;
    private static volatile BdLocationMananger mInstance = null;
    public long mTimeOutValue = 10000;
    public long lastLocationTime = 0;
    private long location_expiration = 300000;
    private boolean mLastAddressIsAccuracy = false;
    private boolean mCurrentLocationIsAccurcy = false;
    private boolean mIsExecLocationTask = false;
    private int errorCode = 4;
    private Address lastAddress = null;
    private ArrayList<SoftReference<LocationCallBack>> mLocationCallBacks = null;
    private ArrayList<ILocationProvider> mLocationProviders = new ArrayList<>();
    private Handler handler = null;
    private ProviderCallBack mLocationProviderCallback = new ProviderCallBack() { // from class: com.baidu.live.adp.lib.lbs.BdLocationMananger.1
        @Override // com.baidu.live.adp.lib.lbs.BdLocationMananger.ProviderCallBack
        public void onProviderGetLocation(int i, String str, Address address, long j, boolean z) {
            BdLocationMananger.this.lastLocationTime = j;
            BdLocationMananger.this.lastAddress = address;
            BdLocationMananger.this.mLastAddressIsAccuracy = z;
            BdLocationMananger.this.errorCode = i;
            BdLocationMananger.this.stopLocationServer();
            switch (i) {
                case 1:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.sdk_location_gps_offline);
                        break;
                    }
                    break;
                case 2:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.sdk_location_net_offline);
                        break;
                    }
                    break;
                case 3:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.sdk_location_all_offline);
                        break;
                    }
                    break;
                case 4:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.sdk_location_out_time);
                        break;
                    }
                    break;
            }
            BdLocationMananger.this.doCallBacks(i, str, address);
        }
    };

    /* loaded from: classes11.dex */
    public interface LocationCallBack {
        void onLocationGeted(int i, String str, Address address);
    }

    /* loaded from: classes11.dex */
    public interface ProviderCallBack {
        void onProviderGetLocation(int i, String str, Address address, long j, boolean z);
    }

    private BdLocationMananger() {
    }

    public static BdLocationMananger getInstance() {
        if (mInstance == null) {
            synchronized (BdLocationMananger.class) {
                if (mInstance == null) {
                    mInstance = new BdLocationMananger();
                }
            }
        }
        return mInstance;
    }

    public void registerProvider(ILocationProvider iLocationProvider) {
        if (iLocationProvider != null) {
            synchronized (this.mLocationProviders) {
                if (!this.mLocationProviders.contains(iLocationProvider)) {
                    iLocationProvider.init(this.mLocationProviderCallback);
                    this.mLocationProviders.add(iLocationProvider);
                }
            }
        }
    }

    public void unRegiserProvider(ILocationProvider iLocationProvider) {
        if (iLocationProvider != null) {
            synchronized (this.mLocationProviders) {
                iLocationProvider.destroy();
                this.mLocationProviders.remove(iLocationProvider);
            }
        }
    }

    public void initial() {
        this.mLocationCallBacks = new ArrayList<>();
        initHandler();
    }

    private void initHandler() {
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.live.adp.lib.lbs.BdLocationMananger.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        BdLocationMananger.this.stopLocationServer();
                        String str = "";
                        switch (BdLocationMananger.this.errorCode) {
                            case 1:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.sdk_location_gps_offline);
                                break;
                            case 2:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.sdk_location_net_offline);
                                break;
                            case 3:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.sdk_location_all_offline);
                                break;
                            case 4:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.sdk_location_out_time);
                                break;
                            case 6:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.sdk_location_out_time);
                                break;
                        }
                        BdLocationMananger.this.doCallBacks(BdLocationMananger.this.errorCode, str, null);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    public void setTimeOut(long j) {
        this.mTimeOutValue = j;
    }

    public long getTimeOut() {
        return this.mTimeOutValue;
    }

    public void setTimeExpiration(long j) {
        this.location_expiration = j;
    }

    public long getTimeExpiration() {
        return this.location_expiration;
    }

    public Address getAddress(boolean z) {
        return getAddress(z, false);
    }

    public Address getAddress(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.lastLocationTime > this.location_expiration) {
            this.lastAddress = null;
        }
        if (this.lastAddress != null && !z && ((z2 && this.mLastAddressIsAccuracy) || !z2)) {
            return this.lastAddress;
        }
        this.lastAddress = null;
        if (!this.mIsExecLocationTask) {
            startLocationServer(z2);
            return null;
        } else if (this.mIsExecLocationTask && z2 && !this.mCurrentLocationIsAccurcy) {
            stopLocationServer();
            startLocationServer(z2);
            return null;
        } else {
            return null;
        }
    }

    public Address getAddress(boolean z, LocationCallBack locationCallBack) {
        return getAddress(z, false, locationCallBack);
    }

    public Address getAddress(boolean z, boolean z2, LocationCallBack locationCallBack) {
        boolean z3;
        LocationCallBack locationCallBack2;
        if (System.currentTimeMillis() - this.lastLocationTime > this.location_expiration) {
            this.lastAddress = null;
        }
        if (this.lastAddress != null && !z && ((z2 && this.mLastAddressIsAccuracy) || !z2)) {
            if (locationCallBack != null) {
                locationCallBack.onLocationGeted(0, "", this.lastAddress);
            }
            return this.lastAddress;
        }
        if (locationCallBack != null) {
            synchronized (this.mLocationCallBacks) {
                int i = 0;
                while (true) {
                    if (i >= this.mLocationCallBacks.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<LocationCallBack> softReference = this.mLocationCallBacks.get(i);
                    if (softReference == null || (locationCallBack2 = softReference.get()) == null || !locationCallBack2.equals(locationCallBack)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.mLocationCallBacks.size() >= 100) {
                        this.mLocationCallBacks.remove(0);
                    }
                    this.mLocationCallBacks.add(new SoftReference<>(locationCallBack));
                }
            }
            if (!this.mIsExecLocationTask) {
                startLocationServer(z2);
                return null;
            } else if (this.mIsExecLocationTask && z2 && !this.mCurrentLocationIsAccurcy) {
                stopLocationServer();
                startLocationServer(z2);
                return null;
            }
        }
        return null;
    }

    public void removeLocationCallback(LocationCallBack locationCallBack) {
        LocationCallBack locationCallBack2;
        synchronized (this.mLocationCallBacks) {
            int i = 0;
            while (true) {
                if (i < this.mLocationCallBacks.size()) {
                    SoftReference<LocationCallBack> softReference = this.mLocationCallBacks.get(i);
                    if (softReference == null || (locationCallBack2 = softReference.get()) == null || !locationCallBack2.equals(locationCallBack)) {
                        i++;
                    } else {
                        this.mLocationCallBacks.remove(softReference);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    public void destroy() {
        stopLocationServer();
        Iterator<ILocationProvider> it = this.mLocationProviders.iterator();
        while (it.hasNext()) {
            ILocationProvider next = it.next();
            if (next != null) {
                next.destroy();
            }
        }
        this.mLocationCallBacks.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocationServer() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.mIsExecLocationTask = false;
        Iterator<ILocationProvider> it = this.mLocationProviders.iterator();
        while (it.hasNext()) {
            ILocationProvider next = it.next();
            if (next != null) {
                try {
                    next.stopLocation();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void startLocationServer(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.mCurrentLocationIsAccurcy = z;
        this.mIsExecLocationTask = true;
        if (this.mLocationProviders == null || this.mLocationProviders.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<ILocationProvider> it = this.mLocationProviders.iterator();
        while (it.hasNext()) {
            ILocationProvider next = it.next();
            if (next != null) {
                try {
                    next.startLocation(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.mTimeOutValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallBacks(int i, String str, Address address) {
        LocationCallBack locationCallBack;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.mLocationCallBacks != null) {
            synchronized (this.mLocationCallBacks) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.mLocationCallBacks.size()) {
                        SoftReference<LocationCallBack> softReference = this.mLocationCallBacks.get(i3);
                        if (softReference != null && (locationCallBack = softReference.get()) != null) {
                            locationCallBack.onLocationGeted(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.mLocationCallBacks.clear();
                    }
                }
            }
        }
    }
}
