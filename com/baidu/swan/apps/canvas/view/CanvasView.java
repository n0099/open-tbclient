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
/* loaded from: classes9.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> bcv;
    private final DrawFilter bcw;
    private int bcx;
    private HashMap<String, Bitmap> bcy;
    private b bcz;

    /* loaded from: classes9.dex */
    public interface b {
        void HB();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bcv = new ArrayList();
        this.bcw = new PaintFlagsDrawFilter(0, 3);
        this.bcx = 0;
        this.bcy = new HashMap<>();
        this.bcx = getLayerType();
    }

    public void e(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.bcv.contains(list)) {
            if (!z) {
                this.bcv.clear();
            }
            int size = this.bcv.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.bcv.get(size - 1);
                aVar.bcB = aVar2.bcB;
                aVar.bcl = aVar2.bcl;
                aVar.bcl.addAll(list);
            } else {
                aVar.bcB = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.bcl = list;
            }
            this.bcv.add(aVar);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.HM();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return HL() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bcv.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.bcw);
            for (a aVar : this.bcv) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.bcl;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.bcB;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).k(this.bcy);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.bcv.size() > 0) {
            return this.bcv.get(this.bcv.size() - 1).bcB;
        }
        return null;
    }

    public Bitmap fW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bcy.get(str);
    }

    public synchronized void onRelease() {
        this.bcy.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void HM() {
        int i;
        int i2 = this.bcx;
        if (this.bcv.size() > 0) {
            Iterator<a> it = this.bcv.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().bcl) {
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
    /* loaded from: classes9.dex */
    public static class a {
        com.baidu.swan.apps.canvas.a.a.b bcB;
        List<com.baidu.swan.apps.canvas.a.a.a> bcl;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.bcz = bVar;
    }
}
