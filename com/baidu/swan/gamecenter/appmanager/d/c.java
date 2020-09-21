package com.baidu.swan.gamecenter.appmanager.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes14.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(String str, String str2, String str3, String str4, a aVar) {
        String uN = b.uN(str2);
        if (!TextUtils.isEmpty(uN)) {
            if (DEBUG) {
                Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
            }
            if (!TextUtils.isEmpty(str)) {
                b bVar = new b();
                bVar.a(aVar);
                bVar.mType = uN;
                bVar.mValue = str3;
                bVar.packageName = str;
                bVar.mAppVersion = ak.getVersionName();
                if (e.aAs() != null) {
                    b.a aAv = e.aAs().aAv();
                    bVar.mFrom = h.jG(aAv.getAppFrameType());
                    bVar.mAppId = aAv.getAppId();
                    bVar.mSource = aAv.arx();
                }
                bVar.mErrorCode = str4;
                h.a("1245", bVar);
            }
        }
    }
}
