package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.canvas.a.a.af;
import com.baidu.swan.apps.canvas.a.a.f;
import com.baidu.swan.apps.canvas.a.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> bTK;
    private final DrawFilter bTL;
    private int bTM;
    private HashMap<String, Bitmap> bTN;
    private b bTO;

    /* loaded from: classes11.dex */
    public interface b {
        void VW();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTK = new ArrayList();
        this.bTL = new PaintFlagsDrawFilter(0, 3);
        this.bTM = 0;
        this.bTN = new HashMap<>();
        this.bTM = getLayerType();
    }

    public void g(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.bTK.contains(list)) {
            if (!z) {
                this.bTK.clear();
            }
            int size = this.bTK.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.bTK.get(size - 1);
                aVar.bTQ = aVar2.bTQ;
                aVar.bTA = aVar2.bTA;
                aVar.bTA.addAll(list);
            } else {
                aVar.bTQ = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.bTA = list;
            }
            this.bTK.add(aVar);
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.Wg();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return Wf() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bTK.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.bTL);
            for (a aVar : this.bTK) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.bTA;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.bTQ;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).y(this.bTN);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.bTK.size() > 0) {
            return this.bTK.get(this.bTK.size() - 1).bTQ;
        }
        return null;
    }

    public Bitmap iJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bTN.get(str);
    }

    public synchronized void onRelease() {
        this.bTN.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wg() {
        int i;
        int i2 = this.bTM;
        if (this.bTK.size() > 0) {
            Iterator<a> it = this.bTK.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().bTA.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        i2 = i;
                        break;
                    }
                    com.baidu.swan.apps.canvas.a.a.a next = it2.next();
                    if (next instanceof f) {
                        i = 2;
                    } else if (next instanceof af) {
                        i2 = 1;
                        break;
                    }
                }
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
        List<com.baidu.swan.apps.canvas.a.a.a> bTA;
        com.baidu.swan.apps.canvas.a.a.b bTQ;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.bTO = bVar;
    }
}
