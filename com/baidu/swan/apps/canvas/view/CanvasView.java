package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.canvas.a.a.af;
import com.baidu.swan.apps.canvas.a.a.f;
import com.baidu.swan.apps.canvas.a.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> cDb;
    private final DrawFilter cDc;
    private int cDd;
    private HashMap<String, Bitmap> cDe;
    private b cDf;

    /* loaded from: classes10.dex */
    public interface b {
        void akx();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cDb = new ArrayList();
        this.cDc = new PaintFlagsDrawFilter(0, 3);
        this.cDd = 0;
        this.cDe = new HashMap<>();
        this.cDd = getLayerType();
    }

    public void i(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.cDb.contains(list)) {
            if (!z) {
                this.cDb.clear();
            }
            int size = this.cDb.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.cDb.get(size - 1);
                aVar.cDh = aVar2.cDh;
                aVar.cCR = aVar2.cCR;
                aVar.cCR.addAll(list);
            } else {
                aVar.cDh = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.cCR = list;
            }
            this.cDb.add(aVar);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.akH();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return akG() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cDb.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.cDc);
            for (a aVar : this.cDb) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.cCR;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.cDh;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).y(this.cDe);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.cDb.size() > 0) {
            return this.cDb.get(this.cDb.size() - 1).cDh;
        }
        return null;
    }

    public Bitmap mh(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cDe.get(str);
    }

    public synchronized void onRelease() {
        this.cDe.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akH() {
        int i;
        int i2 = this.cDd;
        if (this.cDb.size() > 0) {
            Iterator<a> it = this.cDb.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().cCR.iterator();
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
    /* loaded from: classes10.dex */
    public static class a {
        List<com.baidu.swan.apps.canvas.a.a.a> cCR;
        com.baidu.swan.apps.canvas.a.a.b cDh;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.cDf = bVar;
    }
}
