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
    private AlgoHandleController bU = null;
    private e lb;
    private a oY;

    private void b(long j) {
        if (this.bU == null || j <= 0) {
            return;
        }
        long handleType = this.bU.getHandleType(j);
        if (this.oY == null || handleType != 19) {
            return;
        }
        this.oY.b(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.bU == null || this.bU.getHandleType(j) != 19) {
            return;
        }
        b(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        if (this.oY != null) {
            this.oY.a((AlgoHandleController) null);
            this.oY.ai();
            a(this.oY);
        }
        if (this.bU != null) {
            this.bU.release();
            this.bU = null;
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        if (this.bU == null) {
            this.bU = new AlgoHandleController();
        }
        this.oY = new a();
        this.oY.a(this.bU);
        this.lb = new e() { // from class: com.baidu.ar.hand.HandAR.1
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                long cn = bVar.cn();
                j r = HandAR.this.r();
                if (r == null || cn <= 0) {
                    return;
                }
                r.a(cn, "ability_hand_skeleton");
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        };
        a(this.oY, this.lb);
        com.baidu.ar.b.a.ac().a(getContext(), getMdlConfigs());
        this.oY.c((Bundle) null);
    }
}
