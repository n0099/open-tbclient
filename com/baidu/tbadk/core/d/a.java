package com.baidu.tbadk.core.d;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class a {
    public static void a(String str, long j, int i, String str2, int i2, String str3, Object... objArr) {
        com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a();
        aVar.append("cmd", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str2)) {
            aVar.append("action", str2);
        }
        aVar.append("errNo", String.valueOf(i2));
        if (!TextUtils.isEmpty(str3) && i2 != 0) {
            aVar.append("errMsg", str3);
        }
        if (objArr != null && objArr.length > 0) {
            aVar.append(objArr);
        }
        if (i2 == 0) {
            BdStatisticsManager.getInstance().debug(str, j, null, aVar);
        } else {
            BdStatisticsManager.getInstance().error(str, j, (String) null, aVar);
        }
    }
}
