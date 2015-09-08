package com.baidu.tbadk.coreExtra.act;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a {
    private static boolean agz = false;
    public static l agA = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (agA == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, l.class)) != null && runTask.getData() != null) {
            agA = (l) runTask.getData();
        }
    }

    public static l we() {
        return agA;
    }

    public static boolean wf() {
        return agz;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            agz = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.m411getInst().isLowVersionPassV6ShouldOpen()) {
                agz = false;
            } else {
                agz = true;
            }
        } else if (TbadkCoreApplication.m411getInst().isPassportV6ShouldOpen()) {
            agz = false;
        } else {
            agz = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !agz && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m411getInst().getContext())) {
            TbadkCoreApplication.m411getInst().incPassportV6CrashCount();
            agz = true;
        }
    }
}
