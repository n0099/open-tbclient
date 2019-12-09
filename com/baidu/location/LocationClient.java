package com.baidu.location;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.location.a.c;
import com.baidu.location.a.d;
import com.baidu.location.a.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class LocationClient implements c.a, d.b {
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
    private Context e;
    private String v;
    private long a = 0;
    private String b = null;
    private boolean d = false;
    private Messenger f = null;
    private ArrayList<BDLocationListener> i = null;
    private ArrayList<BDAbstractLocationListener> j = null;
    private BDLocation k = null;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private b o = null;
    private boolean p = false;
    private final Object q = new Object();
    private long r = 0;
    private long s = 0;
    private BDLocationListener t = null;
    private String u = null;
    private boolean w = false;
    private boolean x = true;
    private Boolean y = false;
    private Boolean z = false;
    private Boolean A = true;
    private c C = null;
    private d D = null;
    private boolean E = false;
    private boolean F = false;
    private ServiceConnection G = new ServiceConnection() { // from class: com.baidu.location.LocationClient.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LocationClient.this.f = new Messenger(iBinder);
            if (LocationClient.this.f == null) {
                return;
            }
            LocationClient.this.d = true;
            Log.d("baidu_location_client", "baidu location connected ...");
            if (LocationClient.this.x) {
                LocationClient.this.g.obtainMessage(2).sendToTarget();
                return;
            }
            try {
                Message obtain = Message.obtain((Handler) null, 11);
                obtain.replyTo = LocationClient.this.h;
                obtain.setData(LocationClient.this.d());
                LocationClient.this.f.send(obtain);
                LocationClient.this.d = true;
                if (LocationClient.this.c != null) {
                    if (LocationClient.this.A.booleanValue()) {
                    }
                    LocationClient.this.g.obtainMessage(4).sendToTarget();
                }
            } catch (Exception e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LocationClient.this.f = null;
            LocationClient.this.d = false;
        }
    };
    private a g = new a(Looper.getMainLooper(), this);
    private final Messenger h = new Messenger(this.g);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
                    locationClient.b();
                    return;
                case 2:
                    locationClient.c();
                    return;
                case 3:
                    locationClient.a(message);
                    return;
                case 4:
                    locationClient.f();
                    return;
                case 5:
                    locationClient.c(message);
                    return;
                case 6:
                    locationClient.f(message);
                    return;
                case 7:
                    return;
                case 8:
                    locationClient.b(message);
                    return;
                case 11:
                    locationClient.e();
                    return;
                case 12:
                    locationClient.a();
                    return;
                case 21:
                    Bundle data = message.getData();
                    data.setClassLoader(BDLocation.class.getClassLoader());
                    BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                    if (!locationClient.F && locationClient.E && bDLocation.getLocType() == 66) {
                        return;
                    }
                    if (!locationClient.F && locationClient.E) {
                        locationClient.F = true;
                        return;
                    }
                    if (!locationClient.F) {
                        locationClient.F = true;
                    }
                    locationClient.a(message, 21);
                    return;
                case 26:
                    locationClient.a(message, 26);
                    return;
                case 27:
                    locationClient.g(message);
                    return;
                case 54:
                    if (locationClient.c.location_change_notify) {
                        locationClient.p = true;
                        return;
                    }
                    return;
                case 55:
                    if (locationClient.c.location_change_notify) {
                        locationClient.p = false;
                        return;
                    }
                    return;
                case 303:
                    try {
                        Bundle data2 = message.getData();
                        int i = data2.getInt("loctype");
                        int i2 = data2.getInt("diagtype");
                        byte[] byteArray = data2.getByteArray("diagmessage");
                        if (i <= 0 || i2 <= 0 || byteArray == null || locationClient.j == null) {
                            return;
                        }
                        Iterator it = locationClient.j.iterator();
                        while (it.hasNext()) {
                            ((BDAbstractLocationListener) it.next()).onLocDiagnosticMessage(i, i2, new String(byteArray, HTTP.UTF_8));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                case 406:
                    try {
                        Bundle data3 = message.getData();
                        byte[] byteArray2 = data3.getByteArray("mac");
                        String str = byteArray2 != null ? new String(byteArray2, HTTP.UTF_8) : null;
                        int i3 = data3.getInt("hotspot", -1);
                        if (locationClient.j != null) {
                            Iterator it2 = locationClient.j.iterator();
                            while (it2.hasNext()) {
                                ((BDAbstractLocationListener) it2.next()).onConnectHotSpotMessage(str, i3);
                            }
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                case CyberPlayerManager.MEDIA_INFO_BUFFERING_START /* 701 */:
                    locationClient.a((BDLocation) message.obj);
                    return;
                case CyberPlayerManager.MEDIA_INFO_BUFFERING_END /* 702 */:
                    BDLocation bDLocation2 = (BDLocation) message.obj;
                    if (locationClient.x) {
                        return;
                    }
                    locationClient.k = bDLocation2;
                    if (locationClient.i != null) {
                        Iterator it3 = locationClient.i.iterator();
                        while (it3.hasNext()) {
                            ((BDLocationListener) it3.next()).onReceiveLocation(bDLocation2);
                        }
                    }
                    if (locationClient.j != null) {
                        Iterator it4 = locationClient.j.iterator();
                        while (it4.hasNext()) {
                            ((BDAbstractLocationListener) it4.next()).onReceiveLocation(bDLocation2);
                        }
                        return;
                    }
                    return;
                case 1300:
                    locationClient.d(message);
                    return;
                case 1400:
                    locationClient.e(message);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (LocationClient.this.q) {
                LocationClient.this.n = false;
                if (LocationClient.this.f == null || LocationClient.this.h == null) {
                    return;
                }
                if ((LocationClient.this.i == null || LocationClient.this.i.size() < 1) && (LocationClient.this.j == null || LocationClient.this.j.size() < 1)) {
                    return;
                }
                if (!LocationClient.this.m) {
                    LocationClient.this.g.obtainMessage(4).sendToTarget();
                    return;
                }
                if (LocationClient.this.o == null) {
                    LocationClient.this.o = new b();
                }
                LocationClient.this.g.postDelayed(LocationClient.this.o, LocationClient.this.c.scanSpan);
            }
        }
    }

    public LocationClient(Context context) {
        this.c = new LocationClientOption();
        this.e = null;
        this.e = context;
        this.c = new LocationClientOption();
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) {
        this.c = new LocationClientOption();
        this.e = null;
        this.e = context;
        this.c = locationClientOption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Message obtain = Message.obtain((Handler) null, 28);
        try {
            obtain.replyTo = this.h;
            this.f.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        this.m = false;
        if (message == null || message.obj == null) {
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) message.obj;
        if (this.c.optionEquals(locationClientOption)) {
            return;
        }
        if (this.c.scanSpan != locationClientOption.scanSpan) {
            try {
                synchronized (this.q) {
                    if (this.n) {
                        this.g.removeCallbacks(this.o);
                        this.n = false;
                    }
                    if (locationClientOption.scanSpan >= 1000 && !this.n) {
                        if (this.o == null) {
                            this.o = new b();
                        }
                        this.g.postDelayed(this.o, locationClientOption.scanSpan);
                        this.n = true;
                    }
                }
            } catch (Exception e) {
            }
        }
        this.c = new LocationClientOption(locationClientOption);
        if (this.f != null) {
            try {
                Message obtain = Message.obtain((Handler) null, 15);
                obtain.replyTo = this.h;
                obtain.setData(d());
                this.f.send(obtain);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[Catch: Exception -> 0x0050, TryCatch #0 {Exception -> 0x0050, blocks: (B:5:0x0006, B:7:0x0022, B:9:0x002e, B:10:0x003a, B:12:0x0044, B:14:0x004c, B:19:0x0055, B:21:0x005d, B:23:0x0061, B:25:0x0065), top: B:29:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[Catch: Exception -> 0x0050, TryCatch #0 {Exception -> 0x0050, blocks: (B:5:0x0006, B:7:0x0022, B:9:0x002e, B:10:0x003a, B:12:0x0044, B:14:0x004c, B:19:0x0055, B:21:0x005d, B:23:0x0061, B:25:0x0065), top: B:29:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Message message, int i) {
        boolean z;
        if (!this.d) {
            return;
        }
        try {
            Bundle data = message.getData();
            data.setClassLoader(BDLocation.class.getClassLoader());
            this.k = (BDLocation) data.getParcelable("locStr");
            if (this.D != null) {
                int b2 = d.b(this.k.getAddress());
                if (b2 == 1) {
                    this.D.a(this.k.getAddress());
                    z = true;
                } else if (b2 == 2) {
                    Address a2 = this.D.a();
                    if (a2 == null || a2.city == null || a2.cityCode == null) {
                        z = false;
                    } else {
                        this.k.setAddr(a2);
                        z = true;
                    }
                }
                if (this.k.getLocType() == 61) {
                    this.r = System.currentTimeMillis();
                }
                if (z) {
                    return;
                }
                b(i);
                return;
            }
            z = true;
            if (this.k.getLocType() == 61) {
            }
            if (z) {
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BDLocation bDLocation) {
        if (this.x) {
            return;
        }
        this.k = bDLocation;
        if (!this.F && bDLocation.getLocType() == 161) {
            this.E = true;
        }
        if (this.i != null) {
            Iterator<BDLocationListener> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocation(bDLocation);
            }
        }
        if (this.j != null) {
            Iterator<BDAbstractLocationListener> it2 = this.j.iterator();
            while (it2.hasNext()) {
                it2.next().onReceiveLocation(bDLocation);
            }
        }
    }

    private boolean a(int i) {
        if (this.f == null || !this.d) {
            return false;
        }
        try {
            this.f.send(Message.obtain((Handler) null, i));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.baidu.location.LocationClient$2] */
    public void b() {
        if (this.d) {
            return;
        }
        if (this.D == null) {
            this.D = new d(this.e, this.c, this);
        }
        if (this.A.booleanValue()) {
            try {
                new Thread() { // from class: com.baidu.location.LocationClient.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        if (LocationClient.this.C == null) {
                            LocationClient.this.C = new c(LocationClient.this.e, LocationClient.this.c, LocationClient.this);
                        }
                        if (LocationClient.this.C != null) {
                            LocationClient.this.C.c();
                        }
                    }
                }.start();
            } catch (Throwable th) {
            }
            this.A = false;
        }
        this.b = this.e.getPackageName();
        this.u = this.b + "_bdls_v2.9";
        Intent intent = new Intent(this.e, f.class);
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
            this.e.bindService(intent, this.G, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.d = false;
        }
    }

    private void b(int i) {
        if (this.k.getCoorType() == null) {
            this.k.setCoorType(this.c.coorType);
        }
        if (this.l || ((this.c.location_change_notify && this.k.getLocType() == 61) || this.k.getLocType() == 66 || this.k.getLocType() == 67 || this.w || this.k.getLocType() == 161)) {
            if (this.i != null) {
                Iterator<BDLocationListener> it = this.i.iterator();
                while (it.hasNext()) {
                    it.next().onReceiveLocation(this.k);
                }
            }
            if (this.j != null) {
                Iterator<BDAbstractLocationListener> it2 = this.j.iterator();
                while (it2.hasNext()) {
                    it2.next().onReceiveLocation(this.k);
                }
            }
            if (this.k.getLocType() == 66 || this.k.getLocType() == 67) {
                return;
            }
            this.l = false;
            this.s = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.t = (BDLocationListener) message.obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!this.d || this.f == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.replyTo = this.h;
        try {
            this.f.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.e.unbindService(this.G);
        } catch (Exception e2) {
        }
        synchronized (this.q) {
            try {
                if (this.n) {
                    this.g.removeCallbacks(this.o);
                    this.n = false;
                }
            } catch (Exception e3) {
            }
        }
        this.f = null;
        this.m = false;
        this.w = false;
        this.d = false;
        this.E = false;
        this.F = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        if (this.i == null) {
            this.i = new ArrayList<>();
        }
        if (this.i.contains(bDLocationListener)) {
            return;
        }
        this.i.add(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle d() {
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
        bundle.putInt("priority", this.c.priority);
        bundle.putBoolean("map", this.y.booleanValue());
        bundle.putBoolean(com.baidu.sapi2.utils.enums.a.a, this.z.booleanValue());
        bundle.putBoolean("needDirect", this.c.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.c.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.c.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.c.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.c.isNeedAptagd);
        bundle.putBoolean("isneedaltitude", this.c.isNeedAltitude);
        bundle.putBoolean("isneednewrgc", this.c.isNeedNewVersionRgc);
        bundle.putInt("autoNotifyMaxInterval", this.c.a());
        bundle.putInt("autoNotifyMinTimeInterval", this.c.getAutoNotifyMinTimeInterval());
        bundle.putInt("autoNotifyMinDistance", this.c.getAutoNotifyMinDistance());
        bundle.putFloat("autoNotifyLocSensitivity", this.c.b());
        bundle.putInt("wifitimeout", this.c.wifiCacheTimeOut);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) message.obj;
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        if (this.j.contains(bDAbstractLocationListener)) {
            return;
        }
        this.j.add(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 22);
        try {
            obtain.replyTo = this.h;
            this.f.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) message.obj;
        if (this.j == null || !this.j.contains(bDAbstractLocationListener)) {
            return;
        }
        this.j.remove(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f == null) {
            return;
        }
        if ((System.currentTimeMillis() - this.r > 3000 || !this.c.location_change_notify || this.m) && (!this.w || System.currentTimeMillis() - this.s > 20000 || this.m)) {
            Message obtain = Message.obtain((Handler) null, 22);
            if (this.m) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isWaitingLocTag", this.m);
                this.m = false;
                obtain.setData(bundle);
            }
            try {
                obtain.replyTo = this.h;
                this.f.send(obtain);
                this.a = System.currentTimeMillis();
                this.l = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        synchronized (this.q) {
            if (this.c != null && this.c.scanSpan >= 1000 && !this.n) {
                if (this.o == null) {
                    this.o = new b();
                }
                this.g.postDelayed(this.o, this.c.scanSpan);
                this.n = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        if (this.i == null || !this.i.contains(bDLocationListener)) {
            return;
        }
        this.i.remove(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        try {
            Bundle data = message.getData();
            data.setClassLoader(BDLocation.class.getClassLoader());
            BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
            if (this.t != null) {
                if (this.c != null && this.c.isDisableCache() && bDLocation.getLocType() == 65) {
                    return;
                }
                this.t.onReceiveLocation(bDLocation);
            }
        } catch (Exception e) {
        }
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        double[] coorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
        bDLocation2.setLatitude(coorEncrypt[1]);
        bDLocation2.setLongitude(coorEncrypt[0]);
        return bDLocation2;
    }

    public String getAccessKey() {
        try {
            this.v = i.b(this.e);
            if (TextUtils.isEmpty(this.v)) {
                throw new IllegalStateException("please setting key from Manifest.xml");
            }
            return String.format("KEY=%s", this.v);
        } catch (Exception e) {
            return null;
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.k;
    }

    public LocationClientOption getLocOption() {
        return this.c;
    }

    public String getVersion() {
        return "7.8.0";
    }

    public boolean isStarted() {
        return this.d;
    }

    @Override // com.baidu.location.a.d.b
    public void onReceiveFixLocation(BDLocation bDLocation) {
        Message obtainMessage = this.g.obtainMessage(CyberPlayerManager.MEDIA_INFO_BUFFERING_END);
        obtainMessage.obj = bDLocation;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.location.a.c.a
    public void onReceiveLocation(BDLocation bDLocation) {
        if ((!this.F || this.E) && bDLocation != null) {
            Message obtainMessage = this.g.obtainMessage(CyberPlayerManager.MEDIA_INFO_BUFFERING_START);
            obtainMessage.obj = bDLocation;
            obtainMessage.sendToTarget();
        }
    }

    public void registerLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.g.obtainMessage(1300);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.g.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.g.obtainMessage(8);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean requestHotSpotState() {
        if (this.f == null || !this.d) {
            return false;
        }
        try {
            this.f.send(Message.obtain((Handler) null, 406));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int requestLocation() {
        if (this.f == null || this.h == null) {
            return 1;
        }
        if ((this.i == null || this.i.size() < 1) && (this.j == null || this.j.size() < 1)) {
            return 2;
        }
        if (System.currentTimeMillis() - this.a < 1000) {
            return 6;
        }
        this.m = true;
        Message obtainMessage = this.g.obtainMessage(4);
        obtainMessage.arg1 = 0;
        obtainMessage.sendToTarget();
        return 0;
    }

    public void requestNotifyLocation() {
        this.g.obtainMessage(11).sendToTarget();
    }

    public int requestOfflineLocation() {
        if (this.f == null || this.h == null) {
            return 1;
        }
        if ((this.i == null || this.i.size() < 1) && (this.j == null || this.j.size() < 1)) {
            return 2;
        }
        this.g.obtainMessage(12).sendToTarget();
        return 0;
    }

    public void restart() {
        stop();
        this.x = false;
        this.g.sendEmptyMessageDelayed(1, 1000L);
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (locationClientOption.a() > 0) {
            locationClientOption.setScanSpan(0);
            locationClientOption.setLocationNotify(true);
        }
        Message obtainMessage = this.g.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public void start() {
        this.x = false;
        this.g.obtainMessage(1).sendToTarget();
    }

    public boolean startIndoorMode() {
        boolean a2 = a(110);
        if (a2) {
            this.w = true;
        }
        return a2;
    }

    public void stop() {
        this.x = true;
        this.g.obtainMessage(2).sendToTarget();
        this.C = null;
        this.D = null;
    }

    public boolean stopIndoorMode() {
        boolean a2 = a(111);
        if (a2) {
            this.w = false;
        }
        return a2;
    }

    public void unRegisterLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.g.obtainMessage(1400);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.g.obtainMessage(6);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) {
        if (this.f == null || this.h == null || location == null) {
            return false;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 57);
            obtain.obj = location;
            this.f.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
