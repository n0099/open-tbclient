package com.baidu.swan.games.view.webview;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.webview.a;
/* loaded from: classes8.dex */
class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull e eVar, @NonNull a.C0512a c0512a) {
        long j = eVar.azM().getLong("launch_time", 0L);
        if (j <= 0) {
            if (DEBUG) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.e eVar2 = new com.baidu.swan.apps.statistic.a.e();
        eVar2.mFrom = h.jv(eVar.azM().getAppFrameType());
        eVar2.mAppId = eVar.getAppId();
        eVar2.mSource = eVar.azM().aqN();
        eVar2.mType = "startup";
        eVar2.mPage = c0512a.mGameId;
        eVar2.mValue = c0512a.mGameName;
        eVar2.u("na_start", Long.valueOf(j));
        eVar2.u("h5_start", Long.valueOf(c0512a.dzZ));
        eVar2.u("h5_finish", Long.valueOf(c0512a.dAa));
        h.a("1235", eVar2);
    }
}
