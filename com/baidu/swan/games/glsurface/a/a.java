package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes10.dex */
public final class a {
    private com.baidu.swan.games.f.a dPL;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dPL = aVar;
    }

    public void ay(int i, int i2) {
        b.aA(i, i2);
    }

    public void az(int i, int i2) {
        b.az(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dPL != null) {
            boolean a2 = b.a(this.dPL.aSp());
            boolean a3 = b.a(this.dPL.aSq());
            JSEvent jSEvent = null;
            if (a2 || a3) {
                jSEvent = b.D(motionEvent);
            }
            r0 = a2 ? this.dPL.dispatchEvent(jSEvent) : false;
            if (a3 && this.dPL.isLoaded()) {
                this.dPL.aSq().dispatchEvent(jSEvent);
            }
            b.hn(true);
        }
        return r0;
    }
}
