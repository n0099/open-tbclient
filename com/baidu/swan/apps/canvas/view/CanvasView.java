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
/* loaded from: classes8.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> cIs;
    private final DrawFilter cIt;
    private int cIu;
    private HashMap<String, Bitmap> cIv;
    private b cIw;

    /* loaded from: classes8.dex */
    public interface b {
        void ako();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cIs = new ArrayList();
        this.cIt = new PaintFlagsDrawFilter(0, 3);
        this.cIu = 0;
        this.cIv = new HashMap<>();
        this.cIu = getLayerType();
    }

    public void i(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.cIs.contains(list)) {
            if (!z) {
                this.cIs.clear();
            }
            int size = this.cIs.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.cIs.get(size - 1);
                aVar.cIy = aVar2.cIy;
                aVar.cIi = aVar2.cIi;
                aVar.cIi.addAll(list);
            } else {
                aVar.cIy = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.cIi = list;
            }
            this.cIs.add(aVar);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.akx();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return akw() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cIs.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.cIt);
            for (a aVar : this.cIs) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.cIi;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.cIy;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).y(this.cIv);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.cIs.size() > 0) {
            return this.cIs.get(this.cIs.size() - 1).cIy;
        }
        return null;
    }

    public Bitmap lq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cIv.get(str);
    }

    public synchronized void onRelease() {
        this.cIv.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akx() {
        int i;
        int i2 = this.cIu;
        if (this.cIs.size() > 0) {
            Iterator<a> it = this.cIs.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().cIi.iterator();
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
    /* loaded from: classes8.dex */
    public static class a {
        List<com.baidu.swan.apps.canvas.a.a.a> cIi;
        com.baidu.swan.apps.canvas.a.a.b cIy;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.cIw = bVar;
    }
}
