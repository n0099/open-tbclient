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
    private List<a> aGR;
    private final DrawFilter aGS;
    private int aGT;
    private HashMap<String, Bitmap> aGU;
    private b aGV;

    /* loaded from: classes2.dex */
    public interface b {
        void CR();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGR = new ArrayList();
        this.aGS = new PaintFlagsDrawFilter(0, 3);
        this.aGT = 0;
        this.aGU = new HashMap<>();
        this.aGT = getLayerType();
    }

    public void f(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.aGR.contains(list)) {
            if (!z) {
                this.aGR.clear();
            }
            int size = this.aGR.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.aGR.get(size - 1);
                aVar.aGX = aVar2.aGX;
                aVar.aGE = aVar2.aGE;
                aVar.aGE.addAll(list);
            } else {
                aVar.aGX = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.aGE = list;
            }
            this.aGR.add(aVar);
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.Dc();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return Db() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aGR.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.aGS);
            for (a aVar : this.aGR) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.aGE;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.aGX;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).m(this.aGU);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.aGR.size() > 0) {
            return this.aGR.get(this.aGR.size() - 1).aGX;
        }
        return null;
    }

    public Bitmap dZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aGU.get(str);
    }

    public synchronized void CK() {
        this.aGU.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Dc() {
        int i;
        int i2 = this.aGT;
        if (this.aGR.size() > 0) {
            Iterator<a> it = this.aGR.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().aGE) {
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
        List<com.baidu.swan.apps.canvas.a.a.a> aGE;
        com.baidu.swan.apps.canvas.a.a.b aGX;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.aGV = bVar;
    }
}
