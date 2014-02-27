package com.baidu.android.a;

import android.content.Context;
import android.os.Environment;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class i {
    private static i a = null;
    private ArrayList b = new ArrayList();

    private i(Context context) {
        b(context);
    }

    public static synchronized i a(Context context) {
        i iVar;
        synchronized (i.class) {
            if (a == null) {
                a = new i(context);
            }
            iVar = a;
        }
        return iVar;
    }

    private void b(Context context) {
        ArrayList a2 = o.a(context.getApplicationContext()).a(2);
        if (a2 == null || a2.size() == 0) {
            return;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String str = !absolutePath.endsWith("/") ? absolutePath + "/" : absolutePath;
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            this.b.add(str + ((k) it.next()).b());
        }
    }

    public static void c() {
        if (a != null) {
            a.b = null;
        }
        a = null;
    }

    public final ArrayList a() {
        return this.b;
    }

    public final void b() {
        this.b = null;
    }
}
