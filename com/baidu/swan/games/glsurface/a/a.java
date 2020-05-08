package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public final class a {
    private com.baidu.swan.games.e.a cNK;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.cNK = aVar;
    }

    public void ap(int i, int i2) {
        b.ar(i, i2);
    }

    public void aq(int i, int i2) {
        b.aq(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cNK != null) {
            boolean a = b.a(this.cNK.avM());
            boolean a2 = b.a(this.cNK.avN());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.o(motionEvent);
            }
            r0 = a ? this.cNK.dispatchEvent(jSEvent) : false;
            if (a2 && this.cNK.isLoaded()) {
                this.cNK.avN().dispatchEvent(jSEvent);
            }
            b.fC(true);
        }
        return r0;
    }
}
