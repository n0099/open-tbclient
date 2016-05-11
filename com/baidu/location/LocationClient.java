package com.baidu.location;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.baidu.location.a.b;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class LocationClient implements b.InterfaceC0018b {
    private static final int MIN_REQUEST_SPAN = 1000;
    private static final int MSG_REG_LISTENER = 5;
    private static final int MSG_REG_NOTIFY_LISTENER = 8;
    private static final int MSG_REMOVE_NOTIFY = 10;
    private static final int MSG_REQ_LOC = 4;
    private static final int MSG_REQ_NOTIFY_LOC = 11;
    private static final int MSG_REQ_OFFLINE_LOC = 12;
    private static final int MSG_REQ_POI = 7;
    private static final int MSG_RIGSTER_NOTIFY = 9;
    private static final int MSG_SET_OPT = 3;
    private static final int MSG_START = 1;
    private static final int MSG_STOP = 2;
    private static final int MSG_UNREG_LISTENER = 6;
    private static final String mTAG = "baidu_location_Client";
    private Context mContext;
    private boolean mDebugByDev;
    private String mKey;
    private LocationClientOption mOption;
    private long mLastRequestTime = 0;
    private String mPackName = null;
    private boolean mIsStarted = false;
    private Messenger mServer = null;
    private a mHandler = new a(this, null);
    private final Messenger mMessenger = new Messenger(this.mHandler);
    private ArrayList<BDLocationListener> mLocationListeners = null;
    private BDLocation mLastLocation = null;
    private boolean isWaitingForLocation = false;
    private boolean isWaitingLocTag = false;
    private boolean isScheduled = false;
    private b mScheduledRequest = null;
    private boolean mGpsStatus = false;
    private final Object mLock = new Object();
    private long lastReceiveGpsTime = 0;
    private long lastReceiveLocationTime = 0;
    private com.baidu.location.d.a mNotifyCache = null;
    private BDLocationListener NotifyLocationListenner = null;
    private String serviceName = null;
    private boolean inDoorState = false;
    private boolean isStop = true;
    private Boolean mConfig_map = false;
    private Boolean mConfig_preimport = false;
    private Boolean firstConnected = true;
    private com.baidu.location.a.b mloc = null;
    private boolean clientFirst = false;
    private boolean serverFirst = false;
    private ServiceConnection mConnection = new com.baidu.location.b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        /* synthetic */ a(LocationClient locationClient, com.baidu.location.b bVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    LocationClient.this.onStart();
                    return;
                case 2:
                    LocationClient.this.onStop();
                    return;
                case 3:
                    LocationClient.this.onSetOption(message);
                    return;
                case 4:
                    LocationClient.this.onRequestLocation();
                    return;
                case 5:
                    LocationClient.this.onRegisterListener(message);
                    return;
                case 6:
                    LocationClient.this.onUnRegisterListener(message);
                    return;
                case 7:
                    return;
                case 8:
                    LocationClient.this.onRegisterNotifyLocationListener(message);
                    return;
                case 9:
                    LocationClient.this.onRegisterNotify(message);
                    return;
                case 10:
                    LocationClient.this.onRemoveNotifyEvent(message);
                    return;
                case 11:
                    LocationClient.this.onRequestNotifyLocation();
                    return;
                case 12:
                    LocationClient.this.onRequestOffLineLocation();
                    return;
                case 21:
                    Bundle data = message.getData();
                    data.setClassLoader(BDLocation.class.getClassLoader());
                    BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                    if (!LocationClient.this.serverFirst && LocationClient.this.clientFirst && bDLocation.getLocType() == 66) {
                        return;
                    }
                    if (!LocationClient.this.serverFirst && LocationClient.this.clientFirst) {
                        LocationClient.this.serverFirst = true;
                        return;
                    }
                    if (!LocationClient.this.serverFirst) {
                        LocationClient.this.serverFirst = true;
                    }
                    LocationClient.this.onNewLocation(message, 21);
                    return;
                case TbConfig.NOTIFY_FANS_NEW_ID /* 26 */:
                    LocationClient.this.onNewLocation(message, 26);
                    return;
                case 27:
                    LocationClient.this.onNewNotifyLocation(message);
                    return;
                case 54:
                    if (LocationClient.this.mOption.location_change_notify) {
                        LocationClient.this.mGpsStatus = true;
                        return;
                    }
                    return;
                case 55:
                    if (LocationClient.this.mOption.location_change_notify) {
                        LocationClient.this.mGpsStatus = false;
                        return;
                    }
                    return;
                case 701:
                    LocationClient.this.sendFirstLoc((BDLocation) message.obj);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(LocationClient locationClient, com.baidu.location.b bVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (LocationClient.this.mLock) {
                LocationClient.this.isScheduled = false;
                if (LocationClient.this.mServer == null || LocationClient.this.mMessenger == null) {
                    return;
                }
                if (LocationClient.this.mLocationListeners == null || LocationClient.this.mLocationListeners.size() < 1) {
                    return;
                }
                if (!LocationClient.this.isWaitingLocTag) {
                    LocationClient.this.mHandler.obtainMessage(4).sendToTarget();
                    return;
                }
                if (LocationClient.this.mScheduledRequest == null) {
                    LocationClient.this.mScheduledRequest = new b();
                }
                LocationClient.this.mHandler.postDelayed(LocationClient.this.mScheduledRequest, LocationClient.this.mOption.scanSpan);
            }
        }
    }

    public LocationClient(Context context) {
        this.mOption = new LocationClientOption();
        this.mContext = null;
        this.mContext = context;
        this.mOption = new LocationClientOption();
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) {
        this.mOption = new LocationClientOption();
        this.mContext = null;
        this.mContext = context;
        this.mOption = locationClientOption;
    }

    private void callListeners(int i) {
        if (this.mLastLocation.getCoorType() == null) {
            this.mLastLocation.setCoorType(this.mOption.coorType);
        }
        if (this.isWaitingForLocation || ((this.mOption.location_change_notify && this.mLastLocation.getLocType() == 61) || this.mLastLocation.getLocType() == 66 || this.mLastLocation.getLocType() == 67 || this.inDoorState || this.mLastLocation.getLocType() == 161)) {
            if (this.mLocationListeners != null) {
                Iterator<BDLocationListener> it = this.mLocationListeners.iterator();
                while (it.hasNext()) {
                    it.next().onReceiveLocation(this.mLastLocation);
                }
            }
            if (this.mLastLocation.getLocType() == 66 || this.mLastLocation.getLocType() == 67) {
                return;
            }
            this.isWaitingForLocation = false;
            this.lastReceiveLocationTime = System.currentTimeMillis();
        }
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        double[] coorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
        bDLocation2.setLatitude(coorEncrypt[1]);
        bDLocation2.setLongitude(coorEncrypt[0]);
        return bDLocation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle getOptionBundle() {
        if (this.mOption == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.mPackName);
        bundle.putString("prodName", this.mOption.prodName);
        bundle.putString("coorType", this.mOption.coorType);
        bundle.putString("addrType", this.mOption.addrType);
        bundle.putBoolean("openGPS", this.mOption.openGps);
        bundle.putBoolean("location_change_notify", this.mOption.location_change_notify);
        bundle.putInt("scanSpan", this.mOption.scanSpan);
        bundle.putBoolean("enableSimulateGps", this.mOption.enableSimulateGps);
        bundle.putInt("timeOut", this.mOption.timeOut);
        bundle.putInt("priority", this.mOption.priority);
        bundle.putBoolean("map", this.mConfig_map.booleanValue());
        bundle.putBoolean("import", this.mConfig_preimport.booleanValue());
        bundle.putBoolean("needDirect", this.mOption.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.mOption.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.mOption.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.mOption.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.mOption.isNeedAptagd);
        bundle.putBoolean("isneedaltitude", this.mOption.isNeedAltitude);
        bundle.putInt("autoNotifyMaxInterval", this.mOption.getAutoNotifyMaxInterval());
        bundle.putInt("autoNotifyMinTimeInterval", this.mOption.getAutoNotifyMinTimeInterval());
        bundle.putInt("autoNotifyMinDistance", this.mOption.getAutoNotifyMinDistance());
        bundle.putFloat("autoNotifyLocSensitivity", this.mOption.getAutoNotifyLocSensitivity());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewLocation(Message message, int i) {
        if (this.mIsStarted) {
            try {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                this.mLastLocation = (BDLocation) data.getParcelable("locStr");
                if (this.mLastLocation.getLocType() == 61) {
                    this.lastReceiveGpsTime = System.currentTimeMillis();
                }
                callListeners(i);
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewNotifyLocation(Message message) {
        try {
            Bundle data = message.getData();
            data.setClassLoader(BDLocation.class.getClassLoader());
            BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
            if (this.NotifyLocationListenner != null) {
                if (this.mOption != null && this.mOption.isDisableCache() && bDLocation.getLocType() == 65) {
                    return;
                }
                this.NotifyLocationListenner.onReceiveLocation(bDLocation);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRegisterListener(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        if (this.mLocationListeners == null) {
            this.mLocationListeners = new ArrayList<>();
        }
        if (this.mLocationListeners.contains(bDLocationListener)) {
            return;
        }
        this.mLocationListeners.add(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRegisterNotify(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDNotifyListener bDNotifyListener = (BDNotifyListener) message.obj;
        if (this.mNotifyCache == null) {
            this.mNotifyCache = new com.baidu.location.d.a(this.mContext, this);
        }
        this.mNotifyCache.a(bDNotifyListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRegisterNotifyLocationListener(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.NotifyLocationListenner = (BDLocationListener) message.obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRemoveNotifyEvent(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDNotifyListener bDNotifyListener = (BDNotifyListener) message.obj;
        if (this.mNotifyCache != null) {
            this.mNotifyCache.c(bDNotifyListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequestLocation() {
        if (this.mServer == null) {
            return;
        }
        if ((System.currentTimeMillis() - this.lastReceiveGpsTime > 3000 || !this.mOption.location_change_notify || this.isWaitingLocTag) && (!this.inDoorState || System.currentTimeMillis() - this.lastReceiveLocationTime > 20000 || this.isWaitingLocTag)) {
            Message obtain = Message.obtain((Handler) null, 22);
            if (this.isWaitingLocTag) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isWaitingLocTag", this.isWaitingLocTag);
                this.isWaitingLocTag = false;
                obtain.setData(bundle);
            }
            try {
                obtain.replyTo = this.mMessenger;
                this.mServer.send(obtain);
                this.mLastRequestTime = System.currentTimeMillis();
                this.isWaitingForLocation = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        synchronized (this.mLock) {
            if (this.mOption != null && this.mOption.scanSpan >= 1000 && !this.isScheduled) {
                if (this.mScheduledRequest == null) {
                    this.mScheduledRequest = new b(this, null);
                }
                this.mHandler.postDelayed(this.mScheduledRequest, this.mOption.scanSpan);
                this.isScheduled = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequestNotifyLocation() {
        if (this.mServer == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 22);
        try {
            obtain.replyTo = this.mMessenger;
            this.mServer.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequestOffLineLocation() {
        Message obtain = Message.obtain((Handler) null, 28);
        try {
            obtain.replyTo = this.mMessenger;
            this.mServer.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetOption(Message message) {
        this.isWaitingLocTag = false;
        if (message == null || message.obj == null) {
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) message.obj;
        if (this.mOption.optionEquals(locationClientOption)) {
            return;
        }
        if (this.mOption.scanSpan != locationClientOption.scanSpan) {
            try {
                synchronized (this.mLock) {
                    if (this.isScheduled) {
                        this.mHandler.removeCallbacks(this.mScheduledRequest);
                        this.isScheduled = false;
                    }
                    if (locationClientOption.scanSpan >= 1000 && !this.isScheduled) {
                        if (this.mScheduledRequest == null) {
                            this.mScheduledRequest = new b(this, null);
                        }
                        this.mHandler.postDelayed(this.mScheduledRequest, locationClientOption.scanSpan);
                        this.isScheduled = true;
                    }
                }
            } catch (Exception e) {
            }
        }
        this.mOption = new LocationClientOption(locationClientOption);
        if (this.mServer != null) {
            try {
                Message obtain = Message.obtain((Handler) null, 15);
                obtain.replyTo = this.mMessenger;
                obtain.setData(getOptionBundle());
                this.mServer.send(obtain);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        if (this.mIsStarted) {
            return;
        }
        if (this.firstConnected.booleanValue()) {
            if (this.mloc == null) {
                this.mloc = new com.baidu.location.a.b(this.mContext, this.mOption, this);
            }
            this.mloc.c();
            this.firstConnected = false;
        }
        this.mPackName = this.mContext.getPackageName();
        this.serviceName = this.mPackName + "_bdls_v2.9";
        Intent intent = new Intent(this.mContext, f.class);
        try {
            intent.putExtra("debug_dev", this.mDebugByDev);
        } catch (Exception e) {
        }
        if (this.mOption == null) {
            this.mOption = new LocationClientOption();
        }
        intent.putExtra("cache_exception", this.mOption.isIgnoreCacheException);
        intent.putExtra("kill_process", this.mOption.isIgnoreKillProcess);
        try {
            this.mContext.bindService(intent, this.mConnection, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.mIsStarted = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (!this.mIsStarted || this.mServer == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.replyTo = this.mMessenger;
        try {
            this.mServer.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.mContext.unbindService(this.mConnection);
        } catch (Exception e2) {
        }
        synchronized (this.mLock) {
            try {
                if (this.isScheduled) {
                    this.mHandler.removeCallbacks(this.mScheduledRequest);
                    this.isScheduled = false;
                }
            } catch (Exception e3) {
            }
        }
        if (this.mNotifyCache != null) {
            this.mNotifyCache.a();
        }
        this.mServer = null;
        this.isWaitingLocTag = false;
        this.inDoorState = false;
        this.mIsStarted = false;
        this.clientFirst = false;
        this.serverFirst = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUnRegisterListener(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        if (this.mLocationListeners == null || !this.mLocationListeners.contains(bDLocationListener)) {
            return;
        }
        this.mLocationListeners.remove(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFirstLoc(BDLocation bDLocation) {
        if (this.isStop) {
            return;
        }
        this.mLastLocation = bDLocation;
        if (!this.serverFirst && bDLocation.getLocType() == 161) {
            this.clientFirst = true;
        }
        if (this.mLocationListeners != null) {
            Iterator<BDLocationListener> it = this.mLocationListeners.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocation(bDLocation);
            }
        }
    }

    public String getAccessKey() {
        try {
            this.mKey = com.baidu.location.h.a.b(this.mContext);
            if (TextUtils.isEmpty(this.mKey)) {
                throw new IllegalStateException("please setting key from Manifest.xml");
            }
            return String.format("KEY=%s;SHA1=%s", this.mKey, com.baidu.location.h.a.a(this.mContext));
        } catch (Exception e) {
            return null;
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.mLastLocation;
    }

    public LocationClientOption getLocOption() {
        return this.mOption;
    }

    public String getVersion() {
        return "6.2.3";
    }

    public boolean isStarted() {
        return this.mIsStarted;
    }

    @Override // com.baidu.location.a.b.InterfaceC0018b
    public void onReceiveLocation(BDLocation bDLocation) {
        if ((!this.serverFirst || this.clientFirst) && bDLocation != null) {
            Message obtainMessage = this.mHandler.obtainMessage(701);
            obtainMessage.obj = bDLocation;
            obtainMessage.sendToTarget();
        }
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.mHandler.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotify(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.mHandler.obtainMessage(9);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.mHandler.obtainMessage(8);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void removeNotifyEvent(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.mHandler.obtainMessage(10);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public int requestLocation() {
        if (this.mServer == null || this.mMessenger == null) {
            return 1;
        }
        if (this.mLocationListeners == null || this.mLocationListeners.size() < 1) {
            return 2;
        }
        if (System.currentTimeMillis() - this.mLastRequestTime < 1000) {
            return 6;
        }
        this.isWaitingLocTag = true;
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.arg1 = 0;
        obtainMessage.sendToTarget();
        return 0;
    }

    public void requestNotifyLocation() {
        this.mHandler.obtainMessage(11).sendToTarget();
    }

    public int requestOfflineLocation() {
        if (this.mServer == null || this.mMessenger == null) {
            return 1;
        }
        if (this.mLocationListeners == null || this.mLocationListeners.size() < 1) {
            return 2;
        }
        this.mHandler.obtainMessage(12).sendToTarget();
        return 0;
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (locationClientOption.getAutoNotifyMaxInterval() > 0) {
            locationClientOption.setScanSpan(0);
            locationClientOption.setLocationNotify(true);
        }
        Message obtainMessage = this.mHandler.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public void start() {
        this.isStop = false;
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    public void stop() {
        this.isStop = true;
        this.mHandler.obtainMessage(2).sendToTarget();
        this.mloc = null;
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.mHandler.obtainMessage(6);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) {
        if (this.mServer == null || this.mMessenger == null || location == null) {
            return false;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 57);
            obtain.obj = location;
            this.mServer.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
