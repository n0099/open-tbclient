package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class q extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ad adVar = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IN_PV_ADDRESS);
        adVar.o("st_type", TbConfig.ST_TYPE_ENTER_FORE);
        adVar.o("os_version", Build.VERSION.RELEASE);
        adVar.o("subapp_type", "im");
        adVar.oy();
    }
}
