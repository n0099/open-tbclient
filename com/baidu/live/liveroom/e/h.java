package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes7.dex */
public class h {
    private static volatile h bee = null;
    private e bef;
    private e beh;
    private c bei;
    private com.baidu.live.p.d bej;

    private h() {
    }

    public static h Lr() {
        if (bee == null) {
            synchronized (h.class) {
                if (bee == null) {
                    bee = new h();
                }
            }
        }
        return bee;
    }

    public void a(e eVar) {
        this.bef = eVar;
    }

    public void b(e eVar) {
        this.beh = eVar;
    }

    public boolean Ls() {
        return this.bef != null;
    }

    public d av(Context context) {
        if (this.bef != null) {
            return this.bef.au(context);
        }
        return null;
    }

    public d aw(Context context) {
        if (this.beh != null) {
            return this.beh.au(context);
        }
        return null;
    }

    public void a(c cVar) {
        this.bei = cVar;
    }

    public b Lt() {
        if (this.bei != null) {
            return this.bei.Lq();
        }
        return null;
    }

    public com.baidu.live.p.d Lu() {
        return this.bej;
    }
}
