package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes7.dex */
public final class a {
    private com.baidu.swan.games.f.a dja;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dja = aVar;
    }

    public void ar(int i, int i2) {
        b.at(i, i2);
    }

    public void as(int i, int i2) {
        b.as(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dja != null) {
            boolean a = b.a(this.dja.aEm());
            boolean a2 = b.a(this.dja.aEn());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.o(motionEvent);
            }
            r0 = a ? this.dja.dispatchEvent(jSEvent) : false;
            if (a2 && this.dja.isLoaded()) {
                this.dja.aEn().dispatchEvent(jSEvent);
            }
            b.gj(true);
        }
        return r0;
    }
}
