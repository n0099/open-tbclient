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
    private a pc;
    private String bx = "ability_head_segmentation";
    private AlgoHandleController bU = null;
    private e pd = new e() { // from class: com.baidu.ar.headseg.HeadSegAR.1
        @Override // com.baidu.ar.c.e
        public void a(com.baidu.ar.c.b bVar) {
            long cn = bVar.cn();
            j r = HeadSegAR.this.r();
            if (r == null || cn <= 0 || HeadSegAR.this.bU == null) {
                return;
            }
            HeadSegAR.this.bU.sendHandleToRenderer(cn, r, "ability_head_segmentation");
        }

        @Override // com.baidu.ar.c.e
        public void a(l lVar) {
        }

        @Override // com.baidu.ar.c.e
        public void b(l lVar) {
        }
    };
    private e pe = new e() { // from class: com.baidu.ar.headseg.HeadSegAR.2
        @Override // com.baidu.ar.c.e
        public void a(com.baidu.ar.c.b bVar) {
            long cn = bVar.cn();
            if (HeadSegAR.this.bU == null) {
                ARMdlInterfaceJNI.updateLastFaceInfo(0L);
            } else if (HeadSegAR.this.bU.getHandleType(cn) == 10) {
                ARMdlInterfaceJNI.updateLastFaceInfo(cn);
            }
            AlgoHandleAdapter.destroyHandle(cn);
        }

        @Override // com.baidu.ar.c.e
        public void a(l lVar) {
        }

        @Override // com.baidu.ar.c.e
        public void b(l lVar) {
        }
    };

    private void b(long j) {
        if (this.bU == null || j <= 0) {
            return;
        }
        long handleType = this.bU.getHandleType(j);
        if (this.pc == null || handleType != 22) {
            return;
        }
        this.pc.b(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.bU == null || this.bU.getHandleType(j) != 22) {
            return;
        }
        b(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(false);
        if (this.pc != null) {
            this.pc.a((AlgoHandleController) null);
            this.pc.ai();
            a(this.pc);
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
        this.pc = new a();
        this.pc.a(this.bU);
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("ability_name", this.bx);
        a("FaceDetector", this.pe, hashMap2);
        b(true);
        a(this.pc, this.pd);
        com.baidu.ar.b.a.ac().a(getContext(), getMdlConfigs());
        this.pc.c((Bundle) null);
    }
}
