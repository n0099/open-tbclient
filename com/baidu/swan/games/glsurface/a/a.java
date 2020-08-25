package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes8.dex */
public final class a {
    private com.baidu.swan.games.f.a dth;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dth = aVar;
    }

    public void ay(int i, int i2) {
        b.aA(i, i2);
    }

    public void az(int i, int i2) {
        b.az(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dth != null) {
            boolean a = b.a(this.dth.aNb());
            boolean a2 = b.a(this.dth.aNc());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.D(motionEvent);
            }
            r0 = a ? this.dth.dispatchEvent(jSEvent) : false;
            if (a2 && this.dth.isLoaded()) {
                this.dth.aNc().dispatchEvent(jSEvent);
            }
            b.gF(true);
        }
        return r0;
    }
}
