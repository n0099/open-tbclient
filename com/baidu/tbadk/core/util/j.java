package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class j extends Thread {
    private String awA = "1";

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.IN_PV_ADDRESS);
        xVar.x("st_type", TbConfig.ST_TYPE_ENTER_FORE);
        xVar.x(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE);
        xVar.x("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
        xVar.x("op_type", this.awA);
        xVar.BH();
    }

    public void setOpType(String str) {
        this.awA = str;
    }
}
