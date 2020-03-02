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
    private List<a> bhA;
    private final DrawFilter bhB;
    private int bhC;
    private HashMap<String, Bitmap> bhD;
    private b bhE;

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
        this.bhA = new ArrayList();
        this.bhB = new PaintFlagsDrawFilter(0, 3);
        this.bhC = 0;
        this.bhD = new HashMap<>();
        this.bhC = getLayerType();
    }

    public void g(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.bhA.contains(list)) {
            if (!z) {
                this.bhA.clear();
            }
            int size = this.bhA.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.bhA.get(size - 1);
                aVar.bhG = aVar2.bhG;
                aVar.bhq = aVar2.bhq;
                aVar.bhq.addAll(list);
            } else {
                aVar.bhG = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.bhq = list;
            }
            this.bhA.add(aVar);
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
        if (this.bhA.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.bhB);
            for (a aVar : this.bhA) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.bhq;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.bhG;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).k(this.bhD);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.bhA.size() > 0) {
            return this.bhA.get(this.bhA.size() - 1).bhG;
        }
        return null;
    }

    public Bitmap go(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bhD.get(str);
    }

    public synchronized void onRelease() {
        this.bhD.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Kz() {
        int i;
        int i2 = this.bhC;
        if (this.bhA.size() > 0) {
            Iterator<a> it = this.bhA.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().bhq) {
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
        com.baidu.swan.apps.canvas.a.a.b bhG;
        List<com.baidu.swan.apps.canvas.a.a.a> bhq;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.bhE = bVar;
    }
}
