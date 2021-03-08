package com.baidu.live.tbadk.coreextra.act;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sapi2.utils.enums.Domain;
/* loaded from: classes10.dex */
public class AccountCoreSetting {
    private static final int LOGIN_SDK_VERSION = 9;
    public static Domain PASS_LOGIN_ADDRESS = Domain.DOMAIN_ONLINE;
    private static boolean mIsUseOldLogin = true;
    public static IPassManager mIPassManager = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (mIPassManager == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, IPassManager.class)) != null && runTask.getData() != null) {
            mIPassManager = (IPassManager) runTask.getData();
        }
    }

    public static IPassManager getPassManager() {
        return mIPassManager;
    }

    public static boolean getIsUseOldLogin() {
        return mIsUseOldLogin;
    }

    public static void setIsUseOldLogin(boolean z) {
        mIsUseOldLogin = z;
    }

    public static void checkPassV6Switch() {
    }
}
