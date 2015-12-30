package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ap extends Thread {
    private String acn;
    private boolean aco;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ap(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.acn = null;
        this.mObjTp = null;
        this.aco = false;
        this.mType = str;
        this.aco = z;
    }

    public ap(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.acn = null;
        this.mObjTp = null;
        this.aco = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.aco) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        abVar.o("st_type", this.mType);
        if (this.mParam != null) {
            abVar.o("st_param", this.mParam);
        }
        if (this.acn != null) {
            abVar.o("obj", this.acn);
        }
        if (this.mObjTp != null) {
            abVar.o("obj_tp", this.mObjTp);
        }
        abVar.tV();
    }
}
