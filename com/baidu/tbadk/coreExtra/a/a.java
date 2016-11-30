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
    public static Domain ajT = Domain.DOMAIN_ONLINE;
    private static boolean ajU = true;
    public static c ajV = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (ajV == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            ajV = (c) runTask.getData();
        }
    }

    public static c xv() {
        return ajV;
    }

    public static boolean xw() {
        return ajU;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            ajU = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.m9getInst().isLowVersionPassV6ShouldOpen()) {
                ajU = false;
            } else {
                ajU = true;
            }
        } else if (TbadkCoreApplication.m9getInst().isPassportV6ShouldOpen()) {
            ajU = false;
        } else {
            ajU = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !ajU && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m9getInst().getContext())) {
            TbadkCoreApplication.m9getInst().incPassportV6CrashCount();
            ajU = true;
        }
    }
}
