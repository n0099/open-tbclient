package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class av extends Thread {
    private String El;
    private String Jf;
    private boolean Jg;
    private String mObjTp;
    private String my;

    public av(String str) {
        this.my = null;
        this.El = null;
        this.Jf = null;
        this.mObjTp = null;
        this.Jg = false;
        this.my = str;
        this.Jg = false;
    }

    public av(String str, String str2) {
        this.my = null;
        this.El = null;
        this.Jf = null;
        this.mObjTp = null;
        this.Jg = false;
        this.my = str;
        this.El = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.Jg) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        ad adVar = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        if (!this.Jg) {
            String po = al.pl().po();
            if (!ba.isEmpty(po)) {
                al.pl().pn();
                adVar.o("st_record", po);
            }
        }
        adVar.o("st_type", this.my);
        if (this.El != null) {
            adVar.o("st_param", this.El);
        }
        if (this.Jf != null) {
            adVar.o("obj", this.Jf);
        }
        if (this.mObjTp != null) {
            adVar.o("obj_tp", this.mObjTp);
        }
        adVar.ov();
    }
}
