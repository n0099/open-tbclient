package com.baidu.android.nebula.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.location.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class BDLocationManager {
    private static BDLocationManager b;
    private static int h = 2000;

    /* renamed from: a  reason: collision with root package name */
    private Context f288a;
    private c c;
    private String g;
    private Handler n;
    private com.baidu.location.e d = null;
    private BaiduLocationListener e = null;
    private boolean i = false;
    private boolean j = true;
    private long k = 0;
    private Runnable l = new a(this);
    private Runnable m = new b(this);
    private ArrayList f = new ArrayList();

    /* loaded from: classes.dex */
    public class BaiduLocationListener implements NoProGuard, com.baidu.location.c {
        public BaiduLocationListener() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
            if (r3 != r5) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00b4, code lost:
            if (r3 != r5) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00d9, code lost:
            if (android.text.TextUtils.equals(r1, r3) == false) goto L58;
         */
        @Override // com.baidu.location.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceiveLocation(com.baidu.location.a aVar) {
            double d;
            double d2;
            double d3;
            String str;
            boolean z;
            String str2;
            String str3;
            double d4;
            double d5;
            double d6;
            double d7;
            double d8;
            BDLocationManager.this.i = false;
            if (aVar == null) {
                Log.d("BDLocationManager", "BaiduLocationListener return null");
                return;
            }
            int d9 = aVar.d();
            if (d9 == 61 || d9 == 161 || d9 == 65) {
                c cVar = BDLocationManager.this.c;
                if (cVar == null) {
                    cVar = new c();
                }
                cVar.f291a = System.currentTimeMillis();
                cVar.b = aVar.b();
                cVar.c = aVar.a();
                cVar.d = 1000.0d;
                cVar.e = aVar.e();
                d = cVar.b;
                if (d < 1.0E-4d) {
                    d8 = cVar.c;
                    if (d8 < 1.0E-4d) {
                        BDLocationManager.this.c = null;
                        BDLocationManager.this.i = false;
                        BDLocationManager.this.a(0L);
                        return;
                    }
                }
                if (BDLocationManager.this.c != null) {
                    d6 = BDLocationManager.this.c.b;
                    d7 = cVar.b;
                }
                BDLocationManager bDLocationManager = BDLocationManager.this;
                d2 = cVar.b;
                bDLocationManager.a(d2);
                if (BDLocationManager.this.c != null) {
                    d4 = BDLocationManager.this.c.c;
                    d5 = cVar.c;
                }
                BDLocationManager bDLocationManager2 = BDLocationManager.this;
                d3 = cVar.c;
                bDLocationManager2.b(d3);
                if (BDLocationManager.this.c != null) {
                    str2 = BDLocationManager.this.c.e;
                    str3 = cVar.e;
                }
                BDLocationManager bDLocationManager3 = BDLocationManager.this;
                str = cVar.e;
                bDLocationManager3.a(str);
                BDLocationManager.this.c = cVar;
                z = false;
            } else if (d9 == 63) {
                z = true;
            } else {
                if (d9 == 167) {
                }
                z = false;
            }
            synchronized (BDLocationManager.this.f) {
                Iterator it = BDLocationManager.this.f.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).a(BDLocationManager.this.c);
                }
            }
            BDLocationManager.this.i = false;
            if (z) {
                BDLocationManager.this.a(0L);
            }
        }

        @Override // com.baidu.location.c
        public void onReceivePoi(com.baidu.location.a aVar) {
        }
    }

    private BDLocationManager(Context context) {
        this.g = null;
        this.n = null;
        this.f288a = context.getApplicationContext();
        this.g = com.baidu.android.moplus.util.b.b(context, context.getPackageName(), "LocServiceName");
        if (a(this.f288a)) {
            e();
        }
        this.n = new Handler(context.getMainLooper());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d) {
        if (d > 0.0d) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f288a).edit();
            edit.putString("rcd_key_lclong", String.valueOf(d));
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (j < 0) {
            return;
        }
        g();
        if (!this.i || SystemClock.elapsedRealtime() - this.k > 32000) {
            this.n.removeCallbacks(this.m);
            this.n.postDelayed(this.m, j);
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
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f288a).edit();
        edit.putString("rcd_key_lcaddr", str2);
        edit.commit();
    }

    public static boolean a(Context context) {
        boolean z;
        try {
            z = Class.forName("com.baidu.location.e") != null;
        } catch (ClassNotFoundException e) {
            z = false;
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            arrayList.add("android.permission.ACCESS_WIFI_STATE");
            arrayList.add("android.permission.CHANGE_WIFI_STATE");
            arrayList.add("android.permission.MOUNT_UNMOUNT_FILESYSTEMS");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(double d) {
        if (d > 0.0d) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f288a).edit();
            edit.putString("rcd_key_lclat", String.valueOf(d));
            edit.commit();
        }
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
        if (this.d == null) {
            return;
        }
        this.d.c(b.e);
        this.d.e();
        this.d = null;
    }

    private void e() {
        this.d = new com.baidu.location.e(this.f288a);
        this.e = new BaiduLocationListener();
        this.d.b(this.e);
        this.d.a(f());
        this.d.d();
    }

    private j f() {
        j jVar = new j();
        jVar.a(false);
        jVar.b("all");
        jVar.a("bd09");
        jVar.c("bd_service_android");
        if (this.g != null) {
            jVar.d(this.g);
        }
        return jVar;
    }

    private void g() {
        this.n.removeCallbacks(this.l);
        this.n.postDelayed(this.l, 1800000L);
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
        j f = f();
        f.a(z);
        this.d.a(f);
    }

    public c b() {
        long j;
        g();
        c cVar = this.c;
        if (cVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            j = cVar.f291a;
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
