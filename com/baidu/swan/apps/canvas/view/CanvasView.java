package com.baidu.swan.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.canvas.a.a.af;
import com.baidu.swan.apps.canvas.a.a.f;
import com.baidu.swan.apps.canvas.a.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes25.dex */
public class CanvasView extends AbsCanvasView {
    private List<a> cIm;
    private final DrawFilter cIn;
    private int cIo;
    private HashMap<String, Bitmap> cIp;
    private b cIq;

    /* loaded from: classes25.dex */
    public interface b {
        void amX();
    }

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cIm = new ArrayList();
        this.cIn = new PaintFlagsDrawFilter(0, 3);
        this.cIo = 0;
        this.cIp = new HashMap<>();
        this.cIo = getLayerType();
    }

    public void i(List<com.baidu.swan.apps.canvas.a.a.a> list, boolean z) {
        if (list != null && !this.cIm.contains(list)) {
            if (!z) {
                this.cIm.clear();
            }
            int size = this.cIm.size();
            boolean z2 = z && size > 0;
            a aVar = new a();
            if (z2) {
                a aVar2 = this.cIm.get(size - 1);
                aVar.cIs = aVar2.cIs;
                aVar.cId = aVar2.cId;
                aVar.cId.addAll(list);
            } else {
                aVar.cIs = new com.baidu.swan.apps.canvas.a.a.b(this);
                aVar.cId = list;
            }
            this.cIm.add(aVar);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.anh();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return ang() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cIm.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.cIn);
            for (a aVar : this.cIm) {
                List<com.baidu.swan.apps.canvas.a.a.a> list = aVar.cId;
                com.baidu.swan.apps.canvas.a.a.b bVar = aVar.cIs;
                bVar.init();
                for (com.baidu.swan.apps.canvas.a.a.a aVar2 : list) {
                    aVar2.a(bVar, canvas);
                    if (aVar2 instanceof k) {
                        ((k) aVar2).y(this.cIp);
                    }
                }
            }
            canvas.restore();
        }
    }

    public com.baidu.swan.apps.canvas.a.a.b getCanvasContext() {
        if (this.cIm.size() > 0) {
            return this.cIm.get(this.cIm.size() - 1).cIs;
        }
        return null;
    }

    public Bitmap mI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cIp.get(str);
    }

    public synchronized void onRelease() {
        this.cIp.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anh() {
        int i;
        int i2 = this.cIo;
        if (this.cIm.size() > 0) {
            Iterator<a> it = this.cIm.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Iterator<com.baidu.swan.apps.canvas.a.a.a> it2 = it.next().cId.iterator();
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
    /* loaded from: classes25.dex */
    public static class a {
        List<com.baidu.swan.apps.canvas.a.a.a> cId;
        com.baidu.swan.apps.canvas.a.a.b cIs;

        private a() {
        }
    }

    public void setOnDrawCompleteLinstener(b bVar) {
        this.cIq = bVar;
    }
}
