package com.baidu.tbadk.coreExtra.a;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a {
    public static Domain aqB = Domain.DOMAIN_ONLINE;
    private static boolean aqC = true;
    public static c aqD = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (aqD == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            aqD = (c) runTask.getData();
        }
    }

    public static c xo() {
        return aqD;
    }

    public static boolean xp() {
        return aqC;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            aqC = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                aqC = false;
            } else {
                aqC = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            aqC = false;
        } else {
            aqC = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !aqC && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
            aqC = true;
        }
    }
}
