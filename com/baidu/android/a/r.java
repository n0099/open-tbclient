package com.baidu.android.a;

import android.content.Context;
import android.os.Environment;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class r {
    private static r a = null;
    private ArrayList b = new ArrayList();

    private r(Context context) {
        b(context);
    }

    public static synchronized r a(Context context) {
        r rVar;
        synchronized (r.class) {
            if (a == null) {
                a = new r(context);
            }
            rVar = a;
        }
        return rVar;
    }

    private void b(Context context) {
        ArrayList a2 = h.a(context.getApplicationContext()).a(2);
        if (a2 == null || a2.size() == 0) {
            return;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String str = !absolutePath.endsWith("/") ? absolutePath + "/" : absolutePath;
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            this.b.add(str + ((e) it.next()).b());
        }
    }

    public static void c() {
        if (a != null) {
            a.b();
        }
        a = null;
    }

    public ArrayList a() {
        return this.b;
    }

    public void b() {
        this.b = null;
    }
}
