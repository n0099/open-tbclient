package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes3.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d daf;

    public l() {
        n.cN(n.getBasePath(), n.aOl());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sl(String str) {
        return n.sl(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sm(String str) {
        if (com.baidu.swan.apps.storage.b.sd(str) == PathType.RELATIVE) {
            return n.sl(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sn(String str) {
        String vt = n.vt(str);
        if (TextUtils.isEmpty(vt)) {
            return null;
        }
        return vt;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String so(String str) {
        return n.vK(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sp(String str) {
        return so(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sq(String str) {
        return n.vF("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aDJ() {
        return n.vF("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aDK() {
        return n.vE(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sc(String str) {
        return sm(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean rW(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean rX(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean aa(String str, boolean z) {
        return n.vz(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d aDL() {
        if (this.daf == null) {
            this.daf = new m();
        }
        return this.daf;
    }
}
