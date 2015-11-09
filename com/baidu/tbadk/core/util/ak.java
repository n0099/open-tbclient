package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ak extends Thread {
    private String aaW;
    private boolean aaX;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ak(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.aaW = null;
        this.mObjTp = null;
        this.aaX = false;
        this.mType = str;
        this.aaX = z;
    }

    public ak(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.aaW = null;
        this.mObjTp = null;
        this.aaX = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.aaX) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        w wVar = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        wVar.o("st_type", this.mType);
        if (this.mParam != null) {
            wVar.o("st_param", this.mParam);
        }
        if (this.aaW != null) {
            wVar.o("obj", this.aaW);
        }
        if (this.mObjTp != null) {
            wVar.o("obj_tp", this.mObjTp);
        }
        wVar.tG();
    }
}
