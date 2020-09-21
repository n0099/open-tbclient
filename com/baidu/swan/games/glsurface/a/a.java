package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public final class a {
    private com.baidu.swan.games.f.a dvn;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dvn = aVar;
    }

    public void ay(int i, int i2) {
        b.aA(i, i2);
    }

    public void az(int i, int i2) {
        b.az(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dvn != null) {
            boolean a = b.a(this.dvn.aNM());
            boolean a2 = b.a(this.dvn.aNN());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.D(motionEvent);
            }
            r0 = a ? this.dvn.dispatchEvent(jSEvent) : false;
            if (a2 && this.dvn.isLoaded()) {
                this.dvn.aNN().dispatchEvent(jSEvent);
            }
            b.gE(true);
        }
        return r0;
    }
}
