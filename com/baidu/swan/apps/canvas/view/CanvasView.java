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
/* loaded from: classes7.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> cBr;
    private final DrawFilter cBs;
    private int cBt;
    private HashMap<String, Bitmap> cBu;
    private b cBv;

    /* loaded from: classes7.dex */
    public interface b {
        void ajP();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cBr = new ArrayList();
        this.cBs = new PaintFlagsDrawFilter(0, 3);
        this.cBt = 0;
        this.cBu = new HashMap<>();
        this.cBt = getLayerType();
    }

    public void i(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.cBr.contains(list)) {
            if (!z) {
                this.cBr.clear();
            }
            int size = this.cBr.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.cBr.get(size - 1);
                aVar.cBx = aVar2.cBx;
                aVar.cBh = aVar2.cBh;
                aVar.cBh.addAll(list);
            } else {
                aVar.cBx = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.cBh = list;
            }
            this.cBr.add(aVar);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.ajZ();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return ajY() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cBr.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.cBs);
            for (a aVar : this.cBr) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.cBh;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.cBx;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).y(this.cBu);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.cBr.size() > 0) {
            return this.cBr.get(this.cBr.size() - 1).cBx;
        }
        return null;
    }

    public Bitmap mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cBu.get(str);
    }

    public synchronized void onRelease() {
        this.cBu.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajZ() {
        int i;
        int i2 = this.cBt;
        if (this.cBr.size() > 0) {
            Iterator<a> it = this.cBr.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().cBh.iterator();
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
        List<com.baidu.swan.apps.canvas.a.a.a> cBh;
        com.baidu.swan.apps.canvas.a.a.b cBx;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.cBv = bVar;
    }
}
