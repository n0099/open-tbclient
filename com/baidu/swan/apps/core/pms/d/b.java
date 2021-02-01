package com.baidu.swan.apps.core.pms.d;

import android.util.Log;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.env.c.c;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes9.dex */
public class b extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a.InterfaceC0400a cVH;

    public b(String str, a.InterfaceC0400a interfaceC0400a) {
        super(str);
        this.cVH = interfaceC0400a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aqG() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void anG() {
        super.anG();
        if (this.cUJ != null) {
            aqT();
            a.mR(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.cVH != null) {
            if (aVar.errorNo == 1010) {
                this.cVH.anL();
            } else {
                this.cVH.gD(0);
            }
        }
        gV(aVar.errorNo);
        if (a.c(aVar)) {
            a.mR(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aqK() {
        super.aqK();
        this.cUK.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.al.a aqS = aqS();
        this.cUK.add(new UbcFlowEvent("na_end_update_db"));
        if (aqS == null) {
            a.mR(this.mAppId);
            if (this.cVH != null) {
                this.cVH.anL();
            }
        } else if (this.cVH != null) {
            this.cVH.gD(5);
        }
        bw("main_pre_download", this.cUL);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.atF().atG().a(hashSet, c.auk().hh(7).aul());
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void l(Throwable th) {
        if (this.cVH != null) {
            this.cVH.gD(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aqL() {
        return PMSDownloadType.PRE;
    }
}
