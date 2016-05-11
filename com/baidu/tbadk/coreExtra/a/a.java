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
    private static boolean afp = true;
    public static c afq = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (afq == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            afq = (c) runTask.getData();
        }
    }

    public static c wg() {
        return afq;
    }

    public static boolean wh() {
        return afp;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            afp = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.m11getInst().isLowVersionPassV6ShouldOpen()) {
                afp = false;
            } else {
                afp = true;
            }
        } else if (TbadkCoreApplication.m11getInst().isPassportV6ShouldOpen()) {
            afp = false;
        } else {
            afp = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !afp && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m11getInst().getContext())) {
            TbadkCoreApplication.m11getInst().incPassportV6CrashCount();
            afp = true;
        }
    }
}
