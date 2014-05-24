package com.baidu.tbadk.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.as;
import com.baidu.tbadk.core.atomData.at;
import com.baidu.tbadk.core.atomData.au;
import com.baidu.tbadk.core.atomData.m;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class f {
    public static boolean a(Context context, String str) {
        if (str != null) {
            try {
                if (str.contains("jump=outer")) {
                    com.baidu.tbadk.browser.a.c(context, str);
                    return true;
                }
            } catch (Exception e) {
                BdLog.e(f.class.getName(), "jumpTiebaNative", e.getMessage());
            }
        }
        if (str != null && str.contains("jump=finish_this_page") && (context instanceof BaseActivity)) {
            ((BaseActivity) context).finish();
            return true;
        }
        if (str != null && str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE)) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfig.DAILY_CLASSICLA_CUSTOM_CMD, new com.baidu.tbadk.core.atomData.g(context)));
                return true;
            } else if (str.contains("jump_personalCenter=1") && str.contains("userid=") && str.contains("un=")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003003, new at(context, a(str, "userid="), a(str, "un="))));
                return true;
            } else if (str.contains("jump_chat=1")) {
                String a = a(str, "userid=");
                String a2 = a(str, "username=");
                String a3 = a(str, "portrait=");
                if (a != null && a.length() > 0) {
                    try {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003005, new au(context, Long.parseLong(a), a2, a3, 0)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2010012));
                }
                return true;
            } else if (str.contains("kz=")) {
                String a4 = a(str, "kz=");
                if (a4 != null && a4.length() >= 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2006001, new as(context).a(a4, null, "allthread")));
                }
                return true;
            } else if (str.contains("kw=")) {
                String a5 = a(str, "kw=");
                if (a5 != null && a5.length() >= 0) {
                    if (context instanceof BaseActivity) {
                        ((BaseActivity) context).sendMessage(new CustomMessage(2005000, new m(context).a(a5, "allthread")));
                    } else if (context instanceof BaseFragmentActivity) {
                        ((BaseFragmentActivity) context).a(new CustomMessage(2005000, new m(context).a(a5, "allthread")));
                    }
                }
                return true;
            } else if (str.contains("jumptologin=1") && (context instanceof Activity)) {
                LoginActivity.a((Activity) context, "", true, 0);
                return true;
            } else if (str.contains("jumptobubble_list") && (context instanceof Activity)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.e(context)));
                return true;
            } else if (str.contains("pay=1") && (context instanceof Activity)) {
                ((Activity) context).finish();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfig.BUBBLE_LIST_REFRESH));
            }
        }
        return false;
    }

    public static String a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            int length = str2.length() + indexOf;
            int i = length;
            while (i < str.length() && str.charAt(i) != '&') {
                i++;
            }
            return URLDecoder.decode(str.substring(length, i));
        }
        return "";
    }
}
