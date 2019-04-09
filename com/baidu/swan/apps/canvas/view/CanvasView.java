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
    private List<a> amF;
    private final DrawFilter amG;
    private int amH;
    private HashMap<String, Bitmap> amI;
    private b amJ;

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
        this.amF = new ArrayList();
        this.amG = new PaintFlagsDrawFilter(0, 3);
        this.amH = 0;
        this.amI = new HashMap<>();
        this.amH = getLayerType();
    }

    public void d(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.amF.contains(list)) {
            if (!z) {
                this.amF.clear();
            }
            int size = this.amF.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.amF.get(size - 1);
                aVar.amL = aVar2.amL;
                aVar.ams = aVar2.ams;
                aVar.ams.addAll(list);
            } else {
                aVar.amL = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.ams = list;
            }
            this.amF.add(aVar);
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
        if (this.amF.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.amG);
            for (a aVar : this.amF) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.ams;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.amL;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).m(this.amI);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.amF.size() > 0) {
            return this.amF.get(this.amF.size() - 1).amL;
        }
        return null;
    }

    public Bitmap dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.amI.get(str);
    }

    public synchronized void onRelease() {
        this.amI.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void wG() {
        int i;
        int i2 = this.amH;
        if (this.amF.size() > 0) {
            Iterator<a> it = this.amF.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().ams) {
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
        com.baidu.swan.apps.canvas.a.a.b amL;
        List<com.baidu.swan.apps.canvas.a.a.a> ams;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.amJ = bVar;
    }
}
