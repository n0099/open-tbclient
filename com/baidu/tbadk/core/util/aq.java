package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aq extends Thread {
    private String abW;
    private boolean abX;
    private String mObjTp;
    private String mParam;
    private String mType;

    public aq(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.abW = null;
        this.mObjTp = null;
        this.abX = false;
        this.mType = str;
        this.abX = z;
    }

    public aq(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.abW = null;
        this.mObjTp = null;
        this.abX = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.abX) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        abVar.p("st_type", this.mType);
        if (this.mParam != null) {
            abVar.p("st_param", this.mParam);
        }
        if (this.abW != null) {
            abVar.p("obj", this.abW);
        }
        if (this.mObjTp != null) {
            abVar.p("obj_tp", this.mObjTp);
        }
        abVar.vw();
    }
}
