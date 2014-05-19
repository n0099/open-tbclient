package com.baidu.android.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class l {
    public static final String a = c();
    private static l e = null;
    public static final String b = a + "/xcloudboss?r=config/distribute";
    private HashMap d = new HashMap();
    public String c = a + "/xcloudboss?r=log/upload";

    private l(Context context) {
        b(context);
    }

    public static synchronized l a(Context context) {
        l lVar;
        synchronized (l.class) {
            if (e == null) {
                e = new l(context);
            }
            lVar = e;
        }
        return lVar;
    }

    public static void b() {
        if (e != null) {
            e.d();
            e = null;
        }
    }

    private void b(Context context) {
        ArrayList a2 = o.a(context.getApplicationContext()).a(0);
        if (a2 == null || a2.size() == 0) {
            return;
        }
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            this.d.put(kVar.a(), kVar.b());
        }
    }

    private static String c() {
        return com.baidu.android.systemmonitor.c.a.m() != null ? com.baidu.android.systemmonitor.c.a.m() : "http://m.baidu.com";
    }

    private void d() {
        this.d = null;
    }

    public String a() {
        return (this.d == null || TextUtils.isEmpty((CharSequence) this.d.get("upload"))) ? this.c : (String) this.d.get("upload");
    }
}
