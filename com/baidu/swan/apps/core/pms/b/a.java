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
    private a.InterfaceC0243a bqz;

    public a(String str, a.InterfaceC0243a interfaceC0243a) {
        super(str);
        this.bqz = interfaceC0243a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pg() {
        super.Pg();
        if (this.bqb != null) {
            Pw();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.bqz != null) {
            if (aVar.errorNo == 1010) {
                this.bqz.Nc();
            } else {
                this.bqz.eq(0);
            }
        }
        eH(aVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void Pm() {
        this.bqc.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ap.a Pv = Pv();
        this.bqc.add(new UbcFlowEvent("na_end_update_db"));
        if (Pv == null) {
            if (this.bqz != null) {
                this.bqz.Nc();
            }
        } else if (this.bqz != null) {
            this.bqz.eq(5);
        }
        aB("main_pre_download", this.bqd);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.RB().RC().c(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void m(Throwable th) {
        if (this.bqz != null) {
            this.bqz.eq(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType Pn() {
        return PMSDownloadType.PRE;
    }
}
