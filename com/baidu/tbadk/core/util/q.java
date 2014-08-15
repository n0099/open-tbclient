package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class q extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ae aeVar = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IN_PV_ADDRESS);
        aeVar.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, TbConfig.ST_TYPE_ENTER_FORE);
        aeVar.a("os_version", Build.VERSION.RELEASE);
        aeVar.a("subapp_type", "im");
        aeVar.h();
    }
}
