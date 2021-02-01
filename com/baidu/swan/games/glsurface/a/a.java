package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes9.dex */
public final class a {
    private com.baidu.swan.games.f.a ehl;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.ehl = aVar;
    }

    public void au(int i, int i2) {
        b.aw(i, i2);
    }

    public void av(int i, int i2) {
        b.av(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ehl != null) {
            boolean a2 = b.a(this.ehl.aVZ());
            boolean a3 = b.a(this.ehl.aWa());
            JSEvent jSEvent = null;
            if (a2 || a3) {
                jSEvent = b.D(motionEvent);
            }
            r0 = a2 ? this.ehl.dispatchEvent(jSEvent) : false;
            if (a3 && this.ehl.isLoaded()) {
                this.ehl.aWa().dispatchEvent(jSEvent);
            }
            b.ie(true);
        }
        return r0;
    }
}
