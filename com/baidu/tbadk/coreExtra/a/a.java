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
    private static boolean afN = true;
    public static c afO = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (afO == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            afO = (c) runTask.getData();
        }
    }

    public static c vX() {
        return afO;
    }

    public static boolean vY() {
        return afN;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            afN = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.m411getInst().isLowVersionPassV6ShouldOpen()) {
                afN = false;
            } else {
                afN = true;
            }
        } else if (TbadkCoreApplication.m411getInst().isPassportV6ShouldOpen()) {
            afN = false;
        } else {
            afN = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !afN && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m411getInst().getContext())) {
            TbadkCoreApplication.m411getInst().incPassportV6CrashCount();
            afN = true;
        }
    }
}
