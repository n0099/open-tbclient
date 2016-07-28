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
    private static boolean agF = true;
    public static c agG = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (agG == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            agG = (c) runTask.getData();
        }
    }

    public static c wk() {
        return agG;
    }

    public static boolean wl() {
        return agF;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            agF = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.m10getInst().isLowVersionPassV6ShouldOpen()) {
                agF = false;
            } else {
                agF = true;
            }
        } else if (TbadkCoreApplication.m10getInst().isPassportV6ShouldOpen()) {
            agF = false;
        } else {
            agF = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !agF && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m10getInst().getContext())) {
            TbadkCoreApplication.m10getInst().incPassportV6CrashCount();
            agF = true;
        }
    }
}
