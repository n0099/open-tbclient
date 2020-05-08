package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class b implements c {
    @Override // com.baidu.swan.apps.storage.b.c
    public String ns(String str) {
        e akM = e.akM();
        return akM == null ? str : com.baidu.swan.apps.storage.b.d(str, akM);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nt(String str) {
        e akM = e.akM();
        if (akM == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.a(str, akM, akM.getVersion());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nu(String str) {
        e akM = e.akM();
        if (akM == null) {
            return null;
        }
        return com.baidu.swan.apps.storage.b.by(str, akM.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nv(String str) {
        e akM = e.akM();
        return akM == null ? str : com.baidu.swan.apps.storage.b.bA(str, akM.id);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nw(String str) {
        String su = com.baidu.swan.d.c.su(str);
        return TextUtils.isEmpty(su) ? nv(str) : nv(str) + "." + su;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nx(String str) {
        e akM = e.akM();
        return akM == null ? "" : com.baidu.swan.apps.storage.b.H(akM.id, str, null);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String anw() {
        e akM = e.akM();
        return akM == null ? "" : com.baidu.swan.apps.storage.b.nk(akM.id);
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
