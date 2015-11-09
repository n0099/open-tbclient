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
    private static boolean afS = true;
    public static c afT = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (afT == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            afT = (c) runTask.getData();
        }
    }

    public static c vY() {
        return afT;
    }

    public static boolean vZ() {
        return afS;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            afS = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.m411getInst().isLowVersionPassV6ShouldOpen()) {
                afS = false;
            } else {
                afS = true;
            }
        } else if (TbadkCoreApplication.m411getInst().isPassportV6ShouldOpen()) {
            afS = false;
        } else {
            afS = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !afS && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m411getInst().getContext())) {
            TbadkCoreApplication.m411getInst().incPassportV6CrashCount();
            afS = true;
        }
    }
}
