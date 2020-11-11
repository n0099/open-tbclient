package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes4.dex */
public class i {
    private static volatile i bnB = null;
    private e bnC;
    private e bnD;
    private c bnE;
    private com.baidu.live.s.d bnF;

    private i() {
    }

    public static i NS() {
        if (bnB == null) {
            synchronized (i.class) {
                if (bnB == null) {
                    bnB = new i();
                }
            }
        }
        return bnB;
    }

    public void a(e eVar) {
        this.bnC = eVar;
    }

    public void b(e eVar) {
        this.bnD = eVar;
    }

    public boolean NT() {
        return this.bnC != null;
    }

    public d ay(Context context) {
        if (this.bnC != null) {
            return this.bnC.ax(context);
        }
        return null;
    }

    public d az(Context context) {
        if (this.bnD != null) {
            return this.bnD.ax(context);
        }
        return null;
    }

    public void a(c cVar) {
        this.bnE = cVar;
    }

    public b NU() {
        if (this.bnE != null) {
            return this.bnE.NR();
        }
        return null;
    }

    public com.baidu.live.s.d NV() {
        return this.bnF;
    }
}
