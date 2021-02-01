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
/* loaded from: classes9.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> cKG;
    private final DrawFilter cKH;
    private int cKI;
    private HashMap<String, Bitmap> cKJ;
    private b cKK;

    /* loaded from: classes9.dex */
    public interface b {
        void akM();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKG = new ArrayList();
        this.cKH = new PaintFlagsDrawFilter(0, 3);
        this.cKI = 0;
        this.cKJ = new HashMap<>();
        this.cKI = getLayerType();
    }

    public void i(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.cKG.contains(list)) {
            if (!z) {
                this.cKG.clear();
            }
            int size = this.cKG.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.cKG.get(size - 1);
                aVar.cKM = aVar2.cKM;
                aVar.cKy = aVar2.cKy;
                aVar.cKy.addAll(list);
            } else {
                aVar.cKM = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.cKy = list;
            }
            this.cKG.add(aVar);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.akV();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return akU() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cKG.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.cKH);
            for (a aVar : this.cKG) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.cKy;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.cKM;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).A(this.cKJ);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.cKG.size() > 0) {
            return this.cKG.get(this.cKG.size() - 1).cKM;
        }
        return null;
    }

    public Bitmap lI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cKJ.get(str);
    }

    public synchronized void onRelease() {
        this.cKJ.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akV() {
        int i;
        int i2 = this.cKI;
        if (this.cKG.size() > 0) {
            Iterator<a> it = this.cKG.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().cKy.iterator();
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
    /* loaded from: classes9.dex */
    public static class a {
        com.baidu.swan.apps.canvas.a.a.b cKM;
        List<com.baidu.swan.apps.canvas.a.a.a> cKy;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.cKK = bVar;
    }
}
