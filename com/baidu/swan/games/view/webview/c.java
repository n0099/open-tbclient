package com.baidu.swan.games.view.webview;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.games.view.webview.a;
/* loaded from: classes10.dex */
class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull e eVar, @NonNull a.C0344a c0344a) {
        long j = eVar.aas().getLong("launch_time", 0L);
        if (j <= 0) {
            if (DEBUG) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.e eVar2 = new com.baidu.swan.apps.statistic.a.e();
        eVar2.mFrom = f.gb(eVar.aas().getAppFrameType());
        eVar2.mAppId = eVar.getAppId();
        eVar2.mSource = eVar.aas().Tt();
        eVar2.mType = "startup";
        eVar2.mPage = c0344a.mGameId;
        eVar2.mValue = c0344a.mGameName;
        eVar2.n("na_start", Long.valueOf(j));
        eVar2.n("h5_start", Long.valueOf(c0344a.cqY));
        eVar2.n("h5_finish", Long.valueOf(c0344a.cqZ));
        f.a("1235", eVar2);
    }
}
