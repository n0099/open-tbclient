package com.baidu.swan.games.h;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes11.dex */
public class k implements com.baidu.swan.apps.storage.b.c {
    @Override // com.baidu.swan.apps.storage.b.c
    public String ns(String str) {
        return l.ns(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nt(String str) {
        if (com.baidu.swan.apps.storage.b.nm(str) == PathType.RELATIVE) {
            return l.ns(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nu(String str) {
        String pZ = l.pZ(str);
        if (TextUtils.isEmpty(pZ)) {
            return null;
        }
        return pZ;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nv(String str) {
        return l.qq(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nw(String str) {
        return nv(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nx(String str) {
        return l.qk("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String anw() {
        return l.qk("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String nl(String str) {
        return nt(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ng(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean bi(long j) {
        return l.bE(j);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public void bj(long j) {
        l.bD(j);
    }
}
