package com.baidu.ar.hand;

import android.os.Bundle;
import com.baidu.ar.arrender.j;
import com.baidu.ar.c;
import com.baidu.ar.c.e;
import com.baidu.ar.c.l;
import com.baidu.ar.databasic.AlgoHandleController;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class HandAR extends c {
    private static final String TAG = HandAR.class.getSimpleName();
    private AlgoHandleController ch = null;
    private e ly;
    private a py;

    private void b(long j) {
        if (this.ch == null || j <= 0) {
            return;
        }
        long handleType = this.ch.getHandleType(j);
        if (this.py == null || handleType != 19) {
            return;
        }
        this.py.b(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.ch == null || this.ch.getHandleType(j) != 19) {
            return;
        }
        b(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        if (this.py != null) {
            this.py.a((AlgoHandleController) null);
            this.py.aw();
            a(this.py);
        }
        if (this.ch != null) {
            this.ch.release();
            this.ch = null;
        }
        j r = r();
        if (r != null) {
            r.r(19);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        if (this.ch == null) {
            this.ch = new AlgoHandleController();
        }
        this.py = new a();
        this.py.a(this.ch);
        this.ly = new e() { // from class: com.baidu.ar.hand.HandAR.1
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                long cF = bVar.cF();
                j r = HandAR.this.r();
                if (r == null || cF <= 0) {
                    return;
                }
                r.a(cF, "ability_hand_skeleton");
                HandAR.this.a(cF);
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
                com.baidu.ar.f.b.c(HandAR.TAG, "onSetup result = " + lVar.isSuccess());
                j r = HandAR.this.r();
                if (r == null || HandAR.this.py == null) {
                    return;
                }
                r.a(lVar.cL(), HandAR.this.py.cK());
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
                com.baidu.ar.f.b.c(HandAR.TAG, "onRelease result = " + lVar.isSuccess());
            }
        };
        a(this.py, this.ly);
        com.baidu.ar.b.a.aq().a(getContext(), getMdlConfigs());
        this.py.c((Bundle) null);
    }
}
