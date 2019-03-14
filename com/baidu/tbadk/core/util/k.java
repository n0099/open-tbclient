package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class k extends Thread {
    private String bIy = "1";

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.IN_PV_ADDRESS);
        xVar.x("st_type", TbConfig.ST_TYPE_ENTER_FORE);
        xVar.x("os_version", Build.VERSION.RELEASE);
        xVar.x("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
        xVar.x("op_type", this.bIy);
        xVar.acj();
    }

    public void setOpType(String str) {
        this.bIy = str;
    }
}
