package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.canvas.a.a.af;
import com.baidu.swan.apps.canvas.a.a.f;
import com.baidu.swan.apps.canvas.a.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> bUC;
    private final DrawFilter bUD;
    private int bUE;
    private HashMap<String, Bitmap> bUF;
    private b bUG;

    /* loaded from: classes7.dex */
    public interface b {
        void WD();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUC = new ArrayList();
        this.bUD = new PaintFlagsDrawFilter(0, 3);
        this.bUE = 0;
        this.bUF = new HashMap<>();
        this.bUE = getLayerType();
    }

    public void g(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.bUC.contains(list)) {
            if (!z) {
                this.bUC.clear();
            }
            int size = this.bUC.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.bUC.get(size - 1);
                aVar.bUI = aVar2.bUI;
                aVar.bUs = aVar2.bUs;
                aVar.bUs.addAll(list);
            } else {
                aVar.bUI = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.bUs = list;
            }
            this.bUC.add(aVar);
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.WN();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return WM() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bUC.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.bUD);
            for (a aVar : this.bUC) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.bUs;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.bUI;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).y(this.bUF);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.bUC.size() > 0) {
            return this.bUC.get(this.bUC.size() - 1).bUI;
        }
        return null;
    }

    public Bitmap iT(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bUF.get(str);
    }

    public synchronized void onRelease() {
        this.bUF.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WN() {
        int i;
        int i2 = this.bUE;
        if (this.bUC.size() > 0) {
            Iterator<a> it = this.bUC.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().bUs.iterator();
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
    /* loaded from: classes7.dex */
    public static class a {
        com.baidu.swan.apps.canvas.a.a.b bUI;
        List<com.baidu.swan.apps.canvas.a.a.a> bUs;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.bUG = bVar;
    }
}
