package com.baidu.tbadk.core.log;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.d;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class b {
    public static void a(String str, long j, int i, String str2, int i2, String str3, Object... objArr) {
        d dVar = new d();
        dVar.b(IntentConfig.CMD, Integer.valueOf(i));
        if (!TextUtils.isEmpty(str2)) {
            dVar.r("action", str2);
        }
        dVar.r("errNo", String.valueOf(i2));
        if (!TextUtils.isEmpty(str3) && i2 != 0) {
            dVar.r("errMsg", str3);
        }
        if (objArr != null && objArr.length > 0) {
            dVar.b(objArr);
        }
        if (i2 == 0) {
            com.baidu.adp.lib.stats.a.ht().a(str, j, (String) null, dVar);
        } else {
            com.baidu.adp.lib.stats.a.ht().b(str, j, (String) null, dVar);
        }
    }
}
