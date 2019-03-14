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
    private List<a> amA;
    private final DrawFilter amB;
    private int amC;
    private HashMap<String, Bitmap> amD;
    private b amE;

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
        this.amA = new ArrayList();
        this.amB = new PaintFlagsDrawFilter(0, 3);
        this.amC = 0;
        this.amD = new HashMap<>();
        this.amC = getLayerType();
    }

    public void d(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.amA.contains(list)) {
            if (!z) {
                this.amA.clear();
            }
            int size = this.amA.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.amA.get(size - 1);
                aVar.amG = aVar2.amG;
                aVar.amn = aVar2.amn;
                aVar.amn.addAll(list);
            } else {
                aVar.amG = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.amn = list;
            }
            this.amA.add(aVar);
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
        if (this.amA.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.amB);
            for (a aVar : this.amA) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.amn;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.amG;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).m(this.amD);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.amA.size() > 0) {
            return this.amA.get(this.amA.size() - 1).amG;
        }
        return null;
    }

    public Bitmap dv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.amD.get(str);
    }

    public synchronized void onRelease() {
        this.amD.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void wH() {
        int i;
        int i2 = this.amC;
        if (this.amA.size() > 0) {
            Iterator<a> it = this.amA.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().amn) {
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
        com.baidu.swan.apps.canvas.a.a.b amG;
        List<com.baidu.swan.apps.canvas.a.a.a> amn;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.amE = bVar;
    }
}
