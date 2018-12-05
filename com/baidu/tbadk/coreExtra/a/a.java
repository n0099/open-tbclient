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
    public static Domain aMX = Domain.DOMAIN_ONLINE;
    private static boolean aMY = true;
    public static c aMZ = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (aMZ == null && (runTask = MessageManager.getInstance().runTask(2001268, c.class)) != null && runTask.getData() != null) {
            aMZ = (c) runTask.getData();
        }
    }

    public static c FZ() {
        return aMZ;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            aMY = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                aMY = false;
            } else {
                aMY = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            aMY = false;
        } else {
            aMY = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !aMY && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
            aMY = true;
        }
    }
}
