package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class v extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        an anVar = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IN_PV_ADDRESS);
        anVar.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, TbConfig.ST_TYPE_ENTER_FORE);
        anVar.a("os_version", Build.VERSION.RELEASE);
        anVar.a("subapp_type", "im");
        anVar.i();
    }
}
