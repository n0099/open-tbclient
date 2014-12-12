package com.baidu.tbadk.browser;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.DailyRecommendActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.plugins.XiubaPlugin;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class b implements bj {
    @Override // com.baidu.tbadk.core.util.bj
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        String str = strArr[0];
        String str2 = strArr.length > 2 ? strArr[2] : null;
        String str3 = strArr.length > 1 ? strArr[1] : null;
        if (str.startsWith("opfeature:")) {
            a.y(tbPageContext.getContext(), a.I(str.replaceFirst("opfeature:", ""), str2));
        } else if (str.startsWith("web:")) {
            a.y(tbPageContext.getContext(), a.I(str.replaceFirst("web:", ""), str2));
        } else if (str.startsWith("topic:")) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(tbPageContext.getContext(), str.substring(6), str3, true, true, false, true, false)));
        } else if (str.startsWith("zb:")) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(tbPageContext.getContext(), tbPageContext.getString(z.kn_zhibo), str.substring(3), true, true, false, false, false)));
        } else if (str.startsWith("jctj:")) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902022, new DailyRecommendActivityConfig(tbPageContext.getContext(), null)));
        } else if (str.startsWith("list:")) {
            String substring = str.substring(5);
            if (!TextUtils.isEmpty(substring)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902028, new ForumRankActivityConfig(tbPageContext.getContext(), substring, str2)));
            }
        } else if (!str.startsWith("xiuba:")) {
            return false;
        } else {
            if (!UtilHelper.isNetOk()) {
                UtilHelper.showToast(tbPageContext.getContext(), z.neterror);
            } else {
                XiubaPlugin xiubaPlugin = (XiubaPlugin) PluginCenter.gX().hf();
                if (xiubaPlugin != null) {
                    xiubaPlugin.startXiuba(tbPageContext.getContext());
                }
            }
        }
        return true;
    }
}
