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
    private a.InterfaceC0418a cOa;

    public b(String str, a.InterfaceC0418a interfaceC0418a) {
        super(str);
        this.cOa = interfaceC0418a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aql() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void anq() {
        super.anq();
        if (this.cNc != null) {
            aqy();
            a.nq(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.cOa != null) {
            if (aVar.errorNo == 1010) {
                this.cOa.anv();
            } else {
                this.cOa.hS(0);
            }
        }
        ij(aVar.errorNo);
        if (a.c(aVar)) {
            a.nq(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aqp() {
        super.aqp();
        this.cNd.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a aqx = aqx();
        this.cNd.add(new UbcFlowEvent("na_end_update_db"));
        if (aqx == null) {
            a.nq(this.mAppId);
            if (this.cOa != null) {
                this.cOa.anv();
            }
        } else if (this.cOa != null) {
            this.cOa.hS(5);
        }
        by("main_pre_download", this.cNe);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.ati().atj().a(hashSet, c.atN().iv(7).atO());
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        if (this.cOa != null) {
            this.cOa.hS(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aqq() {
        return PMSDownloadType.PRE;
    }
}
