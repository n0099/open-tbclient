package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.canvas.a.a.af;
import com.baidu.swan.apps.canvas.a.a.f;
import com.baidu.swan.apps.canvas.a.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> cMg;
    private final DrawFilter cMh;
    private int cMi;
    private HashMap<String, Bitmap> cMj;
    private b cMk;

    /* loaded from: classes8.dex */
    public interface b {
        void akP();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cMg = new ArrayList();
        this.cMh = new PaintFlagsDrawFilter(0, 3);
        this.cMi = 0;
        this.cMj = new HashMap<>();
        this.cMi = getLayerType();
    }

    public void i(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.cMg.contains(list)) {
            if (!z) {
                this.cMg.clear();
            }
            int size = this.cMg.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.cMg.get(size - 1);
                aVar.cMm = aVar2.cMm;
                aVar.cLY = aVar2.cLY;
                aVar.cLY.addAll(list);
            } else {
                aVar.cMm = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.cLY = list;
            }
            this.cMg.add(aVar);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.akY();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return akX() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cMg.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.cMh);
            for (a aVar : this.cMg) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.cLY;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.cMm;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).A(this.cMj);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.cMg.size() > 0) {
            return this.cMg.get(this.cMg.size() - 1).cMm;
        }
        return null;
    }

    public Bitmap lP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cMj.get(str);
    }

    public synchronized void onRelease() {
        this.cMj.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        int i;
        int i2 = this.cMi;
        if (this.cMg.size() > 0) {
            Iterator<a> it = this.cMg.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().cLY.iterator();
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
    /* loaded from: classes8.dex */
    public static class a {
        List<com.baidu.swan.apps.canvas.a.a.a> cLY;
        com.baidu.swan.apps.canvas.a.a.b cMm;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.cMk = bVar;
    }
}
