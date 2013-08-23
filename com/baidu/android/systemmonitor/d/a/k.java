package com.baidu.android.systemmonitor.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class k {
    private static k g = null;

    /* renamed from: a  reason: collision with root package name */
    private boolean f694a = true;
    private boolean b = true;
    private boolean c = true;
    private int d = 3;
    private int e = 24;
    private HashMap f = new HashMap();

    private k(Context context) {
        b(context);
    }

    public static synchronized k a(Context context) {
        k kVar;
        synchronized (k.class) {
            if (g == null) {
                g = new k(context);
            }
            kVar = g;
        }
        return kVar;
    }

    private void b(Context context) {
        ArrayList a2 = i.a(context.getApplicationContext()).a(1);
        if (a2 == null || a2.size() == 0) {
            return;
        }
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            this.f.put(bVar.a(), bVar.b());
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
        return com.baidu.android.systemmonitor.d.d.f() != -1 ? com.baidu.android.systemmonitor.d.d.f() == 1 : (this.f == null || TextUtils.isEmpty((CharSequence) this.f.get("tjenable"))) ? this.f694a : Boolean.parseBoolean((String) this.f.get("tjenable"));
    }

    public boolean b() {
        return com.baidu.android.systemmonitor.d.d.b() != -1 ? com.baidu.android.systemmonitor.d.d.b() == 1 : (this.f == null || TextUtils.isEmpty((CharSequence) this.f.get("localserverenable"))) ? this.c : Boolean.parseBoolean((String) this.f.get("localserverenable"));
    }

    public boolean c() {
        return com.baidu.android.systemmonitor.d.d.a() != -1 ? com.baidu.android.systemmonitor.d.d.a() == 1 : (this.f == null || TextUtils.isEmpty((CharSequence) this.f.get("pushenable"))) ? this.b : Boolean.parseBoolean((String) this.f.get("pushenable"));
    }

    public long d() {
        return com.baidu.android.systemmonitor.d.d.c() != -1 ? com.baidu.android.systemmonitor.d.d.c() * Util.MILLSECONDS_OF_DAY : (this.f == null || TextUtils.isEmpty((CharSequence) this.f.get("tj_data_remain_time"))) ? this.d * Util.MILLSECONDS_OF_DAY : Long.parseLong((String) this.f.get("tj_data_remain_time")) * Util.MILLSECONDS_OF_DAY;
    }

    public long e() {
        return com.baidu.android.systemmonitor.d.d.d() != -1 ? com.baidu.android.systemmonitor.d.d.d() * Util.MILLSECONDS_OF_MINUTE : (this.f == null || TextUtils.isEmpty((CharSequence) this.f.get("tj_data_upload_interval"))) ? this.e * Util.MILLSECONDS_OF_HOUR : Long.parseLong((String) this.f.get("tj_data_upload_interval")) * Util.MILLSECONDS_OF_HOUR;
    }
}
