package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public final class a {
    private com.baidu.swan.games.e.a bgP;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bgP = aVar;
    }

    public void G(int i, int i2) {
        b.I(i, i2);
    }

    public void H(int i, int i2) {
        b.H(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bgP != null) {
            boolean a = b.a(this.bgP.QN());
            boolean a2 = b.a(this.bgP.QO());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.t(motionEvent);
            }
            r0 = a ? this.bgP.dispatchEvent(jSEvent) : false;
            if (a2 && this.bgP.isLoaded()) {
                this.bgP.QO().dispatchEvent(jSEvent);
            }
            b.cO(true);
        }
        return r0;
    }
}
