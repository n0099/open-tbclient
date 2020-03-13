package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public final class a {
    private com.baidu.swan.games.e.a cox;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.cox = aVar;
    }

    public void am(int i, int i2) {
        b.ao(i, i2);
    }

    public void an(int i, int i2) {
        b.an(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cox != null) {
            boolean a = b.a(this.cox.anw());
            boolean a2 = b.a(this.cox.anx());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.p(motionEvent);
            }
            r0 = a ? this.cox.dispatchEvent(jSEvent) : false;
            if (a2 && this.cox.isLoaded()) {
                this.cox.anx().dispatchEvent(jSEvent);
            }
            b.eE(true);
        }
        return r0;
    }
}
