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
    public static Domain aJx = Domain.DOMAIN_ONLINE;
    private static boolean aJy = true;
    public static c aJz = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (aJz == null && (runTask = MessageManager.getInstance().runTask(2001268, c.class)) != null && runTask.getData() != null) {
            aJz = (c) runTask.getData();
        }
    }

    public static c EV() {
        return aJz;
    }

    public static void checkPassV6Switch() {
        if (TbConfig.USE_OLD_LOGIN) {
            aJy = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                aJy = false;
            } else {
                aJy = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            aJy = false;
        } else {
            aJy = true;
        }
        if (Build.VERSION.SDK_INT <= 10 && !aJy && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
            aJy = true;
        }
    }
}
