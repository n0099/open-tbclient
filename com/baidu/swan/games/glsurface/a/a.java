package com.baidu.swan.games.glsurface.a;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public final class a {
    private com.baidu.swan.games.e.a bcI;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bcI = aVar;
    }

    public void Ot() {
        Pair<Integer, Integer> DR = e.Ec().DR();
        b.K(((Integer) DR.first).intValue(), ((Integer) DR.second).intValue());
    }

    public void J(int i, int i2) {
        b.J(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bcI != null) {
            boolean a = b.a(this.bcI.NV());
            boolean a2 = b.a(this.bcI.NW());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.t(motionEvent);
            }
            r0 = a ? this.bcI.dispatchEvent(jSEvent) : false;
            if (a2 && this.bcI.isLoaded()) {
                this.bcI.NW().dispatchEvent(jSEvent);
            }
            b.cx(true);
        }
        return r0;
    }
}
