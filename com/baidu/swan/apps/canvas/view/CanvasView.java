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
    private List<a> anu;
    private final DrawFilter anv;
    private int anw;
    private HashMap<String, Bitmap> anx;
    private b any;

    /* loaded from: classes2.dex */
    public interface b {
        void xR();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anu = new ArrayList();
        this.anv = new PaintFlagsDrawFilter(0, 3);
        this.anw = 0;
        this.anx = new HashMap<>();
        this.anw = getLayerType();
    }

    public void c(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.anu.contains(list)) {
            if (!z) {
                this.anu.clear();
            }
            int size = this.anu.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.anu.get(size - 1);
                aVar.anA = aVar2.anA;
                aVar.anh = aVar2.anh;
                aVar.anh.addAll(list);
            } else {
                aVar.anA = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.anh = list;
            }
            this.anu.add(aVar);
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.yc();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return yb() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.anu.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.anv);
            for (a aVar : this.anu) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.anh;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.anA;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).m(this.anx);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.anu.size() > 0) {
            return this.anu.get(this.anu.size() - 1).anA;
        }
        return null;
    }

    /* renamed from: do  reason: not valid java name */
    public Bitmap m15do(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.anx.get(str);
    }

    public synchronized void xK() {
        this.anx.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void yc() {
        int i;
        int i2 = this.anw;
        if (this.anu.size() > 0) {
            Iterator<a> it = this.anu.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (com.baidu.swan.apps.canvas.a.a.a aVar : it.next().anh) {
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
        com.baidu.swan.apps.canvas.a.a.b anA;
        List<com.baidu.swan.apps.canvas.a.a.a> anh;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.any = bVar;
    }
}
