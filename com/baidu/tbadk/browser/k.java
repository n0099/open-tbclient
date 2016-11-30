package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements bf.a {
    @Override // com.baidu.tbadk.core.util.bf.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        Bundle gE;
        if (tbPageContext == null || strArr == null || strArr.length == 0) {
            return 3;
        }
        String str = strArr[0];
        if (StringUtils.isNull(str)) {
            return 3;
        }
        str.toLowerCase();
        String str2 = strArr.length > 2 ? strArr[2] : null;
        String str3 = strArr.length > 1 ? strArr[1] : null;
        if (str.startsWith("tel:")) {
            UtilHelper.callPhone(tbPageContext.getPageActivity(), str.substring(4));
            return 0;
        } else if (str.startsWith("sms:")) {
            String substring = str.substring(4);
            String str4 = "";
            if (str.contains("body=")) {
                str4 = com.baidu.tbadk.util.x.at(str, "body=");
                substring = substring.substring(0, substring.indexOf("?") - 1);
            }
            UtilHelper.smsTo(tbPageContext.getPageActivity(), substring, str4);
            return 0;
        } else if (str.contains("jump=outer")) {
            f.w(tbPageContext.getPageActivity(), str);
            return 1;
        } else if (str.contains("jump=finish_this_page") && tbPageContext.getPageActivity() != null) {
            tbPageContext.getPageActivity().finish();
            return 1;
        } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("pay=1") && (tbPageContext instanceof Activity)) {
            UtilHelper.showToast(tbPageContext.getPageActivity(), r.j.buy_sucess);
            ((Activity) tbPageContext).finish();
            return 0;
        } else if (str.startsWith("tieba://focusforum")) {
            TbadkCoreApplication.m9getInst().setLikeBarChanged(true);
            return 0;
        } else if (str.startsWith("baiduxiuba://")) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
            tbPageContext.getPageActivity().startActivity(intent);
            return 0;
        } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("bunding_phone=1")) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_TDOU_PAY_BUNDING_PHONE, com.baidu.tbadk.util.x.at(str, "bindid=")));
            tbPageContext.getPageActivity().finish();
            return 1;
        } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("/changeyinjisuccess") && (gE = com.baidu.tbadk.util.x.gE(str)) != null && "/changeyinjisuccess".equalsIgnoreCase(gE.getString("path"))) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_YINJIN_CHANGE));
            return 0;
        } else {
            if (!str.startsWith("opfeature:")) {
                if (!str.startsWith("web:")) {
                    if (!str.startsWith("topic:")) {
                        if (!str.startsWith("zb:")) {
                            if (!str.startsWith("list:")) {
                                return 3;
                            }
                            String substring2 = str.substring(5);
                            if (!TextUtils.isEmpty(substring2)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_RANK, new ForumRankActivityConfig(tbPageContext.getPageActivity(), substring2, str2)));
                            }
                        } else {
                            Static.c(tbPageContext, str.substring(3), tbPageContext.getString(r.j.kn_zhibo), false, true, false, false);
                        }
                    } else {
                        Static.c(tbPageContext, str3, str.substring(6), false, true, true, false);
                    }
                } else {
                    Static.c(tbPageContext, f.L(str.replaceFirst("web:", ""), str2), null, false, true, true, true);
                }
            } else {
                Static.c(tbPageContext, f.L(str.replaceFirst("opfeature:", ""), str2), null, false, true, true, true);
            }
            return 3;
        }
    }
}
