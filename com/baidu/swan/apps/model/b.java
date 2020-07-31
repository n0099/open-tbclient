package com.baidu.swan.apps.model;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.scheme.actions.k.j;
/* loaded from: classes7.dex */
public final class b {
    public String cvJ;
    public String mBaseUrl;
    public String mPage;
    public String mParams;

    public static b bB(String str, String str2) {
        b bVar = new b();
        bVar.mPage = aj.delAllParamsFromUrl(str);
        bVar.mParams = aj.getParams(str);
        bVar.mBaseUrl = str2;
        bVar.cvJ = j.oZ(bVar.mPage);
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
        if (bVar == null || TextUtils.isEmpty(bVar.cvJ)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.mParams)) {
            return bVar.cvJ;
        }
        return bVar.cvJ + "?" + bVar.mParams;
    }

    public String getPage() {
        return this.mPage;
    }

    public String getParams() {
        return this.mParams;
    }

    public String amo() {
        return this.cvJ;
    }

    public void setParams(String str) {
        this.mParams = str;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.mPage + "', mParams='" + this.mParams + "', mBaseUrl='" + this.mBaseUrl + "', mRoutePage='" + this.cvJ + "'}";
    }
}
