package com.baidu.swan.games.view.webview;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.games.view.webview.a;
/* loaded from: classes9.dex */
class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull e eVar, @NonNull a.C0342a c0342a) {
        long j = eVar.ZV().getLong("launch_time", 0L);
        if (j <= 0) {
            if (DEBUG) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.e eVar2 = new com.baidu.swan.apps.statistic.a.e();
        eVar2.mFrom = f.ga(eVar.ZV().getAppFrameType());
        eVar2.mAppId = eVar.getAppId();
        eVar2.mSource = eVar.ZV().SW();
        eVar2.mType = "startup";
        eVar2.mPage = c0342a.mGameId;
        eVar2.mValue = c0342a.cqM;
        eVar2.n("na_start", Long.valueOf(j));
        eVar2.n("h5_start", Long.valueOf(c0342a.cqN));
        eVar2.n("h5_finish", Long.valueOf(c0342a.cqO));
        f.a("1235", eVar2);
    }
}
