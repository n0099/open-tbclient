package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public final class a {
    private com.baidu.swan.games.f.a ddp;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.ddp = aVar;
    }

    public void ar(int i, int i2) {
        b.at(i, i2);
    }

    public void as(int i, int i2) {
        b.as(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ddp != null) {
            boolean a = b.a(this.ddp.aAH());
            boolean a2 = b.a(this.ddp.aAI());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.o(motionEvent);
            }
            r0 = a ? this.ddp.dispatchEvent(jSEvent) : false;
            if (a2 && this.ddp.isLoaded()) {
                this.ddp.aAI().dispatchEvent(jSEvent);
            }
            b.fS(true);
        }
        return r0;
    }
}
