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
    public static Domain aAZ = Domain.DOMAIN_ONLINE;
    private static boolean aBa = true;
    public static c aBb = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (aBb == null && (runTask = MessageManager.getInstance().runTask(2001268, c.class)) != null && runTask.getData() != null) {
            aBb = (c) runTask.getData();
        }
    }

    public static c Bu() {
        return aBb;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            aBa = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                aBa = false;
            } else {
                aBa = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            aBa = false;
        } else {
            aBa = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !aBa && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
            aBa = true;
        }
    }
}
