package com.baidu.swan.apps.core.pms.d;

import android.util.Log;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.env.c.c;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes10.dex */
public class b extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a.InterfaceC0392a czL;

    public b(String str, a.InterfaceC0392a interfaceC0392a) {
        super(str);
        this.czL = interfaceC0392a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int alQ() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiW() {
        super.aiW();
        if (this.cyN != null) {
            amd();
            a.mI(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.czL != null) {
            if (aVar.errorNo == 1010) {
                this.czL.ajb();
            } else {
                this.czL.hx(0);
            }
        }
        hO(aVar.errorNo);
        if (a.c(aVar)) {
            a.mI(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void alU() {
        super.alU();
        this.cyO.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a amc = amc();
        this.cyO.add(new UbcFlowEvent("na_end_update_db"));
        if (amc == null) {
            a.mI(this.mAppId);
            if (this.czL != null) {
                this.czL.ajb();
            }
        } else if (this.czL != null) {
            this.czL.hx(5);
        }
        br("main_pre_download", this.cyP);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.aoM().aoN().a(hashSet, c.aps().ia(7).apt());
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        if (this.czL != null) {
            this.czL.hx(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType alV() {
        return PMSDownloadType.PRE;
    }
}
