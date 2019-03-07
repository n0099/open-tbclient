package com.baidu.swan.apps.core.pms.a;

import android.util.Log;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.core.a.b.a;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.d;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.b;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class a extends d {
    private static final boolean DEBUG = c.DEBUG;
    private a.InterfaceC0098a aph;

    public a(String str, a.InterfaceC0098a interfaceC0098a) {
        super(str);
        this.aph = interfaceC0098a;
    }

    @Override // com.baidu.swan.pms.a.e
    public void zz() {
        super.zz();
        if (this.asf != null) {
            zJ();
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.e
    public void a(b bVar) {
        super.a(bVar);
        if (DEBUG) {
            Log.e("SwanAppPkgPreDownloadCallback", "onFetchError: " + bVar.toString());
        }
        if (this.aph != null) {
            this.aph.ca(0);
        }
        cp(bVar.errorNo);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void zA() {
        this.aoO.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a zI = zI();
        this.aoO.add(new UbcFlowEvent("na_end_update_db"));
        if (zI == null) {
            if (this.aph != null) {
                this.aph.xO();
            }
        } else if (this.aph != null) {
            this.aph.ca(5);
        }
        ae("main_pre_download", this.apd);
        HashSet hashSet = new HashSet();
        hashSet.add(this.mAppId);
        e.Bf().Bg().f(hashSet);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        if (this.aph != null) {
            this.aph.ca(0);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType zB() {
        return PMSDownloadType.PRE;
    }
}
