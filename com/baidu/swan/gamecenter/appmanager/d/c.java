package com.baidu.swan.gamecenter.appmanager.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(String str, String str2, String str3, String str4, a aVar) {
        String vw = b.vw(str2);
        if (!TextUtils.isEmpty(vw)) {
            if (DEBUG) {
                Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
            }
            if (!TextUtils.isEmpty(str)) {
                b bVar = new b();
                bVar.a(aVar);
                bVar.mType = vw;
                bVar.mValue = str3;
                bVar.packageName = str;
                bVar.mAppVersion = ak.getVersionName();
                if (e.aIs() != null) {
                    b.a aIv = e.aIs().aIv();
                    bVar.mFrom = h.jr(aIv.getAppFrameType());
                    bVar.mAppId = aIv.getAppId();
                    bVar.mSource = aIv.ayC();
                }
                bVar.mErrorCode = str4;
                h.a("1245", bVar);
            }
        }
    }
}
