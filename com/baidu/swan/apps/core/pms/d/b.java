package com.baidu.swan.apps.core.pms.d;

import android.util.Log;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.env.c.c;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes8.dex */
public class b extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a.InterfaceC0403a cTu;

    public b(String str, a.InterfaceC0403a interfaceC0403a) {
        super(str);
        this.cTu = interfaceC0403a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aqi() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ani() {
        super.ani();
        if (this.cSw != null) {
            aqv();
            a.mz(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.cTu != null) {
            if (aVar.errorNo == 1010) {
                this.cTu.ann();
            } else {
                this.cTu.gA(0);
            }
        }
        gS(aVar.errorNo);
        if (a.c(aVar)) {
            a.mz(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aqm() {
        super.aqm();
        this.cSx.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.al.a aqu = aqu();
        this.cSx.add(new UbcFlowEvent("na_end_update_db"));
        if (aqu == null) {
            a.mz(this.mAppId);
            if (this.cTu != null) {
                this.cTu.ann();
            }
        } else if (this.cTu != null) {
            this.cTu.gA(5);
        }
        bC("main_pre_download", this.cSy);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.ath().ati().a(hashSet, c.atM().he(7).atN());
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void m(Throwable th) {
        if (this.cTu != null) {
            this.cTu.gA(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aqn() {
        return PMSDownloadType.PRE;
    }
}
