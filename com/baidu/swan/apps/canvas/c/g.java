package com.baidu.swan.apps.canvas.c;

import android.content.Context;
import com.baidu.swan.apps.canvas.view.CanvasView;
/* loaded from: classes2.dex */
public class g {
    public CanvasView amA;
    public String amz;

    public g(Context context, String str, a aVar) {
        this.amz = str;
        this.amA = new CanvasView(context);
        if (aVar != null) {
            this.amA.setInterceptTouchEvent(aVar.amq);
            this.amA.setHide(aVar.hidden);
            this.amA.setGesture(aVar.aBJ);
            if (aVar.aBJ) {
                this.amA.setInterceptTouchEvent(false);
            }
        }
    }

    public void release() {
        this.amA = null;
    }
}
