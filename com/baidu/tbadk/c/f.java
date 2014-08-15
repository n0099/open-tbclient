package com.baidu.tbadk.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ba;
import com.baidu.tbadk.core.atomData.bb;
import com.baidu.tbadk.core.atomData.bg;
import com.baidu.tbadk.core.atomData.bj;
import com.baidu.tbadk.core.atomData.i;
import com.baidu.tbadk.core.atomData.s;
import com.baidu.tbadk.core.atomData.v;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.x;
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
                BdLog.e(e.getMessage());
            }
        }
        if (str != null && str.contains("jump=finish_this_page") && (context instanceof BaseActivity)) {
            ((BaseActivity) context).finish();
            return true;
        }
        if (str != null && str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE)) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2010021, new i(context)));
                return true;
            } else if (str.contains("jump_personalCenter=1") && str.contains("userid=") && str.contains("un=")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new bg(context, a(str, "userid="), a(str, "un="))));
                return true;
            } else if (str.contains("jump_chat=1")) {
                String a = a(str, "userid=");
                String a2 = a(str, "username=");
                String a3 = a(str, "portrait=");
                if (a != null && a.length() > 0) {
                    try {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new bj(context, Long.parseLong(a), a2, a3, 0)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2008012));
                }
                return true;
            } else if (str.contains("jump_official_chat=1")) {
                String a4 = a(str, "barid=");
                String a5 = a(str, "barname=");
                String a6 = a(str, "portrait=");
                if (a4 != null && a4.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new ba(context, com.baidu.adp.lib.e.b.a(a4, 0L), a5, a6, 0)));
                }
                return true;
            } else if (str.contains("kz=")) {
                String a7 = a(str, "kz=");
                if (a7 != null && a7.length() >= 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new bb(context).a(a7, null, "allthread")));
                }
                return true;
            } else if (str.contains("kw=")) {
                String a8 = a(str, "kw=");
                if (a8 != null && a8.length() >= 0) {
                    if (context instanceof BaseActivity) {
                        ((BaseActivity) context).sendMessage(new CustomMessage(2003000, new s(context).a(a8, "allthread")));
                    } else if (context instanceof BaseFragmentActivity) {
                        ((BaseFragmentActivity) context).a(new CustomMessage(2003000, new s(context).a(a8, "allthread")));
                    }
                }
                return true;
            } else if (str.contains("jumptologin=1") && (context instanceof Activity)) {
                LoginActivity.a((Activity) context, "", true, 0);
                return true;
            } else if (str.contains("jumptobubble_list") && (context instanceof Activity)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.f(context)));
                return true;
            } else {
                if (str.contains("pay=1") && (context instanceof Activity)) {
                    UtilHelper.showToast(context, x.buy_sucess);
                    ((Activity) context).finish();
                }
                if (str.contains("jumpstartgame=1")) {
                    String a9 = a(str, "gameId=");
                    String a10 = a(str, "packageName=");
                    String a11 = a(str, "launcherActivity=");
                    if (!TextUtils.isEmpty(a9) && !TextUtils.isEmpty(a10) && !TextUtils.isEmpty(a11)) {
                        if (UtilHelper.isInstallApk(context, a10) && UtilHelper.startApk(context, a10, a11)) {
                            ((Activity) context).finish();
                            return true;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new v(context, a9)));
                    }
                    ((Activity) context).finish();
                    return true;
                }
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
