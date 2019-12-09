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
    private a.InterfaceC0168a aJz;

    public a(String str, a.InterfaceC0168a interfaceC0168a) {
        super(str);
        this.aJz = interfaceC0168a;
    }

    @Override // com.baidu.swan.pms.a.f
    public void Gj() {
        super.Gj();
        if (this.aMu != null) {
            Gv();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.aJz != null) {
            this.aJz.cW(0);
        }
        dn(aVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void Gk() {
        this.aJg.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a Gu = Gu();
        this.aJg.add(new UbcFlowEvent("na_end_update_db"));
        if (Gu == null) {
            if (this.aJz != null) {
                this.aJz.El();
            }
        } else if (this.aJz != null) {
            this.aJz.cW(5);
        }
        ai("main_pre_download", this.aJv);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        com.baidu.swan.apps.env.d.HO().HQ().c(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        if (this.aJz != null) {
            this.aJz.cW(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType Gl() {
        return PMSDownloadType.PRE;
    }
}
