package com.baidu.tbadk.core.diskCache;

import android.content.Intent;
import android.os.Handler;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.g.i;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a {
    private static boolean aaQ = false;
    private static Handler oA = new b();

    /* JADX INFO: Access modifiers changed from: private */
    public static void startService() {
        i.h(BdBaseApplication.getInst().getContext(), new Intent(BdBaseApplication.getInst().getContext(), ImagesInvalidService.class));
    }

    public static void stopService() {
        i.i(BdBaseApplication.getInst().getContext(), new Intent(BdBaseApplication.getInst().getContext(), ImagesInvalidService.class));
    }

    public static void az(boolean z) {
        aaQ = z;
    }

    public static void init() {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
    }
}
