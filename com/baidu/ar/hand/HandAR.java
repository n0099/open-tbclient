package com.baidu.ar.hand;

import android.os.Bundle;
import com.baidu.ar.arrender.l;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.ar.databasic.AlgoHandleController;
import java.util.HashMap;
/* loaded from: classes.dex */
public class HandAR extends c {
    public static final String TAG = "HandAR";
    public AlgoHandleController cb = null;
    public e mv;
    public HandDetector qu;

    private void b(long j) {
        AlgoHandleController algoHandleController = this.cb;
        if (algoHandleController == null || j <= 0) {
            return;
        }
        long handleType = algoHandleController.getHandleType(j);
        HandDetector handDetector = this.qu;
        if (handDetector == null || handleType != 19) {
            return;
        }
        handDetector.b(j);
    }

    @Override // com.baidu.ar.c
    public void a(long j) {
        AlgoHandleController algoHandleController;
        super.a(j);
        if (j <= 0 || (algoHandleController = this.cb) == null || algoHandleController.getHandleType(j) != 19) {
            return;
        }
        b(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        HandDetector handDetector = this.qu;
        if (handDetector != null) {
            handDetector.a((AlgoHandleController) null);
            this.qu.av();
            a(this.qu);
        }
        AlgoHandleController algoHandleController = this.cb;
        if (algoHandleController != null) {
            algoHandleController.release();
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
        HandDetector handDetector = new HandDetector();
        this.qu = handDetector;
        handDetector.a(this.cb);
        e eVar = new e() { // from class: com.baidu.ar.hand.HandAR.1
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                long de = bVar.de();
                l r = HandAR.this.r();
                if (r == null || de <= 0) {
                    return;
                }
                r.a(de, "ability_hand_skeleton");
                HandAR.this.a(de);
            }

            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.l lVar) {
                String str = HandAR.TAG;
                com.baidu.ar.h.b.c(str, "onSetup result = " + lVar.isSuccess());
                l r = HandAR.this.r();
                if (r == null || HandAR.this.qu == null) {
                    return;
                }
                r.b(lVar.dk(), HandAR.this.qu.dj());
            }

            @Override // com.baidu.ar.d.e
            public void b(com.baidu.ar.d.l lVar) {
                String str = HandAR.TAG;
                com.baidu.ar.h.b.c(str, "onRelease result = " + lVar.isSuccess());
            }
        };
        this.mv = eVar;
        a(this.qu, eVar);
        com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
        this.qu.b((Bundle) null);
    }
}
