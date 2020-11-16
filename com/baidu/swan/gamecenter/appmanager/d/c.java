package com.baidu.swan.gamecenter.appmanager.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes16.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(String str, String str2, String str3, String str4, a aVar) {
        String wb = b.wb(str2);
        if (!TextUtils.isEmpty(wb)) {
            if (DEBUG) {
                Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
            }
            if (!TextUtils.isEmpty(str)) {
                b bVar = new b();
                bVar.a(aVar);
                bVar.mType = wb;
                bVar.mValue = str3;
                bVar.packageName = str;
                bVar.mAppVersion = ak.getVersionName();
                if (e.aGN() != null) {
                    b.a aGQ = e.aGN().aGQ();
                    bVar.mFrom = h.ku(aGQ.getAppFrameType());
                    bVar.mAppId = aGQ.getAppId();
                    bVar.mSource = aGQ.axV();
                }
                bVar.mErrorCode = str4;
                h.a("1245", bVar);
            }
        }
    }
}
