package com.baidu.tbadk.coreExtra.act;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a {
    private static boolean abm = false;
    public static l abn = null;

    public static void init() {
        CustomResponsedMessage runTask;
        if (abn == null && (runTask = MessageManager.getInstance().runTask(2001275, l.class)) != null && runTask.getData() != null) {
            abn = (l) runTask.getData();
        }
    }

    public static l uV() {
        return abn;
    }

    public static boolean uW() {
        return abm;
    }

    public static void checkPassV6Switch() {
        if (Build.VERSION.SDK_INT < 9 || TbConfig.USE_OLD_LOGIN || !TbadkCoreApplication.m411getInst().isPassportV6ShouldOpen()) {
            abm = true;
        } else if (Build.VERSION.SDK_INT <= 10) {
            if (UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m411getInst().getContext())) {
                TbadkCoreApplication.m411getInst().incPassportV6CrashCount();
                abm = true;
                return;
            }
            abm = false;
        } else {
            abm = false;
        }
    }
}
