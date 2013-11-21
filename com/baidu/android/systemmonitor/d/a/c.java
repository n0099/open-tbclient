package com.baidu.android.systemmonitor.d.a;

import android.content.Context;
import android.os.Environment;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f792a = null;
    private ArrayList b = new ArrayList();

    private c(Context context) {
        b(context);
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f792a == null) {
                f792a = new c(context);
            }
            cVar = f792a;
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
        if (f792a != null) {
            f792a.b();
        }
        f792a = null;
    }

    public ArrayList a() {
        return this.b;
    }

    public void b() {
        this.b = null;
    }
}
