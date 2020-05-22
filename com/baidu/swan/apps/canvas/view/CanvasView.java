package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.canvas.a.a.af;
import com.baidu.swan.apps.canvas.a.a.f;
import com.baidu.swan.apps.canvas.a.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> bOW;
    private final DrawFilter bOX;
    private int bOY;
    private HashMap<String, Bitmap> bOZ;
    private b bPa;

    /* loaded from: classes11.dex */
    public interface b {
        void UQ();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOW = new ArrayList();
        this.bOX = new PaintFlagsDrawFilter(0, 3);
        this.bOY = 0;
        this.bOZ = new HashMap<>();
        this.bOY = getLayerType();
    }

    public void g(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.bOW.contains(list)) {
            if (!z) {
                this.bOW.clear();
            }
            int size = this.bOW.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.bOW.get(size - 1);
                aVar.bPc = aVar2.bPc;
                aVar.bOM = aVar2.bOM;
                aVar.bOM.addAll(list);
            } else {
                aVar.bPc = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.bOM = list;
            }
            this.bOW.add(aVar);
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.Va();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return UZ() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bOW.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.bOX);
            for (a aVar : this.bOW) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.bOM;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.bPc;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).y(this.bOZ);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.bOW.size() > 0) {
            return this.bOW.get(this.bOW.size() - 1).bPc;
        }
        return null;
    }

    public Bitmap iB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bOZ.get(str);
    }

    public synchronized void onRelease() {
        this.bOZ.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Va() {
        int i;
        int i2 = this.bOY;
        if (this.bOW.size() > 0) {
            Iterator<a> it = this.bOW.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().bOM.iterator();
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
    /* loaded from: classes11.dex */
    public static class a {
        List<com.baidu.swan.apps.canvas.a.a.a> bOM;
        com.baidu.swan.apps.canvas.a.a.b bPc;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.bPa = bVar;
    }
}
