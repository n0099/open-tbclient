package com.baidu.tbadk.core.diskCache;

import android.content.Intent;
import android.os.Handler;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.h.i;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ImagesInvalidServiceStatic {
    private static boolean WA = false;
    private static Handler hi = new a();

    static {
        MessageManager.getInstance().registerListener(new b(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startService() {
        i.c(BdBaseApplication.getInst().getContext(), new Intent(BdBaseApplication.getInst().getContext(), ImagesInvalidService.class));
    }

    public static void stopService() {
        i.d(BdBaseApplication.getInst().getContext(), new Intent(BdBaseApplication.getInst().getContext(), ImagesInvalidService.class));
    }

    public static void ax(boolean z) {
        WA = z;
    }
}
