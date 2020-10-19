package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes10.dex */
public final class a {
    private com.baidu.swan.games.f.a dHo;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dHo = aVar;
    }

    public void ax(int i, int i2) {
        b.az(i, i2);
    }

    public void ay(int i, int i2) {
        b.ay(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dHo != null) {
            boolean a2 = b.a(this.dHo.aQv());
            boolean a3 = b.a(this.dHo.aQw());
            JSEvent jSEvent = null;
            if (a2 || a3) {
                jSEvent = b.D(motionEvent);
            }
            r0 = a2 ? this.dHo.dispatchEvent(jSEvent) : false;
            if (a3 && this.dHo.isLoaded()) {
                this.dHo.aQw().dispatchEvent(jSEvent);
            }
            b.ha(true);
        }
        return r0;
    }
}
