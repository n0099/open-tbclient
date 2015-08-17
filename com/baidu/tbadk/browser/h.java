package com.baidu.tbadk.browser;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class h implements ax.a {
    @Override // com.baidu.tbadk.core.util.ax.a
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        String str = strArr[0];
        String str2 = strArr.length > 2 ? strArr[2] : null;
        String str3 = strArr.length > 1 ? strArr[1] : null;
        if (!str.startsWith("opfeature:")) {
            if (!str.startsWith("web:")) {
                if (!str.startsWith("topic:")) {
                    if (!str.startsWith("zb:")) {
                        if (!str.startsWith("list:")) {
                            return false;
                        }
                        String substring = str.substring(5);
                        if (!TextUtils.isEmpty(substring)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_RANK, new ForumRankActivityConfig(tbPageContext.getPageActivity(), substring, str2)));
                        }
                    } else {
                        Static.c(tbPageContext, str.substring(3), tbPageContext.getString(i.C0057i.kn_zhibo), false, true, false, false);
                    }
                } else {
                    Static.c(tbPageContext, str3, str.substring(6), false, true, true, false);
                }
            } else {
                Static.c(tbPageContext, f.T(str.replaceFirst("web:", ""), str2), null, false, true, true, true);
            }
        } else {
            Static.c(tbPageContext, f.T(str.replaceFirst("opfeature:", ""), str2), null, false, true, true, true);
        }
        return true;
    }
}
