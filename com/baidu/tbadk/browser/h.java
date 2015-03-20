package com.baidu.tbadk.browser;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.plugins.XiubaPlugin;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class h implements bm {
    @Override // com.baidu.tbadk.core.util.bm
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        boolean b;
        XiubaPlugin xiubaPlugin;
        String str = strArr[0];
        String str2 = strArr.length > 2 ? strArr[2] : null;
        String str3 = strArr.length > 1 ? strArr[1] : null;
        if (str.startsWith("opfeature:")) {
            f.x(tbPageContext.getPageActivity(), f.P(str.replaceFirst("opfeature:", ""), str2));
        } else if (str.startsWith("web:")) {
            f.x(tbPageContext.getPageActivity(), f.P(str.replaceFirst("web:", ""), str2));
        } else if (str.startsWith("topic:")) {
            f.a(tbPageContext.getPageActivity(), str.substring(6), str3, true, true, false);
        } else if (str.startsWith("zb:")) {
            f.a(tbPageContext.getPageActivity(), tbPageContext.getString(y.kn_zhibo), str.substring(3), true, false, false);
        } else if (str.startsWith("list:")) {
            String substring = str.substring(5);
            if (!TextUtils.isEmpty(substring)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902028, new ForumRankActivityConfig(tbPageContext.getPageActivity(), substring, str2)));
            }
        } else if (!str.startsWith("xiuba:")) {
            return false;
        } else {
            if (!UtilHelper.isNetOk()) {
                UtilHelper.showToast(tbPageContext.getPageActivity(), y.neterror);
            } else {
                b = Static.b(tbPageContext);
                if (b && (xiubaPlugin = (XiubaPlugin) PluginCenter.getInstance().getXiubaClassInstance()) != null) {
                    xiubaPlugin.startXiuba(tbPageContext.getPageActivity());
                }
            }
        }
        return true;
    }
}
