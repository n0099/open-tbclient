package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.canvas.a.a.af;
import com.baidu.swan.apps.canvas.a.a.f;
import com.baidu.swan.apps.canvas.a.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> amR;
    private final DrawFilter amS;
    private int amT;
    private HashMap<String, Bitmap> amU;
    private b amV;

    /* loaded from: classes2.dex */
    public interface b {
        void xp();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amR = new ArrayList();
        this.amS = new PaintFlagsDrawFilter(0, 3);
        this.amT = 0;
        this.amU = new HashMap<>();
        this.amT = getLayerType();
    }

    public void c(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.amR.contains(list)) {
            if (!z) {
                this.amR.clear();
            }
            int size = this.amR.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.amR.get(size - 1);
                aVar.amX = aVar2.amX;
                aVar.amE = aVar2.amE;
                aVar.amE.addAll(list);
            } else {
                aVar.amX = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.amE = list;
            }
            this.amR.add(aVar);
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.xy();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return xx() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.amR.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.amS);
            for (a aVar : this.amR) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.amE;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.amX;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).m(this.amU);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.amR.size() > 0) {
            return this.amR.get(this.amR.size() - 1).amX;
        }
        return null;
    }

    public Bitmap dj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.amU.get(str);
    }

    public synchronized void onRelease() {
        this.amU.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void xy() {
        int i;
        int i2 = this.amT;
        if (this.amR.size() > 0) {
            Iterator<a> it = this.amR.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().amE) {
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
        List<com.baidu.swan.apps.canvas.a.a.a> amE;
        com.baidu.swan.apps.canvas.a.a.b amX;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.amV = bVar;
    }
}
