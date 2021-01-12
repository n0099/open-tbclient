package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes10.dex */
public class i {
    private static volatile i bof = null;
    private e bog;
    private e boh;
    private c boi;
    private com.baidu.live.v.d boj;

    private i() {
    }

    public static i Lv() {
        if (bof == null) {
            synchronized (i.class) {
                if (bof == null) {
                    bof = new i();
                }
            }
        }
        return bof;
    }

    public void a(e eVar) {
        this.bog = eVar;
    }

    public void b(e eVar) {
        this.boh = eVar;
    }

    public boolean Lw() {
        return this.bog != null;
    }

    public d ba(Context context) {
        if (this.bog != null) {
            return this.bog.aZ(context);
        }
        return null;
    }

    public d bb(Context context) {
        if (this.boh != null) {
            return this.boh.aZ(context);
        }
        return null;
    }

    public void a(c cVar) {
        this.boi = cVar;
    }

    public b Lx() {
        if (this.boi != null) {
            return this.boi.Lt();
        }
        return null;
    }

    public com.baidu.live.v.d Ly() {
        return this.boj;
    }
}
