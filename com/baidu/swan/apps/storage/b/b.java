package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class b implements c {
    @Override // com.baidu.swan.apps.storage.b.c
    public String mg(String str) {
        e acF = e.acF();
        return acF == null ? str : com.baidu.swan.apps.storage.b.d(str, acF);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mh(String str) {
        e acF = e.acF();
        if (acF == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, acF, acF.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mi(String str) {
        e acF = e.acF();
        if (acF == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.bp(str, acF.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mj(String str) {
        e acF = e.acF();
        return acF == null ? str : com.baidu.swan.apps.storage.b.br(str, acF.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mk(String str) {
        String rh = com.baidu.swan.d.c.rh(str);
        return TextUtils.isEmpty(rh) ? mj(str) : mj(str) + "." + rh;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ml(String str) {
        e acF = e.acF();
        return acF == null ? "" : com.baidu.swan.apps.storage.b.H(acF.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String afp() {
        e acF = e.acF();
        return acF == null ? "" : com.baidu.swan.apps.storage.b.lY(acF.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lZ(String str) {
        return com.baidu.swan.apps.storage.b.lZ(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean lU(String str) {
        return com.baidu.swan.apps.storage.b.lU(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean aD(long j) {
        return false;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public void aE(long j) {
    }
}
