package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ak extends Thread {
    private String aaS;
    private boolean aaT;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ak(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.aaS = null;
        this.mObjTp = null;
        this.aaT = false;
        this.mType = str;
        this.aaT = z;
    }

    public ak(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.aaS = null;
        this.mObjTp = null;
        this.aaT = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.aaT) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        w wVar = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        wVar.o("st_type", this.mType);
        if (this.mParam != null) {
            wVar.o("st_param", this.mParam);
        }
        if (this.aaS != null) {
            wVar.o("obj", this.aaS);
        }
        if (this.mObjTp != null) {
            wVar.o("obj_tp", this.mObjTp);
        }
        wVar.tD();
    }
}
