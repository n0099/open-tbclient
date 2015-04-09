package com.baidu.tbadk.coreExtra.act;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a {
    private static boolean aal = false;
    public static l aam = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (aam == null && (runTask = MessageManager.getInstance().runTask(2001275, l.class)) != null && runTask.getData() != null) {
            aam = (l) runTask.getData();
        }
    }

    public static l um() {
        return aam;
    }

    public static boolean un() {
        return aal;
    }

    public static void checkPassV6Switch() {
        if (Build.VERSION.SDK_INT < 9 || TbConfig.USE_OLD_LOGIN || !TbadkCoreApplication.m411getInst().isPassportV6ShouldOpen()) {
            aal = true;
        } else if (Build.VERSION.SDK_INT <= 10) {
            if (UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m411getInst().getContext())) {
                TbadkCoreApplication.m411getInst().incPassportV6CrashCount();
                aal = true;
                return;
            }
            aal = false;
        } else {
            aal = false;
        }
    }
}
