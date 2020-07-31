package com.baidu.swan.games.view.webview;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.webview.a;
/* loaded from: classes7.dex */
class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull e eVar, @NonNull a.C0464a c0464a) {
        long j = eVar.arz().getLong("launch_time", 0L);
        if (j <= 0) {
            if (DEBUG) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.e eVar2 = new com.baidu.swan.apps.statistic.a.e();
        eVar2.mFrom = h.ho(eVar.arz().getAppFrameType());
        eVar2.mAppId = eVar.getAppId();
        eVar2.mSource = eVar.arz().ajg();
        eVar2.mType = "startup";
        eVar2.mPage = c0464a.mGameId;
        eVar2.mValue = c0464a.mGameName;
        eVar2.v("na_start", Long.valueOf(j));
        eVar2.v("h5_start", Long.valueOf(c0464a.dpX));
        eVar2.v("h5_finish", Long.valueOf(c0464a.dpY));
        h.a("1235", eVar2);
    }
}
