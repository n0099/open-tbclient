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
    private List<a> cNe;
    private final DrawFilter cNf;
    private int cNg;
    private HashMap<String, Bitmap> cNh;
    private b cNi;

    /* loaded from: classes9.dex */
    public interface b {
        void aoi();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNe = new ArrayList();
        this.cNf = new PaintFlagsDrawFilter(0, 3);
        this.cNg = 0;
        this.cNh = new HashMap<>();
        this.cNg = getLayerType();
    }

    public void i(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.cNe.contains(list)) {
            if (!z) {
                this.cNe.clear();
            }
            int size = this.cNe.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.cNe.get(size - 1);
                aVar.cNk = aVar2.cNk;
                aVar.cMU = aVar2.cMU;
                aVar.cMU.addAll(list);
            } else {
                aVar.cNk = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.cMU = list;
            }
            this.cNe.add(aVar);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.aor();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return aoq() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cNe.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.cNf);
            for (a aVar : this.cNe) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.cMU;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.cNk;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).y(this.cNh);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.cNe.size() > 0) {
            return this.cNe.get(this.cNe.size() - 1).cNk;
        }
        return null;
    }

    public Bitmap mB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cNh.get(str);
    }

    public synchronized void onRelease() {
        this.cNh.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aor() {
        int i;
        int i2 = this.cNg;
        if (this.cNe.size() > 0) {
            Iterator<a> it = this.cNe.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().cMU.iterator();
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
        List<com.baidu.swan.apps.canvas.a.a.a> cMU;
        com.baidu.swan.apps.canvas.a.a.b cNk;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.cNi = bVar;
    }
}
