package com.baidu.swan.apps.core.pms.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.a.b.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.d;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class a extends d {
    private static final boolean DEBUG = b.DEBUG;
    private a.InterfaceC0141a aqB;

    public a(String str, a.InterfaceC0141a interfaceC0141a) {
        super(str);
        this.aqB = interfaceC0141a;
    }

    @Override // com.baidu.swan.pms.a.f
    public void Bn() {
        super.Bn();
        if (this.atv != null) {
            Bz();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.aqB != null) {
            this.aqB.ca(0);
        }
        cr(aVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void Bo() {
        this.aqi.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a By = By();
        this.aqi.add(new UbcFlowEvent("na_end_update_db"));
        if (By == null) {
            if (this.aqB != null) {
                this.aqB.zp();
            }
        } else if (this.aqB != null) {
            this.aqB.ca(5);
        }
        aa("main_pre_download", this.aqx);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        com.baidu.swan.apps.env.d.CT().CV().c(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        if (this.aqB != null) {
            this.aqB.ca(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType Bp() {
        return PMSDownloadType.PRE;
    }
}
