package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes8.dex */
public final class a {
    private com.baidu.swan.games.f.a eiM;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.eiM = aVar;
    }

    public void au(int i, int i2) {
        b.aw(i, i2);
    }

    public void av(int i, int i2) {
        b.av(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.eiM != null) {
            boolean a2 = b.a(this.eiM.aWc());
            boolean a3 = b.a(this.eiM.aWd());
            JSEvent jSEvent = null;
            if (a2 || a3) {
                jSEvent = b.D(motionEvent);
            }
            r0 = a2 ? this.eiM.dispatchEvent(jSEvent) : false;
            if (a3 && this.eiM.isLoaded()) {
                this.eiM.aWd().dispatchEvent(jSEvent);
            }
            b.ie(true);
        }
        return r0;
    }
}
