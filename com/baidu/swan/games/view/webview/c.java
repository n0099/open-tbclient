package com.baidu.swan.games.view.webview;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.games.view.webview.a;
/* loaded from: classes8.dex */
class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull e eVar, @NonNull a.C0534a c0534a) {
        long j = eVar.aIv().getLong("launch_time", 0L);
        if (j <= 0) {
            if (DEBUG) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.e eVar2 = new com.baidu.swan.apps.statistic.a.e();
        eVar2.mFrom = h.jr(eVar.aIv().getAppFrameType());
        eVar2.mAppId = eVar.getAppId();
        eVar2.mSource = eVar.aIv().ayC();
        eVar2.mType = "startup";
        eVar2.mPage = c0534a.mGameId;
        eVar2.mValue = c0534a.ema;
        eVar2.t("na_start", Long.valueOf(j));
        eVar2.t("h5_start", Long.valueOf(c0534a.emb));
        eVar2.t("h5_finish", Long.valueOf(c0534a.emc));
        h.a("1235", eVar2);
    }
}
