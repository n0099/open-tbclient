package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public final class a {
    private com.baidu.swan.games.e.a bhC;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bhC = aVar;
    }

    public void J(int i, int i2) {
        b.L(i, i2);
    }

    public void K(int i, int i2) {
        b.K(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bhC != null) {
            boolean a = b.a(this.bhC.RG());
            boolean a2 = b.a(this.bhC.RH());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.t(motionEvent);
            }
            r0 = a ? this.bhC.dispatchEvent(jSEvent) : false;
            if (a2 && this.bhC.isLoaded()) {
                this.bhC.RH().dispatchEvent(jSEvent);
            }
            b.cR(true);
        }
        return r0;
    }
}
