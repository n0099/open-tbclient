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
/* loaded from: classes3.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> ccp;
    private final DrawFilter ccq;
    private int ccr;
    private HashMap<String, Bitmap> cct;
    private b ccu;

    /* loaded from: classes3.dex */
    public interface b {
        void ads();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ccp = new ArrayList();
        this.ccq = new PaintFlagsDrawFilter(0, 3);
        this.ccr = 0;
        this.cct = new HashMap<>();
        this.ccr = getLayerType();
    }

    public void g(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.ccp.contains(list)) {
            if (!z) {
                this.ccp.clear();
            }
            int size = this.ccp.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.ccp.get(size - 1);
                aVar.ccw = aVar2.ccw;
                aVar.ccf = aVar2.ccf;
                aVar.ccf.addAll(list);
            } else {
                aVar.ccw = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.ccf = list;
            }
            this.ccp.add(aVar);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.adC();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return adB() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ccp.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.ccq);
            for (a aVar : this.ccp) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.ccf;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.ccw;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).w(this.cct);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.ccp.size() > 0) {
            return this.ccp.get(this.ccp.size() - 1).ccw;
        }
        return null;
    }

    public Bitmap kN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cct.get(str);
    }

    public synchronized void onRelease() {
        this.cct.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adC() {
        int i;
        int i2 = this.ccr;
        if (this.ccp.size() > 0) {
            Iterator<a> it = this.ccp.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().ccf.iterator();
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
    /* loaded from: classes3.dex */
    public static class a {
        List<com.baidu.swan.apps.canvas.a.a.a> ccf;
        com.baidu.swan.apps.canvas.a.a.b ccw;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.ccu = bVar;
    }
}
