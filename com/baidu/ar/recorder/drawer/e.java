package com.baidu.ar.recorder.drawer;

import android.content.Context;
import android.util.Log;
import android.view.Surface;
import com.baidu.ar.recorder.filter.FilterManager;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class e {
    private static final String a = e.class.getSimpleName();
    private g b;
    private ArrayList<d> c;
    private int d = 0;

    public e(Context context, Surface surface, ArrayList<b> arrayList) {
        a(context, surface, arrayList);
    }

    private void a(Context context, Surface surface, ArrayList<b> arrayList) {
        if (this.c == null) {
            this.c = new ArrayList<>();
        } else {
            this.c.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            try {
                this.c.add(new d(arrayList.get(i2)));
                if (arrayList.get(i2).e()) {
                    this.d = i2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i2 + 1;
        }
        if (surface != null) {
            this.b = new g(this.c.get(this.d).a(), surface, true);
        } else {
            this.b.a(this.c.get(this.d).a());
        }
        Iterator<d> it = this.c.iterator();
        while (it.hasNext()) {
            d next = it.next();
            this.b.b(next.a());
            next.a(context);
        }
    }

    public void a() {
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        if (this.c != null) {
            Iterator<d> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.c.clear();
            this.c = null;
        }
    }

    public void a(Context context, FilterManager.FilterType filterType) {
        Iterator<d> it = this.c.iterator();
        while (it.hasNext()) {
            d next = it.next();
            this.b.b(next.a());
            next.a(context, filterType);
        }
    }

    public void a(Context context, ArrayList<b> arrayList) {
        Log.d(a, "updateSurfaceDrawer !!!");
        this.b.b();
        Iterator<d> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.c.clear();
        a(context, null, arrayList);
    }

    public void a(float[] fArr, long j) {
        Log.d(a, "frameAvailable timestampNanos = " + j);
        if (this.b == null || this.c == null || this.c.size() == 0) {
            return;
        }
        Iterator<d> it = this.c.iterator();
        while (it.hasNext()) {
            d next = it.next();
            this.b.b(next.a());
            next.a(fArr);
        }
        this.b.a(j);
        this.b.c();
    }
}
