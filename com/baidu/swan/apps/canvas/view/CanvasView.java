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
    private List<a> bFZ;
    private final DrawFilter bGa;
    private int bGb;
    private HashMap<String, Bitmap> bGc;
    private b bGd;

    /* loaded from: classes11.dex */
    public interface b {
        void Sf();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bFZ = new ArrayList();
        this.bGa = new PaintFlagsDrawFilter(0, 3);
        this.bGb = 0;
        this.bGc = new HashMap<>();
        this.bGb = getLayerType();
    }

    public void g(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.bFZ.contains(list)) {
            if (!z) {
                this.bFZ.clear();
            }
            int size = this.bFZ.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.bFZ.get(size - 1);
                aVar.bGf = aVar2.bGf;
                aVar.bFP = aVar2.bFP;
                aVar.bFP.addAll(list);
            } else {
                aVar.bGf = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.bFP = list;
            }
            this.bFZ.add(aVar);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.Sq();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return Sp() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bFZ.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.bGa);
            for (a aVar : this.bFZ) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.bFP;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.bGf;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).y(this.bGc);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.bFZ.size() > 0) {
            return this.bFZ.get(this.bFZ.size() - 1).bGf;
        }
        return null;
    }

    public Bitmap hB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bGc.get(str);
    }

    public synchronized void onRelease() {
        this.bGc.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Sq() {
        int i;
        int i2 = this.bGb;
        if (this.bFZ.size() > 0) {
            Iterator<a> it = this.bFZ.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().bFP) {
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
        List<com.baidu.swan.apps.canvas.a.a.a> bFP;
        com.baidu.swan.apps.canvas.a.a.b bGf;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.bGd = bVar;
    }
}
