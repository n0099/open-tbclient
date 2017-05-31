package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class j extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IN_PV_ADDRESS);
        zVar.n("st_type", TbConfig.ST_TYPE_ENTER_FORE);
        zVar.n("os_version", Build.VERSION.RELEASE);
        zVar.n("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
        zVar.ug();
    }
}
