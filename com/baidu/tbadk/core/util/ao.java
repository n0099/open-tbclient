package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ao extends Thread {
    private String acJ;
    private boolean acK;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ao(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.acJ = null;
        this.mObjTp = null;
        this.acK = false;
        this.mType = str;
        this.acK = z;
    }

    public ao(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.acJ = null;
        this.mObjTp = null;
        this.acK = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.acK) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        aaVar.p("st_type", this.mType);
        if (this.mParam != null) {
            aaVar.p("st_param", this.mParam);
        }
        if (this.acJ != null) {
            aaVar.p("obj", this.acJ);
        }
        if (this.mObjTp != null) {
            aaVar.p("obj_tp", this.mObjTp);
        }
        aaVar.uZ();
    }
}
