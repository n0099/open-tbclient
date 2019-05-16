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
    private a.InterfaceC0130a apA;

    public a(String str, a.InterfaceC0130a interfaceC0130a) {
        super(str);
        this.apA = interfaceC0130a;
    }

    @Override // com.baidu.swan.pms.a.f
    public void AB() {
        super.AB();
        if (this.asu != null) {
            AN();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.apA != null) {
            this.apA.bZ(0);
        }
        cq(aVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void AC() {
        this.apg.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a AM = AM();
        this.apg.add(new UbcFlowEvent("na_end_update_db"));
        if (AM == null) {
            if (this.apA != null) {
                this.apA.yF();
            }
        } else if (this.apA != null) {
            this.apA.bZ(5);
        }
        aa("main_pre_download", this.apw);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        com.baidu.swan.apps.env.d.Cg().Ci().c(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        if (this.apA != null) {
            this.apA.bZ(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType AD() {
        return PMSDownloadType.PRE;
    }
}
