package com.baidu.ar.headseg;

import android.os.Bundle;
import com.baidu.ar.arrender.j;
import com.baidu.ar.c;
import com.baidu.ar.c.e;
import com.baidu.ar.c.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class HeadSegAR extends c {
    private static final String TAG = HeadSegAR.class.getSimpleName();
    private a pC;
    private String bJ = "ability_head_segmentation";
    private AlgoHandleController ch = null;
    private e pD = new e() { // from class: com.baidu.ar.headseg.HeadSegAR.1
        @Override // com.baidu.ar.c.e
        public void a(com.baidu.ar.c.b bVar) {
            long cF = bVar.cF();
            j r = HeadSegAR.this.r();
            if (r == null || cF <= 0 || HeadSegAR.this.ch == null) {
                return;
            }
            HeadSegAR.this.ch.sendHandleToRenderer(cF, r, "ability_head_segmentation");
            HeadSegAR.this.a(cF);
        }

        @Override // com.baidu.ar.c.e
        public void a(l lVar) {
            j r = HeadSegAR.this.r();
            if (r == null || HeadSegAR.this.pC == null || lVar == null) {
                return;
            }
            r.a(lVar.cL(), HeadSegAR.this.pC.cK());
        }

        @Override // com.baidu.ar.c.e
        public void b(l lVar) {
        }
    };
    private e kG = new e() { // from class: com.baidu.ar.headseg.HeadSegAR.2
        @Override // com.baidu.ar.c.e
        public void a(com.baidu.ar.c.b bVar) {
            long cF = bVar.cF();
            if (HeadSegAR.this.ch == null) {
                ARMdlInterfaceJNI.updateLastFaceInfo(0L);
            } else if (HeadSegAR.this.ch.getHandleType(cF) == 10) {
                ARMdlInterfaceJNI.updateLastFaceInfo(cF);
            }
            AlgoHandleAdapter.destroyHandle(cF);
        }

        @Override // com.baidu.ar.c.e
        public void a(l lVar) {
        }

        @Override // com.baidu.ar.c.e
        public void b(l lVar) {
        }
    };

    private void b(long j) {
        if (this.ch == null || j <= 0) {
            return;
        }
        long handleType = this.ch.getHandleType(j);
        if (this.pC == null || handleType != 22) {
            return;
        }
        this.pC.b(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.ch == null || this.ch.getHandleType(j) != 22) {
            return;
        }
        b(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(false);
        if (this.pC != null) {
            this.pC.a((AlgoHandleController) null);
            this.pC.aw();
            a(this.pC);
        }
        if (this.ch != null) {
            this.ch.release();
            this.ch = null;
        }
        j r = r();
        if (r != null) {
            r.r(22);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        if (this.ch == null) {
            this.ch = new AlgoHandleController();
        }
        this.pC = new a();
        this.pC.a(this.ch);
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("ability_name", this.bJ);
        a("FaceDetector", this.kG, hashMap2);
        b(true);
        a(this.pC, this.pD);
        com.baidu.ar.b.a.aq().a(getContext(), getMdlConfigs());
        this.pC.c((Bundle) null);
    }
}
