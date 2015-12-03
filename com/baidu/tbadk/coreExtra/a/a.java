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
    private static boolean ahx = true;
    public static c ahy = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (ahy == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            ahy = (c) runTask.getData();
        }
    }

    public static c wP() {
        return ahy;
    }

    public static boolean wQ() {
        return ahx;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            ahx = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.m411getInst().isLowVersionPassV6ShouldOpen()) {
                ahx = false;
            } else {
                ahx = true;
            }
        } else if (TbadkCoreApplication.m411getInst().isPassportV6ShouldOpen()) {
            ahx = false;
        } else {
            ahx = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !ahx && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m411getInst().getContext())) {
            TbadkCoreApplication.m411getInst().incPassportV6CrashCount();
            ahx = true;
        }
    }
}
