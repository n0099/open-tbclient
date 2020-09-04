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
/* loaded from: classes8.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> cao;
    private final DrawFilter cap;
    private int caq;
    private HashMap<String, Bitmap> car;
    private b cas;

    /* loaded from: classes8.dex */
    public interface b {
        void acJ();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cao = new ArrayList();
        this.cap = new PaintFlagsDrawFilter(0, 3);
        this.caq = 0;
        this.car = new HashMap<>();
        this.caq = getLayerType();
    }

    public void g(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.cao.contains(list)) {
            if (!z) {
                this.cao.clear();
            }
            int size = this.cao.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.cao.get(size - 1);
                aVar.cau = aVar2.cau;
                aVar.cae = aVar2.cae;
                aVar.cae.addAll(list);
            } else {
                aVar.cau = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.cae = list;
            }
            this.cao.add(aVar);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.acT();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return acS() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cao.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.cap);
            for (a aVar : this.cao) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.cae;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.cau;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).w(this.car);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.cao.size() > 0) {
            return this.cao.get(this.cao.size() - 1).cau;
        }
        return null;
    }

    public Bitmap ku(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.car.get(str);
    }

    public synchronized void onRelease() {
        this.car.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acT() {
        int i;
        int i2 = this.caq;
        if (this.cao.size() > 0) {
            Iterator<a> it = this.cao.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().cae.iterator();
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
        List<com.baidu.swan.apps.canvas.a.a.a> cae;
        com.baidu.swan.apps.canvas.a.a.b cau;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.cas = bVar;
    }
}
