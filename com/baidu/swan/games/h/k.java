package com.baidu.swan.games.h;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes9.dex */
public class k implements com.baidu.swan.apps.storage.b.c {
    @Override // com.baidu.swan.apps.storage.b.c
    public String lO(String str) {
        return l.lO(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lP(String str) {
        if (com.baidu.swan.apps.storage.b.lI(str) == PathType.RELATIVE) {
            return l.lO(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lQ(String str) {
        String ov = l.ov(str);
        if (TextUtils.isEmpty(ov)) {
            return null;
        }
        return ov;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lR(String str) {
        return l.oM(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lS(String str) {
        return lR(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lT(String str) {
        return l.oG("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String acC() {
        return l.oG("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lH(String str) {
        return lP(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean lC(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean aw(long j) {
        return l.aS(j);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public void ax(long j) {
        l.aR(j);
    }
}
