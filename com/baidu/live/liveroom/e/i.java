package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes4.dex */
public class i {
    private static volatile i bmh = null;
    private e bmi;
    private e bmj;
    private c bmk;
    private com.baidu.live.r.d bml;

    private i() {
    }

    public static i Ns() {
        if (bmh == null) {
            synchronized (i.class) {
                if (bmh == null) {
                    bmh = new i();
                }
            }
        }
        return bmh;
    }

    public void a(e eVar) {
        this.bmi = eVar;
    }

    public void b(e eVar) {
        this.bmj = eVar;
    }

    public boolean Nt() {
        return this.bmi != null;
    }

    public d ay(Context context) {
        if (this.bmi != null) {
            return this.bmi.ax(context);
        }
        return null;
    }

    public d az(Context context) {
        if (this.bmj != null) {
            return this.bmj.ax(context);
        }
        return null;
    }

    public void a(c cVar) {
        this.bmk = cVar;
    }

    public b Nu() {
        if (this.bmk != null) {
            return this.bmk.Nr();
        }
        return null;
    }

    public com.baidu.live.r.d Nv() {
        return this.bml;
    }
}
