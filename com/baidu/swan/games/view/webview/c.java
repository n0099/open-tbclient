package com.baidu.swan.games.view.webview;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.webview.a;
/* loaded from: classes25.dex */
class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull e eVar, @NonNull a.C0560a c0560a) {
        long j = eVar.aJY().getLong("launch_time", 0L);
        if (j <= 0) {
            if (DEBUG) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.e eVar2 = new com.baidu.swan.apps.statistic.a.e();
        eVar2.mFrom = h.kS(eVar.aJY().getAppFrameType());
        eVar2.mAppId = eVar.getAppId();
        eVar2.mSource = eVar.aJY().aBe();
        eVar2.mType = "startup";
        eVar2.mPage = c0560a.mGameId;
        eVar2.mValue = c0560a.ehM;
        eVar2.t("na_start", Long.valueOf(j));
        eVar2.t("h5_start", Long.valueOf(c0560a.ehN));
        eVar2.t("h5_finish", Long.valueOf(c0560a.ehO));
        h.a("1235", eVar2);
    }
}
