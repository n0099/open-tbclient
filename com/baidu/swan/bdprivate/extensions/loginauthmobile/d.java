package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.h;
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void g(String str, String str2, String str3, String str4, String str5) {
        f fVar = new f();
        fVar.mFrom = "swan";
        fVar.mType = str;
        fVar.mPage = str2;
        if (TextUtils.equals(str, "click")) {
            fVar.mValue = str3;
        }
        fVar.mAppId = str5;
        fVar.u("source", str4);
        if (DEBUG) {
            Log.d("LoginAndGetMobileStatics", "staticLoginResult: event = " + fVar.toJSONObject());
        }
        h.a("1372", fVar);
    }
}
