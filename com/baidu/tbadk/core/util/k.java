package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class k extends Thread {
    private String elr = "1";

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.IN_PV_ADDRESS);
            aaVar.addPostData("st_type", TbConfig.ST_TYPE_ENTER_FORE);
            aaVar.addPostData("os_version", Build.VERSION.RELEASE);
            aaVar.addPostData(MapController.ANDROID_SDK_LAYER_TAG, String.valueOf(Build.VERSION.SDK_INT));
            aaVar.addPostData("op_type", this.elr);
            aaVar.postNetData();
        }
    }

    public void setOpType(String str) {
        this.elr = str;
    }
}
