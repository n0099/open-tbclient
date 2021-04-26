package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import d.a.h0.a.i2.k0;
import d.a.h0.a.y.a.j.f;
import d.a.h0.a.y.a.j.f0;
import d.a.h0.a.y.a.j.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CanvasView extends AbsCanvasView {

    /* renamed from: f  reason: collision with root package name */
    public List<b> f11618f;

    /* renamed from: g  reason: collision with root package name */
    public final DrawFilter f11619g;

    /* renamed from: h  reason: collision with root package name */
    public int f11620h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, Bitmap> f11621i;

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
        public List<d.a.h0.a.y.a.j.a> f11623a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.h0.a.y.a.j.b f11624b;

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

    public void c(List<d.a.h0.a.y.a.j.a> list, boolean z) {
        if (list == null || this.f11618f.contains(list)) {
            return;
        }
        if (!z) {
            this.f11618f.clear();
        }
        int size = this.f11618f.size();
        boolean z2 = z && size > 0;
        b bVar = new b(null);
        if (z2) {
            b bVar2 = this.f11618f.get(size - 1);
            bVar.f11624b = bVar2.f11624b;
            List<d.a.h0.a.y.a.j.a> list2 = bVar2.f11623a;
            bVar.f11623a = list2;
            list2.addAll(list);
        } else {
            bVar.f11624b = new d.a.h0.a.y.a.j.b(this);
            bVar.f11623a = list;
        }
        this.f11618f.add(bVar);
        k0.X(new a());
    }

    public final void d() {
        int i2 = this.f11620h;
        if (this.f11618f.size() > 0) {
            for (b bVar : this.f11618f) {
                Iterator<d.a.h0.a.y.a.j.a> it = bVar.f11623a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        d.a.h0.a.y.a.j.a next = it.next();
                        if (next instanceof f) {
                            i2 = 2;
                        } else if (next instanceof f0) {
                            i2 = 1;
                            break;
                        }
                    }
                }
            }
        }
        if (getLayerType() != i2) {
            setLayerType(i2, null);
        }
    }

    public Bitmap e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f11621i.get(str);
    }

    public synchronized void f() {
        this.f11621i.clear();
    }

    public d.a.h0.a.y.a.j.b getCanvasContext() {
        if (this.f11618f.size() > 0) {
            List<b> list = this.f11618f;
            return list.get(list.size() - 1).f11624b;
        }
        return null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11618f.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.f11619g);
            for (b bVar : this.f11618f) {
                List<d.a.h0.a.y.a.j.a> list = bVar.f11623a;
                d.a.h0.a.y.a.j.b bVar2 = bVar.f11624b;
                bVar2.e();
                for (d.a.h0.a.y.a.j.a aVar : list) {
                    aVar.a(bVar2, canvas);
                    if (aVar instanceof k) {
                        ((k) aVar).e(this.f11621i);
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

    public CanvasView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11618f = new ArrayList();
        this.f11619g = new PaintFlagsDrawFilter(0, 3);
        this.f11620h = 0;
        this.f11621i = new HashMap<>();
        this.f11620h = getLayerType();
    }
}
