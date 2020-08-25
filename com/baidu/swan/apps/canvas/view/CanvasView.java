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
    private List<a> cak;
    private final DrawFilter cal;
    private int cam;
    private HashMap<String, Bitmap> can;
    private b cao;

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
        this.cak = new ArrayList();
        this.cal = new PaintFlagsDrawFilter(0, 3);
        this.cam = 0;
        this.can = new HashMap<>();
        this.cam = getLayerType();
    }

    public void g(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.cak.contains(list)) {
            if (!z) {
                this.cak.clear();
            }
            int size = this.cak.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.cak.get(size - 1);
                aVar.caq = aVar2.caq;
                aVar.caa = aVar2.caa;
                aVar.caa.addAll(list);
            } else {
                aVar.caq = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.caa = list;
            }
            this.cak.add(aVar);
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
        if (this.cak.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.cal);
            for (a aVar : this.cak) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.caa;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.caq;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).w(this.can);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.cak.size() > 0) {
            return this.cak.get(this.cak.size() - 1).caq;
        }
        return null;
    }

    public Bitmap kt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.can.get(str);
    }

    public synchronized void onRelease() {
        this.can.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acT() {
        int i;
        int i2 = this.cam;
        if (this.cak.size() > 0) {
            Iterator<a> it = this.cak.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().caa.iterator();
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
        List<com.baidu.swan.apps.canvas.a.a.a> caa;
        com.baidu.swan.apps.canvas.a.a.b caq;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.cao = bVar;
    }
}
