package com.baidu.swan.apps.core.pms.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes11.dex */
public class a extends f {
    private static final boolean DEBUG = b.DEBUG;
    private a.InterfaceC0243a bqN;

    public a(String str, a.InterfaceC0243a interfaceC0243a) {
        super(str);
        this.bqN = interfaceC0243a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pl() {
        super.Pl();
        if (this.bqp != null) {
            PB();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.bqN != null) {
            if (aVar.errorNo == 1010) {
                this.bqN.Nh();
            } else {
                this.bqN.eq(0);
            }
        }
        eH(aVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void Pr() {
        this.bqq.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ap.a PA = PA();
        this.bqq.add(new UbcFlowEvent("na_end_update_db"));
        if (PA == null) {
            if (this.bqN != null) {
                this.bqN.Nh();
            }
        } else if (this.bqN != null) {
            this.bqN.eq(5);
        }
        aA("main_pre_download", this.bqr);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.RG().RH().c(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void m(Throwable th) {
        if (this.bqN != null) {
            this.bqN.eq(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType Ps() {
        return PMSDownloadType.PRE;
    }
}
