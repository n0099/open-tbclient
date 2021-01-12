package com.baidu.swan.apps.model;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.scheme.actions.k.j;
/* loaded from: classes8.dex */
public final class b {
    public String dlD;
    public String mBaseUrl;
    public String mPage;
    public String mParams;

    public static b cf(String str, String str2) {
        b bVar = new b();
        bVar.mPage = ai.delAllParamsFromUrl(str);
        bVar.mParams = ai.getParams(str);
        bVar.mBaseUrl = str2;
        bVar.dlD = j.rX(bVar.mPage);
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
        if (bVar == null || TextUtils.isEmpty(bVar.dlD)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.mParams)) {
            return bVar.dlD;
        }
        return bVar.dlD + "?" + bVar.mParams;
    }

    public String getPage() {
        return this.mPage;
    }

    public String getParams() {
        return this.mParams;
    }

    public String aBZ() {
        return this.dlD;
    }

    public void setParams(String str) {
        this.mParams = str;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.mPage + "', mParams='" + this.mParams + "', mBaseUrl='" + this.mBaseUrl + "', mRoutePage='" + this.dlD + "'}";
    }
}
