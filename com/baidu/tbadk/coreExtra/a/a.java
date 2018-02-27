package com.baidu.tbadk.coreExtra.a;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a {
    public static Domain bgB = Domain.DOMAIN_ONLINE;
    private static boolean bgC = true;
    public static c bgD = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (bgD == null && (runTask = MessageManager.getInstance().runTask(2001268, c.class)) != null && runTask.getData() != null) {
            bgD = (c) runTask.getData();
        }
    }

    public static c EZ() {
        return bgD;
    }

    public static boolean Fa() {
        return bgC;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            bgC = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                bgC = false;
            } else {
                bgC = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            bgC = false;
        } else {
            bgC = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !bgC && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
            bgC = true;
        }
    }
}
