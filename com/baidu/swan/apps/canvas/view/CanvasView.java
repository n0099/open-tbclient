package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import d.b.h0.a.i2.k0;
import d.b.h0.a.y.a.j.f;
import d.b.h0.a.y.a.j.f0;
import d.b.h0.a.y.a.j.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CanvasView extends AbsCanvasView {

    /* renamed from: f  reason: collision with root package name */
    public List<b> f11788f;

    /* renamed from: g  reason: collision with root package name */
    public final DrawFilter f11789g;

    /* renamed from: h  reason: collision with root package name */
    public int f11790h;
    public HashMap<String, Bitmap> i;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CanvasView.this.d();
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<d.b.h0.a.y.a.j.a> f11792a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.h0.a.y.a.j.b f11793b;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public void c(List<d.b.h0.a.y.a.j.a> list, boolean z) {
        if (list == null || this.f11788f.contains(list)) {
            return;
        }
        if (!z) {
            this.f11788f.clear();
        }
        int size = this.f11788f.size();
        boolean z2 = z && size > 0;
        b bVar = new b(null);
        if (z2) {
            b bVar2 = this.f11788f.get(size - 1);
            bVar.f11793b = bVar2.f11793b;
            List<d.b.h0.a.y.a.j.a> list2 = bVar2.f11792a;
            bVar.f11792a = list2;
            list2.addAll(list);
        } else {
            bVar.f11793b = new d.b.h0.a.y.a.j.b(this);
            bVar.f11792a = list;
        }
        this.f11788f.add(bVar);
        k0.X(new a());
    }

    public final void d() {
        int i = this.f11790h;
        if (this.f11788f.size() > 0) {
            for (b bVar : this.f11788f) {
                Iterator<d.b.h0.a.y.a.j.a> it = bVar.f11792a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        d.b.h0.a.y.a.j.a next = it.next();
                        if (next instanceof f) {
                            i = 2;
                        } else if (next instanceof f0) {
                            i = 1;
                            break;
                        }
                    }
                }
            }
        }
        if (getLayerType() != i) {
            setLayerType(i, null);
        }
    }

    public Bitmap e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.i.get(str);
    }

    public synchronized void f() {
        this.i.clear();
    }

    public d.b.h0.a.y.a.j.b getCanvasContext() {
        if (this.f11788f.size() > 0) {
            List<b> list = this.f11788f;
            return list.get(list.size() - 1).f11793b;
        }
        return null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11788f.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.f11789g);
            for (b bVar : this.f11788f) {
                List<d.b.h0.a.y.a.j.a> list = bVar.f11792a;
                d.b.h0.a.y.a.j.b bVar2 = bVar.f11793b;
                bVar2.e();
                for (d.b.h0.a.y.a.j.a aVar : list) {
                    aVar.a(bVar2, canvas);
                    if (aVar instanceof k) {
                        ((k) aVar).e(this.i);
                    }
                }
            }
            canvas.restore();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return a() || super.onTouchEvent(motionEvent);
    }

    public void setOnDrawCompleteLinstener(c cVar) {
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11788f = new ArrayList();
        this.f11789g = new PaintFlagsDrawFilter(0, 3);
        this.f11790h = 0;
        this.i = new HashMap<>();
        this.f11790h = getLayerType();
    }
}
