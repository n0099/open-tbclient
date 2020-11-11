package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes10.dex */
public final class a {
    private com.baidu.swan.games.f.a dVD;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dVD = aVar;
    }

    public void ay(int i, int i2) {
        b.aA(i, i2);
    }

    public void az(int i, int i2) {
        b.az(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dVD != null) {
            boolean a2 = b.a(this.dVD.aUP());
            boolean a3 = b.a(this.dVD.aUQ());
            JSEvent jSEvent = null;
            if (a2 || a3) {
                jSEvent = b.D(motionEvent);
            }
            r0 = a2 ? this.dVD.dispatchEvent(jSEvent) : false;
            if (a3 && this.dVD.isLoaded()) {
                this.dVD.aUQ().dispatchEvent(jSEvent);
            }
            b.hw(true);
        }
        return r0;
    }
}
