package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import d.a.l0.a.a0.a.j.f;
import d.a.l0.a.a0.a.j.f0;
import d.a.l0.a.a0.a.j.k;
import d.a.l0.a.v2.q0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CanvasView extends AbsCanvasView {

    /* renamed from: f  reason: collision with root package name */
    public List<b> f10727f;

    /* renamed from: g  reason: collision with root package name */
    public final DrawFilter f10728g;

    /* renamed from: h  reason: collision with root package name */
    public int f10729h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, Bitmap> f10730i;

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
        public List<d.a.l0.a.a0.a.j.a> f10732a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.l0.a.a0.a.j.b f10733b;

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

    public void c(List<d.a.l0.a.a0.a.j.a> list, boolean z) {
        if (list == null || this.f10727f.contains(list)) {
            return;
        }
        if (!z) {
            this.f10727f.clear();
        }
        int size = this.f10727f.size();
        boolean z2 = z && size > 0;
        b bVar = new b(null);
        if (z2) {
            b bVar2 = this.f10727f.get(size - 1);
            bVar.f10733b = bVar2.f10733b;
            List<d.a.l0.a.a0.a.j.a> list2 = bVar2.f10732a;
            bVar.f10732a = list2;
            list2.addAll(list);
        } else {
            bVar.f10733b = new d.a.l0.a.a0.a.j.b(this);
            bVar.f10732a = list;
        }
        this.f10727f.add(bVar);
        q0.b0(new a());
    }

    public final void d() {
        int i2 = this.f10729h;
        if (this.f10727f.size() > 0) {
            for (b bVar : this.f10727f) {
                Iterator<d.a.l0.a.a0.a.j.a> it = bVar.f10732a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        d.a.l0.a.a0.a.j.a next = it.next();
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
        return this.f10730i.get(str);
    }

    public synchronized void f() {
        this.f10730i.clear();
    }

    public d.a.l0.a.a0.a.j.b getCanvasContext() {
        if (this.f10727f.size() > 0) {
            List<b> list = this.f10727f;
            return list.get(list.size() - 1).f10733b;
        }
        return null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f10727f.size() > 0) {
            int save = canvas.save();
            canvas.setDrawFilter(this.f10728g);
            for (b bVar : this.f10727f) {
                List<d.a.l0.a.a0.a.j.a> list = bVar.f10732a;
                d.a.l0.a.a0.a.j.b bVar2 = bVar.f10733b;
                bVar2.e();
                for (d.a.l0.a.a0.a.j.a aVar : list) {
                    aVar.a(bVar2, canvas);
                    if (aVar instanceof k) {
                        ((k) aVar).e(this.f10730i);
                    }
                }
            }
            if (canvas.getSaveCount() > 0) {
                canvas.restoreToCount(save);
            }
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
        this.f10727f = new ArrayList();
        this.f10728g = new PaintFlagsDrawFilter(0, 3);
        this.f10729h = 0;
        this.f10730i = new HashMap<>();
        this.f10729h = getLayerType();
    }
}
