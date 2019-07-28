package com.baidu.swan.apps.core.pms.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.a.b.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.d;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class a extends d {
    private static final boolean DEBUG = b.DEBUG;
    private a.InterfaceC0132a aqd;

    public a(String str, a.InterfaceC0132a interfaceC0132a) {
        super(str);
        this.aqd = interfaceC0132a;
    }

    @Override // com.baidu.swan.pms.a.f
    public void Bj() {
        super.Bj();
        if (this.asX != null) {
            Bv();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.aqd != null) {
            this.aqd.bZ(0);
        }
        cq(aVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void Bk() {
        this.apK.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a Bu = Bu();
        this.apK.add(new UbcFlowEvent("na_end_update_db"));
        if (Bu == null) {
            if (this.aqd != null) {
                this.aqd.zl();
            }
        } else if (this.aqd != null) {
            this.aqd.bZ(5);
        }
        aa("main_pre_download", this.apZ);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        com.baidu.swan.apps.env.d.CP().CR().c(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        if (this.aqd != null) {
            this.aqd.bZ(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType Bl() {
        return PMSDownloadType.PRE;
    }
}
