package com.baidu.android.systemmonitor.d.a;

import android.content.Context;
import android.os.Environment;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f777a = null;
    private ArrayList b = new ArrayList();

    private c(Context context) {
        b(context);
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f777a == null) {
                f777a = new c(context);
            }
            cVar = f777a;
        }
        return cVar;
    }

    private void b(Context context) {
        ArrayList a2 = i.a(context.getApplicationContext()).a(2);
        if (a2 == null || a2.size() == 0) {
            return;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String str = !absolutePath.endsWith("/") ? absolutePath + "/" : absolutePath;
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            this.b.add(str + ((b) it.next()).b());
        }
    }

    public static void c() {
        if (f777a != null) {
            f777a.b();
        }
        f777a = null;
    }

    public ArrayList a() {
        return this.b;
    }

    public void b() {
        this.b = null;
    }
}
