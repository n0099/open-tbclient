package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tieba.j42;
import com.baidu.tieba.k42;
import com.baidu.tieba.o42;
import com.baidu.tieba.o52;
import com.baidu.tieba.t42;
import com.baidu.tieba.xo3;
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
        public List<j42> a;
        public k42 b;

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

    public void c(List<j42> list, boolean z) {
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
                List<j42> list2 = bVar2.a;
                bVar.a = list2;
                list2.addAll(list);
            } else {
                bVar.b = new k42(this);
                bVar.a = list;
            }
            this.b.add(bVar);
            xo3.e0(new a());
        }
    }

    public final void d() {
        int i = this.d;
        if (this.b.size() > 0) {
            for (b bVar : this.b) {
                Iterator<j42> it = bVar.a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        j42 next = it.next();
                        if (next instanceof o42) {
                            i = 2;
                        } else if (next instanceof o52) {
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

    public k42 getCanvasContext() {
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
                List<j42> list = bVar.a;
                k42 k42Var = bVar.b;
                k42Var.d();
                for (j42 j42Var : list) {
                    j42Var.a(k42Var, canvas);
                    if (j42Var instanceof t42) {
                        ((t42) j42Var).e(this.e);
                    }
                }
            }
            if (canvas.getSaveCount() > 0) {
                canvas.restoreToCount(save);
            }
        }
    }
}
