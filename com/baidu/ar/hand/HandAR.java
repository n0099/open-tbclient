package com.baidu.ar.hand;

import android.os.Bundle;
import com.baidu.ar.arrender.l;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.ar.databasic.AlgoHandleController;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class HandAR extends c {
    private static final String TAG = HandAR.class.getSimpleName();
    private AlgoHandleController cb = null;
    private e mv;
    private HandDetector qu;

    private void b(long j) {
        if (this.cb == null || j <= 0) {
            return;
        }
        long handleType = this.cb.getHandleType(j);
        if (this.qu == null || handleType != 19) {
            return;
        }
        this.qu.b(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.cb == null || this.cb.getHandleType(j) != 19) {
            return;
        }
        b(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        if (this.qu != null) {
            this.qu.a((AlgoHandleController) null);
            this.qu.av();
            a(this.qu);
        }
        if (this.cb != null) {
            this.cb.release();
            this.cb = null;
        }
        l r = r();
        if (r != null) {
            r.q(19);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        if (this.cb == null) {
            this.cb = new AlgoHandleController();
        }
        this.qu = new HandDetector();
        this.qu.a(this.cb);
        this.mv = new e() { // from class: com.baidu.ar.hand.HandAR.1
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                long de2 = bVar.de();
                l r = HandAR.this.r();
                if (r == null || de2 <= 0) {
                    return;
                }
                r.a(de2, "ability_hand_skeleton");
                HandAR.this.a(de2);
            }

            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.l lVar) {
                com.baidu.ar.h.b.c(HandAR.TAG, "onSetup result = " + lVar.isSuccess());
                l r = HandAR.this.r();
                if (r == null || HandAR.this.qu == null) {
                    return;
                }
                r.b(lVar.dk(), HandAR.this.qu.dj());
            }

            @Override // com.baidu.ar.d.e
            public void b(com.baidu.ar.d.l lVar) {
                com.baidu.ar.h.b.c(HandAR.TAG, "onRelease result = " + lVar.isSuccess());
            }
        };
        a(this.qu, this.mv);
        com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
        this.qu.b((Bundle) null);
    }
}
