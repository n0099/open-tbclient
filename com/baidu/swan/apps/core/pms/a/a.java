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
    private a.InterfaceC0127a apn;

    public a(String str, a.InterfaceC0127a interfaceC0127a) {
        super(str);
        this.apn = interfaceC0127a;
    }

    @Override // com.baidu.swan.pms.a.e
    public void zy() {
        super.zy();
        if (this.asl != null) {
            zI();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.model.b bVar) {
        super.a(bVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + bVar.toString());
        }
        if (this.apn != null) {
            this.apn.bZ(0);
        }
        co(bVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void zz() {
        this.aoU.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a zH = zH();
        this.aoU.add(new UbcFlowEvent("na_end_update_db"));
        if (zH == null) {
            if (this.apn != null) {
                this.apn.xN();
            }
        } else if (this.apn != null) {
            this.apn.bZ(5);
        }
        ae("main_pre_download", this.apj);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.Bd().Be().f(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        if (this.apn != null) {
            this.apn.bZ(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType zA() {
        return PMSDownloadType.PRE;
    }
}
