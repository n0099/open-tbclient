package com.baidu.ar.headseg;

import android.os.Bundle;
import com.baidu.ar.arrender.l;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import java.util.HashMap;
/* loaded from: classes.dex */
public class HeadSegAR extends c {
    public static final String TAG = "HeadSegAR";
    public HeadSegDetector qy;
    public String bD = "ability_head_segmentation";
    public AlgoHandleController cb = null;
    public e qz = new e() { // from class: com.baidu.ar.headseg.HeadSegAR.1
        @Override // com.baidu.ar.d.e
        public void a(b bVar) {
            long de = bVar.de();
            l r = HeadSegAR.this.r();
            if (r == null || de <= 0 || HeadSegAR.this.cb == null) {
                return;
            }
            HeadSegAR.this.cb.sendHandleToRenderer(de, r, "ability_head_segmentation");
            HeadSegAR.this.a(de);
        }

        @Override // com.baidu.ar.d.e
        public void a(com.baidu.ar.d.l lVar) {
            l r = HeadSegAR.this.r();
            if (r == null || HeadSegAR.this.qy == null || lVar == null) {
                return;
            }
            r.b(lVar.dk(), HeadSegAR.this.qy.dj());
        }

        @Override // com.baidu.ar.d.e
        public void b(com.baidu.ar.d.l lVar) {
        }
    };
    public e lE = new e() { // from class: com.baidu.ar.headseg.HeadSegAR.2
        @Override // com.baidu.ar.d.e
        public void a(b bVar) {
            long de = bVar.de();
            if (HeadSegAR.this.cb == null) {
                ARMdlInterfaceJNI.updateLastFaceInfo(0L);
            } else if (HeadSegAR.this.cb.getHandleType(de) == 10) {
                ARMdlInterfaceJNI.updateLastFaceInfo(de);
            }
            AlgoHandleAdapter.destroyHandle(de);
        }

        @Override // com.baidu.ar.d.e
        public void a(com.baidu.ar.d.l lVar) {
        }

        @Override // com.baidu.ar.d.e
        public void b(com.baidu.ar.d.l lVar) {
        }
    };

    private void b(long j) {
        AlgoHandleController algoHandleController = this.cb;
        if (algoHandleController == null || j <= 0) {
            return;
        }
        long handleType = algoHandleController.getHandleType(j);
        HeadSegDetector headSegDetector = this.qy;
        if (headSegDetector == null || handleType != 22) {
            return;
        }
        headSegDetector.b(j);
    }

    @Override // com.baidu.ar.c
    public void a(long j) {
        AlgoHandleController algoHandleController;
        super.a(j);
        if (j <= 0 || (algoHandleController = this.cb) == null || algoHandleController.getHandleType(j) != 22) {
            return;
        }
        b(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(false);
        HeadSegDetector headSegDetector = this.qy;
        if (headSegDetector != null) {
            headSegDetector.a((AlgoHandleController) null);
            this.qy.av();
            a(this.qy);
        }
        AlgoHandleController algoHandleController = this.cb;
        if (algoHandleController != null) {
            algoHandleController.release();
            this.cb = null;
        }
        l r = r();
        if (r != null) {
            r.q(22);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        if (this.cb == null) {
            this.cb = new AlgoHandleController();
        }
        HeadSegDetector headSegDetector = new HeadSegDetector();
        this.qy = headSegDetector;
        headSegDetector.a(this.cb);
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("ability_name", this.bD);
        a("FaceDetector", this.lE, hashMap2);
        b(true);
        a(this.qy, this.qz);
        com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
        this.qy.b((Bundle) null);
    }
}
