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
    private a.InterfaceC0294a bOZ;

    public a(String str, a.InterfaceC0294a interfaceC0294a) {
        super(str);
        this.bOZ = interfaceC0294a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void WZ() {
        super.WZ();
        if (this.bOB != null) {
            Xp();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.bOZ != null) {
            if (aVar.errorNo == 1010) {
                this.bOZ.UT();
            } else {
                this.bOZ.ev(0);
            }
        }
        eM(aVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void Xf() {
        this.bOC.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ap.a Xo = Xo();
        this.bOC.add(new UbcFlowEvent("na_end_update_db"));
        if (Xo == null) {
            if (this.bOZ != null) {
                this.bOZ.UT();
            }
        } else if (this.bOZ != null) {
            this.bOZ.ev(5);
        }
        aJ("main_pre_download", this.bOD);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.Zu().Zv().d(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        if (this.bOZ != null) {
            this.bOZ.ev(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType Xg() {
        return PMSDownloadType.PRE;
    }
}
