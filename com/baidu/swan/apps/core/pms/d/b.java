package com.baidu.swan.apps.core.pms.d;

import android.util.Log;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes11.dex */
public class b extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a.InterfaceC0337a cdr;

    public b(String str, a.InterfaceC0337a interfaceC0337a) {
        super(str);
        this.cdr = interfaceC0337a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaR() {
        super.aaR();
        if (this.ccw != null) {
            abh();
            a.jG(this.mAppId);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.cdr != null) {
            if (aVar.errorNo == 1010) {
                this.cdr.YF();
            } else {
                this.cdr.eR(0);
            }
        }
        fi(aVar.errorNo);
        if (a.c(aVar)) {
            a.jG(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aaX() {
        super.aaX();
        this.ccx.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.an.a abg = abg();
        this.ccx.add(new UbcFlowEvent("na_end_update_db"));
        if (abg == null) {
            a.jG(this.mAppId);
            if (this.cdr != null) {
                this.cdr.YF();
            }
        } else if (this.cdr != null) {
            this.cdr.eR(5);
        }
        bc("main_pre_download", this.ccy);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.adB().adC().d(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void p(Throwable th) {
        if (this.cdr != null) {
            this.cdr.eR(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aaY() {
        return PMSDownloadType.PRE;
    }
}
