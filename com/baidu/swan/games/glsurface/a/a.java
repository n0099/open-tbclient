package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public final class a {
    private com.baidu.swan.games.e.a cov;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.cov = aVar;
    }

    public void am(int i, int i2) {
        b.ao(i, i2);
    }

    public void an(int i, int i2) {
        b.an(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cov != null) {
            boolean a = b.a(this.cov.anu());
            boolean a2 = b.a(this.cov.anv());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.p(motionEvent);
            }
            r0 = a ? this.cov.dispatchEvent(jSEvent) : false;
            if (a2 && this.cov.isLoaded()) {
                this.cov.anv().dispatchEvent(jSEvent);
            }
            b.eE(true);
        }
        return r0;
    }
}
