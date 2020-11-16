package com.baidu.tbadk.coreExtra.a;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a {
    public static Domain PASS_LOGIN_ADDRESS = Domain.DOMAIN_ONLINE;
    private static boolean mIsUseOldLogin = true;
    public static c fbh = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (fbh == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            fbh = (c) runTask.getData();
        }
    }

    public static c btw() {
        return fbh;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            mIsUseOldLogin = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                mIsUseOldLogin = false;
            } else {
                mIsUseOldLogin = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            mIsUseOldLogin = false;
        } else {
            mIsUseOldLogin = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !mIsUseOldLogin && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
            mIsUseOldLogin = true;
        }
    }
}
