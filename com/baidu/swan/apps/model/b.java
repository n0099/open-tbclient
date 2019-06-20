package com.baidu.swan.apps.model;

import android.text.TextUtils;
import com.baidu.swan.apps.an.aa;
/* loaded from: classes2.dex */
public final class b {
    public String ayL;
    public String mBaseUrl;
    public String mParams;

    public static b aq(String str, String str2) {
        b bVar = new b();
        bVar.ayL = aa.ij(str);
        bVar.mParams = aa.ik(str);
        bVar.mBaseUrl = str2;
        return bVar;
    }

    public static String f(b bVar) {
        if (bVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.mParams)) {
            return bVar.ayL;
        }
        return bVar.ayL + "?" + bVar.mParams;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.ayL + "', mParams='" + this.mParams + "', mBaseUrl='" + this.mBaseUrl + "'}";
    }
}
