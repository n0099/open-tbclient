package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class m extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IN_PV_ADDRESS);
        aaVar.o("st_type", TbConfig.ST_TYPE_ENTER_FORE);
        aaVar.o("os_version", Build.VERSION.RELEASE);
        aaVar.sw();
    }
}
