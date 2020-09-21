package com.baidu.swan.apps.core.pms.d;

import android.util.Log;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.env.c.c;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes3.dex */
public class b extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a.InterfaceC0375a cnv;

    public b(String str, a.InterfaceC0375a interfaceC0375a) {
        super(str);
        this.cnv = interfaceC0375a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int ajf() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void agl() {
        super.agl();
        if (this.cmw != null) {
            ajs();
            a.lW(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.cnv != null) {
            if (aVar.errorNo == 1010) {
                this.cnv.agq();
            } else {
                this.cnv.ha(0);
            }
        }
        hr(aVar.errorNo);
        if (a.c(aVar)) {
            a.lW(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void ajj() {
        super.ajj();
        this.cmx.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a ajr = ajr();
        this.cmx.add(new UbcFlowEvent("na_end_update_db"));
        if (ajr == null) {
            a.lW(this.mAppId);
            if (this.cnv != null) {
                this.cnv.agq();
            }
        } else if (this.cnv != null) {
            this.cnv.ha(5);
        }
        bm("main_pre_download", this.cmy);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.amb().amc().a(hashSet, c.amG().hD(7).amH());
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        if (this.cnv != null) {
            this.cnv.ha(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType ajk() {
        return PMSDownloadType.PRE;
    }
}
