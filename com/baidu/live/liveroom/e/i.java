package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes4.dex */
public class i {
    private static volatile i blQ = null;
    private e blR;
    private e blS;
    private c blT;
    private com.baidu.live.s.d blU;

    private i() {
    }

    public static i Nj() {
        if (blQ == null) {
            synchronized (i.class) {
                if (blQ == null) {
                    blQ = new i();
                }
            }
        }
        return blQ;
    }

    public void a(e eVar) {
        this.blR = eVar;
    }

    public void b(e eVar) {
        this.blS = eVar;
    }

    public boolean Nk() {
        return this.blR != null;
    }

    public d ay(Context context) {
        if (this.blR != null) {
            return this.blR.ax(context);
        }
        return null;
    }

    public d az(Context context) {
        if (this.blS != null) {
            return this.blS.ax(context);
        }
        return null;
    }

    public void a(c cVar) {
        this.blT = cVar;
    }

    public b Nl() {
        if (this.blT != null) {
            return this.blT.Ni();
        }
        return null;
    }

    public com.baidu.live.s.d Nm() {
        return this.blU;
    }
}
