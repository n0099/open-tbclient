package com.baidu.swan.apps.canvas.c;

import android.content.Context;
import com.baidu.swan.apps.canvas.view.CanvasView;
/* loaded from: classes2.dex */
public class g {
    public String anN;
    public CanvasView anO;

    public g(Context context, String str, a aVar) {
        this.anN = str;
        this.anO = new CanvasView(context);
        if (aVar != null) {
            this.anO.setInterceptTouchEvent(aVar.anE);
            this.anO.setHide(aVar.hidden);
            this.anO.setGesture(aVar.aEv);
            if (aVar.aEv) {
                this.anO.setInterceptTouchEvent(false);
            }
        }
    }

    public void release() {
        this.anO = null;
    }
}
