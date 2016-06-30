package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ar extends Thread {
    private String XO;
    private boolean XP;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ar(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.XO = null;
        this.mObjTp = null;
        this.XP = false;
        this.mType = str;
        this.XP = z;
    }

    public ar(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.XO = null;
        this.mObjTp = null;
        this.XP = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.XP) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        abVar.n("st_type", this.mType);
        if (this.mParam != null) {
            abVar.n("st_param", this.mParam);
        }
        if (this.XO != null) {
            abVar.n("obj", this.XO);
        }
        if (this.mObjTp != null) {
            abVar.n("obj_tp", this.mObjTp);
        }
        abVar.ta();
    }
}
