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
    public static Domain bgN = Domain.DOMAIN_ONLINE;
    private static boolean bgO = true;
    public static c bgP = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (bgP == null && (runTask = MessageManager.getInstance().runTask(2001268, c.class)) != null && runTask.getData() != null) {
            bgP = (c) runTask.getData();
        }
    }

    public static c Fa() {
        return bgP;
    }

    public static boolean Fb() {
        return bgO;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            bgO = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                bgO = false;
            } else {
                bgO = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            bgO = false;
        } else {
            bgO = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !bgO && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
            bgO = true;
        }
    }
}
