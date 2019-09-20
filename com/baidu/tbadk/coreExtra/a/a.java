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
    public static Domain cge = Domain.DOMAIN_ONLINE;
    private static boolean cgf = true;
    public static c cgg = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (cgg == null && (runTask = MessageManager.getInstance().runTask(2001268, c.class)) != null && runTask.getData() != null) {
            cgg = (c) runTask.getData();
        }
    }

    public static c alW() {
        return cgg;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            cgf = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                cgf = false;
            } else {
                cgf = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            cgf = false;
        } else {
            cgf = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !cgf && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
            cgf = true;
        }
    }
}
