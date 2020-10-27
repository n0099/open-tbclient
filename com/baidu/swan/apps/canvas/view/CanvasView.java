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
    private List<a> cxi;
    private final DrawFilter cxj;
    private int cxk;
    private HashMap<String, Bitmap> cxl;
    private b cxm;

    /* loaded from: classes10.dex */
    public interface b {
        void ahX();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cxi = new ArrayList();
        this.cxj = new PaintFlagsDrawFilter(0, 3);
        this.cxk = 0;
        this.cxl = new HashMap<>();
        this.cxk = getLayerType();
    }

    public void i(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.cxi.contains(list)) {
            if (!z) {
                this.cxi.clear();
            }
            int size = this.cxi.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.cxi.get(size - 1);
                aVar.cxo = aVar2.cxo;
                aVar.cwY = aVar2.cwY;
                aVar.cwY.addAll(list);
            } else {
                aVar.cxo = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.cwY = list;
            }
            this.cxi.add(aVar);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.aih();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return aig() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cxi.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.cxj);
            for (a aVar : this.cxi) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.cwY;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.cxo;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).y(this.cxl);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.cxi.size() > 0) {
            return this.cxi.get(this.cxi.size() - 1).cxo;
        }
        return null;
    }

    public Bitmap lS(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cxl.get(str);
    }

    public synchronized void onRelease() {
        this.cxl.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aih() {
        int i;
        int i2 = this.cxk;
        if (this.cxi.size() > 0) {
            Iterator<a> it = this.cxi.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().cwY.iterator();
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
        List<com.baidu.swan.apps.canvas.a.a.a> cwY;
        com.baidu.swan.apps.canvas.a.a.b cxo;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.cxm = bVar;
    }
}
