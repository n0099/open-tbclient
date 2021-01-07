package com.baidu.swan.games.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes9.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d dOF;

    public l() {
        n.de(n.getBasePath(), n.bag());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ue(String str) {
        return n.ue(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String uf(String str) {
        if (com.baidu.swan.apps.storage.b.tW(str) == PathType.RELATIVE) {
            return n.ue(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ug(String str) {
        String xn = n.xn(str);
        if (TextUtils.isEmpty(xn)) {
            return null;
        }
        return xn;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String uh(String str) {
        return n.xE(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ui(String str) {
        return uh(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String uj(String str) {
        return n.xz("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aPC() {
        return n.xz("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aPD() {
        return n.xy(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tV(String str) {
        return uf(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tP(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tQ(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ah(String str, boolean z) {
        return n.xt(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d aPE() {
        if (this.dOF == null) {
            this.dOF = new m();
        }
        return this.dOF;
    }
}
