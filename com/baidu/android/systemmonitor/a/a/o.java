package com.baidu.android.systemmonitor.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class o {
    private static o g = null;

    /* renamed from: a  reason: collision with root package name */
    private boolean f383a = true;
    private boolean b = true;
    private boolean c = true;
    private int d = 3;
    private int e = 24;
    private HashMap f = new HashMap();

    private o(Context context) {
        b(context);
    }

    public static synchronized o a(Context context) {
        o oVar;
        synchronized (o.class) {
            if (g == null) {
                g = new o(context);
            }
            oVar = g;
        }
        return oVar;
    }

    private void b(Context context) {
        ArrayList a2 = n.a(context.getApplicationContext()).a(1);
        if (a2 == null || a2.size() == 0) {
            return;
        }
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            this.f.put(lVar.a(), lVar.b());
        }
        com.baidu.android.moplus.util.b.b(context, b());
    }

    public static void f() {
        if (g != null) {
            g.g();
            g = null;
        }
    }

    private void g() {
        this.f = null;
    }

    public boolean a() {
        return com.baidu.android.systemmonitor.a.a.f() != -1 ? com.baidu.android.systemmonitor.a.a.f() == 1 : (this.f == null || TextUtils.isEmpty((CharSequence) this.f.get("tjenable"))) ? this.f383a : Boolean.parseBoolean((String) this.f.get("tjenable"));
    }

    public boolean b() {
        return com.baidu.android.systemmonitor.a.a.b() != -1 ? com.baidu.android.systemmonitor.a.a.b() == 1 : (this.f == null || TextUtils.isEmpty((CharSequence) this.f.get("localserverenable"))) ? this.c : Boolean.parseBoolean((String) this.f.get("localserverenable"));
    }

    public boolean c() {
        return com.baidu.android.systemmonitor.a.a.a() != -1 ? com.baidu.android.systemmonitor.a.a.a() == 1 : (this.f == null || TextUtils.isEmpty((CharSequence) this.f.get("pushenable"))) ? this.b : Boolean.parseBoolean((String) this.f.get("pushenable"));
    }

    public long d() {
        return com.baidu.android.systemmonitor.a.a.c() != -1 ? com.baidu.android.systemmonitor.a.a.c() * 86400000 : (this.f == null || TextUtils.isEmpty((CharSequence) this.f.get("tj_data_remain_time"))) ? this.d * 86400000 : Long.parseLong((String) this.f.get("tj_data_remain_time")) * 86400000;
    }

    public long e() {
        return com.baidu.android.systemmonitor.a.a.d() != -1 ? com.baidu.android.systemmonitor.a.a.d() * 60000 : (this.f == null || TextUtils.isEmpty((CharSequence) this.f.get("tj_data_upload_interval"))) ? this.e * 3600000 : Long.parseLong((String) this.f.get("tj_data_upload_interval")) * 3600000;
    }
}
