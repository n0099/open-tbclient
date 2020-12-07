package com.baidu.swan.apps.core.pms.d;

import android.util.Log;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.env.c.c;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes25.dex */
public class b extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a.InterfaceC0428a cTj;

    public b(String str, a.InterfaceC0428a interfaceC0428a) {
        super(str);
        this.cTj = interfaceC0428a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int asL() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void apQ() {
        super.apQ();
        if (this.cSl != null) {
            asY();
            a.nR(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.cTj != null) {
            if (aVar.errorNo == 1010) {
                this.cTj.apV();
            } else {
                this.cTj.im(0);
            }
        }
        iD(aVar.errorNo);
        if (a.c(aVar)) {
            a.nR(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void asP() {
        super.asP();
        this.cSm.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a asX = asX();
        this.cSm.add(new UbcFlowEvent("na_end_update_db"));
        if (asX == null) {
            a.nR(this.mAppId);
            if (this.cTj != null) {
                this.cTj.apV();
            }
        } else if (this.cTj != null) {
            this.cTj.im(5);
        }
        bE("main_pre_download", this.cSn);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.avI().avJ().a(hashSet, c.awn().iP(7).awo());
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        if (this.cTj != null) {
            this.cTj.im(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType asQ() {
        return PMSDownloadType.PRE;
    }
}
