package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class b implements c {
    @Override // com.baidu.swan.apps.storage.b.c
    public String ns(String str) {
        e akN = e.akN();
        return akN == null ? str : com.baidu.swan.apps.storage.b.d(str, akN);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nt(String str) {
        e akN = e.akN();
        if (akN == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, akN, akN.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nu(String str) {
        e akN = e.akN();
        if (akN == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.by(str, akN.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nv(String str) {
        e akN = e.akN();
        return akN == null ? str : com.baidu.swan.apps.storage.b.bA(str, akN.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nw(String str) {
        String su = com.baidu.swan.d.c.su(str);
        return TextUtils.isEmpty(su) ? nv(str) : nv(str) + "." + su;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nx(String str) {
        e akN = e.akN();
        return akN == null ? "" : com.baidu.swan.apps.storage.b.H(akN.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String anx() {
        e akN = e.akN();
        return akN == null ? "" : com.baidu.swan.apps.storage.b.nk(akN.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nl(String str) {
        return com.baidu.swan.apps.storage.b.nl(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ng(String str) {
        return com.baidu.swan.apps.storage.b.ng(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean bi(long j) {
        return false;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public void bj(long j) {
    }
}
