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
/* loaded from: classes10.dex */
public class HeadSegAR extends c {
    private static final String TAG = HeadSegAR.class.getSimpleName();
    private HeadSegDetector qy;
    private String bD = "ability_head_segmentation";
    private AlgoHandleController cb = null;
    private e qz = new e() { // from class: com.baidu.ar.headseg.HeadSegAR.1
        @Override // com.baidu.ar.d.e
        public void a(b bVar) {
            long de2 = bVar.de();
            l r = HeadSegAR.this.r();
            if (r == null || de2 <= 0 || HeadSegAR.this.cb == null) {
                return;
            }
            HeadSegAR.this.cb.sendHandleToRenderer(de2, r, "ability_head_segmentation");
            HeadSegAR.this.a(de2);
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
    private e lE = new e() { // from class: com.baidu.ar.headseg.HeadSegAR.2
        @Override // com.baidu.ar.d.e
        public void a(b bVar) {
            long de2 = bVar.de();
            if (HeadSegAR.this.cb == null) {
                ARMdlInterfaceJNI.updateLastFaceInfo(0L);
            } else if (HeadSegAR.this.cb.getHandleType(de2) == 10) {
                ARMdlInterfaceJNI.updateLastFaceInfo(de2);
            }
            AlgoHandleAdapter.destroyHandle(de2);
        }

        @Override // com.baidu.ar.d.e
        public void a(com.baidu.ar.d.l lVar) {
        }

        @Override // com.baidu.ar.d.e
        public void b(com.baidu.ar.d.l lVar) {
        }
    };

    private void b(long j) {
        if (this.cb == null || j <= 0) {
            return;
        }
        long handleType = this.cb.getHandleType(j);
        if (this.qy == null || handleType != 22) {
            return;
        }
        this.qy.b(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.cb == null || this.cb.getHandleType(j) != 22) {
            return;
        }
        b(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(false);
        if (this.qy != null) {
            this.qy.a((AlgoHandleController) null);
            this.qy.av();
            a(this.qy);
        }
        if (this.cb != null) {
            this.cb.release();
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
        this.qy = new HeadSegDetector();
        this.qy.a(this.cb);
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("ability_name", this.bD);
        a("FaceDetector", this.lE, hashMap2);
        b(true);
        a(this.qy, this.qz);
        com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
        this.qy.b((Bundle) null);
    }
}
