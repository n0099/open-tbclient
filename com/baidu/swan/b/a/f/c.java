package com.baidu.swan.b.a.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(String str, String str2, String str3, String str4, a aVar) {
        String qV = b.qV(str2);
        if (!TextUtils.isEmpty(qV)) {
            if (DEBUG) {
                Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
            }
            if (!TextUtils.isEmpty(str)) {
                b bVar = new b();
                bVar.a(aVar);
                bVar.mType = qV;
                bVar.mValue = str3;
                bVar.packageName = str;
                if (e.aoG() != null) {
                    b.a aoJ = e.aoG().aoJ();
                    bVar.mFrom = h.gS(aoJ.getAppFrameType());
                    bVar.mAppId = aoJ.getAppId();
                    bVar.mSource = aoJ.agK();
                }
                bVar.mErrorCode = str4;
                h.a("1245", bVar);
            }
        }
    }
}
