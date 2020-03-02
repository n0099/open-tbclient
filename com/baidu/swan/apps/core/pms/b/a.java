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
    private a.InterfaceC0243a bqA;

    public a(String str, a.InterfaceC0243a interfaceC0243a) {
        super(str);
        this.bqA = interfaceC0243a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pi() {
        super.Pi();
        if (this.bqc != null) {
            Py();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.bqA != null) {
            if (aVar.errorNo == 1010) {
                this.bqA.Ne();
            } else {
                this.bqA.eq(0);
            }
        }
        eH(aVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void Po() {
        this.bqd.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ap.a Px = Px();
        this.bqd.add(new UbcFlowEvent("na_end_update_db"));
        if (Px == null) {
            if (this.bqA != null) {
                this.bqA.Ne();
            }
        } else if (this.bqA != null) {
            this.bqA.eq(5);
        }
        aB("main_pre_download", this.bqe);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.RD().RE().c(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void m(Throwable th) {
        if (this.bqA != null) {
            this.bqA.eq(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType Pp() {
        return PMSDownloadType.PRE;
    }
}
