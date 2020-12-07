package com.baidu.swan.apps.core;

import android.support.annotation.Nullable;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.statistic.h;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
/* loaded from: classes25.dex */
public class d {
    public static void I(String str, @Nullable String str2, String str3) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mFrom = "swan";
        eVar.mType = str;
        if (str2 == null) {
            str2 = "";
        }
        eVar.mValue = str2;
        eVar.t("appid", com.baidu.swan.apps.runtime.d.aJQ().getAppId());
        eVar.t(DpStatConstants.KEY_NETWORK_STATUS, str3);
        eVar.t("isShow", c.apt() ? "1" : "0");
        h.a("1619", eVar);
    }

    public static void bu(String str, String str2) {
        I(str, null, str2);
    }

    public static void kt(final String str) {
        SwanAppNetworkUtils.a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.d.1
            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
            public void onResult(int i) {
                String str2 = "unknown";
                switch (i) {
                    case 1:
                        str2 = FrsActivityConfig.GOOD;
                        break;
                    case 2:
                        str2 = "bad";
                        break;
                    case 3:
                        str2 = "offline";
                        break;
                }
                d.I(str, null, str2);
            }
        });
    }
}
