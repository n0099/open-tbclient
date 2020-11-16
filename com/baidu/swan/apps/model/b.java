package com.baidu.swan.apps.model;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.scheme.actions.k.j;
/* loaded from: classes7.dex */
public final class b {
    public String dew;
    public String mBaseUrl;
    public String mPage;
    public String mParams;

    public static b ca(String str, String str2) {
        b bVar = new b();
        bVar.mPage = ai.delAllParamsFromUrl(str);
        bVar.mParams = ai.getParams(str);
        bVar.mBaseUrl = str2;
        bVar.dew = j.sF(bVar.mPage);
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

    public static String e(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.dew)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.mParams)) {
            return bVar.dew;
        }
        return bVar.dew + "?" + bVar.mParams;
    }

    public String getPage() {
        return this.mPage;
    }

    public String getParams() {
        return this.mParams;
    }

    public String aBq() {
        return this.dew;
    }

    public void setParams(String str) {
        this.mParams = str;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.mPage + "', mParams='" + this.mParams + "', mBaseUrl='" + this.mBaseUrl + "', mRoutePage='" + this.dew + "'}";
    }
}
