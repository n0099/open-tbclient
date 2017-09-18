package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ag extends Thread {
    private String ahh;
    private boolean ahi;
    private String mObjTp;
    private String mParam;
    private String mType;

    public ag(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.ahh = null;
        this.mObjTp = null;
        this.ahi = false;
        this.mType = str;
        this.ahi = z;
    }

    public ag(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.ahh = null;
        this.mObjTp = null;
        this.ahi = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.ahi) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        x xVar = new x(TbConfig.SERVER_ADDRESS + str);
        xVar.n("st_type", this.mType);
        if (this.mParam != null) {
            xVar.n("st_param", this.mParam);
        }
        if (this.ahh != null) {
            xVar.n("obj", this.ahh);
        }
        if (this.mObjTp != null) {
            xVar.n("obj_tp", this.mObjTp);
        }
        xVar.uM();
    }
}
