package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes4.dex */
public class i {
    private static volatile i bqX = null;
    private e bqY;
    private e bqZ;
    private c bra;
    private com.baidu.live.u.d brb;

    private i() {
    }

    public static i PB() {
        if (bqX == null) {
            synchronized (i.class) {
                if (bqX == null) {
                    bqX = new i();
                }
            }
        }
        return bqX;
    }

    public void a(e eVar) {
        this.bqY = eVar;
    }

    public void b(e eVar) {
        this.bqZ = eVar;
    }

    public boolean PC() {
        return this.bqY != null;
    }

    public d bc(Context context) {
        if (this.bqY != null) {
            return this.bqY.bb(context);
        }
        return null;
    }

    public d bd(Context context) {
        if (this.bqZ != null) {
            return this.bqZ.bb(context);
        }
        return null;
    }

    public void a(c cVar) {
        this.bra = cVar;
    }

    public b PD() {
        if (this.bra != null) {
            return this.bra.PA();
        }
        return null;
    }

    public com.baidu.live.u.d PE() {
        return this.brb;
    }
}
