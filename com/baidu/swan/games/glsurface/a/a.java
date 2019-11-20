package com.baidu.swan.games.glsurface.a;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public final class a {
    private com.baidu.swan.games.e.a bzZ;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bzZ = aVar;
    }

    public void N(int i, int i2) {
        b.P(i, i2);
    }

    public void O(int i, int i2) {
        b.O(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bzZ != null) {
            boolean a = b.a(this.bzZ.Wz());
            boolean a2 = b.a(this.bzZ.WA());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.p(motionEvent);
            }
            r0 = a ? this.bzZ.dispatchEvent(jSEvent) : false;
            if (a2 && this.bzZ.isLoaded()) {
                this.bzZ.WA().dispatchEvent(jSEvent);
            }
            b.di(true);
        }
        return r0;
    }
}
