package com.baidu.mapapi;

import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mapapi.cloud.GeoSearchListener;
import java.io.File;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class Mj {
    static boolean q;
    static boolean r;
    static final Uri t;
    private String G;
    private String H;
    private String I;

    /* renamed from: a  reason: collision with root package name */
    static f f528a = null;
    static final MKLocationManager b = new MKLocationManager();
    static int c = 2;
    static MapView d = null;
    private static Handler u = null;
    static Context e = null;
    static ServerSocket f = null;
    static int g = 0;
    static int h = 0;
    static int i = 0;
    static float j = 1.0f;
    static String k = "";
    private static String v = "";
    private static String w = "";
    private static String x = "";
    private static String y = "";
    public static int l = 0;
    public static int m = 0;
    public static int n = 0;
    public static int o = 0;
    public static int p = 0;
    static int s = -1;
    private static com.baidu.mapapi.b W = null;
    private static Method X = null;
    private static Method Y = null;
    private static Class Z = null;
    private TelephonyManager z = null;
    private WifiManager A = null;
    private j B = null;
    private j C = null;
    private j D = null;
    private j E = null;
    private com.baidu.mapapi.cloud.c F = null;
    private final long J = 3;
    private final long K = 3;
    private List L = null;
    private long M = 0;
    private long N = 0;
    private int O = 0;
    private int P = 0;
    private int Q = 0;
    private int R = 0;
    private int S = 0;
    private int T = 0;
    private List U = null;
    private List V = null;
    private Handler aa = new Handler();
    private ArrayList ab = new ArrayList();

    /* loaded from: classes.dex */
    class a {

        /* renamed from: a  reason: collision with root package name */
        int f530a = 0;
        int b;
        int c;
        int d;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public int f531a;
        public int b;

        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Mj.MsgMapProc(1, 8, this.f531a, 0);
            Mj.this.aa.postDelayed(this, this.b);
        }
    }

    static {
        try {
            System.loadLibrary("BMapApiEngine_v1_3_5");
        } catch (UnsatisfiedLinkError e2) {
            Log.d("BMapApiEngine_v1_3_5", "BMapApiEngine_v1_3_5 library not found!");
            Log.d("BMapApiEngine_v1_3_5", e2.getLocalizedMessage());
        }
        t = Uri.parse("content://telephony/carriers/preferapn");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mj(BMapManager bMapManager, Context context) {
        e = context;
        e();
    }

    public static native String AppendRecord(String str, String str2);

    public static native int DisableProviderCC(int i2);

    public static native int EnableProviderCC(int i2);

    public static native Bundle GetGPSStatus();

    public static native Bundle GetMapStatus();

    public static native Bundle GetNotifyInternal();

    public static native int InitLocationCC();

    public static native int InitMapControlCC(int i2, int i3);

    public static native int MapProc(int i2, int i3, int i4);

    public static native int MsgMapProc(int i2, int i3, int i4, int i5);

    public static native void SetCellData(int i2, int i3, int i4, int i5, String str, String str2, String str3);

    public static native void SetCellInfo(int i2, int i3, int i4, int i5, String str);

    public static native void SetLocationCoordinateType(int i2);

    public static native int SetNotifyInternal(int i2, int i3);

    public static native int SetProxyInfo(String str, int i2);

    public static native void SetUpdateWifi(String str);

    public static native void UpdataGPS(double d2, double d3, float f2, float f3, float f4, int i2);

    private void a(int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.ab.size()) {
                return;
            }
            b bVar = (b) this.ab.get(i4);
            if (bVar.f531a == i2) {
                if (BMapManager.c) {
                    this.aa.removeCallbacks(bVar);
                }
                this.ab.remove(i4);
                return;
            }
            i3 = i4 + 1;
        }
    }

    private void a(int i2, int i3) {
        Iterator it = this.ab.iterator();
        while (it.hasNext()) {
            if (((b) it.next()).f531a == i2) {
                return;
            }
        }
        b bVar = new b();
        bVar.f531a = i2;
        bVar.b = i3;
        if (BMapManager.c) {
            this.aa.postDelayed(bVar, 500L);
        }
        this.ab.add(bVar);
    }

    public static void changeGprsConnect() {
        String h2;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return;
        }
        if (!activeNetworkInfo.getTypeName().toLowerCase().equals("wifi")) {
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo != null) {
                if (!extraInfo.toLowerCase().contains(com.baidu.loginshare.e.d)) {
                    SetProxyInfo(null, 0);
                    return;
                }
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost == null) {
                    defaultHost = "10.0.0.172";
                }
                SetProxyInfo(defaultHost, defaultPort != -1 ? defaultPort : 80);
            }
        } else if (1 == s) {
            SetProxyInfo(null, 0);
        } else if (s != 0 || (h2 = h()) == null) {
        } else {
            if (!h2.toLowerCase().contains(com.baidu.loginshare.e.d)) {
                SetProxyInfo(null, 0);
                return;
            }
            String defaultHost2 = Proxy.getDefaultHost();
            int defaultPort2 = Proxy.getDefaultPort();
            if (defaultHost2 == null) {
                defaultHost2 = "10.0.0.172";
            }
            if (defaultPort2 == -1) {
                defaultPort2 = 80;
            }
            SetProxyInfo(defaultHost2, defaultPort2);
        }
    }

    private int d() {
        try {
            Z = Class.forName("android.telephony.cdma.CdmaCellLocation");
            X = Z.getMethod("getBaseStationId", new Class[0]);
            Y = Z.getMethod("getNetworkId", new Class[0]);
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private void e() {
        if (e != null) {
            File filesDir = e.getFilesDir();
            if (filesDir != null) {
                y = filesDir.getAbsolutePath();
            }
            if (this.z == null) {
                this.z = (TelephonyManager) e.getSystemService("phone");
            }
            if (this.z != null) {
                k = this.z.getDeviceId();
                v = this.z.getSubscriberId();
                w = Build.MODEL;
                x = Build.VERSION.SDK;
            }
            WindowManager windowManager = (WindowManager) e.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                g = defaultDisplay.getWidth();
                h = defaultDisplay.getHeight();
                defaultDisplay.getMetrics(displayMetrics);
            }
            j = displayMetrics.density;
            if (Integer.parseInt(Build.VERSION.SDK) > 3) {
                try {
                    i = Class.forName("android.util.DisplayMetrics").getField("densityDpi").getInt(displayMetrics);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    i = 160;
                }
            } else {
                i = 160;
            }
            try {
                this.H = e.getPackageManager().getPackageInfo(e.getPackageName(), 0).applicationInfo.loadLabel(e.getPackageManager()).toString();
                this.I = e.getPackageName();
            } catch (Exception e3) {
                Log.d("baidumap", e3.getMessage());
                this.H = null;
            }
        }
    }

    private static void f() {
        String g2 = g();
        if (g2 == null) {
            SetProxyInfo(null, 0);
        } else if (!g2.toLowerCase().contains(com.baidu.loginshare.e.d)) {
            SetProxyInfo(null, 0);
        } else {
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost == null) {
                defaultHost = "10.0.0.172";
            }
            if (defaultPort == -1) {
                defaultPort = 80;
            }
            SetProxyInfo(defaultHost, defaultPort);
        }
    }

    private static String g() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            if (!activeNetworkInfo.getTypeName().toLowerCase().equals("wifi")) {
                return activeNetworkInfo.getExtraInfo();
            }
            if (1 == s) {
                return null;
            }
            if (s == 0) {
                return h();
            }
        }
        return null;
    }

    public static native Bundle getNewBundle(int i2, int i3, int i4);

    private static String h() {
        Cursor query = e.getContentResolver().query(t, new String[]{"_id", "apn", "type"}, null, null, null);
        query.moveToFirst();
        if (query.isAfterLast()) {
            return null;
        }
        return query.getString(1);
    }

    public static native int initOfflineCC();

    public static native int initSearchCC();

    public static native void nativeDone();

    public static native void nativeInit();

    public static native void nativeRender();

    public static native void nativeResize(int i2, int i3);

    public static native void renderBaiduMap(Bitmap bitmap);

    public static native void renderCalDisScreenPos(Bundle bundle);

    public static native void renderFlsScreenPos(Bundle bundle);

    public static native void renderUpdateScreen(short[] sArr, int i2, int i3);

    public static native int sendBundle(Bundle bundle);

    public static native void sendPhoneInfo(Bundle bundle);

    public native int InitMapApiEngine();

    public void JNI_MapcallBackProc(int i2, int i3, int i4, int i5) {
        a aVar = new a();
        aVar.f530a = i2;
        aVar.b = i3;
        aVar.c = i4;
        aVar.d = i5;
        Message obtainMessage = u.obtainMessage(1, 1, 1, aVar);
        if (obtainMessage != null) {
            u.sendMessage(obtainMessage);
        }
    }

    public void JNI_callBackProc(int i2, int i3, int i4) {
        switch (i2) {
            case 9:
            case BdWebErrorView.ERROR_CODE_505 /* 505 */:
                if (d != null) {
                    d.a(i2, i3, i4);
                    return;
                }
                return;
            case 506:
                c();
                return;
            case 511:
                a(i3, i4);
                return;
            case 512:
                a(i3);
                return;
            case 5000:
                if (f528a != null) {
                    f528a.a(i2, i3, i4);
                    return;
                }
                return;
            case PushConstants.ERROR_NETWORK_ERROR /* 10001 */:
            case PushConstants.ERROR_SERVICE_NOT_AVAILABLE /* 10002 */:
            case PushConstants.ERROR_SERVICE_NOT_AVAILABLE_TEMP /* 10003 */:
            case 10004:
            case 10006:
            case 10010:
            case 10011:
            case 10012:
            case 10015:
            case 10016:
            case 10017:
            case 10018:
                if (this.C != null) {
                    this.C.a(new MKEvent(i2 - 10000, i3, i4));
                    return;
                }
                return;
            case 10005:
                if (b != null) {
                    b.c();
                    return;
                }
                return;
            case 10007:
            case 10009:
                if (this.B != null) {
                    this.B.a(new MKEvent(i2 - 10000, i3, i4));
                    return;
                }
                return;
            case 10013:
                if (this.D != null) {
                    this.D.a(new MKEvent(i3, i3, i4));
                    return;
                }
                return;
            case 10014:
                if (d != null) {
                    d.a(8020, i3, i4);
                }
                if (this.E != null) {
                    if (Math.abs(l - n) > 2 || Math.abs(m - o) > 2 || 1 == p) {
                        this.E.a(new MKEvent(i2 - 10000, i3, i4));
                    }
                    l = 0;
                    m = 0;
                    o = 0;
                    n = 0;
                    p = 0;
                    return;
                }
                return;
            case 10504:
            case 10505:
                this.F.a(new com.baidu.mapapi.cloud.a(i2 - 10000, i3, i4));
                return;
            default:
                return;
        }
    }

    public Bundle J_GetDevInfo(int i2) {
        Bundle bundle = new Bundle();
        switch (i2) {
            case 1:
                bundle.putString("im", k);
                break;
            case 2:
                bundle.putString("is", v);
                break;
            case 3:
                bundle.putString("mb", w);
                bundle.putString("os", "Android_" + x);
                bundle.putInt("cx", g);
                bundle.putInt("cy", h);
                bundle.putInt("xd", i);
                bundle.putInt("yd", i);
                break;
            case 4:
                bundle.putString("na", y);
                break;
        }
        return bundle;
    }

    public native int SetCacheDirectoryCC(String str);

    public native int StartApiEngineCC(String str, String str2, String str3);

    public native int StopApiEngineCC();

    public native int UnInitMapApiEngine();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MKMapViewListener mKMapViewListener) {
        this.E = new i(mKMapViewListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MKOfflineMapListener mKOfflineMapListener) {
        this.D = new k(mKOfflineMapListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MKSearchListener mKSearchListener) {
        this.C = new m(mKSearchListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        f();
        W = new com.baidu.mapapi.b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        e.registerReceiver(W, intentFilter, null, null);
        if (b != null) {
            this.N = 0L;
            this.V = null;
            this.T = 0;
            this.S = 0;
            b.a();
            UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
            SetCellData(0, 0, 0, 0, null, null, null);
            if (q) {
                b.enableProvider(0);
            }
            if (r) {
                b.enableProvider(1);
            }
        }
        Iterator it = this.ab.iterator();
        while (it.hasNext()) {
            this.aa.postDelayed((b) it.next(), 500L);
        }
        if (StartApiEngineCC(this.G, this.H, this.I) == 0) {
            try {
                if (W != null) {
                    e.unregisterReceiver(W);
                    W = null;
                }
            } catch (Exception e2) {
                Log.d("baidumap", e2.getMessage());
                W = null;
            }
            Iterator it2 = this.ab.iterator();
            while (it2.hasNext()) {
                this.aa.removeCallbacks((b) it2.next());
            }
            if (b != null) {
                b.b();
                return false;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, MKGeneralListener mKGeneralListener) {
        if (mKGeneralListener != null) {
            this.B = new g(mKGeneralListener);
        }
        this.G = str;
        if (f528a == null) {
            f528a = new f(e);
        }
        if (e != null) {
            if (this.z == null) {
                this.z = (TelephonyManager) e.getSystemService("phone");
            }
            if (this.A == null) {
                this.A = (WifiManager) e.getSystemService("wifi");
            }
            if (this.A != null && this.A.isWifiEnabled()) {
                this.A.startScan();
            }
        }
        u = new Handler() { // from class: com.baidu.mapapi.Mj.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                a aVar = (a) message.obj;
                Mj.MsgMapProc(aVar.f530a, aVar.b, aVar.c, aVar.d);
                super.handleMessage(message);
            }
        };
        try {
            if (initClass(new Bundle(), 0) == 0) {
                return false;
            }
            if (InitMapApiEngine() == 0) {
                return false;
            }
            this.ab.clear();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        } catch (UnsatisfiedLinkError e3) {
            e3.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        try {
            if (W != null) {
                e.unregisterReceiver(W);
                W = null;
            }
        } catch (Exception e2) {
            Log.d("baidumap", e2.getMessage());
            W = null;
        }
        Iterator it = this.ab.iterator();
        while (it.hasNext()) {
            this.aa.removeCallbacks((b) it.next());
        }
        if (b != null) {
            b.b();
        }
        return StopApiEngineCC() != 0;
    }

    boolean c() {
        String str;
        String str2;
        String str3;
        String str4;
        if (f528a == null) {
            return false;
        }
        if (this.z == null) {
            this.z = (TelephonyManager) e.getSystemService("phone");
        }
        if (this.z != null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - this.N > 3) {
                CellLocation cellLocation = this.z.getCellLocation();
                this.N = currentTimeMillis;
                if (cellLocation == null || !(cellLocation instanceof GsmCellLocation)) {
                    try {
                        if (Integer.parseInt(Build.VERSION.SDK) >= 5 && ((Z != null || -1 != d()) && Z.isInstance(cellLocation))) {
                            Object invoke = X.invoke(cellLocation, new Object[0]);
                            if (invoke instanceof Integer) {
                                this.R = ((Integer) invoke).intValue();
                                if (this.R < 0) {
                                    this.R = 0;
                                }
                                Object invoke2 = Y.invoke(cellLocation, new Object[0]);
                                if (invoke2 instanceof Integer) {
                                    this.Q = ((Integer) invoke2).intValue();
                                    if (this.Q < 0) {
                                        this.Q = 0;
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    this.R = gsmCellLocation.getCid();
                    if (this.R < 0) {
                        this.R = 0;
                    }
                    this.Q = gsmCellLocation.getLac();
                    if (this.Q < 0) {
                        this.Q = 0;
                    }
                }
                String networkOperator = this.z.getNetworkOperator();
                if (networkOperator != null && networkOperator.length() > 0 && !"null".equals(networkOperator)) {
                    try {
                        if (networkOperator.length() >= 3) {
                            this.O = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        }
                        if (networkOperator.length() >= 5) {
                            this.P = Integer.valueOf(networkOperator.substring(3, 5)).intValue();
                        }
                    } catch (NumberFormatException e3) {
                        e3.printStackTrace();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                try {
                    if (Z != null && Z.isInstance(cellLocation)) {
                        this.P = ((Integer) Z.getMethod("getSystemId", new Class[0]).invoke(cellLocation, new Object[0])).intValue();
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        } else {
            this.R = 0;
            this.Q = 0;
            this.O = 0;
            this.P = 0;
        }
        if (this.A == null) {
            this.A = (WifiManager) e.getSystemService("wifi");
        }
        if (this.A == null || !this.A.isWifiEnabled()) {
            this.U = null;
            SetUpdateWifi("");
        } else {
            long currentTimeMillis2 = System.currentTimeMillis() / 1000;
            if (currentTimeMillis2 - this.M > 3) {
                this.A.startScan();
                this.U = null;
                this.M = currentTimeMillis2;
            }
            this.U = this.A.getScanResults();
            if (this.U == null || this.U.size() <= 0) {
                SetUpdateWifi("");
            }
        }
        String str5 = "";
        if (this.R > 0 && this.Q >= 0 && this.O >= 0) {
            str5 = f528a.a(this.O, this.P, this.Q, this.R, this.L, "");
            if (str5.length() > 0) {
                str = str5;
                if (this.U != null || this.U.size() <= 0) {
                    str2 = "";
                    str3 = "";
                } else {
                    f528a.a(this.U);
                    String a2 = f528a.a(this.U, str5);
                    if (a2.length() > 0) {
                        SetUpdateWifi(a2);
                        str4 = a2;
                    } else {
                        str4 = "";
                    }
                    str2 = f528a.b(this.U, a2);
                    if (str2.length() > 0) {
                        str3 = str4;
                    } else {
                        str2 = "";
                        str3 = str4;
                    }
                }
                if (this.T == this.R || this.S != this.Q || !f528a.a(this.U, this.V)) {
                    this.V = this.U;
                    this.T = this.R;
                    this.S = this.Q;
                    SetCellData(this.R, this.Q, this.O, this.P, str, str3, str2);
                }
                return true;
            }
        }
        str = "";
        if (this.U != null) {
        }
        str2 = "";
        str3 = "";
        if (this.T == this.R) {
        }
        this.V = this.U;
        this.T = this.R;
        this.S = this.Q;
        SetCellData(this.R, this.Q, this.O, this.P, str, str3, str2);
        return true;
    }

    public native int initClass(Object obj, int i2);

    public void initGeoListener(GeoSearchListener geoSearchListener) {
        this.F = new com.baidu.mapapi.cloud.b(geoSearchListener);
    }
}
