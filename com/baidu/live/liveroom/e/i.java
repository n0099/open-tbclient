package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes11.dex */
public class i {
    private static volatile i brG = null;
    private e brH;
    private e brI;
    private c brJ;
    private com.baidu.live.u.d brK;

    private i() {
    }

    public static i MT() {
        if (brG == null) {
            synchronized (i.class) {
                if (brG == null) {
                    brG = new i();
                }
            }
        }
        return brG;
    }

    public void a(e eVar) {
        this.brH = eVar;
    }

    public void b(e eVar) {
        this.brI = eVar;
    }

    public boolean MU() {
        return this.brH != null;
    }

    public d ba(Context context) {
        if (this.brH != null) {
            return this.brH.aZ(context);
        }
        return null;
    }

    public d bb(Context context) {
        if (this.brI != null) {
            return this.brI.aZ(context);
        }
        return null;
    }

    public void a(c cVar) {
        this.brJ = cVar;
    }

    public b MV() {
        if (this.brJ != null) {
            return this.brJ.MR();
        }
        return null;
    }

    public com.baidu.live.u.d MW() {
        return this.brK;
    }
}
