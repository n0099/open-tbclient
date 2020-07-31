package com.baidu.swan.apps.core.pms.d;

import android.util.Log;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.env.b.c;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes7.dex */
public class b extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a.InterfaceC0339a ceW;

    public b(String str, a.InterfaceC0339a interfaceC0339a) {
        super(str);
        this.ceW = interfaceC0339a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int abW() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Zs() {
        super.Zs();
        if (this.cea != null) {
            acj();
            a.jY(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.ceW != null) {
            if (aVar.errorNo == 1010) {
                this.ceW.Zx();
            } else {
                this.ceW.eV(0);
            }
        }
        fm(aVar.errorNo);
        if (a.c(aVar)) {
            a.jY(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aca() {
        super.aca();
        this.ceb.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.an.a aci = aci();
        this.ceb.add(new UbcFlowEvent("na_end_update_db"));
        if (aci == null) {
            a.jY(this.mAppId);
            if (this.ceW != null) {
                this.ceW.Zx();
            }
        } else if (this.ceW != null) {
            this.ceW.eV(5);
        }
        be("main_pre_download", this.cec);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.aeI().aeJ().a(hashSet, c.aeQ().fx(7).aeR());
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void p(Throwable th) {
        if (this.ceW != null) {
            this.ceW.eV(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType acb() {
        return PMSDownloadType.PRE;
    }
}
