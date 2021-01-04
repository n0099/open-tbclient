package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class k extends Thread {
    private String fbX = "1";

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            z zVar = new z(TbConfig.SERVER_ADDRESS + TbConfig.IN_PV_ADDRESS);
            zVar.addPostData("st_type", TbConfig.ST_TYPE_ENTER_FORE);
            zVar.addPostData("os_version", Build.VERSION.RELEASE);
            zVar.addPostData(MapController.ANDROID_SDK_LAYER_TAG, String.valueOf(Build.VERSION.SDK_INT));
            zVar.addPostData("op_type", this.fbX);
            zVar.postNetData();
        }
    }

    public void setOpType(String str) {
        this.fbX = str;
    }
}
