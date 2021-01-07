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
    protected int aud() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ard() {
        super.ard();
        if (this.cXi != null) {
            auq();
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
                this.cYg.ari();
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
    public void auh() {
        super.auh();
        this.cXj.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.al.a aup = aup();
        this.cXj.add(new UbcFlowEvent("na_end_update_db"));
        if (aup == null) {
            a.nK(this.mAppId);
            if (this.cYg != null) {
                this.cYg.ari();
            }
        } else if (this.cYg != null) {
            this.cYg.ig(5);
        }
        bD("main_pre_download", this.cXk);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.axb().axc().a(hashSet, c.axG().iK(7).axH());
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void m(Throwable th) {
        if (this.cYg != null) {
            this.cYg.ig(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aui() {
        return PMSDownloadType.PRE;
    }
}
