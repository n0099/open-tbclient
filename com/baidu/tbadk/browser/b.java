package com.baidu.tbadk.browser;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.DailyRecommendActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.util.bi;
/* loaded from: classes.dex */
class b implements bi {
    @Override // com.baidu.tbadk.core.util.bi
    public boolean a(Context context, String[] strArr) {
        String str = strArr[0];
        String str2 = strArr.length > 1 ? strArr[1] : null;
        String str3 = strArr.length > 2 ? strArr[2] : null;
        if (str.startsWith("opfeature:")) {
            a.i(context, a.x(str.replaceFirst("opfeature:", ""), str3));
        } else if (str.startsWith("web:")) {
            a.i(context, a.x(str.replaceFirst("web:", ""), str3));
        } else if (str.startsWith("topic:")) {
            TbWebViewActivity.startActivityWithCookie(context, str.substring(6), str2);
        } else if (str.startsWith("zb:")) {
            TbWebViewActivity.startActivity(context, context.getString(com.baidu.tieba.y.kn_zhibo), str.substring(3));
        } else if (str.startsWith("jctj:")) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2010020, new DailyRecommendActivityConfig(context, null)));
        } else if (!str.startsWith("list:")) {
            return false;
        } else {
            String substring = str.substring(5);
            if (!TextUtils.isEmpty(substring)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRankActivityConfig(context, substring, str3)));
            }
        }
        return true;
    }
}
