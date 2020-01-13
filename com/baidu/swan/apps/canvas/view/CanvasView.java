package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.canvas.a.a.af;
import com.baidu.swan.apps.canvas.a.a.f;
import com.baidu.swan.apps.canvas.a.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> bdk;
    private final DrawFilter bdl;
    private int bdm;
    private HashMap<String, Bitmap> bdn;
    private b bdo;

    /* loaded from: classes10.dex */
    public interface b {
        void HX();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdk = new ArrayList();
        this.bdl = new PaintFlagsDrawFilter(0, 3);
        this.bdm = 0;
        this.bdn = new HashMap<>();
        this.bdm = getLayerType();
    }

    public void f(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.bdk.contains(list)) {
            if (!z) {
                this.bdk.clear();
            }
            int size = this.bdk.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.bdk.get(size - 1);
                aVar.bdq = aVar2.bdq;
                aVar.bda = aVar2.bda;
                aVar.bda.addAll(list);
            } else {
                aVar.bdq = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.bda = list;
            }
            this.bdk.add(aVar);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.Ii();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return Ih() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bdk.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.bdl);
            for (a aVar : this.bdk) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.bda;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.bdq;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).k(this.bdn);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.bdk.size() > 0) {
            return this.bdk.get(this.bdk.size() - 1).bdq;
        }
        return null;
    }

    public Bitmap fZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bdn.get(str);
    }

    public synchronized void onRelease() {
        this.bdn.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Ii() {
        int i;
        int i2 = this.bdm;
        if (this.bdk.size() > 0) {
            Iterator<a> it = this.bdk.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().bda) {
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
    /* loaded from: classes10.dex */
    public static class a {
        List<com.baidu.swan.apps.canvas.a.a.a> bda;
        com.baidu.swan.apps.canvas.a.a.b bdq;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.bdo = bVar;
    }
}
