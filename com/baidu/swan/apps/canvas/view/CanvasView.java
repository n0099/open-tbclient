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
/* loaded from: classes11.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> bGe;
    private final DrawFilter bGf;
    private int bGg;
    private HashMap<String, Bitmap> bGh;
    private b bGi;

    /* loaded from: classes11.dex */
    public interface b {
        void Se();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGe = new ArrayList();
        this.bGf = new PaintFlagsDrawFilter(0, 3);
        this.bGg = 0;
        this.bGh = new HashMap<>();
        this.bGg = getLayerType();
    }

    public void g(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.bGe.contains(list)) {
            if (!z) {
                this.bGe.clear();
            }
            int size = this.bGe.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.bGe.get(size - 1);
                aVar.bGk = aVar2.bGk;
                aVar.bFU = aVar2.bFU;
                aVar.bFU.addAll(list);
            } else {
                aVar.bGk = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.bFU = list;
            }
            this.bGe.add(aVar);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.Sp();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return So() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bGe.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.bGf);
            for (a aVar : this.bGe) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.bFU;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.bGk;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).y(this.bGh);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.bGe.size() > 0) {
            return this.bGe.get(this.bGe.size() - 1).bGk;
        }
        return null;
    }

    public Bitmap hB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bGh.get(str);
    }

    public synchronized void onRelease() {
        this.bGh.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Sp() {
        int i;
        int i2 = this.bGg;
        if (this.bGe.size() > 0) {
            Iterator<a> it = this.bGe.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().bFU) {
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
    /* loaded from: classes11.dex */
    public static class a {
        List<com.baidu.swan.apps.canvas.a.a.a> bFU;
        com.baidu.swan.apps.canvas.a.a.b bGk;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.bGi = bVar;
    }
}
