package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class k extends Thread {
    private String dTa = "1";

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.IN_PV_ADDRESS);
            yVar.addPostData("st_type", TbConfig.ST_TYPE_ENTER_FORE);
            yVar.addPostData("os_version", Build.VERSION.RELEASE);
            yVar.addPostData("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
            yVar.addPostData("op_type", this.dTa);
            yVar.postNetData();
        }
    }

    public void setOpType(String str) {
        this.dTa = str;
    }
}
