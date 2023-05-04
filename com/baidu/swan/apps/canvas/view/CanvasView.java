package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tieba.d12;
import com.baidu.tieba.e12;
import com.baidu.tieba.i12;
import com.baidu.tieba.i22;
import com.baidu.tieba.n12;
import com.baidu.tieba.rl3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class CanvasView extends AbsCanvasView {
    public List<b> b;
    public final DrawFilter c;
    public int d;
    public HashMap<String, Bitmap> e;

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CanvasView.this.d();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public List<d12> a;
        public e12 b;

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

    public void c(List<d12> list, boolean z) {
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
                List<d12> list2 = bVar2.a;
                bVar.a = list2;
                list2.addAll(list);
            } else {
                bVar.b = new e12(this);
                bVar.a = list;
            }
            this.b.add(bVar);
            rl3.e0(new a());
        }
    }

    public final void d() {
        int i = this.d;
        if (this.b.size() > 0) {
            for (b bVar : this.b) {
                Iterator<d12> it = bVar.a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        d12 next = it.next();
                        if (next instanceof i12) {
                            i = 2;
                        } else if (next instanceof i22) {
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

    public e12 getCanvasContext() {
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
                List<d12> list = bVar.a;
                e12 e12Var = bVar.b;
                e12Var.d();
                for (d12 d12Var : list) {
                    d12Var.a(e12Var, canvas);
                    if (d12Var instanceof n12) {
                        ((n12) d12Var).e(this.e);
                    }
                }
            }
            if (canvas.getSaveCount() > 0) {
                canvas.restoreToCount(save);
            }
        }
    }
}
