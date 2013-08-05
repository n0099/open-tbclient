package com.baidu.android.systemmonitor.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final String f651a = c();
    private static m e = null;
    public static final String b = f651a + "/xcloudboss?r=config/distribute";
    private HashMap d = new HashMap();
    public String c = f651a + "/xcloudboss?r=log/upload";

    private m(Context context) {
        b(context);
    }

    public static synchronized m a(Context context) {
        m mVar;
        synchronized (m.class) {
            if (e == null) {
                e = new m(context);
            }
            mVar = e;
        }
        return mVar;
    }

    public static void b() {
        if (e != null) {
            e.d();
            e = null;
        }
    }

    private void b(Context context) {
        ArrayList a2 = n.a(context.getApplicationContext()).a(0);
        if (a2 == null || a2.size() == 0) {
            return;
        }
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            this.d.put(lVar.a(), lVar.b());
        }
    }

    private static String c() {
        return com.baidu.android.systemmonitor.a.a.j() != null ? com.baidu.android.systemmonitor.a.a.j() : "http://m.baidu.com";
    }

    private void d() {
        this.d = null;
    }

    public String a() {
        return (this.d == null || TextUtils.isEmpty((CharSequence) this.d.get("upload"))) ? this.c : (String) this.d.get("upload");
    }
}
