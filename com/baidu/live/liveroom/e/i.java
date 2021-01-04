package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes11.dex */
public class i {
    private static volatile i bsR = null;
    private e bsS;
    private e bsT;
    private c bsU;
    private com.baidu.live.v.d bsV;

    private i() {
    }

    public static i Pq() {
        if (bsR == null) {
            synchronized (i.class) {
                if (bsR == null) {
                    bsR = new i();
                }
            }
        }
        return bsR;
    }

    public void a(e eVar) {
        this.bsS = eVar;
    }

    public void b(e eVar) {
        this.bsT = eVar;
    }

    public boolean Pr() {
        return this.bsS != null;
    }

    public d bb(Context context) {
        if (this.bsS != null) {
            return this.bsS.ba(context);
        }
        return null;
    }

    public d bc(Context context) {
        if (this.bsT != null) {
            return this.bsT.ba(context);
        }
        return null;
    }

    public void a(c cVar) {
        this.bsU = cVar;
    }

    public b Ps() {
        if (this.bsU != null) {
            return this.bsU.Po();
        }
        return null;
    }

    public com.baidu.live.v.d Pt() {
        return this.bsV;
    }
}
