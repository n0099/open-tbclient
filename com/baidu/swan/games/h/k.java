package com.baidu.swan.games.h;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes11.dex */
public class k implements com.baidu.swan.apps.storage.b.c {
    @Override // com.baidu.swan.apps.storage.b.c
    public String mf(String str) {
        return l.mf(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mg(String str) {
        if (com.baidu.swan.apps.storage.b.lZ(str) == PathType.RELATIVE) {
            return l.mf(str);
        }
        return null;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mh(String str) {
        String oM = l.oM(str);
        if (TextUtils.isEmpty(oM)) {
            return null;
        }
        return oM;
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mi(String str) {
        return l.pd(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mj(String str) {
        return mi(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String mk(String str) {
        return l.oX("bdfile://tmp" + File.separator + str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String afs() {
        return l.oX("bdfile://tmp");
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public String lY(String str) {
        return mg(str);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean lT(String str) {
        return !TextUtils.isEmpty(str) && (a.USER_DATA_PATH.equals(str) || str.startsWith(new StringBuilder().append(a.USER_DATA_PATH).append(File.separator).toString()));
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public boolean aD(long j) {
        return l.aZ(j);
    }

    @Override // com.baidu.swan.apps.storage.b.c
    public void aE(long j) {
        l.aY(j);
    }
}
