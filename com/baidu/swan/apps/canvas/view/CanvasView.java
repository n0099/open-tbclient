package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import d.a.m0.a.a0.a.j.f;
import d.a.m0.a.a0.a.j.f0;
import d.a.m0.a.a0.a.j.k;
import d.a.m0.a.v2.q0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CanvasView extends AbsCanvasView {

    /* renamed from: f  reason: collision with root package name */
    public List<b> f10809f;

    /* renamed from: g  reason: collision with root package name */
    public final DrawFilter f10810g;

    /* renamed from: h  reason: collision with root package name */
    public int f10811h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, Bitmap> f10812i;

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
        public List<d.a.m0.a.a0.a.j.a> f10814a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.m0.a.a0.a.j.b f10815b;

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

    public void c(List<d.a.m0.a.a0.a.j.a> list, boolean z) {
        if (list == null || this.f10809f.contains(list)) {
            return;
        }
        if (!z) {
            this.f10809f.clear();
        }
        int size = this.f10809f.size();
        boolean z2 = z && size > 0;
        b bVar = new b(null);
        if (z2) {
            b bVar2 = this.f10809f.get(size - 1);
            bVar.f10815b = bVar2.f10815b;
            List<d.a.m0.a.a0.a.j.a> list2 = bVar2.f10814a;
            bVar.f10814a = list2;
            list2.addAll(list);
        } else {
            bVar.f10815b = new d.a.m0.a.a0.a.j.b(this);
            bVar.f10814a = list;
        }
        this.f10809f.add(bVar);
        q0.b0(new a());
    }

    public final void d() {
        int i2 = this.f10811h;
        if (this.f10809f.size() > 0) {
            for (b bVar : this.f10809f) {
                Iterator<d.a.m0.a.a0.a.j.a> it = bVar.f10814a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        d.a.m0.a.a0.a.j.a next = it.next();
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
        return this.f10812i.get(str);
    }

    public synchronized void f() {
        this.f10812i.clear();
    }

    public d.a.m0.a.a0.a.j.b getCanvasContext() {
        if (this.f10809f.size() > 0) {
            List<b> list = this.f10809f;
            return list.get(list.size() - 1).f10815b;
        }
        return null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f10809f.size() > 0) {
            int save = canvas.save();
            canvas.setDrawFilter(this.f10810g);
            for (b bVar : this.f10809f) {
                List<d.a.m0.a.a0.a.j.a> list = bVar.f10814a;
                d.a.m0.a.a0.a.j.b bVar2 = bVar.f10815b;
                bVar2.e();
                for (d.a.m0.a.a0.a.j.a aVar : list) {
                    aVar.a(bVar2, canvas);
                    if (aVar instanceof k) {
                        ((k) aVar).e(this.f10812i);
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
        this.f10809f = new ArrayList();
        this.f10810g = new PaintFlagsDrawFilter(0, 3);
        this.f10811h = 0;
        this.f10812i = new HashMap<>();
        this.f10811h = getLayerType();
    }
}
