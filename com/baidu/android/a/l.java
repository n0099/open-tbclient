package com.baidu.android.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class l {
    private static l b = null;
    private ArrayList a = new ArrayList();

    private l(Context context) {
        b(context);
    }

    public static synchronized l a(Context context) {
        l lVar;
        synchronized (l.class) {
            if (b == null) {
                b = new l(context);
            }
            lVar = b;
        }
        return lVar;
    }

    public static void b() {
        if (b != null) {
            b.c();
            b = null;
        }
    }

    private void b(Context context) {
        ArrayList a = h.a(context.getApplicationContext()).a(4);
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
