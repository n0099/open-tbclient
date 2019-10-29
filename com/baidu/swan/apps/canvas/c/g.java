package com.baidu.swan.apps.canvas.c;

import android.content.Context;
import com.baidu.swan.apps.canvas.view.CanvasView;
/* loaded from: classes2.dex */
public class g {
    public String aHe;
    public CanvasView aHf;

    public g(Context context, String str, a aVar) {
        this.aHe = str;
        this.aHf = new CanvasView(context);
        if (aVar != null) {
            this.aHf.setInterceptTouchEvent(aVar.aGV);
            this.aHf.setHide(aVar.hidden);
            this.aHf.setGesture(aVar.aXK);
            if (aVar.aXK) {
                this.aHf.setInterceptTouchEvent(false);
            }
        }
    }

    public void release() {
        this.aHf = null;
    }
}
