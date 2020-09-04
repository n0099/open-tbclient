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
    private a.InterfaceC0380a cls;

    public b(String str, a.InterfaceC0380a interfaceC0380a) {
        super(str);
        this.cls = interfaceC0380a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aiv() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void afB() {
        super.afB();
        if (this.cku != null) {
            aiI();
            a.lD(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.cls != null) {
            if (aVar.errorNo == 1010) {
                this.cls.afG();
            } else {
                this.cls.gR(0);
            }
        }
        hi(aVar.errorNo);
        if (a.c(aVar)) {
            a.lD(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aiz() {
        super.aiz();
        this.ckv.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a aiH = aiH();
        this.ckv.add(new UbcFlowEvent("na_end_update_db"));
        if (aiH == null) {
            a.lD(this.mAppId);
            if (this.cls != null) {
                this.cls.afG();
            }
        } else if (this.cls != null) {
            this.cls.gR(5);
        }
        bm("main_pre_download", this.ckw);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.alr().als().a(hashSet, c.alW().hu(7).alX());
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        if (this.cls != null) {
            this.cls.gR(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aiA() {
        return PMSDownloadType.PRE;
    }
}
