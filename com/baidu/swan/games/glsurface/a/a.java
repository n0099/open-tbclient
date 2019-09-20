package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public final class a {
    private com.baidu.swan.games.e.a bia;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bia = aVar;
    }

    public void J(int i, int i2) {
        b.L(i, i2);
    }

    public void K(int i, int i2) {
        b.K(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bia != null) {
            boolean a = b.a(this.bia.RK());
            boolean a2 = b.a(this.bia.RL());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.t(motionEvent);
            }
            r0 = a ? this.bia.dispatchEvent(jSEvent) : false;
            if (a2 && this.bia.isLoaded()) {
                this.bia.RL().dispatchEvent(jSEvent);
            }
            b.cR(true);
        }
        return r0;
    }
}
