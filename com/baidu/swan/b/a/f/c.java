package com.baidu.swan.b.a.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(String str, String str2, String str3, String str4, a aVar) {
        String oi = b.oi(str2);
        if (!TextUtils.isEmpty(oi)) {
            if (DEBUG) {
                Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
            }
            if (!TextUtils.isEmpty(str)) {
                b bVar = new b();
                bVar.a(aVar);
                bVar.mType = oi;
                bVar.mValue = str3;
                bVar.packageName = str;
                if (e.acG() != null) {
                    b.a acI = e.acG().acI();
                    bVar.mFrom = f.gs(acI.getAppFrameType());
                    bVar.mAppId = acI.getAppId();
                    bVar.mSource = acI.VJ();
                }
                bVar.mErrorCode = str4;
                f.a("1245", bVar);
            }
        }
    }
}
