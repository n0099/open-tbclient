package com.baidu.android.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class o {
    private static o b = null;
    private ArrayList a = new ArrayList();

    private o(Context context) {
        b(context);
    }

    public static synchronized o a(Context context) {
        o oVar;
        synchronized (o.class) {
            if (b == null) {
                b = new o(context);
            }
            oVar = b;
        }
        return oVar;
    }

    public static void b() {
        if (b != null) {
            b.c();
            b = null;
        }
    }

    private void b(Context context) {
        ArrayList a = h.a(context.getApplicationContext()).a(6);
        if (a == null || a.size() == 0) {
            return;
        }
        Iterator it = a.iterator();
        while (it.hasNext()) {
            this.a.add(((e) it.next()).b());
        }
    }

    private void c() {
        this.a.clear();
        this.a = null;
    }

    public ArrayList a() {
        return this.a;
    }
}
