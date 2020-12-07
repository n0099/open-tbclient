package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes25.dex */
public final class a {
    private com.baidu.swan.games.f.a eaT;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.eaT = aVar;
    }

    public void aA(int i, int i2) {
        b.aC(i, i2);
    }

    public void aB(int i, int i2) {
        b.aB(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.eaT != null) {
            boolean a2 = b.a(this.eaT.aXm());
            boolean a3 = b.a(this.eaT.aXn());
            JSEvent jSEvent = null;
            if (a2 || a3) {
                jSEvent = b.D(motionEvent);
            }
            r0 = a2 ? this.eaT.dispatchEvent(jSEvent) : false;
            if (a3 && this.eaT.isLoaded()) {
                this.eaT.aXn().dispatchEvent(jSEvent);
            }
            b.hO(true);
        }
        return r0;
    }
}
