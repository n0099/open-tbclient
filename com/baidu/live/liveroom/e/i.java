package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes10.dex */
public class i {
    private static volatile i btg = null;
    private e bth;
    private e bti;
    private c btj;
    private com.baidu.live.u.d btk;

    private i() {
    }

    public static i MW() {
        if (btg == null) {
            synchronized (i.class) {
                if (btg == null) {
                    btg = new i();
                }
            }
        }
        return btg;
    }

    public void a(e eVar) {
        this.bth = eVar;
    }

    public void b(e eVar) {
        this.bti = eVar;
    }

    public boolean MX() {
        return this.bth != null;
    }

    public d aZ(Context context) {
        if (this.bth != null) {
            return this.bth.aY(context);
        }
        return null;
    }

    public d ba(Context context) {
        if (this.bti != null) {
            return this.bti.aY(context);
        }
        return null;
    }

    public void a(c cVar) {
        this.btj = cVar;
    }

    public b MY() {
        if (this.btj != null) {
            return this.btj.MU();
        }
        return null;
    }

    public com.baidu.live.u.d MZ() {
        return this.btk;
    }
}
