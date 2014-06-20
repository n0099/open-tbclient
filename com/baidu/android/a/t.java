package com.baidu.android.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class t {
    public static final String a = c();
    private static t e = null;
    public static final String b = a + "/xcloudboss?r=config/distribute";
    private HashMap d = new HashMap();
    public String c = a + "/xcloudboss?r=log/upload";

    private t(Context context) {
        b(context);
    }

    public static synchronized t a(Context context) {
        t tVar;
        synchronized (t.class) {
            if (e == null) {
                e = new t(context);
            }
            tVar = e;
        }
        return tVar;
    }

    public static void b() {
        if (e != null) {
            e.d();
            e = null;
        }
    }

    private void b(Context context) {
        ArrayList a2 = h.a(context.getApplicationContext()).a(0);
        if (a2 == null || a2.size() == 0) {
            return;
        }
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            this.d.put(eVar.a(), eVar.b());
        }
    }

    private static String c() {
        return com.baidu.android.systemmonitor.util.a.m() != null ? com.baidu.android.systemmonitor.util.a.m() : "http://m.baidu.com";
    }

    private void d() {
        this.d = null;
    }

    public String a() {
        return (this.d == null || TextUtils.isEmpty((CharSequence) this.d.get("upload"))) ? this.c : (String) this.d.get("upload");
    }
}
