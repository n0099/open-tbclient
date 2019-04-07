package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.canvas.a.a.af;
import com.baidu.swan.apps.canvas.a.a.f;
import com.baidu.swan.apps.canvas.a.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> amE;
    private final DrawFilter amF;
    private int amG;
    private HashMap<String, Bitmap> amH;
    private b amI;

    /* loaded from: classes2.dex */
    public interface b {
        void wx();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amE = new ArrayList();
        this.amF = new PaintFlagsDrawFilter(0, 3);
        this.amG = 0;
        this.amH = new HashMap<>();
        this.amG = getLayerType();
    }

    public void d(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.amE.contains(list)) {
            if (!z) {
                this.amE.clear();
            }
            int size = this.amE.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.amE.get(size - 1);
                aVar.amK = aVar2.amK;
                aVar.amr = aVar2.amr;
                aVar.amr.addAll(list);
            } else {
                aVar.amK = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.amr = list;
            }
            this.amE.add(aVar);
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.wG();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return wF() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.amE.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.amF);
            for (a aVar : this.amE) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.amr;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.amK;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).m(this.amH);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.amE.size() > 0) {
            return this.amE.get(this.amE.size() - 1).amK;
        }
        return null;
    }

    public Bitmap dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.amH.get(str);
    }

    public synchronized void onRelease() {
        this.amH.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void wG() {
        int i;
        int i2 = this.amG;
        if (this.amE.size() > 0) {
            Iterator<a> it = this.amE.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().amr) {
                    if ((aVar instanceof af) || (aVar instanceof f)) {
                        i2 = 1;
                        break;
                    }
                    while (r3.hasNext()) {
                    }
                }
                i2 = i;
            }
        } else {
            i = i2;
        }
        if (getLayerType() != i) {
            setLayerType(i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        com.baidu.swan.apps.canvas.a.a.b amK;
        List<com.baidu.swan.apps.canvas.a.a.a> amr;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.amI = bVar;
    }
}
