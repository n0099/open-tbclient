package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class j extends Thread {
    private String aqX = "1";

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.IN_PV_ADDRESS);
        xVar.u("st_type", TbConfig.ST_TYPE_ENTER_FORE);
        xVar.u(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE);
        xVar.u("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
        xVar.u("op_type", this.aqX);
        xVar.zt();
    }

    public void setOpType(String str) {
        this.aqX = str;
    }
}
