package com.baidu.swan.games.glsurface.a;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public final class a {
    private com.baidu.swan.games.e.a bcM;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bcM = aVar;
    }

    public void Or() {
        Pair<Integer, Integer> DP = e.Ea().DP();
        b.K(((Integer) DP.first).intValue(), ((Integer) DP.second).intValue());
    }

    public void J(int i, int i2) {
        b.J(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bcM != null) {
            boolean a = b.a(this.bcM.NT());
            boolean a2 = b.a(this.bcM.NU());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.t(motionEvent);
            }
            r0 = a ? this.bcM.dispatchEvent(jSEvent) : false;
            if (a2 && this.bcM.isLoaded()) {
                this.bcM.NU().dispatchEvent(jSEvent);
            }
            b.cx(true);
        }
        return r0;
    }
}
