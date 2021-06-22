package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.n0.b.d;
import d.a.n0.r.q.r0;
/* loaded from: classes3.dex */
public class DialogLoginHelper {
    public static final String DIALOG_TYPE_ONE_KEY = "yijiandenglu";
    public static final String DIALOG_TYPE_SHARE = "hutongdenglu";
    public static final String FULL_SCREEN_TYPE_ONE_KEY = "yijiandenglu_2";
    public static final String FULL_SCREEN_TYPE_SHARE = "hutongdenglu_2";

    public static void addLoginDialogInvokeLog(String str, String str2) {
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOGIN_DIALOG_INVOKE);
        statisticItem.param("obj_locate", str);
        statisticItem.param("obj_type", str2);
        TiebaStatic.log(statisticItem);
    }

    public static void addLoginDialogSuccessLog(String str, String str2, String str3) {
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOGIN_DIALOG_SUCCESS);
        statisticItem.param("obj_locate", str);
        statisticItem.param("obj_type", str2);
        statisticItem.param("obj_source", str3);
        TiebaStatic.log(statisticItem);
    }

    public static boolean checkUpIsLogin(r0 r0Var) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            skipToLoginDialogActivity(r0Var);
        }
        return isLogin;
    }

    public static String getOneKeyLoginActivityLocate() {
        return d.k() ? "new_start_1" : d.l() ? "new_start_2" : "";
    }

    public static void skipToLoginDialogActivity(r0 r0Var) {
        if (r0Var != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921530, r0Var));
        }
    }
}
