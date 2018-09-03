package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class j extends Thread {
    private String aor = "1";

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.IN_PV_ADDRESS);
        yVar.o("st_type", TbConfig.ST_TYPE_ENTER_FORE);
        yVar.o(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE);
        yVar.o("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
        yVar.o("op_type", this.aor);
        yVar.yo();
    }

    public void setOpType(String str) {
        this.aor = str;
    }
}
