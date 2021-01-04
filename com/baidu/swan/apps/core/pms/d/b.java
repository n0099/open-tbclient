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
    private a.InterfaceC0420a cYg;

    public b(String str, a.InterfaceC0420a interfaceC0420a) {
        super(str);
        this.cYg = interfaceC0420a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int auc() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void arc() {
        super.arc();
        if (this.cXi != null) {
            aup();
            a.nK(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.cYg != null) {
            if (aVar.errorNo == 1010) {
                this.cYg.arh();
            } else {
                this.cYg.ig(0);
            }
        }
        iy(aVar.errorNo);
        if (a.c(aVar)) {
            a.nK(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aug() {
        super.aug();
        this.cXj.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.al.a auo = auo();
        this.cXj.add(new UbcFlowEvent("na_end_update_db"));
        if (auo == null) {
            a.nK(this.mAppId);
            if (this.cYg != null) {
                this.cYg.arh();
            }
        } else if (this.cYg != null) {
            this.cYg.ig(5);
        }
        bD("main_pre_download", this.cXk);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.axa().axb().a(hashSet, c.axF().iK(7).axG());
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void m(Throwable th) {
        if (this.cYg != null) {
            this.cYg.ig(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType auh() {
        return PMSDownloadType.PRE;
    }
}
