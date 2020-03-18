package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class b implements c {
    @Override // com.baidu.swan.apps.storage.b.c
    public String mf(String str) {
        e acI = e.acI();
        return acI == null ? str : com.baidu.swan.apps.storage.b.d(str, acI);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mg(String str) {
        e acI = e.acI();
        if (acI == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, acI, acI.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mh(String str) {
        e acI = e.acI();
        if (acI == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.bo(str, acI.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mi(String str) {
        e acI = e.acI();
        return acI == null ? str : com.baidu.swan.apps.storage.b.bq(str, acI.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mj(String str) {
        String rg = com.baidu.swan.d.c.rg(str);
        return TextUtils.isEmpty(rg) ? mi(str) : mi(str) + "." + rg;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mk(String str) {
        e acI = e.acI();
        return acI == null ? "" : com.baidu.swan.apps.storage.b.H(acI.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String afs() {
        e acI = e.acI();
        return acI == null ? "" : com.baidu.swan.apps.storage.b.lX(acI.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lY(String str) {
        return com.baidu.swan.apps.storage.b.lY(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean lT(String str) {
        return com.baidu.swan.apps.storage.b.lT(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean aD(long j) {
        return false;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public void aE(long j) {
    }
}
