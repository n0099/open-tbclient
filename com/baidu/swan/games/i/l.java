package com.baidu.swan.games.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes10.dex */
public class l implements com.baidu.swan.apps.storage.b.c {
    private com.baidu.swan.apps.storage.b.d dAJ;

    public l() {
        n.cZ(n.getBasePath(), n.aVo());
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tF(String str) {
        return n.tF(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tG(String str) {
        if (com.baidu.swan.apps.storage.b.tx(str) == PathType.RELATIVE) {
            return n.tF(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tH(String str) {
        String wM = n.wM(str);
        if (TextUtils.isEmpty(wM)) {
            return null;
        }
        return wM;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tI(String str) {
        return n.xd(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tJ(String str) {
        return tI(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tK(String str) {
        return n.wY("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aKM() {
        return n.wY("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String aKN() {
        return n.wX(a.USER_DATA_PATH);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String tw(String str) {
        return tG(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tq(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean tr(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean ag(String str, boolean z) {
        return n.wS(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    @NonNull
    public synchronized com.baidu.swan.apps.storage.b.d aKO() {
        if (this.dAJ == null) {
            this.dAJ = new m();
        }
        return this.dAJ;
    }
}
