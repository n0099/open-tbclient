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
    public static Domain aop = Domain.DOMAIN_ONLINE;
    private static boolean aoq = true;
    public static c aor = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (aor == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            aor = (c) runTask.getData();
        }
    }

    public static c xU() {
        return aor;
    }

    public static boolean xV() {
        return aoq;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            aoq = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.m9getInst().isLowVersionPassV6ShouldOpen()) {
                aoq = false;
            } else {
                aoq = true;
            }
        } else if (TbadkCoreApplication.m9getInst().isPassportV6ShouldOpen()) {
            aoq = false;
        } else {
            aoq = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !aoq && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m9getInst().getContext())) {
            TbadkCoreApplication.m9getInst().incPassportV6CrashCount();
            aoq = true;
        }
    }
}
