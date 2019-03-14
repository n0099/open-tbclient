package com.baidu.swan.apps.core.pms.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.a.b.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.d;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class a extends d {
    private static final boolean DEBUG = b.DEBUG;
    private a.InterfaceC0127a api;

    public a(String str, a.InterfaceC0127a interfaceC0127a) {
        super(str);
        this.api = interfaceC0127a;
    }

    @Override // com.baidu.swan.pms.a.e
    public void zz() {
        super.zz();
        if (this.asg != null) {
            zJ();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.model.b bVar) {
        super.a(bVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + bVar.toString());
        }
        if (this.api != null) {
            this.api.ca(0);
        }
        cp(bVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void zA() {
        this.aoP.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a zI = zI();
        this.aoP.add(new UbcFlowEvent("na_end_update_db"));
        if (zI == null) {
            if (this.api != null) {
                this.api.xO();
            }
        } else if (this.api != null) {
            this.api.ca(5);
        }
        ae("main_pre_download", this.ape);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.Bf().Bg().f(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        if (this.api != null) {
            this.api.ca(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType zB() {
        return PMSDownloadType.PRE;
    }
}
