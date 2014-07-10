package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class x extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        aq aqVar = new aq(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IN_PV_ADDRESS);
        aqVar.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, TbConfig.ST_TYPE_ENTER_FORE);
        aqVar.a("os_version", Build.VERSION.RELEASE);
        aqVar.a("subapp_type", "im");
        aqVar.i();
    }
}
