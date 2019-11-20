package com.baidu.swan.apps.model;

import android.text.TextUtils;
import com.baidu.swan.apps.an.aa;
/* loaded from: classes2.dex */
public final class b {
    public String aSM;
    public String mBaseUrl;
    public String mParams;

    public static b ay(String str, String str2) {
        b bVar = new b();
        bVar.aSM = aa.iV(str);
        bVar.mParams = aa.iW(str);
        bVar.mBaseUrl = str2;
        return bVar;
    }

    public static String f(b bVar) {
        if (bVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.mParams)) {
            return bVar.aSM;
        }
        return bVar.aSM + "?" + bVar.mParams;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.aSM + "', mParams='" + this.mParams + "', mBaseUrl='" + this.mBaseUrl + "'}";
    }
}
