package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes9.dex */
public final class a {
    private com.baidu.swan.games.e.a cke;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.cke = aVar;
    }

    public void ai(int i, int i2) {
        b.ak(i, i2);
    }

    public void aj(int i, int i2) {
        b.aj(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cke != null) {
            boolean a = b.a(this.cke.akN());
            boolean a2 = b.a(this.cke.akO());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.p(motionEvent);
            }
            r0 = a ? this.cke.dispatchEvent(jSEvent) : false;
            if (a2 && this.cke.isLoaded()) {
                this.cke.akO().dispatchEvent(jSEvent);
            }
            b.es(true);
        }
        return r0;
    }
}
