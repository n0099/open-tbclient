package com.baidu.swan.apps.canvas.c;

import android.content.Context;
import com.baidu.swan.apps.canvas.view.CanvasView;
/* loaded from: classes2.dex */
public class g {
    public String amA;
    public CanvasView amB;

    public g(Context context, String str, a aVar) {
        this.amA = str;
        this.amB = new CanvasView(context);
        if (aVar != null) {
            this.amB.setInterceptTouchEvent(aVar.amr);
            this.amB.setHide(aVar.hidden);
            this.amB.setGesture(aVar.aBK);
            if (aVar.aBK) {
                this.amB.setInterceptTouchEvent(false);
            }
        }
    }

    public void release() {
        this.amB = null;
    }
}
