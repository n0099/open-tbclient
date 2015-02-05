package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ba extends Thread {
    private String Em;
    private String Jv;
    private boolean Jw;
    private String mB;
    private String mObjTp;

    public ba(String str) {
        this.mB = null;
        this.Em = null;
        this.Jv = null;
        this.mObjTp = null;
        this.Jw = false;
        this.mB = str;
        this.Jw = false;
    }

    public ba(String str, String str2) {
        this.mB = null;
        this.Em = null;
        this.Jv = null;
        this.mObjTp = null;
        this.Jw = false;
        this.mB = str;
        this.Em = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.Jw) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        ad adVar = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        if (!this.Jw) {
            String pk = al.ph().pk();
            if (!bf.isEmpty(pk)) {
                al.ph().pj();
                adVar.o("st_record", pk);
            }
        }
        adVar.o("st_type", this.mB);
        if (this.Em != null) {
            adVar.o("st_param", this.Em);
        }
        if (this.Jv != null) {
            adVar.o("obj", this.Jv);
        }
        if (this.mObjTp != null) {
            adVar.o("obj_tp", this.mObjTp);
        }
        adVar.or();
    }
}
