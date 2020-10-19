package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes4.dex */
public class i {
    private static volatile i bkM = null;
    private e bkN;
    private e bkO;
    private c bkP;
    private com.baidu.live.q.d bkQ;

    private i() {
    }

    public static i MY() {
        if (bkM == null) {
            synchronized (i.class) {
                if (bkM == null) {
                    bkM = new i();
                }
            }
        }
        return bkM;
    }

    public void a(e eVar) {
        this.bkN = eVar;
    }

    public void b(e eVar) {
        this.bkO = eVar;
    }

    public boolean MZ() {
        return this.bkN != null;
    }

    public d ay(Context context) {
        if (this.bkN != null) {
            return this.bkN.ax(context);
        }
        return null;
    }

    public d az(Context context) {
        if (this.bkO != null) {
            return this.bkO.ax(context);
        }
        return null;
    }

    public void a(c cVar) {
        this.bkP = cVar;
    }

    public b Na() {
        if (this.bkP != null) {
            return this.bkP.MX();
        }
        return null;
    }

    public com.baidu.live.q.d Nb() {
        return this.bkQ;
    }
}
