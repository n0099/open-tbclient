package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class l extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IN_PV_ADDRESS);
        abVar.o("st_type", TbConfig.ST_TYPE_ENTER_FORE);
        abVar.o("os_version", Build.VERSION.RELEASE);
        abVar.o("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
        abVar.tV();
    }
}
