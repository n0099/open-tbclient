package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class j extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        y yVar = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IN_PV_ADDRESS);
        yVar.n("st_type", TbConfig.ST_TYPE_ENTER_FORE);
        yVar.n("os_version", Build.VERSION.RELEASE);
        yVar.n("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
        yVar.ud();
    }
}
