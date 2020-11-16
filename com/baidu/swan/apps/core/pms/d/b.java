package com.baidu.swan.apps.core.pms.d;

import android.util.Log;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.env.c.c;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes7.dex */
public class b extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a.InterfaceC0416a cMq;

    public b(String str, a.InterfaceC0416a interfaceC0416a) {
        super(str);
        this.cMq = interfaceC0416a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int apD() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void amI() {
        super.amI();
        if (this.cLs != null) {
            apQ();
            a.nk(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.cMq != null) {
            if (aVar.errorNo == 1010) {
                this.cMq.amN();
            } else {
                this.cMq.hO(0);
            }
        }
        m33if(aVar.errorNo);
        if (a.c(aVar)) {
            a.nk(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void apH() {
        super.apH();
        this.cLt.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a apP = apP();
        this.cLt.add(new UbcFlowEvent("na_end_update_db"));
        if (apP == null) {
            a.nk(this.mAppId);
            if (this.cMq != null) {
                this.cMq.amN();
            }
        } else if (this.cMq != null) {
            this.cMq.hO(5);
        }
        bx("main_pre_download", this.cLu);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.asA().asB().a(hashSet, c.atf().ir(7).atg());
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        if (this.cMq != null) {
            this.cMq.hO(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType apI() {
        return PMSDownloadType.PRE;
    }
}
