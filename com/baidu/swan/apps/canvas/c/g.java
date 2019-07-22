package com.baidu.swan.apps.canvas.c;

import android.content.Context;
import com.baidu.swan.apps.canvas.view.CanvasView;
/* loaded from: classes2.dex */
public class g {
    public String anp;
    public CanvasView anq;

    public g(Context context, String str, a aVar) {
        this.anp = str;
        this.anq = new CanvasView(context);
        if (aVar != null) {
            this.anq.setInterceptTouchEvent(aVar.ang);
            this.anq.setHide(aVar.hidden);
            this.anq.setGesture(aVar.aDX);
            if (aVar.aDX) {
                this.anq.setInterceptTouchEvent(false);
            }
        }
    }

    public void release() {
        this.anq = null;
    }
}
