package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class k extends Thread {
    private String dyf = "1";

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.IN_PV_ADDRESS);
            xVar.addPostData("st_type", TbConfig.ST_TYPE_ENTER_FORE);
            xVar.addPostData("os_version", Build.VERSION.RELEASE);
            xVar.addPostData("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
            xVar.addPostData("op_type", this.dyf);
            xVar.postNetData();
        }
    }

    public void setOpType(String str) {
        this.dyf = str;
    }
}
