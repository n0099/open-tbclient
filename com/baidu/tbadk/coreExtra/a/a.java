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
    private static boolean ajD = true;
    public static c ajE = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (ajE == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            ajE = (c) runTask.getData();
        }
    }

    public static c yn() {
        return ajE;
    }

    public static boolean yo() {
        return ajD;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            ajD = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.m411getInst().isLowVersionPassV6ShouldOpen()) {
                ajD = false;
            } else {
                ajD = true;
            }
        } else if (TbadkCoreApplication.m411getInst().isPassportV6ShouldOpen()) {
            ajD = false;
        } else {
            ajD = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !ajD && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m411getInst().getContext())) {
            TbadkCoreApplication.m411getInst().incPassportV6CrashCount();
            ajD = true;
        }
    }
}
