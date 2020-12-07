package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes25.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d dGb;

    public l() {
        n.df(n.getBasePath(), n.aXL());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String uh(String str) {
        return n.uh(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ui(String str) {
        if (com.baidu.swan.apps.storage.b.tZ(str) == PathType.RELATIVE) {
            return n.uh(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String uj(String str) {
        String xo = n.xo(str);
        if (TextUtils.isEmpty(xo)) {
            return null;
        }
        return xo;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String uk(String str) {
        return n.xF(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String ul(String str) {
        return uk(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String um(String str) {
        return n.xA("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aNl() {
        return n.xA("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aNm() {
        return n.xz(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tY(String str) {
        return ui(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tS(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tT(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ah(String str, boolean z) {
        return n.xu(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d aNn() {
        if (this.dGb == null) {
            this.dGb = new m();
        }
        return this.dGb;
    }
}
