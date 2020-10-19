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
    private List<a> coG;
    private final DrawFilter coH;
    private int coI;
    private HashMap<String, Bitmap> coJ;
    private b coK;

    /* loaded from: classes10.dex */
    public interface b {
        void agd();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.coG = new ArrayList();
        this.coH = new PaintFlagsDrawFilter(0, 3);
        this.coI = 0;
        this.coJ = new HashMap<>();
        this.coI = getLayerType();
    }

    public void h(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.coG.contains(list)) {
            if (!z) {
                this.coG.clear();
            }
            int size = this.coG.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.coG.get(size - 1);
                aVar.coM = aVar2.coM;
                aVar.cow = aVar2.cow;
                aVar.cow.addAll(list);
            } else {
                aVar.coM = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.cow = list;
            }
            this.coG.add(aVar);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.agn();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return agm() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.coG.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.coH);
            for (a aVar : this.coG) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.cow;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.coM;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).y(this.coJ);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.coG.size() > 0) {
            return this.coG.get(this.coG.size() - 1).coM;
        }
        return null;
    }

    public Bitmap lz(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.coJ.get(str);
    }

    public synchronized void onRelease() {
        this.coJ.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agn() {
        int i;
        int i2 = this.coI;
        if (this.coG.size() > 0) {
            Iterator<a> it = this.coG.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().cow.iterator();
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
        com.baidu.swan.apps.canvas.a.a.b coM;
        List<com.baidu.swan.apps.canvas.a.a.a> cow;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.coK = bVar;
    }
}
