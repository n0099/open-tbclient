package com.baidu.android.systemmonitor.a.a;

import android.content.Context;
import android.os.Environment;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static i f378a = null;
    private ArrayList b = new ArrayList();

    private i(Context context) {
        b(context);
    }

    public static synchronized i a(Context context) {
        i iVar;
        synchronized (i.class) {
            if (f378a == null) {
                f378a = new i(context);
            }
            iVar = f378a;
        }
        return iVar;
    }

    private void b(Context context) {
        ArrayList a2 = n.a(context.getApplicationContext()).a(2);
        if (a2 == null || a2.size() == 0) {
            return;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String str = !absolutePath.endsWith("/") ? absolutePath + "/" : absolutePath;
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            this.b.add(str + ((l) it.next()).b());
        }
    }

    public static void c() {
        if (f378a != null) {
            f378a.b();
        }
        f378a = null;
    }

    public ArrayList a() {
        return this.b;
    }

    public void b() {
        this.b = null;
    }
}
