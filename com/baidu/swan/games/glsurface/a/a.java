package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public final class a {
    private com.baidu.swan.games.e.a bAQ;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bAQ = aVar;
    }

    public void P(int i, int i2) {
        b.R(i, i2);
    }

    public void Q(int i, int i2) {
        b.Q(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bAQ != null) {
            boolean a = b.a(this.bAQ.WB());
            boolean a2 = b.a(this.bAQ.WC());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.p(motionEvent);
            }
            r0 = a ? this.bAQ.dispatchEvent(jSEvent) : false;
            if (a2 && this.bAQ.isLoaded()) {
                this.bAQ.WC().dispatchEvent(jSEvent);
            }
            b.di(true);
        }
        return r0;
    }
}
