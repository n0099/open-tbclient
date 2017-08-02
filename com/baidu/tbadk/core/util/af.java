package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class af extends Thread {
    private String agt;
    private boolean agu;
    private String mObjTp;
    private String mParam;
    private String mType;

    public af(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.agt = null;
        this.mObjTp = null;
        this.agu = false;
        this.mType = str;
        this.agu = z;
    }

    public af(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.agt = null;
        this.mObjTp = null;
        this.agu = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.agu) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        w wVar = new w(TbConfig.SERVER_ADDRESS + str);
        wVar.n("st_type", this.mType);
        if (this.mParam != null) {
            wVar.n("st_param", this.mParam);
        }
        if (this.agt != null) {
            wVar.n("obj", this.agt);
        }
        if (this.mObjTp != null) {
            wVar.n("obj_tp", this.mObjTp);
        }
        wVar.uE();
    }
}
