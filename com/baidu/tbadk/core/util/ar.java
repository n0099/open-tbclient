package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ar extends Thread {
    private String Yx;
    private boolean Yy;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ar(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.Yx = null;
        this.mObjTp = null;
        this.Yy = false;
        this.mType = str;
        this.Yy = z;
    }

    public ar(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.Yx = null;
        this.mObjTp = null;
        this.Yy = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.Yy) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        abVar.n("st_type", this.mType);
        if (this.mParam != null) {
            abVar.n("st_param", this.mParam);
        }
        if (this.Yx != null) {
            abVar.n("obj", this.Yx);
        }
        if (this.mObjTp != null) {
            abVar.n("obj_tp", this.mObjTp);
        }
        abVar.sZ();
    }
}
