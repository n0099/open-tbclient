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
    private List<a> bhB;
    private final DrawFilter bhC;
    private int bhD;
    private HashMap<String, Bitmap> bhE;
    private b bhF;

    /* loaded from: classes11.dex */
    public interface b {
        void Ko();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bhB = new ArrayList();
        this.bhC = new PaintFlagsDrawFilter(0, 3);
        this.bhD = 0;
        this.bhE = new HashMap<>();
        this.bhD = getLayerType();
    }

    public void g(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.bhB.contains(list)) {
            if (!z) {
                this.bhB.clear();
            }
            int size = this.bhB.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.bhB.get(size - 1);
                aVar.bhH = aVar2.bhH;
                aVar.bhr = aVar2.bhr;
                aVar.bhr.addAll(list);
            } else {
                aVar.bhH = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.bhr = list;
            }
            this.bhB.add(aVar);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.Kz();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return Ky() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bhB.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.bhC);
            for (a aVar : this.bhB) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.bhr;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.bhH;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).k(this.bhE);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.bhB.size() > 0) {
            return this.bhB.get(this.bhB.size() - 1).bhH;
        }
        return null;
    }

    public Bitmap go(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bhE.get(str);
    }

    public synchronized void onRelease() {
        this.bhE.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Kz() {
        int i;
        int i2 = this.bhD;
        if (this.bhB.size() > 0) {
            Iterator<a> it = this.bhB.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().bhr) {
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
        com.baidu.swan.apps.canvas.a.a.b bhH;
        List<com.baidu.swan.apps.canvas.a.a.a> bhr;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.bhF = bVar;
    }
}
