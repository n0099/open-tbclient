package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.canvas.a.a.af;
import com.baidu.swan.apps.canvas.a.a.f;
import com.baidu.swan.apps.canvas.a.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> aHj;
    private final DrawFilter aHk;
    private int aHl;
    private HashMap<String, Bitmap> aHm;
    private b aHn;

    /* loaded from: classes2.dex */
    public interface b {
        void CQ();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHj = new ArrayList();
        this.aHk = new PaintFlagsDrawFilter(0, 3);
        this.aHl = 0;
        this.aHm = new HashMap<>();
        this.aHl = getLayerType();
    }

    public void f(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.aHj.contains(list)) {
            if (!z) {
                this.aHj.clear();
            }
            int size = this.aHj.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.aHj.get(size - 1);
                aVar.aHp = aVar2.aHp;
                aVar.aGW = aVar2.aGW;
                aVar.aGW.addAll(list);
            } else {
                aVar.aHp = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.aGW = list;
            }
            this.aHj.add(aVar);
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.Db();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return Da() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aHj.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.aHk);
            for (a aVar : this.aHj) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.aGW;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.aHp;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).m(this.aHm);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.aHj.size() > 0) {
            return this.aHj.get(this.aHj.size() - 1).aHp;
        }
        return null;
    }

    public Bitmap dZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aHm.get(str);
    }

    public synchronized void CJ() {
        this.aHm.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Db() {
        int i;
        int i2 = this.aHl;
        if (this.aHj.size() > 0) {
            Iterator<a> it = this.aHj.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().aGW) {
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
        List<com.baidu.swan.apps.canvas.a.a.a> aGW;
        com.baidu.swan.apps.canvas.a.a.b aHp;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.aHn = bVar;
    }
}
