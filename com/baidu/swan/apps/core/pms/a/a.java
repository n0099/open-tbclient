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
    private a.InterfaceC0173a aJR;

    public a(String str, a.InterfaceC0173a interfaceC0173a) {
        super(str);
        this.aJR = interfaceC0173a;
    }

    @Override // com.baidu.swan.pms.a.f
    public void Gi() {
        super.Gi();
        if (this.aMM != null) {
            Gu();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.aJR != null) {
            this.aJR.cW(0);
        }
        dn(aVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void Gj() {
        this.aJy.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a Gt = Gt();
        this.aJy.add(new UbcFlowEvent("na_end_update_db"));
        if (Gt == null) {
            if (this.aJR != null) {
                this.aJR.Ek();
            }
        } else if (this.aJR != null) {
            this.aJR.cW(5);
        }
        ai("main_pre_download", this.aJN);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        com.baidu.swan.apps.env.d.HN().HP().c(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        if (this.aJR != null) {
            this.aJR.cW(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType Gk() {
        return PMSDownloadType.PRE;
    }
}
