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
        String rd = b.rd(str2);
        if (!TextUtils.isEmpty(rd)) {
            if (DEBUG) {
                Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
            }
            if (!TextUtils.isEmpty(str)) {
                b bVar = new b();
                bVar.a(aVar);
                bVar.mType = rd;
                bVar.mValue = str3;
                bVar.packageName = str;
                if (e.apN() != null) {
                    b.a apQ = e.apN().apQ();
                    bVar.mFrom = h.hf(apQ.getAppFrameType());
                    bVar.mAppId = apQ.getAppId();
                    bVar.mSource = apQ.ahQ();
                }
                bVar.mErrorCode = str4;
                h.a("1245", bVar);
            }
        }
    }
}
