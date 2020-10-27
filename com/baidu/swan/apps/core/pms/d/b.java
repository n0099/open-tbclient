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
    private a.InterfaceC0406a cIh;

    public b(String str, a.InterfaceC0406a interfaceC0406a) {
        super(str);
        this.cIh = interfaceC0406a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int anK() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void akQ() {
        super.akQ();
        if (this.cHj != null) {
            anX();
            a.nb(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.cIh != null) {
            if (aVar.errorNo == 1010) {
                this.cIh.akV();
            } else {
                this.cIh.hI(0);
            }
        }
        hZ(aVar.errorNo);
        if (a.c(aVar)) {
            a.nb(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void anO() {
        super.anO();
        this.cHk.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a anW = anW();
        this.cHk.add(new UbcFlowEvent("na_end_update_db"));
        if (anW == null) {
            a.nb(this.mAppId);
            if (this.cIh != null) {
                this.cIh.akV();
            }
        } else if (this.cIh != null) {
            this.cIh.hI(5);
        }
        by("main_pre_download", this.cHl);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.aqH().aqI().a(hashSet, c.arm().il(7).arn());
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        if (this.cIh != null) {
            this.cIh.hI(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType anP() {
        return PMSDownloadType.PRE;
    }
}
