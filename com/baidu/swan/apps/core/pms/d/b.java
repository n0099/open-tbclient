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
    private a.InterfaceC0406a cXh;

    public b(String str, a.InterfaceC0406a interfaceC0406a) {
        super(str);
        this.cXh = interfaceC0406a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aqJ() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void anJ() {
        super.anJ();
        if (this.cWj != null) {
            aqW();
            a.mY(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.cXh != null) {
            if (aVar.errorNo == 1010) {
                this.cXh.anO();
            } else {
                this.cXh.gE(0);
            }
        }
        gW(aVar.errorNo);
        if (a.c(aVar)) {
            a.mY(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aqN() {
        super.aqN();
        this.cWk.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.al.a aqV = aqV();
        this.cWk.add(new UbcFlowEvent("na_end_update_db"));
        if (aqV == null) {
            a.mY(this.mAppId);
            if (this.cXh != null) {
                this.cXh.anO();
            }
        } else if (this.cXh != null) {
            this.cXh.gE(5);
        }
        bw("main_pre_download", this.cWl);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.atI().atJ().a(hashSet, c.aun().hi(7).auo());
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void l(Throwable th) {
        if (this.cXh != null) {
            this.cXh.gE(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aqO() {
        return PMSDownloadType.PRE;
    }
}
