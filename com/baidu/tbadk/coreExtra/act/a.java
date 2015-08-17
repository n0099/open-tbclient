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
    private static boolean agp = false;
    public static l agq = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (agq == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, l.class)) != null && runTask.getData() != null) {
            agq = (l) runTask.getData();
        }
    }

    public static l vZ() {
        return agq;
    }

    public static boolean wa() {
        return agp;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            agp = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.m411getInst().isLowVersionPassV6ShouldOpen()) {
                agp = false;
            } else {
                agp = true;
            }
        } else if (TbadkCoreApplication.m411getInst().isPassportV6ShouldOpen()) {
            agp = false;
        } else {
            agp = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !agp && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m411getInst().getContext())) {
            TbadkCoreApplication.m411getInst().incPassportV6CrashCount();
            agp = true;
        }
    }
}
