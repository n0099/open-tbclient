package com.baidu.swan.apps.core.pms.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes11.dex */
public class a extends f {
    private static final boolean DEBUG = b.DEBUG;
    private a.InterfaceC0273a bOU;

    public a(String str, a.InterfaceC0273a interfaceC0273a) {
        super(str);
        this.bOU = interfaceC0273a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xa() {
        super.Xa();
        if (this.bOw != null) {
            Xq();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.bOU != null) {
            if (aVar.errorNo == 1010) {
                this.bOU.UU();
            } else {
                this.bOU.ev(0);
            }
        }
        eM(aVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void Xg() {
        this.bOx.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ap.a Xp = Xp();
        this.bOx.add(new UbcFlowEvent("na_end_update_db"));
        if (Xp == null) {
            if (this.bOU != null) {
                this.bOU.UU();
            }
        } else if (this.bOU != null) {
            this.bOU.ev(5);
        }
        aJ("main_pre_download", this.bOy);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.Zv().Zw().d(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        if (this.bOU != null) {
            this.bOU.ev(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType Xh() {
        return PMSDownloadType.PRE;
    }
}
