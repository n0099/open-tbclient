package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes7.dex */
public class h {
    private static volatile h bec = null;
    private e bed;
    private e bee;
    private c bef;
    private com.baidu.live.p.d beh;

    private h() {
    }

    public static h Lr() {
        if (bec == null) {
            synchronized (h.class) {
                if (bec == null) {
                    bec = new h();
                }
            }
        }
        return bec;
    }

    public void a(e eVar) {
        this.bed = eVar;
    }

    public void b(e eVar) {
        this.bee = eVar;
    }

    public boolean Ls() {
        return this.bed != null;
    }

    public d av(Context context) {
        if (this.bed != null) {
            return this.bed.au(context);
        }
        return null;
    }

    public d aw(Context context) {
        if (this.bee != null) {
            return this.bee.au(context);
        }
        return null;
    }

    public void a(c cVar) {
        this.bef = cVar;
    }

    public b Lt() {
        if (this.bef != null) {
            return this.bef.Lq();
        }
        return null;
    }

    public com.baidu.live.p.d Lu() {
        return this.beh;
    }
}
