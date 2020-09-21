package com.baidu.ar.headseg;

import android.os.Bundle;
import com.baidu.ar.arrender.k;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class HeadSegAR extends c {
    private static final String TAG = HeadSegAR.class.getSimpleName();
    private HeadSegDetector qi;
    private String bA = "ability_head_segmentation";
    private AlgoHandleController bY = null;
    private e qj = new e() { // from class: com.baidu.ar.headseg.HeadSegAR.1
        @Override // com.baidu.ar.d.e
        public void a(b bVar) {
            long df = bVar.df();
            k r = HeadSegAR.this.r();
            if (r == null || df <= 0 || HeadSegAR.this.bY == null) {
                return;
            }
            HeadSegAR.this.bY.sendHandleToRenderer(df, r, "ability_head_segmentation");
            HeadSegAR.this.a(df);
        }

        @Override // com.baidu.ar.d.e
        public void a(l lVar) {
            k r = HeadSegAR.this.r();
            if (r == null || HeadSegAR.this.qi == null || lVar == null) {
                return;
            }
            r.b(lVar.dl(), HeadSegAR.this.qi.dk());
        }

        @Override // com.baidu.ar.d.e
        public void b(l lVar) {
        }
    };
    private e lp = new e() { // from class: com.baidu.ar.headseg.HeadSegAR.2
        @Override // com.baidu.ar.d.e
        public void a(b bVar) {
            long df = bVar.df();
            if (HeadSegAR.this.bY == null) {
                ARMdlInterfaceJNI.updateLastFaceInfo(0L);
            } else if (HeadSegAR.this.bY.getHandleType(df) == 10) {
                ARMdlInterfaceJNI.updateLastFaceInfo(df);
            }
            AlgoHandleAdapter.destroyHandle(df);
        }

        @Override // com.baidu.ar.d.e
        public void a(l lVar) {
        }

        @Override // com.baidu.ar.d.e
        public void b(l lVar) {
        }
    };

    private void b(long j) {
        if (this.bY == null || j <= 0) {
            return;
        }
        long handleType = this.bY.getHandleType(j);
        if (this.qi == null || handleType != 22) {
            return;
        }
        this.qi.b(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.bY == null || this.bY.getHandleType(j) != 22) {
            return;
        }
        b(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(false);
        if (this.qi != null) {
            this.qi.a((AlgoHandleController) null);
            this.qi.au();
            a(this.qi);
        }
        if (this.bY != null) {
            this.bY.release();
            this.bY = null;
        }
        k r = r();
        if (r != null) {
            r.o(22);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        if (this.bY == null) {
            this.bY = new AlgoHandleController();
        }
        this.qi = new HeadSegDetector();
        this.qi.a(this.bY);
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("ability_name", this.bA);
        a("FaceDetector", this.lp, hashMap2);
        b(true);
        a(this.qi, this.qj);
        com.baidu.ar.b.a.ar().a(getContext(), getMdlConfigs());
        this.qi.b((Bundle) null);
    }
}
