package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class am extends Thread {
    private String aaA;
    private boolean aaB;
    private String mObjTp;
    private String mParam;
    private String mType;

    public am(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.aaA = null;
        this.mObjTp = null;
        this.aaB = false;
        this.mType = str;
        this.aaB = z;
    }

    public am(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.aaA = null;
        this.mObjTp = null;
        this.aaB = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.aaB) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        y yVar = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        yVar.n("st_type", this.mType);
        if (this.mParam != null) {
            yVar.n("st_param", this.mParam);
        }
        if (this.aaA != null) {
            yVar.n("obj", this.aaA);
        }
        if (this.mObjTp != null) {
            yVar.n("obj_tp", this.mObjTp);
        }
        yVar.ud();
    }
}
