package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public final class a {
    private com.baidu.swan.games.f.a cYC;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.cYC = aVar;
    }

    public void ap(int i, int i2) {
        b.ar(i, i2);
    }

    public void aq(int i, int i2) {
        b.aq(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cYC != null) {
            boolean a = b.a(this.cYC.azB());
            boolean a2 = b.a(this.cYC.azC());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.o(motionEvent);
            }
            r0 = a ? this.cYC.dispatchEvent(jSEvent) : false;
            if (a2 && this.cYC.isLoaded()) {
                this.cYC.azC().dispatchEvent(jSEvent);
            }
            b.fN(true);
        }
        return r0;
    }
}
