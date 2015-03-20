package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ay extends Thread {
    private String PY;
    private String Vh;
    private boolean Vi;
    private String mObjTp;
    private String xP;

    public ay(String str) {
        this.xP = null;
        this.PY = null;
        this.Vh = null;
        this.mObjTp = null;
        this.Vi = false;
        this.xP = str;
        this.Vi = false;
    }

    public ay(String str, String str2) {
        this.xP = null;
        this.PY = null;
        this.Vh = null;
        this.mObjTp = null;
        this.Vi = false;
        this.xP = str;
        this.PY = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.Vi) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        if (!this.Vi) {
            String sH = ai.sE().sH();
            if (!bd.isEmpty(sH)) {
                ai.sE().sG();
                aaVar.o("st_record", sH);
            }
        }
        aaVar.o("st_type", this.xP);
        if (this.PY != null) {
            aaVar.o("st_param", this.PY);
        }
        if (this.Vh != null) {
            aaVar.o("obj", this.Vh);
        }
        if (this.mObjTp != null) {
            aaVar.o("obj_tp", this.mObjTp);
        }
        aaVar.rO();
    }
}
