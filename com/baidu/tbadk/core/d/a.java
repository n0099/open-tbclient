package com.baidu.tbadk.core.d;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.c;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class a {
    public static void a(String str, long j, int i, String str2, int i2, String str3, Object... objArr) {
        c cVar = new c();
        cVar.d(IntentConfig.CMD, Integer.valueOf(i));
        if (!TextUtils.isEmpty(str2)) {
            cVar.p("action", str2);
        }
        cVar.p("errNo", String.valueOf(i2));
        if (!TextUtils.isEmpty(str3) && i2 != 0) {
            cVar.p("errMsg", str3);
        }
        if (objArr != null && objArr.length > 0) {
            cVar.d(objArr);
        }
        if (i2 == 0) {
            BdStatisticsManager.getInstance().debug(str, j, null, cVar);
        } else {
            BdStatisticsManager.getInstance().error(str, j, (String) null, cVar);
        }
    }
}
