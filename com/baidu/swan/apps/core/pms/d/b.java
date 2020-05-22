package com.baidu.swan.apps.core.pms.d;

import android.util.Log;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes11.dex */
public class b extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a.InterfaceC0331a bYB;

    public b(String str, a.InterfaceC0331a interfaceC0331a) {
        super(str);
        this.bYB = interfaceC0331a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZL() {
        super.ZL();
        if (this.bXH != null) {
            aab();
            a.jy(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.bYB != null) {
            if (aVar.errorNo == 1010) {
                this.bYB.Xz();
            } else {
                this.bYB.eE(0);
            }
        }
        eV(aVar.errorNo);
        if (a.c(aVar)) {
            a.jy(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void ZR() {
        super.ZR();
        this.bXI.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.an.a aaa = aaa();
        this.bXI.add(new UbcFlowEvent("na_end_update_db"));
        if (aaa == null) {
            a.jy(this.mAppId);
            if (this.bYB != null) {
                this.bYB.Xz();
            }
        } else if (this.bYB != null) {
            this.bYB.eE(5);
        }
        ba("main_pre_download", this.bXJ);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.acv().acw().d(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void p(Throwable th) {
        if (this.bYB != null) {
            this.bYB.eE(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType ZS() {
        return PMSDownloadType.PRE;
    }
}
