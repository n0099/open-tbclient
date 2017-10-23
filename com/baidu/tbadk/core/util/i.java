package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class i extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.IN_PV_ADDRESS);
        xVar.n("st_type", TbConfig.ST_TYPE_ENTER_FORE);
        xVar.n("os_version", Build.VERSION.RELEASE);
        xVar.n("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
        xVar.ui();
    }
}
