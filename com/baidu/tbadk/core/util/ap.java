package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ap extends Thread {
    private String afW;
    private boolean afX;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ap(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.afW = null;
        this.mObjTp = null;
        this.afX = false;
        this.mType = str;
        this.afX = z;
    }

    public ap(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.afW = null;
        this.mObjTp = null;
        this.afX = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.afX) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        abVar.n("st_type", this.mType);
        if (this.mParam != null) {
            abVar.n("st_param", this.mParam);
        }
        if (this.afW != null) {
            abVar.n("obj", this.afW);
        }
        if (this.mObjTp != null) {
            abVar.n("obj_tp", this.mObjTp);
        }
        abVar.uy();
    }
}
