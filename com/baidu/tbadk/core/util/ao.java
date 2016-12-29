package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ao extends Thread {
    private String abo;
    private boolean abp;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ao(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.abo = null;
        this.mObjTp = null;
        this.abp = false;
        this.mType = str;
        this.abp = z;
    }

    public ao(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.abo = null;
        this.mObjTp = null;
        this.abp = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.abp) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        zVar.n("st_type", this.mType);
        if (this.mParam != null) {
            zVar.n("st_param", this.mParam);
        }
        if (this.abo != null) {
            zVar.n("obj", this.abo);
        }
        if (this.mObjTp != null) {
            zVar.n("obj_tp", this.mObjTp);
        }
        zVar.uk();
    }
}
