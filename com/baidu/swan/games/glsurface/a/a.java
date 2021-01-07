package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes9.dex */
public final class a {
    private com.baidu.swan.games.f.a ejQ;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.ejQ = aVar;
    }

    public void ax(int i, int i2) {
        b.az(i, i2);
    }

    public void ay(int i, int i2) {
        b.ay(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ejQ != null) {
            boolean a2 = b.a(this.ejQ.aZH());
            boolean a3 = b.a(this.ejQ.aZI());
            JSEvent jSEvent = null;
            if (a2 || a3) {
                jSEvent = b.D(motionEvent);
            }
            r0 = a2 ? this.ejQ.dispatchEvent(jSEvent) : false;
            if (a3 && this.ejQ.isLoaded()) {
                this.ejQ.aZI().dispatchEvent(jSEvent);
            }
            b.ig(true);
        }
        return r0;
    }
}
