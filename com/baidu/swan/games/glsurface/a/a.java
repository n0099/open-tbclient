package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes10.dex */
public final class a {
    private com.baidu.swan.games.e.a ckr;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.ckr = aVar;
    }

    public void am(int i, int i2) {
        b.ao(i, i2);
    }

    public void an(int i, int i2) {
        b.an(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ckr != null) {
            boolean a = b.a(this.ckr.alg());
            boolean a2 = b.a(this.ckr.alh());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.p(motionEvent);
            }
            r0 = a ? this.ckr.dispatchEvent(jSEvent) : false;
            if (a2 && this.ckr.isLoaded()) {
                this.ckr.alh().dispatchEvent(jSEvent);
            }
            b.ex(true);
        }
        return r0;
    }
}
