package com.baidu.tbadk.core.diskCache;

import android.content.Intent;
import android.os.Handler;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.g.j;
/* loaded from: classes.dex */
public class ImagesInvalidServiceStatic {
    private static boolean Ss = false;
    private static Handler oy = new b();

    static {
        MessageManager.getInstance().registerListener(new c(2001011));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startService() {
        j.f(BdBaseApplication.getInst().getContext(), new Intent(BdBaseApplication.getInst().getContext(), ImagesInvalidService.class));
    }

    public static void stopService() {
        j.g(BdBaseApplication.getInst().getContext(), new Intent(BdBaseApplication.getInst().getContext(), ImagesInvalidService.class));
    }

    public static void al(boolean z) {
        Ss = z;
    }
}
