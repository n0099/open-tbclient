package com.baidu.tbadk.coreExtra.a;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a {
    private static boolean afQ = true;
    public static c afR = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (afR == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            afR = (c) runTask.getData();
        }
    }

    public static c wk() {
        return afR;
    }

    public static boolean wl() {
        return afQ;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            afQ = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.m9getInst().isLowVersionPassV6ShouldOpen()) {
                afQ = false;
            } else {
                afQ = true;
            }
        } else if (TbadkCoreApplication.m9getInst().isPassportV6ShouldOpen()) {
            afQ = false;
        } else {
            afQ = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !afQ && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m9getInst().getContext())) {
            TbadkCoreApplication.m9getInst().incPassportV6CrashCount();
            afQ = true;
        }
    }
}
