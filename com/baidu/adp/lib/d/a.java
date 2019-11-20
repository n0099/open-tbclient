package com.baidu.adp.lib.d;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a oa = null;
    public long mTimeOutValue = 10000;
    public long lastLocationTime = 0;
    private long location_expiration = 300000;
    private boolean mLastAddressIsAccuracy = false;
    private boolean mCurrentLocationIsAccurcy = false;
    private boolean mIsExecLocationTask = false;
    private int errorCode = 4;
    private Address lastAddress = null;
    private ArrayList<SoftReference<InterfaceC0015a>> mLocationCallBacks = null;
    private ArrayList<com.baidu.adp.lib.d.b> mLocationProviders = new ArrayList<>();
    private Handler handler = null;
    private b ob = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void onProviderGetLocation(int i, String str, Address address, long j, boolean z) {
            a.this.lastLocationTime = j;
            a.this.lastAddress = address;
            a.this.mLastAddressIsAccuracy = z;
            a.this.errorCode = i;
            a.this.stopLocationServer();
            switch (i) {
                case 1:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                        break;
                    }
                    break;
                case 2:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                        break;
                    }
                    break;
                case 3:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                        break;
                    }
                    break;
                case 4:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                        break;
                    }
                    break;
            }
            a.this.doCallBacks(i, str, address);
        }
    };

    /* renamed from: com.baidu.adp.lib.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0015a {
        void onLocationGeted(int i, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface b {
        void onProviderGetLocation(int i, String str, Address address, long j, boolean z);
    }

    private a() {
    }

    public static a fw() {
        if (oa == null) {
            synchronized (a.class) {
                if (oa == null) {
                    oa = new a();
                }
            }
        }
        return oa;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.mLocationProviders) {
                if (!this.mLocationProviders.contains(bVar)) {
                    bVar.a(this.ob);
                    this.mLocationProviders.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.mLocationProviders) {
                bVar.destroy();
                this.mLocationProviders.remove(bVar);
            }
        }
    }

    public void initial() {
        this.mLocationCallBacks = new ArrayList<>();
        initHandler();
    }

    private void initHandler() {
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.adp.lib.d.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.stopLocationServer();
                        String str = "";
                        switch (a.this.errorCode) {
                            case 1:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                                break;
                            case 2:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                                break;
                            case 3:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                                break;
                            case 4:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                                break;
                            case 6:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                                break;
                        }
                        a.this.doCallBacks(a.this.errorCode, str, null);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    public long getTimeOut() {
        return this.mTimeOutValue;
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

    public Address a(boolean z, InterfaceC0015a interfaceC0015a) {
        return a(z, false, interfaceC0015a);
    }

    public Address a(boolean z, boolean z2, InterfaceC0015a interfaceC0015a) {
        boolean z3;
        InterfaceC0015a interfaceC0015a2;
        if (System.currentTimeMillis() - this.lastLocationTime > this.location_expiration) {
            this.lastAddress = null;
        }
        if (this.lastAddress != null && !z && ((z2 && this.mLastAddressIsAccuracy) || !z2)) {
            if (interfaceC0015a != null) {
                interfaceC0015a.onLocationGeted(0, "", this.lastAddress);
            }
            return this.lastAddress;
        }
        if (interfaceC0015a != null) {
            synchronized (this.mLocationCallBacks) {
                int i = 0;
                while (true) {
                    if (i >= this.mLocationCallBacks.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0015a> softReference = this.mLocationCallBacks.get(i);
                    if (softReference == null || (interfaceC0015a2 = softReference.get()) == null || !interfaceC0015a2.equals(interfaceC0015a)) {
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
                    this.mLocationCallBacks.add(new SoftReference<>(interfaceC0015a));
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

    public void a(InterfaceC0015a interfaceC0015a) {
        InterfaceC0015a interfaceC0015a2;
        synchronized (this.mLocationCallBacks) {
            int i = 0;
            while (true) {
                if (i < this.mLocationCallBacks.size()) {
                    SoftReference<InterfaceC0015a> softReference = this.mLocationCallBacks.get(i);
                    if (softReference == null || (interfaceC0015a2 = softReference.get()) == null || !interfaceC0015a2.equals(interfaceC0015a)) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocationServer() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.mIsExecLocationTask = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.mLocationProviders.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
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
        Iterator<com.baidu.adp.lib.d.b> it = this.mLocationProviders.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
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
        InterfaceC0015a interfaceC0015a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.mLocationCallBacks != null) {
            synchronized (this.mLocationCallBacks) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.mLocationCallBacks.size()) {
                        SoftReference<InterfaceC0015a> softReference = this.mLocationCallBacks.get(i3);
                        if (softReference != null && (interfaceC0015a = softReference.get()) != null) {
                            interfaceC0015a.onLocationGeted(i, str, address);
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
