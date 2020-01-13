package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes10.dex */
public class b implements c {
    @Override // com.baidu.swan.apps.storage.b.c
    public String lR(String str) {
        e aap = e.aap();
        return aap == null ? str : com.baidu.swan.apps.storage.b.d(str, aap);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lS(String str) {
        e aap = e.aap();
        if (aap == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, aap, aap.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lT(String str) {
        e aap = e.aap();
        if (aap == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.bg(str, aap.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lU(String str) {
        e aap = e.aap();
        return aap == null ? str : com.baidu.swan.apps.storage.b.bi(str, aap.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lV(String str) {
        String qS = com.baidu.swan.d.c.qS(str);
        return TextUtils.isEmpty(qS) ? lU(str) : lU(str) + "." + qS;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lW(String str) {
        e aap = e.aap();
        return aap == null ? "" : com.baidu.swan.apps.storage.b.G(aap.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String acZ() {
        e aap = e.aap();
        return aap == null ? "" : com.baidu.swan.apps.storage.b.lJ(aap.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lK(String str) {
        return com.baidu.swan.apps.storage.b.lK(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean lF(String str) {
        return com.baidu.swan.apps.storage.b.lF(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean az(long j) {
        return false;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public void aA(long j) {
    }
}
