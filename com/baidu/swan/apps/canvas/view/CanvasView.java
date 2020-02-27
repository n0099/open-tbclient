package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.canvas.a.a.af;
import com.baidu.swan.apps.canvas.a.a.f;
import com.baidu.swan.apps.canvas.a.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class CanvasView extends AbsCanvasView {
    private final DrawFilter bhA;
    private int bhB;
    private HashMap<String, Bitmap> bhC;
    private b bhD;
    private List<a> bhz;

    /* loaded from: classes11.dex */
    public interface b {
        void Km();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bhz = new ArrayList();
        this.bhA = new PaintFlagsDrawFilter(0, 3);
        this.bhB = 0;
        this.bhC = new HashMap<>();
        this.bhB = getLayerType();
    }

    public void g(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.bhz.contains(list)) {
            if (!z) {
                this.bhz.clear();
            }
            int size = this.bhz.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.bhz.get(size - 1);
                aVar.bhF = aVar2.bhF;
                aVar.bhp = aVar2.bhp;
                aVar.bhp.addAll(list);
            } else {
                aVar.bhF = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.bhp = list;
            }
            this.bhz.add(aVar);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.Kx();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return Kw() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bhz.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.bhA);
            for (a aVar : this.bhz) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.bhp;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.bhF;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).k(this.bhC);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.bhz.size() > 0) {
            return this.bhz.get(this.bhz.size() - 1).bhF;
        }
        return null;
    }

    public Bitmap go(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bhC.get(str);
    }

    public synchronized void onRelease() {
        this.bhC.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Kx() {
        int i;
        int i2 = this.bhB;
        if (this.bhz.size() > 0) {
            Iterator<a> it = this.bhz.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().bhp) {
                    if ((aVar instanceof af) || (aVar instanceof f)) {
                        i2 = 1;
                        break;
                    }
                    while (r3.hasNext()) {
                    }
                }
                i2 = i;
            }
        } else {
            i = i2;
        }
        if (getLayerType() != i) {
            setLayerType(i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        com.baidu.swan.apps.canvas.a.a.b bhF;
        List<com.baidu.swan.apps.canvas.a.a.a> bhp;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.bhD = bVar;
    }
}
