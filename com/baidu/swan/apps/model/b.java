package com.baidu.swan.apps.model;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.scheme.actions.k.j;
/* loaded from: classes11.dex */
public final class b {
    public String coT;
    public String mBaseUrl;
    public String mPage;
    public String mParams;

    public static b bx(String str, String str2) {
        b bVar = new b();
        bVar.mPage = ah.delAllParamsFromUrl(str);
        bVar.mParams = ah.getParams(str);
        bVar.mBaseUrl = str2;
        bVar.coT = j.oh(bVar.mPage);
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

    public String ajR() {
        return this.coT;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.mPage + "', mParams='" + this.mParams + "', mBaseUrl='" + this.mBaseUrl + "', mRoutePage='" + this.coT + "'}";
    }
}
