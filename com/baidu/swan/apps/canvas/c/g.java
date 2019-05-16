package com.baidu.swan.apps.canvas.c;

import android.content.Context;
import com.baidu.swan.apps.canvas.view.CanvasView;
/* loaded from: classes2.dex */
public class g {
    public String amM;
    public CanvasView amN;

    public g(Context context, String str, a aVar) {
        this.amM = str;
        this.amN = new CanvasView(context);
        if (aVar != null) {
            this.amN.setInterceptTouchEvent(aVar.amD);
            this.amN.setHide(aVar.hidden);
            this.amN.setGesture(aVar.aDp);
            if (aVar.aDp) {
                this.amN.setInterceptTouchEvent(false);
            }
        }
    }

    public void release() {
        this.amN = null;
    }
}
