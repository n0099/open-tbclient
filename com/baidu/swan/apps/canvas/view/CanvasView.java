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
    private List<a> anS;
    private final DrawFilter anT;
    private int anU;
    private HashMap<String, Bitmap> anV;
    private b anW;

    /* loaded from: classes2.dex */
    public interface b {
        void xV();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anS = new ArrayList();
        this.anT = new PaintFlagsDrawFilter(0, 3);
        this.anU = 0;
        this.anV = new HashMap<>();
        this.anU = getLayerType();
    }

    public void c(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.anS.contains(list)) {
            if (!z) {
                this.anS.clear();
            }
            int size = this.anS.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.anS.get(size - 1);
                aVar.anY = aVar2.anY;
                aVar.anF = aVar2.anF;
                aVar.anF.addAll(list);
            } else {
                aVar.anY = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.anF = list;
            }
            this.anS.add(aVar);
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.yg();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return yf() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.anS.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.anT);
            for (a aVar : this.anS) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.anF;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.anY;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).m(this.anV);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.anS.size() > 0) {
            return this.anS.get(this.anS.size() - 1).anY;
        }
        return null;
    }

    public Bitmap dq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.anV.get(str);
    }

    public synchronized void xO() {
        this.anV.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void yg() {
        int i;
        int i2 = this.anU;
        if (this.anS.size() > 0) {
            Iterator<a> it = this.anS.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().anF) {
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
        List<com.baidu.swan.apps.canvas.a.a.a> anF;
        com.baidu.swan.apps.canvas.a.a.b anY;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.anW = bVar;
    }
}
