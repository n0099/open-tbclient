package com.baidu.android.nebula.d;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.a.g;
import com.baidu.android.nebula.a.e;
import com.baidu.android.nebula.b.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private static b a = null;
    private m b = null;
    private Context c;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    public static void a(Context context, Intent intent) {
        a().a(context);
    }

    public static synchronized void b() {
        synchronized (b.class) {
            if (a != null) {
                a.d();
                a = null;
            }
        }
    }

    public boolean a(Context context) {
        if (this.b == null) {
            this.b = new m(context);
        }
        if (this.b.c()) {
            return true;
        }
        boolean a2 = this.b.a();
        if (a2) {
            this.c = context;
            com.baidu.android.nebula.d.a.a.a(this.c);
            return a2;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(g.START_FAIL_EVENT);
        com.baidu.android.systemmonitor.a.a.a(context).a(arrayList);
        return a2;
    }

    public Context c() {
        return this.c;
    }

    public void d() {
        if (this.b.c()) {
            this.b.b();
        }
        e.a();
    }
}
