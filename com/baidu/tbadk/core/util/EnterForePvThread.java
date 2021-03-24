package com.baidu.tbadk.core.util;

import android.os.Build;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class EnterForePvThread extends Thread {
    public static final String TYPE_NORMAL = "1";
    public static final String TYPE_PB_NOT_EXIST = "2";
    public String mOpType = "1";

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.IN_PV_ADDRESS);
        netWork.addPostData("st_type", TbConfig.ST_TYPE_ENTER_FORE);
        netWork.addPostData("os_version", Build.VERSION.RELEASE);
        netWork.addPostData("android_sdk", String.valueOf(Build.VERSION.SDK_INT));
        netWork.addPostData("op_type", this.mOpType);
        netWork.postNetData();
    }

    public void setOpType(String str) {
        this.mOpType = str;
    }
}
