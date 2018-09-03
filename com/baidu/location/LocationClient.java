package com.baidu.location;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.location.a.c;
import com.baidu.location.a.h;
import com.baidu.location.a.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public final class LocationClient implements c.a {
    public static final int CONNECT_HOT_SPOT_FALSE = 0;
    public static final int CONNECT_HOT_SPOT_TRUE = 1;
    public static final int CONNECT_HOT_SPOT_UNKNOWN = -1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
    public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
    public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;
    private boolean B;
    private LocationClientOption c;
    private LocationClientOption d;
    private Context f;
    private String v;
    private long a = 0;
    private String b = null;
    private boolean e = false;
    private Messenger g = null;
    private ArrayList<BDLocationListener> j = null;
    private ArrayList<BDAbstractLocationListener> k = null;
    private BDLocation l = null;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private b p = null;
    private boolean q = false;
    private final Object r = new Object();
    private long s = 0;
    private long t = 0;
    private String u = null;
    private boolean w = false;
    private boolean x = true;
    private Boolean y = false;
    private Boolean z = false;
    private Boolean A = true;
    private c C = null;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private ServiceConnection G = new ServiceConnection() { // from class: com.baidu.location.LocationClient.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LocationClient.this.g = new Messenger(iBinder);
            if (LocationClient.this.g == null) {
                return;
            }
            LocationClient.this.e = true;
            Log.d("baidu_location_client", "baidu location connected ...");
            if (LocationClient.this.x) {
                LocationClient.this.h.obtainMessage(2).sendToTarget();
                return;
            }
            try {
                Message obtain = Message.obtain((Handler) null, 11);
                obtain.replyTo = LocationClient.this.i;
                obtain.setData(LocationClient.this.c());
                LocationClient.this.g.send(obtain);
                LocationClient.this.e = true;
                if (LocationClient.this.c != null) {
                    if (LocationClient.this.A.booleanValue()) {
                    }
                    LocationClient.this.h.obtainMessage(4).sendToTarget();
                }
            } catch (Exception e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LocationClient.this.g = null;
            LocationClient.this.e = false;
        }
    };
    private a h = new a(Looper.getMainLooper(), this);
    private final Messenger i = new Messenger(this.h);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Handler {
        private final WeakReference<LocationClient> a;

        a(Looper looper, LocationClient locationClient) {
            super(looper);
            this.a = new WeakReference<>(locationClient);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LocationClient locationClient = this.a.get();
            if (locationClient == null) {
                return;
            }
            switch (message.what) {
                case 1:
                    locationClient.a();
                    return;
                case 2:
                    locationClient.b();
                    return;
                case 3:
                    locationClient.a(message);
                    return;
                case 4:
                    locationClient.d();
                    return;
                case 5:
                    locationClient.b(message);
                    return;
                case 6:
                    locationClient.e(message);
                    return;
                case 21:
                    Bundle data = message.getData();
                    data.setClassLoader(BDLocation.class.getClassLoader());
                    BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                    if (!locationClient.E && locationClient.D && bDLocation.getLocType() == 66) {
                        return;
                    }
                    if (!locationClient.E && locationClient.D) {
                        locationClient.E = true;
                        return;
                    }
                    if (!locationClient.E) {
                        locationClient.E = true;
                    }
                    locationClient.a(message, 21);
                    return;
                case 54:
                    if (locationClient.c.location_change_notify) {
                        locationClient.q = true;
                        return;
                    }
                    return;
                case 55:
                    if (locationClient.c.location_change_notify) {
                        locationClient.q = false;
                        return;
                    }
                    return;
                case 303:
                    try {
                        Bundle data2 = message.getData();
                        int i = data2.getInt("loctype");
                        int i2 = data2.getInt("diagtype");
                        byte[] byteArray = data2.getByteArray("diagmessage");
                        if (i <= 0 || i2 <= 0 || byteArray == null || locationClient.k == null) {
                            return;
                        }
                        Iterator it = locationClient.k.iterator();
                        while (it.hasNext()) {
                            ((BDAbstractLocationListener) it.next()).onLocDiagnosticMessage(i, i2, new String(byteArray, "UTF-8"));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                case HttpStatus.SC_NOT_ACCEPTABLE /* 406 */:
                    try {
                        Bundle data3 = message.getData();
                        byte[] byteArray2 = data3.getByteArray("mac");
                        String str = byteArray2 != null ? new String(byteArray2, "UTF-8") : null;
                        int i3 = data3.getInt("hotspot", -1);
                        if (locationClient.k != null) {
                            Iterator it2 = locationClient.k.iterator();
                            while (it2.hasNext()) {
                                ((BDAbstractLocationListener) it2.next()).onConnectHotSpotMessage(str, i3);
                            }
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                case 701:
                    locationClient.a((BDLocation) message.obj);
                    return;
                case 703:
                    try {
                        Bundle data4 = message.getData();
                        int i4 = data4.getInt("id", 0);
                        if (i4 > 0) {
                            locationClient.a(i4, (Notification) data4.getParcelable("notification"));
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        return;
                    }
                case 704:
                    try {
                        locationClient.a(message.getData().getBoolean("removenotify"));
                        return;
                    } catch (Exception e4) {
                        return;
                    }
                case 1300:
                    locationClient.c(message);
                    return;
                case 1400:
                    locationClient.d(message);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (LocationClient.this.r) {
                LocationClient.this.o = false;
                if (LocationClient.this.g == null || LocationClient.this.i == null) {
                    return;
                }
                if ((LocationClient.this.j == null || LocationClient.this.j.size() < 1) && (LocationClient.this.k == null || LocationClient.this.k.size() < 1)) {
                    return;
                }
                if (!LocationClient.this.n) {
                    LocationClient.this.h.obtainMessage(4).sendToTarget();
                    return;
                }
                if (LocationClient.this.p == null) {
                    LocationClient.this.p = new b();
                }
                LocationClient.this.h.postDelayed(LocationClient.this.p, LocationClient.this.c.scanSpan);
            }
        }
    }

    public LocationClient(Context context) {
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.f = null;
        this.f = context;
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) {
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.f = null;
        this.f = context;
        this.c = locationClientOption;
        this.d = new LocationClientOption(locationClientOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.baidu.location.LocationClient$2] */
    public void a() {
        if (this.e) {
            return;
        }
        if (this.A.booleanValue()) {
            new Thread() { // from class: com.baidu.location.LocationClient.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (LocationClient.this.C == null) {
                        LocationClient.this.C = new c(LocationClient.this.f, LocationClient.this.d, LocationClient.this);
                    }
                    LocationClient.this.C.c();
                }
            }.start();
            this.A = false;
        }
        this.b = this.f.getPackageName();
        this.u = this.b + "_bdls_v2.9";
        Intent intent = new Intent(this.f, f.class);
        try {
            intent.putExtra("debug_dev", this.B);
        } catch (Exception e) {
        }
        if (this.c == null) {
            this.c = new LocationClientOption();
        }
        intent.putExtra("cache_exception", this.c.isIgnoreCacheException);
        intent.putExtra("kill_process", this.c.isIgnoreKillProcess);
        try {
            this.f.bindService(intent, this.G, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.e = false;
        }
    }

    private void a(int i) {
        if (this.l.getCoorType() == null) {
            this.l.setCoorType(this.c.coorType);
        }
        if (this.m || ((this.c.location_change_notify && this.l.getLocType() == 61) || this.l.getLocType() == 66 || this.l.getLocType() == 67 || this.w || this.l.getLocType() == 161)) {
            if (this.j != null) {
                Iterator<BDLocationListener> it = this.j.iterator();
                while (it.hasNext()) {
                    it.next().onReceiveLocation(this.l);
                }
            }
            if (this.k != null) {
                Iterator<BDAbstractLocationListener> it2 = this.k.iterator();
                while (it2.hasNext()) {
                    it2.next().onReceiveLocation(this.l);
                }
            }
            if (this.l.getLocType() == 66 || this.l.getLocType() == 67) {
                return;
            }
            this.m = false;
            this.t = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Notification notification) {
        try {
            Intent intent = new Intent(this.f, f.class);
            intent.putExtra("notification", notification);
            intent.putExtra("id", i);
            intent.putExtra("command", 1);
            if (Build.VERSION.SDK_INT >= 26) {
                this.f.startForegroundService(intent);
            } else {
                this.f.startService(intent);
            }
            this.F = true;
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        this.n = false;
        if (message == null || message.obj == null) {
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) message.obj;
        if (this.c.optionEquals(locationClientOption)) {
            return;
        }
        if (this.c.scanSpan != locationClientOption.scanSpan) {
            try {
                synchronized (this.r) {
                    if (this.o) {
                        this.h.removeCallbacks(this.p);
                        this.o = false;
                    }
                    if (locationClientOption.scanSpan >= 1000 && !this.o) {
                        if (this.p == null) {
                            this.p = new b();
                        }
                        this.h.postDelayed(this.p, locationClientOption.scanSpan);
                        this.o = true;
                    }
                }
            } catch (Exception e) {
            }
        }
        this.c = new LocationClientOption(locationClientOption);
        if (this.g != null) {
            try {
                Message obtain = Message.obtain((Handler) null, 15);
                obtain.replyTo = this.i;
                obtain.setData(c());
                this.g.send(obtain);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i) {
        if (this.e) {
            try {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                this.l = (BDLocation) data.getParcelable("locStr");
                if (this.l.getLocType() == 61) {
                    this.s = System.currentTimeMillis();
                }
                a(i);
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BDLocation bDLocation) {
        if (this.x) {
            return;
        }
        this.l = bDLocation;
        if (!this.E && bDLocation.getLocType() == 161) {
            this.D = true;
        }
        if (this.j != null) {
            Iterator<BDLocationListener> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocation(bDLocation);
            }
        }
        if (this.k != null) {
            Iterator<BDAbstractLocationListener> it2 = this.k.iterator();
            while (it2.hasNext()) {
                it2.next().onReceiveLocation(bDLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        try {
            Intent intent = new Intent(this.f, f.class);
            intent.putExtra("removenotify", z);
            intent.putExtra("command", 2);
            this.f.startService(intent);
            this.F = true;
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!this.e || this.g == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.replyTo = this.i;
        try {
            this.g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f.unbindService(this.G);
            if (this.F) {
                try {
                    this.f.stopService(new Intent(this.f, f.class));
                } catch (Exception e2) {
                }
                this.F = false;
            }
        } catch (Exception e3) {
        }
        synchronized (this.r) {
            try {
                if (this.o) {
                    this.h.removeCallbacks(this.p);
                    this.o = false;
                }
            } catch (Exception e4) {
            }
        }
        this.g = null;
        this.n = false;
        this.w = false;
        this.e = false;
        this.D = false;
        this.E = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        if (this.j.contains(bDLocationListener)) {
            return;
        }
        this.j.add(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle c() {
        if (this.c == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.b);
        bundle.putString("prodName", this.c.prodName);
        bundle.putString("coorType", this.c.coorType);
        bundle.putString("addrType", this.c.addrType);
        bundle.putBoolean("openGPS", this.c.openGps);
        bundle.putBoolean("location_change_notify", this.c.location_change_notify);
        bundle.putInt("scanSpan", this.c.scanSpan);
        bundle.putBoolean("enableSimulateGps", this.c.enableSimulateGps);
        bundle.putInt("timeOut", this.c.timeOut);
        bundle.putInt(LogFactory.PRIORITY_KEY, this.c.priority);
        bundle.putBoolean("map", this.y.booleanValue());
        bundle.putBoolean("import", this.z.booleanValue());
        bundle.putBoolean("needDirect", this.c.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.c.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.c.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.c.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.c.isNeedAptagd);
        bundle.putBoolean("isneedaltitude", this.c.isNeedAltitude);
        bundle.putInt("autoNotifyMaxInterval", this.c.a());
        bundle.putInt("autoNotifyMinTimeInterval", this.c.getAutoNotifyMinTimeInterval());
        bundle.putInt("autoNotifyMinDistance", this.c.getAutoNotifyMinDistance());
        bundle.putFloat("autoNotifyLocSensitivity", this.c.b());
        bundle.putInt("wifitimeout", this.c.wifiCacheTimeOut);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) message.obj;
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
        if (this.k.contains(bDAbstractLocationListener)) {
            return;
        }
        this.k.add(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.g == null) {
            return;
        }
        if ((System.currentTimeMillis() - this.s > 3000 || !this.c.location_change_notify || this.n) && (!this.w || System.currentTimeMillis() - this.t > 20000 || this.n)) {
            Message obtain = Message.obtain((Handler) null, 22);
            if (this.n) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isWaitingLocTag", this.n);
                this.n = false;
                obtain.setData(bundle);
            }
            try {
                obtain.replyTo = this.i;
                this.g.send(obtain);
                this.a = System.currentTimeMillis();
                this.m = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        synchronized (this.r) {
            if (this.c != null && this.c.scanSpan >= 1000 && !this.o) {
                if (this.p == null) {
                    this.p = new b();
                }
                this.h.postDelayed(this.p, this.c.scanSpan);
                this.o = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) message.obj;
        if (this.k == null || !this.k.contains(bDAbstractLocationListener)) {
            return;
        }
        this.k.remove(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        if (this.j == null || !this.j.contains(bDLocationListener)) {
            return;
        }
        this.j.remove(bDLocationListener);
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        double[] coorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
        bDLocation2.setLatitude(coorEncrypt[1]);
        bDLocation2.setLongitude(coorEncrypt[0]);
        return bDLocation2;
    }

    public void disableAssistantLocation() {
        i.qr().b();
    }

    public void disableLocInForeground(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("removenotify", z);
        Message obtainMessage = this.h.obtainMessage(704);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public void enableAssistantLocation(WebView webView) {
        i.qr().a(this.f, webView, this);
    }

    public void enableLocInForeground(int i, Notification notification) {
        if (i <= 0 || notification == null) {
            Log.e("baidu_location_Client", "can not startLocInForeground if the param is unlegal");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("id", i);
        bundle.putParcelable("notification", notification);
        Message obtainMessage = this.h.obtainMessage(703);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public String getAccessKey() {
        try {
            this.v = h.b(this.f);
            if (TextUtils.isEmpty(this.v)) {
                throw new IllegalStateException("please setting key from Manifest.xml");
            }
            return String.format("KEY=%s", this.v);
        } catch (Exception e) {
            return null;
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.l;
    }

    public LocationClientOption getLocOption() {
        return this.c;
    }

    public String getVersion() {
        return "7.4.2";
    }

    public boolean isStarted() {
        return this.e;
    }

    @Override // com.baidu.location.a.c.a
    public void onReceiveLocation(BDLocation bDLocation) {
        if ((!this.E || this.D) && bDLocation != null) {
            Message obtainMessage = this.h.obtainMessage(701);
            obtainMessage.obj = bDLocation;
            obtainMessage.sendToTarget();
        }
    }

    public void registerLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(1300);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean requestHotSpotState() {
        if (this.g == null || !this.e) {
            return false;
        }
        try {
            this.g.send(Message.obtain((Handler) null, (int) HttpStatus.SC_NOT_ACCEPTABLE));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int requestLocation() {
        if (this.g == null || this.i == null) {
            return 1;
        }
        if ((this.j == null || this.j.size() < 1) && (this.k == null || this.k.size() < 1)) {
            return 2;
        }
        if (System.currentTimeMillis() - this.a < 1000) {
            return 6;
        }
        this.n = true;
        Message obtainMessage = this.h.obtainMessage(4);
        obtainMessage.arg1 = 0;
        obtainMessage.sendToTarget();
        return 0;
    }

    public void restart() {
        stop();
        this.x = false;
        this.h.sendEmptyMessageDelayed(1, 1000L);
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (locationClientOption.a() > 0) {
            locationClientOption.setScanSpan(0);
            locationClientOption.setLocationNotify(true);
        }
        this.d = new LocationClientOption(locationClientOption);
        Message obtainMessage = this.h.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public void start() {
        this.x = false;
        this.h.obtainMessage(1).sendToTarget();
    }

    public void stop() {
        this.x = true;
        this.h.obtainMessage(2).sendToTarget();
        this.C = null;
    }

    public void unRegisterLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(1400);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(6);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) {
        if (this.g == null || this.i == null || location == null) {
            return false;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 57);
            obtain.obj = location;
            this.g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
