package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ba extends Thread {
    private String Ep;
    private String Jy;
    private boolean Jz;
    private String mB;
    private String mObjTp;

    public ba(String str) {
        this.mB = null;
        this.Ep = null;
        this.Jy = null;
        this.mObjTp = null;
        this.Jz = false;
        this.mB = str;
        this.Jz = false;
    }

    public ba(String str, String str2) {
        this.mB = null;
        this.Ep = null;
        this.Jy = null;
        this.mObjTp = null;
        this.Jz = false;
        this.mB = str;
        this.Ep = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.Jz) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        ad adVar = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        if (!this.Jz) {
            String pr = al.po().pr();
            if (!bf.isEmpty(pr)) {
                al.po().pq();
                adVar.o("st_record", pr);
            }
        }
        adVar.o("st_type", this.mB);
        if (this.Ep != null) {
            adVar.o("st_param", this.Ep);
        }
        if (this.Jy != null) {
            adVar.o("obj", this.Jy);
        }
        if (this.mObjTp != null) {
            adVar.o("obj_tp", this.mObjTp);
        }
        adVar.oy();
    }
}
