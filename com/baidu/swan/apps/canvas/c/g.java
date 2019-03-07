package com.baidu.swan.apps.canvas.c;

import android.content.Context;
import com.baidu.swan.apps.canvas.view.CanvasView;
/* loaded from: classes2.dex */
public class g {
    public String amu;
    public CanvasView amv;

    public g(Context context, String str, a aVar) {
        this.amu = str;
        this.amv = new CanvasView(context);
        if (aVar != null) {
            this.amv.setInterceptTouchEvent(aVar.aml);
            this.amv.setHide(aVar.hidden);
            this.amv.setGesture(aVar.aBF);
            if (aVar.aBF) {
                this.amv.setInterceptTouchEvent(false);
            }
        }
    }

    public void release() {
        this.amv = null;
    }
}
