package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes4.dex */
public class i {
    private static volatile i bgW = null;
    private e bgX;
    private e bgY;
    private c bgZ;
    private com.baidu.live.q.d bha;

    private i() {
    }

    public static i LT() {
        if (bgW == null) {
            synchronized (i.class) {
                if (bgW == null) {
                    bgW = new i();
                }
            }
        }
        return bgW;
    }

    public void a(e eVar) {
        this.bgX = eVar;
    }

    public void b(e eVar) {
        this.bgY = eVar;
    }

    public boolean LU() {
        return this.bgX != null;
    }

    public d av(Context context) {
        if (this.bgX != null) {
            return this.bgX.au(context);
        }
        return null;
    }

    public d aw(Context context) {
        if (this.bgY != null) {
            return this.bgY.au(context);
        }
        return null;
    }

    public void a(c cVar) {
        this.bgZ = cVar;
    }

    public b LV() {
        if (this.bgZ != null) {
            return this.bgZ.LS();
        }
        return null;
    }

    public com.baidu.live.q.d LW() {
        return this.bha;
    }
}
