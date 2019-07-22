package com.baidu.swan.apps.model;

import android.text.TextUtils;
import com.baidu.swan.apps.an.aa;
/* loaded from: classes2.dex */
public final class b {
    public String azs;
    public String mBaseUrl;
    public String mParams;

    public static b aq(String str, String str2) {
        b bVar = new b();
        bVar.azs = aa.iq(str);
        bVar.mParams = aa.ir(str);
        bVar.mBaseUrl = str2;
        return bVar;
    }

    public static String f(b bVar) {
        if (bVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.mParams)) {
            return bVar.azs;
        }
        return bVar.azs + "?" + bVar.mParams;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.azs + "', mParams='" + this.mParams + "', mBaseUrl='" + this.mBaseUrl + "'}";
    }
}
