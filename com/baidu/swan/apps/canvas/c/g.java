package com.baidu.swan.apps.canvas.c;

import android.content.Context;
import com.baidu.swan.apps.canvas.view.CanvasView;
/* loaded from: classes2.dex */
public class g {
    public String aGM;
    public CanvasView aGN;

    public g(Context context, String str, a aVar) {
        this.aGM = str;
        this.aGN = new CanvasView(context);
        if (aVar != null) {
            this.aGN.setInterceptTouchEvent(aVar.aGD);
            this.aGN.setHide(aVar.hidden);
            this.aGN.setGesture(aVar.aXs);
            if (aVar.aXs) {
                this.aGN.setInterceptTouchEvent(false);
            }
        }
    }

    public void release() {
        this.aGN = null;
    }
}
