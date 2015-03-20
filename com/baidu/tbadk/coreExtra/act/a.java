package com.baidu.tbadk.coreExtra.act;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a {
    private static boolean aaj = false;
    public static l aak = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (aak == null && (runTask = MessageManager.getInstance().runTask(2001275, l.class)) != null && runTask.getData() != null) {
            aak = (l) runTask.getData();
        }
    }

    public static l um() {
        return aak;
    }

    public static boolean un() {
        return aaj;
    }

    public static void checkPassV6Switch() {
        if (Build.VERSION.SDK_INT < 9 || TbConfig.USE_OLD_LOGIN || !TbadkCoreApplication.m411getInst().isPassportV6ShouldOpen()) {
            aaj = true;
        } else if (Build.VERSION.SDK_INT <= 10) {
            if (UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m411getInst().getContext())) {
                TbadkCoreApplication.m411getInst().incPassportV6CrashCount();
                aaj = true;
                return;
            }
            aaj = false;
        } else {
            aaj = false;
        }
    }
}
