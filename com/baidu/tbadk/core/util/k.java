package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class k extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IN_PV_ADDRESS);
        aaVar.p("st_type", TbConfig.ST_TYPE_ENTER_FORE);
        aaVar.p("os_version", Build.VERSION.RELEASE);
        aaVar.p("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
        aaVar.uZ();
    }
}
