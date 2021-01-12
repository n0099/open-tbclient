package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes8.dex */
public final class a {
    private com.baidu.swan.games.f.a efd;

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.efd = aVar;
    }

    public void ax(int i, int i2) {
        b.az(i, i2);
    }

    public void ay(int i, int i2) {
        b.ay(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.efd != null) {
            boolean a2 = b.a(this.efd.aVN());
            boolean a3 = b.a(this.efd.aVO());
            JSEvent jSEvent = null;
            if (a2 || a3) {
                jSEvent = b.D(motionEvent);
            }
            r0 = a2 ? this.efd.dispatchEvent(jSEvent) : false;
            if (a3 && this.efd.isLoaded()) {
                this.efd.aVO().dispatchEvent(jSEvent);
            }
            b.ic(true);
        }
        return r0;
    }
}
