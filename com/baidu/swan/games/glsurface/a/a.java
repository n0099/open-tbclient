package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public final class a {
    private com.baidu.swan.games.e.a coI;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.coI = aVar;
    }

    public void am(int i, int i2) {
        b.ao(i, i2);
    }

    public void an(int i, int i2) {
        b.an(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.coI != null) {
            boolean a = b.a(this.coI.anz());
            boolean a2 = b.a(this.coI.anA());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.p(motionEvent);
            }
            r0 = a ? this.coI.dispatchEvent(jSEvent) : false;
            if (a2 && this.coI.isLoaded()) {
                this.coI.anA().dispatchEvent(jSEvent);
            }
            b.eF(true);
        }
        return r0;
    }
}
