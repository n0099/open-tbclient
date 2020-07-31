package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes7.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d cOY;

    public l() {
        n.ct(n.getBasePath(), n.aEM());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pR(String str) {
        return n.pR(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pS(String str) {
        if (com.baidu.swan.apps.storage.b.pJ(str) == PathType.RELATIVE) {
            return n.pR(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pT(String str) {
        String sI = n.sI(str);
        if (TextUtils.isEmpty(sI)) {
            return null;
        }
        return sI;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pU(String str) {
        return n.ta(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pV(String str) {
        return pU(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pW(String str) {
        return n.sU("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String auQ() {
        return n.sU("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String auR() {
        return n.sT(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String pI(String str) {
        return pS(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean pC(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean pD(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean V(String str, boolean z) {
        return n.sO(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d auS() {
        if (this.cOY == null) {
            this.cOY = new m();
        }
        return this.cOY;
    }
}
