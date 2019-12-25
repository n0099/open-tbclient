package com.baidu.swan.apps.core.pms.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes9.dex */
public class a extends f {
    private static final boolean DEBUG = b.DEBUG;
    private a.InterfaceC0231a blA;

    public a(String str, a.InterfaceC0231a interfaceC0231a) {
        super(str);
        this.blA = interfaceC0231a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Mw() {
        super.Mw();
        if (this.blc != null) {
            MM();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.blA != null) {
            if (aVar.errorNo == 1010) {
                this.blA.Kr();
            } else {
                this.blA.dZ(0);
            }
        }
        eq(aVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void MC() {
        this.bld.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ap.a ML = ML();
        this.bld.add(new UbcFlowEvent("na_end_update_db"));
        if (ML == null) {
            if (this.blA != null) {
                this.blA.Kr();
            }
        } else if (this.blA != null) {
            this.blA.dZ(5);
        }
        aq("main_pre_download", this.ble);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.OR().OS().c(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void n(Throwable th) {
        if (this.blA != null) {
            this.blA.dZ(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType MD() {
        return PMSDownloadType.PRE;
    }
}
