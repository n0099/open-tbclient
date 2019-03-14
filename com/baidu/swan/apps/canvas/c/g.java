package com.baidu.swan.apps.canvas.c;

import android.content.Context;
import com.baidu.swan.apps.canvas.view.CanvasView;
/* loaded from: classes2.dex */
public class g {
    public String amv;
    public CanvasView amw;

    public g(Context context, String str, a aVar) {
        this.amv = str;
        this.amw = new CanvasView(context);
        if (aVar != null) {
            this.amw.setInterceptTouchEvent(aVar.amm);
            this.amw.setHide(aVar.hidden);
            this.amw.setGesture(aVar.aBG);
            if (aVar.aBG) {
                this.amw.setInterceptTouchEvent(false);
            }
        }
    }

    public void release() {
        this.amw = null;
    }
}
