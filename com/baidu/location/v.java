package com.baidu.location;

import android.os.Message;
import com.baidu.location.aj;
/* loaded from: classes.dex */
class v extends aj implements a0, n {
    private static v eU = null;
    static final int eV = 3000;
    public aj.a eY;
    private BDLocation eX = null;
    private long eW = 0;

    private v() {
        this.eY = null;
        this.eY = new aj.a();
    }

    private void aM() {
        q.y().F();
    }

    public static v aN() {
        if (eU == null) {
            eU = new v();
        }
        return eU;
    }

    /* renamed from: void  reason: not valid java name */
    private void m360void(Message message) {
        if (System.currentTimeMillis() - this.eW < 3000 && this.eX != null) {
            k.q().m302if(this.eX, 26);
            return;
        }
        this.eY.e(h(k.q().m301if(message)));
        this.eW = System.currentTimeMillis();
    }

    @Override // com.baidu.location.aj
    void aA() {
        c.m273if(a0.i, "on network exception");
        this.eX = null;
        k.q().m302if(a1.ct().m76case(false), 26);
        aM();
    }

    @Override // com.baidu.location.aj
    /* renamed from: byte */
    void mo113byte(Message message) {
        c.m273if(a0.i, "on network success");
        BDLocation bDLocation = (BDLocation) message.obj;
        k.q().m302if(bDLocation, 26);
        if (c.m274if(bDLocation)) {
            this.eX = bDLocation;
        } else {
            this.eX = null;
        }
        aM();
    }

    /* renamed from: long  reason: not valid java name */
    public void m361long(Message message) {
        m360void(message);
    }
}
