package com.baidu.swan.games.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes8.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d dJT;

    public l() {
        n.dd(n.getBasePath(), n.aWm());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sT(String str) {
        return n.sT(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sU(String str) {
        if (com.baidu.swan.apps.storage.b.sL(str) == PathType.RELATIVE) {
            return n.sT(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sV(String str) {
        String wc = n.wc(str);
        if (TextUtils.isEmpty(wc)) {
            return null;
        }
        return wc;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sW(String str) {
        return n.wt(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sX(String str) {
        return sW(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sY(String str) {
        return n.wo("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aLI() {
        return n.wo("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aLJ() {
        return n.wn(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sK(String str) {
        return sU(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean sE(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean sF(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ah(String str, boolean z) {
        return n.wi(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d aLK() {
        if (this.dJT == null) {
            this.dJT = new m();
        }
        return this.dJT;
    }
}
