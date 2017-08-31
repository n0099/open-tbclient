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
    public static Domain aqW = Domain.DOMAIN_ONLINE;
    private static boolean aqX = true;
    public static c aqY = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (aqY == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_PASS_MANAGER, c.class)) != null && runTask.getData() != null) {
            aqY = (c) runTask.getData();
        }
    }

    public static c xO() {
        return aqY;
    }

    public static boolean xP() {
        return aqX;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            aqX = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                aqX = false;
            } else {
                aqX = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            aqX = false;
        } else {
            aqX = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !aqX && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
            aqX = true;
        }
    }
}
