package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes9.dex */
public class b implements c {
    @Override // com.baidu.swan.apps.storage.b.c
    public String lO(String str) {
        e ZS = e.ZS();
        return ZS == null ? str : com.baidu.swan.apps.storage.b.d(str, ZS);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lP(String str) {
        e ZS = e.ZS();
        if (ZS == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, ZS, ZS.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lQ(String str) {
        e ZS = e.ZS();
        if (ZS == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.bf(str, ZS.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lR(String str) {
        e ZS = e.ZS();
        return ZS == null ? str : com.baidu.swan.apps.storage.b.bh(str, ZS.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lS(String str) {
        String qP = com.baidu.swan.d.c.qP(str);
        return TextUtils.isEmpty(qP) ? lR(str) : lR(str) + "." + qP;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lT(String str) {
        e ZS = e.ZS();
        return ZS == null ? "" : com.baidu.swan.apps.storage.b.G(ZS.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String acC() {
        e ZS = e.ZS();
        return ZS == null ? "" : com.baidu.swan.apps.storage.b.lG(ZS.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lH(String str) {
        return com.baidu.swan.apps.storage.b.lH(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean lC(String str) {
        return com.baidu.swan.apps.storage.b.lC(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean aw(long j) {
        return false;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public void ax(long j) {
    }
}
