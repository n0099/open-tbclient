package com.baidu.swan.gamecenter.appmanager.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes20.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(String str, String str2, String str3, String str4, a aVar) {
        String sb = b.sb(str2);
        if (!TextUtils.isEmpty(sb)) {
            if (DEBUG) {
                Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
            }
            if (!TextUtils.isEmpty(str)) {
                b bVar = new b();
                bVar.a(aVar);
                bVar.mType = sb;
                bVar.mValue = str3;
                bVar.packageName = str;
                bVar.mAppVersion = al.getVersionName();
                if (e.arw() != null) {
                    b.a arz = e.arw().arz();
                    bVar.mFrom = h.ho(arz.getAppFrameType());
                    bVar.mAppId = arz.getAppId();
                    bVar.mSource = arz.ajg();
                }
                bVar.mErrorCode = str4;
                h.a("1245", bVar);
            }
        }
    }
}
