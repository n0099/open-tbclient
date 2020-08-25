package com.baidu.swan.apps.model;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.scheme.actions.k.j;
/* loaded from: classes8.dex */
public final class b {
    public String cDC;
    public String mBaseUrl;
    public String mPage;
    public String mParams;

    public static b bP(String str, String str2) {
        b bVar = new b();
        bVar.mPage = ai.delAllParamsFromUrl(str);
        bVar.mParams = ai.getParams(str);
        bVar.mBaseUrl = str2;
        bVar.cDC = j.qW(bVar.mPage);
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
        if (bVar == null || TextUtils.isEmpty(bVar.cDC)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.mParams)) {
            return bVar.cDC;
        }
        return bVar.cDC + "?" + bVar.mParams;
    }

    public String getPage() {
        return this.mPage;
    }

    public String getParams() {
        return this.mParams;
    }

    public String auk() {
        return this.cDC;
    }

    public void setParams(String str) {
        this.mParams = str;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.mPage + "', mParams='" + this.mParams + "', mBaseUrl='" + this.mBaseUrl + "', mRoutePage='" + this.cDC + "'}";
    }
}
