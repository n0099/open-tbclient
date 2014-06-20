package com.baidu.android.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class b {
    private static b b = null;
    private ArrayList a = new ArrayList();

    private b(Context context) {
        b(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b(context);
            }
            bVar = b;
        }
        return bVar;
    }

    public static void b() {
        if (b != null) {
            b.c();
            b = null;
        }
    }

    private void b(Context context) {
        ArrayList a = h.a(context.getApplicationContext()).a(5);
        if (a == null || a.size() == 0) {
            return;
        }
        try {
            Iterator it = a.iterator();
            while (it.hasNext()) {
                this.a.add(Integer.valueOf(Integer.parseInt(((e) it.next()).b())));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
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
