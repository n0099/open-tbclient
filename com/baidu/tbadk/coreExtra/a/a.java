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
    private static boolean ajz = true;
    public static c ajA = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (ajA == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            ajA = (c) runTask.getData();
        }
    }

    public static c xo() {
        return ajA;
    }

    public static boolean xp() {
        return ajz;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            ajz = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.m9getInst().isLowVersionPassV6ShouldOpen()) {
                ajz = false;
            } else {
                ajz = true;
            }
        } else if (TbadkCoreApplication.m9getInst().isPassportV6ShouldOpen()) {
            ajz = false;
        } else {
            ajz = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !ajz && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m9getInst().getContext())) {
            TbadkCoreApplication.m9getInst().incPassportV6CrashCount();
            ajz = true;
        }
    }
}
