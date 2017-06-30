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
    public static Domain ape = Domain.DOMAIN_ONLINE;
    private static boolean apf = true;
    public static c apg = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (apg == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            apg = (c) runTask.getData();
        }
    }

    public static c xt() {
        return apg;
    }

    public static boolean xu() {
        return apf;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            apf = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.m9getInst().isLowVersionPassV6ShouldOpen()) {
                apf = false;
            } else {
                apf = true;
            }
        } else if (TbadkCoreApplication.m9getInst().isPassportV6ShouldOpen()) {
            apf = false;
        } else {
            apf = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !apf && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m9getInst().getContext())) {
            TbadkCoreApplication.m9getInst().incPassportV6CrashCount();
            apf = true;
        }
    }
}
