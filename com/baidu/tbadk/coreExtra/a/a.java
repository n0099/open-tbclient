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
    public static Domain aBc = Domain.DOMAIN_ONLINE;
    private static boolean aBd = true;
    public static c aBe = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (aBe == null && (runTask = MessageManager.getInstance().runTask(2001268, c.class)) != null && runTask.getData() != null) {
            aBe = (c) runTask.getData();
        }
    }

    public static c Bx() {
        return aBe;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            aBd = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                aBd = false;
            } else {
                aBd = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            aBd = false;
        } else {
            aBd = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !aBd && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
            aBd = true;
        }
    }
}
