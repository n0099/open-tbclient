package com.baidu.ar.recorder.b;

import android.content.Context;
import android.util.Log;
import android.view.Surface;
import com.baidu.ar.recorder.filter.FilterManager;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class e {
    private static final String a = e.class.getSimpleName();
    private f b;
    private ArrayList<c> c;
    private int d = 0;

    public e(Context context, Surface surface, ArrayList<a> arrayList) {
        if (context == null || surface == null || arrayList == null) {
            return;
        }
        a(context, surface, arrayList);
    }

    private void a(Context context, Surface surface, ArrayList<a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
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
                this.c.add(new c(arrayList.get(i2)));
                if (arrayList.get(i2).e()) {
                    this.d = i2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i2 + 1;
        }
        if (this.c.size() > this.d) {
            if (surface != null) {
                this.b = new f(this.c.get(this.d).a(), surface, true);
            } else {
                this.b.a(this.c.get(this.d).a());
            }
        }
        Iterator<c> it = this.c.iterator();
        while (it.hasNext()) {
            c next = it.next();
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
            Iterator<c> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.c.clear();
            this.c = null;
        }
    }

    public void a(Context context, FilterManager.FilterType filterType) {
        Iterator<c> it = this.c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            this.b.b(next.a());
            next.a(context, filterType);
        }
    }

    public void a(Context context, ArrayList<a> arrayList) {
        Log.d(a, "updateSurfaceDrawer !!!");
        this.b.b();
        Iterator<c> it = this.c.iterator();
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
        Iterator<c> it = this.c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            this.b.b(next.a());
            next.a(fArr);
        }
        this.b.a(j);
        this.b.c();
    }
}
