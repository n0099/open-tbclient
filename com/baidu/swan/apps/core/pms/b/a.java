package com.baidu.swan.apps.core.pms.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes10.dex */
public class a extends f {
    private static final boolean DEBUG = b.DEBUG;
    private a.InterfaceC0233a bmq;

    public a(String str, a.InterfaceC0233a interfaceC0233a) {
        super(str);
        this.bmq = interfaceC0233a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void MS() {
        super.MS();
        if (this.blR != null) {
            Ni();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.bmq != null) {
            if (aVar.errorNo == 1010) {
                this.bmq.KN();
            } else {
                this.bmq.ea(0);
            }
        }
        er(aVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void MY() {
        this.blS.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ap.a Nh = Nh();
        this.blS.add(new UbcFlowEvent("na_end_update_db"));
        if (Nh == null) {
            if (this.bmq != null) {
                this.bmq.KN();
            }
        } else if (this.bmq != null) {
            this.bmq.ea(5);
        }
        ar("main_pre_download", this.blT);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.Pn().Po().c(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void n(Throwable th) {
        if (this.bmq != null) {
            this.bmq.ea(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType MZ() {
        return PMSDownloadType.PRE;
    }
}
