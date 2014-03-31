package com.baidu.tbadk.browser;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.bi;
/* loaded from: classes.dex */
final class b implements bi {
    @Override // com.baidu.tbadk.core.util.bi
    public final boolean a(Context context, String[] strArr) {
        String str = strArr[0];
        String str2 = strArr.length > 1 ? strArr[1] : null;
        String str3 = strArr.length > 2 ? strArr[2] : null;
        if (str.startsWith("opfeature:")) {
            a.a(context, a.a(str.replaceFirst("opfeature:", ""), str3));
        } else if (str.startsWith("web:")) {
            a.a(context, a.a(str.replaceFirst("web:", ""), str3));
        } else if (str.startsWith("topic:")) {
            TbWebViewActivity.a(context, str.substring(6), str2);
        } else if (str.startsWith("zb:")) {
            TbWebViewActivity.b(context, context.getString(com.baidu.tbadk.l.kn_zhibo), str.substring(3));
        } else if (str.startsWith("jctj:")) {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2010020, new com.baidu.tbadk.core.b.g(context, null)));
        } else if (!str.startsWith("list:")) {
            return false;
        } else {
            String substring = str.substring(5);
            if (!TextUtils.isEmpty(substring)) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.k(context, substring, str3)));
            }
        }
        return true;
    }
}
