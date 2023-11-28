package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tieba.bk3;
import com.baidu.tieba.oz1;
import com.baidu.tieba.pz1;
import com.baidu.tieba.t02;
import com.baidu.tieba.tz1;
import com.baidu.tieba.yz1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class CanvasView extends AbsCanvasView {
    public List<b> b;
    public final DrawFilter c;
    public int d;
    public HashMap<String, Bitmap> e;

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CanvasView.this.d();
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public List<oz1> a;
        public pz1 b;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public Bitmap e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.e.get(str);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!a() && !super.onTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new ArrayList();
        this.c = new PaintFlagsDrawFilter(0, 3);
        this.d = 0;
        this.e = new HashMap<>();
        this.d = getLayerType();
    }

    public void c(List<oz1> list, boolean z) {
        boolean z2;
        if (list != null && !this.b.contains(list)) {
            if (!z) {
                this.b.clear();
            }
            int size = this.b.size();
            if (z && size > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            b bVar = new b(null);
            if (z2) {
                b bVar2 = this.b.get(size - 1);
                bVar.b = bVar2.b;
                List<oz1> list2 = bVar2.a;
                bVar.a = list2;
                list2.addAll(list);
            } else {
                bVar.b = new pz1(this);
                bVar.a = list;
            }
            this.b.add(bVar);
            bk3.e0(new a());
        }
    }

    public final void d() {
        int i = this.d;
        if (this.b.size() > 0) {
            for (b bVar : this.b) {
                Iterator<oz1> it = bVar.a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        oz1 next = it.next();
                        if (next instanceof tz1) {
                            i = 2;
                        } else if (next instanceof t02) {
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

    public synchronized void f() {
        this.e.clear();
    }

    public pz1 getCanvasContext() {
        if (this.b.size() > 0) {
            List<b> list = this.b;
            return list.get(list.size() - 1).b;
        }
        return null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b.size() > 0) {
            int save = canvas.save();
            canvas.setDrawFilter(this.c);
            for (b bVar : this.b) {
                List<oz1> list = bVar.a;
                pz1 pz1Var = bVar.b;
                pz1Var.d();
                for (oz1 oz1Var : list) {
                    oz1Var.a(pz1Var, canvas);
                    if (oz1Var instanceof yz1) {
                        ((yz1) oz1Var).e(this.e);
                    }
                }
            }
            if (canvas.getSaveCount() > 0) {
                canvas.restoreToCount(save);
            }
        }
    }
}
