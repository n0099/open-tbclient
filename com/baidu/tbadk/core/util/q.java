package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class q extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ac acVar = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IN_PV_ADDRESS);
        acVar.k("st_type", TbConfig.ST_TYPE_ENTER_FORE);
        acVar.k("os_version", Build.VERSION.RELEASE);
        acVar.k("subapp_type", "im");
        acVar.lA();
    }
}
