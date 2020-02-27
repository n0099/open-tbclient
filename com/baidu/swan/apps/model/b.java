package com.baidu.swan.apps.model;

import android.text.TextUtils;
import com.baidu.swan.apps.as.ag;
/* loaded from: classes11.dex */
public final class b {
    public String mBaseUrl;
    public String mPage;
    public String mParams;

    public static b aX(String str, String str2) {
        b bVar = new b();
        bVar.mPage = ag.delAllParamsFromUrl(str);
        bVar.mParams = ag.getParams(str);
        bVar.mBaseUrl = str2;
        return bVar;
    }

    public static String d(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.mPage)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.mParams)) {
            return bVar.mPage;
        }
        return bVar.mPage + "?" + bVar.mParams;
    }

    public String getPage() {
        return this.mPage;
    }

    public String getParams() {
        return this.mParams;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.mPage + "', mParams='" + this.mParams + "', mBaseUrl='" + this.mBaseUrl + "'}";
    }
}
