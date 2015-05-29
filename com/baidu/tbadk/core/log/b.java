package com.baidu.tbadk.core.log;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.q;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class b {
    public static void a(String str, long j, int i, String str2, int i2, String str3, Object... objArr) {
        q qVar = new q();
        qVar.f(c.CMD, Integer.valueOf(i));
        if (!TextUtils.isEmpty(str2)) {
            qVar.r("action", str2);
        }
        qVar.r("errNo", String.valueOf(i2));
        if (!TextUtils.isEmpty(str3) && i2 != 0) {
            qVar.r("errMsg", str3);
        }
        if (objArr != null && objArr.length > 0) {
            qVar.f(objArr);
        }
        if (i2 == 0) {
            com.baidu.adp.lib.h.a.iB().b(str, j, null, qVar);
        } else {
            com.baidu.adp.lib.h.a.iB().c(str, j, null, qVar);
        }
    }
}
