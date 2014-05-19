package com.baidu.android.nebula.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
/* loaded from: classes.dex */
public final class BDLocationManager {
    private static BDLocationManager b;
    private static int h = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
    private Context a;
    private c c;
    private String g;
    private Handler m;
    private LocationClient d = null;
    private BaiduLocationListener e = null;
    private boolean i = false;
    private boolean j = true;
    private long k = 0;
    private Runnable l = new a(this);
    private Timer n = new Timer();
    private ArrayList f = new ArrayList();

    /* loaded from: classes.dex */
    public class BaiduLocationListener implements NoProGuard, BDLocationListener {
        public BaiduLocationListener() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
            if (android.text.TextUtils.equals(r1, r2) == false) goto L35;
         */
        @Override // com.baidu.location.BDLocationListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceiveLocation(BDLocation bDLocation) {
            String str;
            String str2;
            String str3;
            BDLocationManager.this.i = false;
            if (bDLocation == null) {
                Log.d("BDLocationManager", "BaiduLocationListener return null");
                return;
            }
            int locType = bDLocation.getLocType();
            if (locType == 61 || locType == 161 || locType == 65) {
                c cVar = BDLocationManager.this.c;
                if (cVar == null) {
                    cVar = new c();
                }
                cVar.a = System.currentTimeMillis();
                cVar.b = bDLocation.getLongitude();
                cVar.c = bDLocation.getLatitude();
                cVar.d = 1000.0d;
                cVar.e = bDLocation.getAddrStr();
                if (BDLocationManager.this.c != null) {
                    str2 = BDLocationManager.this.c.e;
                    str3 = cVar.e;
                }
                BDLocationManager bDLocationManager = BDLocationManager.this;
                str = cVar.e;
                bDLocationManager.a(str);
                BDLocationManager.this.c = cVar;
            }
            synchronized (BDLocationManager.this.f) {
                Iterator it = BDLocationManager.this.f.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).a(BDLocationManager.this.c);
                }
            }
            BDLocationManager.this.i = false;
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceivePoi(BDLocation bDLocation) {
        }
    }

    private BDLocationManager(Context context) {
        this.g = null;
        this.m = null;
        this.a = context.getApplicationContext();
        this.g = com.baidu.android.moplus.util.b.b(context, context.getPackageName(), "LocServiceName");
        if (a(this.a)) {
            e();
        }
        this.m = new Handler(context.getMainLooper());
        g();
    }

    public static synchronized void a() {
        synchronized (BDLocationManager.class) {
            if (b != null) {
                b.d();
                b = null;
            }
        }
    }

    private void a(long j) {
        if (j < 0) {
            return;
        }
        g();
        if (!this.i || SystemClock.elapsedRealtime() - this.k > 32000) {
            this.m.removeCallbacks(this.l);
            this.m.postDelayed(this.l, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            str2 = com.baidu.android.systemmonitor.security.a.a(str);
        } catch (Exception e) {
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.a).edit();
        edit.putString("rcd_key_lcaddr", str2);
        edit.commit();
    }

    public static boolean a(Context context) {
        boolean z;
        try {
            z = Class.forName("com.baidu.location.LocationClient") != null;
        } catch (ClassNotFoundException e) {
            z = false;
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            arrayList.add("android.permission.ACCESS_WIFI_STATE");
            arrayList.add("android.permission.CHANGE_WIFI_STATE");
            if (Build.VERSION.SDK_INT < 14) {
                arrayList.add("android.permission.MOUNT_UNMOUNT_FILESYSTEMS");
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (context.getPackageManager().checkPermission((String) it.next(), context.getPackageName()) != 0) {
                    return false;
                }
            }
        }
        return z;
    }

    public static synchronized BDLocationManager b(Context context) {
        BDLocationManager bDLocationManager;
        synchronized (BDLocationManager.class) {
            if (b == null) {
                b = new BDLocationManager(context.getApplicationContext());
            }
            bDLocationManager = b;
        }
        return bDLocationManager;
    }

    public static String c(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("rcd_key_lcaddr", "");
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return com.baidu.android.systemmonitor.security.a.b(string);
        } catch (Exception e) {
            return string;
        }
    }

    public static String d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("rcd_key_lcaddr", "");
    }

    private void d() {
        if (this.d == null || b == null || this.e == null) {
            return;
        }
        this.d.unRegisterLocationListener(this.e);
        this.d.stop();
        this.e = null;
        this.d = null;
    }

    private void e() {
        this.d = new LocationClient(this.a);
        this.e = new BaiduLocationListener();
        this.d.registerLocationListener(this.e);
        this.d.setLocOption(f());
        this.d.start();
    }

    private LocationClientOption f() {
        LocationClientOption locationClientOption = new LocationClientOption();
        locationClientOption.setOpenGps(false);
        locationClientOption.setAddrType("all");
        locationClientOption.setCoorType("bd09");
        locationClientOption.setProdName("bd_service_android");
        if (this.g != null) {
            locationClientOption.setServiceName(this.g);
        }
        return locationClientOption;
    }

    private void g() {
        if (this.n != null) {
            this.n.cancel();
            this.n = new Timer();
        }
        this.n.schedule(new b(this), 1800000L);
    }

    public void a(e eVar) {
        synchronized (this.f) {
            if (!this.f.contains(eVar)) {
                this.f.add(eVar);
            }
        }
    }

    public void a(boolean z) {
        if (this.d == null) {
            return;
        }
        LocationClientOption f = f();
        f.setOpenGps(z);
        this.d.setLocOption(f);
    }

    public c b() {
        long j;
        g();
        c cVar = this.c;
        if (cVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            j = cVar.a;
            if (currentTimeMillis - j > h) {
                return null;
            }
            return cVar;
        }
        return cVar;
    }

    public void b(e eVar) {
        synchronized (this.f) {
            this.f.remove(eVar);
        }
    }

    public void c() {
        if (!this.j) {
            a(0L);
            return;
        }
        a(1000L);
        this.j = false;
    }
}
