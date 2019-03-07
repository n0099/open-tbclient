package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.canvas.a.a.af;
import com.baidu.swan.apps.canvas.a.a.f;
import com.baidu.swan.apps.canvas.a.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CanvasView extends AbsCanvasView {
    private final DrawFilter amA;
    private int amB;
    private HashMap<String, Bitmap> amC;
    private b amD;
    private List<a> amz;

    /* loaded from: classes2.dex */
    public interface b {
        void wy();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amz = new ArrayList();
        this.amA = new PaintFlagsDrawFilter(0, 3);
        this.amB = 0;
        this.amC = new HashMap<>();
        this.amB = getLayerType();
    }

    public void d(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.amz.contains(list)) {
            if (!z) {
                this.amz.clear();
            }
            int size = this.amz.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.amz.get(size - 1);
                aVar.amF = aVar2.amF;
                aVar.amm = aVar2.amm;
                aVar.amm.addAll(list);
            } else {
                aVar.amF = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.amm = list;
            }
            this.amz.add(aVar);
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.wH();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return wG() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.amz.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.amA);
            for (a aVar : this.amz) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.amm;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.amF;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).m(this.amC);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.amz.size() > 0) {
            return this.amz.get(this.amz.size() - 1).amF;
        }
        return null;
    }

    public Bitmap dv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.amC.get(str);
    }

    public synchronized void onRelease() {
        this.amC.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void wH() {
        int i;
        int i2 = this.amB;
        if (this.amz.size() > 0) {
            Iterator<a> it = this.amz.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().amm) {
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
    /* loaded from: classes2.dex */
    public static class a {
        com.baidu.swan.apps.canvas.a.a.b amF;
        List<com.baidu.swan.apps.canvas.a.a.a> amm;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.amD = bVar;
    }
}
