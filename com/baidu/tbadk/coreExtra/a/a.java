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
    public static Domain apP = Domain.DOMAIN_ONLINE;
    private static boolean apQ = true;
    public static c apR = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (apR == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            apR = (c) runTask.getData();
        }
    }

    public static c xg() {
        return apR;
    }

    public static boolean xh() {
        return apQ;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            apQ = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                apQ = false;
            } else {
                apQ = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            apQ = false;
        } else {
            apQ = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !apQ && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
            apQ = true;
        }
    }
}
