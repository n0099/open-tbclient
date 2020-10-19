package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes10.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d dmp;

    public l() {
        n.cS(n.getBasePath(), n.aQU());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sY(String str) {
        return n.sY(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sZ(String str) {
        if (com.baidu.swan.apps.storage.b.sQ(str) == PathType.RELATIVE) {
            return n.sY(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ta(String str) {
        String wf = n.wf(str);
        if (TextUtils.isEmpty(wf)) {
            return null;
        }
        return wf;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tb(String str) {
        return n.ww(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tc(String str) {
        return tb(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String td(String str) {
        return n.wr("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aGs() {
        return n.wr("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aGt() {
        return n.wq(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String sP(String str) {
        return sZ(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean sJ(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean sK(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ae(String str, boolean z) {
        return n.wl(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d aGu() {
        if (this.dmp == null) {
            this.dmp = new m();
        }
        return this.dmp;
    }
}
