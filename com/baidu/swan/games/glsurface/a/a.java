package com.baidu.swan.games.glsurface.a;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public final class a {
    private com.baidu.swan.games.e.a bcH;

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bcH = aVar;
    }

    public void Ot() {
        Pair<Integer, Integer> DR = e.Ec().DR();
        b.K(((Integer) DR.first).intValue(), ((Integer) DR.second).intValue());
    }

    public void J(int i, int i2) {
        b.J(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bcH != null) {
            boolean a = b.a(this.bcH.NV());
            boolean a2 = b.a(this.bcH.NW());
            JSEvent jSEvent = null;
            if (a || a2) {
                jSEvent = b.t(motionEvent);
            }
            r0 = a ? this.bcH.dispatchEvent(jSEvent) : false;
            if (a2 && this.bcH.isLoaded()) {
                this.bcH.NW().dispatchEvent(jSEvent);
            }
            b.cx(true);
        }
        return r0;
    }
}
