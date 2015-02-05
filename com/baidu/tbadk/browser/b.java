package com.baidu.tbadk.browser;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.DailyRecommendActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bo;
import com.baidu.tbadk.plugins.XiubaPlugin;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class b implements bo {
    @Override // com.baidu.tbadk.core.util.bo
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str = strArr[0];
        if (StringUtils.isNull(str) || tbPageContext == null) {
            return false;
        }
        String str2 = strArr.length > 2 ? strArr[2] : null;
        String str3 = strArr.length > 1 ? strArr[1] : null;
        if (str.startsWith("opfeature:")) {
            a.x(tbPageContext.getContext(), a.M(str.replaceFirst("opfeature:", ""), str2));
        } else if (str.startsWith("web:")) {
            a.x(tbPageContext.getContext(), a.M(str.replaceFirst("web:", ""), str2));
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
        } else if (str.startsWith("xiuba:")) {
            if (!UtilHelper.isNetOk()) {
                UtilHelper.showToast(tbPageContext.getContext(), z.neterror);
            } else {
                XiubaPlugin xiubaPlugin = (XiubaPlugin) PluginCenter.getInstance().getXiubaClassInstance();
                if (xiubaPlugin != null) {
                    xiubaPlugin.startXiuba(tbPageContext.getContext());
                }
            }
        } else if (!str.startsWith("tbdou:")) {
            return false;
        } else {
            String str4 = "";
            String substring2 = str.substring("tbdou:".length());
            if (!StringUtils.isNull(substring2)) {
                if (substring2.contains(",")) {
                    String[] split = substring2.split(",");
                    r6 = split.length >= 1 ? com.baidu.adp.lib.g.c.toInt(split[0], 0) : 0;
                    if (split.length >= 2 && !StringUtils.isNull(split[1])) {
                        str4 = split[1];
                    }
                } else {
                    r6 = com.baidu.adp.lib.g.c.toInt(substring2, 0);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(tbPageContext.getPageActivity(), r6, str4)));
        }
        return true;
    }
}
