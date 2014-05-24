package com.baidu.tbadk.browser;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.util.bk;
/* loaded from: classes.dex */
class b implements bk {
    @Override // com.baidu.tbadk.core.util.bk
    public boolean a(Context context, String[] strArr) {
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
            TbWebViewActivity.b(context, context.getString(com.baidu.tieba.y.kn_zhibo), str.substring(3));
        } else if (str.startsWith("jctj:")) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfig.DAILY_RECOMMEND_CUSTOM_CMD, new com.baidu.tbadk.core.atomData.h(context, null)));
        } else if (!str.startsWith("list:")) {
            return false;
        } else {
            String substring = str.substring(5);
            if (!TextUtils.isEmpty(substring)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.l(context, substring, str3)));
            }
        }
        return true;
    }
}
