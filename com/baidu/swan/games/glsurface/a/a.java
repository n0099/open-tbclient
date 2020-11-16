package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes7.dex */
public final class a {
    private com.baidu.swan.games.f.a dTV;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dTV = aVar;
    }

    public void ay(int i, int i2) {
        b.aA(i, i2);
    }

    public void az(int i, int i2) {
        b.az(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dTV != null) {
            boolean a2 = b.a(this.dTV.aUh());
            boolean a3 = b.a(this.dTV.aUi());
            JSEvent jSEvent = null;
            if (a2 || a3) {
                jSEvent = b.D(motionEvent);
            }
            r0 = a2 ? this.dTV.dispatchEvent(jSEvent) : false;
            if (a3 && this.dTV.isLoaded()) {
                this.dTV.aUi().dispatchEvent(jSEvent);
            }
            b.hz(true);
        }
        return r0;
    }
}
