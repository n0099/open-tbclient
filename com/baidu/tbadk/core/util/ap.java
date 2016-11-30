package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ap extends Thread {
    private String abX;
    private boolean abY;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ap(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.abX = null;
        this.mObjTp = null;
        this.abY = false;
        this.mType = str;
        this.abY = z;
    }

    public ap(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.abX = null;
        this.mObjTp = null;
        this.abY = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.abY) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        zVar.n("st_type", this.mType);
        if (this.mParam != null) {
            zVar.n("st_param", this.mParam);
        }
        if (this.abX != null) {
            zVar.n("obj", this.abX);
        }
        if (this.mObjTp != null) {
            zVar.n("obj_tp", this.mObjTp);
        }
        zVar.uy();
    }
}
