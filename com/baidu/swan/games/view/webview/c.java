package com.baidu.swan.games.view.webview;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.games.view.webview.a;
/* loaded from: classes11.dex */
class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull e eVar, @NonNull a.C0405a c0405a) {
        long j = eVar.akP().getLong("launch_time", 0L);
        if (j <= 0) {
            if (DEBUG) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.e eVar2 = new com.baidu.swan.apps.statistic.a.e();
        eVar2.mFrom = f.gz(eVar.akP().getAppFrameType());
        eVar2.mAppId = eVar.getAppId();
        eVar2.mSource = eVar.akP().adA();
        eVar2.mType = "startup";
        eVar2.mPage = c0405a.mGameId;
        eVar2.mValue = c0405a.mGameName;
        eVar2.s("na_start", Long.valueOf(j));
        eVar2.s("h5_start", Long.valueOf(c0405a.cUp));
        eVar2.s("h5_finish", Long.valueOf(c0405a.cUq));
        f.a("1235", eVar2);
    }
}
