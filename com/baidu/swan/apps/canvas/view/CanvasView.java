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
    private List<a> bhO;
    private final DrawFilter bhP;
    private int bhQ;
    private HashMap<String, Bitmap> bhR;
    private b bhS;

    /* loaded from: classes11.dex */
    public interface b {
        void Kr();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bhO = new ArrayList();
        this.bhP = new PaintFlagsDrawFilter(0, 3);
        this.bhQ = 0;
        this.bhR = new HashMap<>();
        this.bhQ = getLayerType();
    }

    public void g(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.bhO.contains(list)) {
            if (!z) {
                this.bhO.clear();
            }
            int size = this.bhO.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.bhO.get(size - 1);
                aVar.bhU = aVar2.bhU;
                aVar.bhE = aVar2.bhE;
                aVar.bhE.addAll(list);
            } else {
                aVar.bhU = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.bhE = list;
            }
            this.bhO.add(aVar);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.KC();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return KB() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bhO.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.bhP);
            for (a aVar : this.bhO) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.bhE;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.bhU;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).k(this.bhR);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.bhO.size() > 0) {
            return this.bhO.get(this.bhO.size() - 1).bhU;
        }
        return null;
    }

    public Bitmap gn(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bhR.get(str);
    }

    public synchronized void onRelease() {
        this.bhR.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void KC() {
        int i;
        int i2 = this.bhQ;
        if (this.bhO.size() > 0) {
            Iterator<a> it = this.bhO.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().bhE) {
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
        List<com.baidu.swan.apps.canvas.a.a.a> bhE;
        com.baidu.swan.apps.canvas.a.a.b bhU;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.bhS = bVar;
    }
}
