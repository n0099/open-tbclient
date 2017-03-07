package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class an extends Thread {
    private String afQ;
    private boolean afR;
    private String mObjTp;
    private String mParam;
    private String mType;

    public an(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.afQ = null;
        this.mObjTp = null;
        this.afR = false;
        this.mType = str;
        this.afR = z;
    }

    public an(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.afQ = null;
        this.mObjTp = null;
        this.afR = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.afR) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        zVar.n("st_type", this.mType);
        if (this.mParam != null) {
            zVar.n("st_param", this.mParam);
        }
        if (this.afQ != null) {
            zVar.n("obj", this.afQ);
        }
        if (this.mObjTp != null) {
            zVar.n("obj_tp", this.mObjTp);
        }
        zVar.uB();
    }
}
