package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class j extends Thread {
    private String aAC = "1";

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.IN_PV_ADDRESS);
            xVar.x("st_type", TbConfig.ST_TYPE_ENTER_FORE);
            xVar.x(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE);
            xVar.x("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
            xVar.x("op_type", this.aAC);
            xVar.CY();
        }
    }

    public void setOpType(String str) {
        this.aAC = str;
    }
}
