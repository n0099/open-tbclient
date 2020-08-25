package com.baidu.ar.hand;

import android.os.Bundle;
import com.baidu.ar.arrender.k;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleController;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class HandAR extends c {
    private static final String TAG = HandAR.class.getSimpleName();
    private AlgoHandleController bY = null;
    private e mg;
    private HandDetector qe;

    private void b(long j) {
        if (this.bY == null || j <= 0) {
            return;
        }
        long handleType = this.bY.getHandleType(j);
        if (this.qe == null || handleType != 19) {
            return;
        }
        this.qe.b(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.bY == null || this.bY.getHandleType(j) != 19) {
            return;
        }
        b(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        if (this.qe != null) {
            this.qe.a((AlgoHandleController) null);
            this.qe.au();
            a(this.qe);
        }
        if (this.bY != null) {
            this.bY.release();
            this.bY = null;
        }
        k r = r();
        if (r != null) {
            r.o(19);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        if (this.bY == null) {
            this.bY = new AlgoHandleController();
        }
        this.qe = new HandDetector();
        this.qe.a(this.bY);
        this.mg = new e() { // from class: com.baidu.ar.hand.HandAR.1
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                long df = bVar.df();
                k r = HandAR.this.r();
                if (r == null || df <= 0) {
                    return;
                }
                r.a(df, "ability_hand_skeleton");
                HandAR.this.a(df);
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                com.baidu.ar.g.b.c(HandAR.TAG, "onSetup result = " + lVar.isSuccess());
                k r = HandAR.this.r();
                if (r == null || HandAR.this.qe == null) {
                    return;
                }
                r.b(lVar.dl(), HandAR.this.qe.dk());
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
                com.baidu.ar.g.b.c(HandAR.TAG, "onRelease result = " + lVar.isSuccess());
            }
        };
        a(this.qe, this.mg);
        com.baidu.ar.b.a.ar().a(getContext(), getMdlConfigs());
        this.qe.b((Bundle) null);
    }
}
