package com.baidu.swan.apps.model;

import android.text.TextUtils;
import com.baidu.swan.apps.an.y;
/* loaded from: classes2.dex */
public final class b {
    public String axI;
    public String mBaseUrl;
    public String mParams;

    public static b ap(String str, String str2) {
        b bVar = new b();
        bVar.axI = y.hF(str);
        bVar.mParams = y.hG(str);
        bVar.mBaseUrl = str2;
        return bVar;
    }

    public static String f(b bVar) {
        if (bVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.mParams)) {
            return bVar.axI;
        }
        return bVar.axI + "?" + bVar.mParams;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.axI + "', mParams='" + this.mParams + "', mBaseUrl='" + this.mBaseUrl + "'}";
    }
}
