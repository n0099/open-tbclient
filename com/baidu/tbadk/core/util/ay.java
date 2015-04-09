package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ay extends Thread {
    private String Qa;
    private String Vj;
    private boolean Vk;
    private String mObjTp;
    private String xP;

    public ay(String str) {
        this.xP = null;
        this.Qa = null;
        this.Vj = null;
        this.mObjTp = null;
        this.Vk = false;
        this.xP = str;
        this.Vk = false;
    }

    public ay(String str, String str2) {
        this.xP = null;
        this.Qa = null;
        this.Vj = null;
        this.mObjTp = null;
        this.Vk = false;
        this.xP = str;
        this.Qa = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.Vk) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        if (!this.Vk) {
            String sH = ai.sE().sH();
            if (!bd.isEmpty(sH)) {
                ai.sE().sG();
                aaVar.o("st_record", sH);
            }
        }
        aaVar.o("st_type", this.xP);
        if (this.Qa != null) {
            aaVar.o("st_param", this.Qa);
        }
        if (this.Vj != null) {
            aaVar.o("obj", this.Vj);
        }
        if (this.mObjTp != null) {
            aaVar.o("obj_tp", this.mObjTp);
        }
        aaVar.rO();
    }
}
