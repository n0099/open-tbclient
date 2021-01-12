package com.baidu.live.tbadk.core.util;

import android.content.Context;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.RegisterActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes10.dex */
public class ViewHelper {
    public static void skipToRegisterActivity(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(context, 3, true)));
        }
    }

    @Deprecated
    public static void skipToLoginActivity(Context context) {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN));
    }

    public static void skipToLoginActivity() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN));
    }

    public static boolean checkUpIsLogin(Context context) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            skipToLoginActivity(context);
        }
        return isLogin;
    }

    public static void setGroupTextColor(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                textView.setTextColor(-11446171);
            } else {
                textView.setTextColor(-5065030);
            }
        }
    }
}
