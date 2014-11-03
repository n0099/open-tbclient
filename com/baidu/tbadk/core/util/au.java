package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class au extends Thread {
    private String Aa;
    private String EU;
    private boolean EV;
    private String mA;
    private String mObjTp;

    public au(String str) {
        this.mA = null;
        this.Aa = null;
        this.EU = null;
        this.mObjTp = null;
        this.EV = false;
        this.mA = str;
        this.EV = false;
    }

    public au(String str, String str2) {
        this.mA = null;
        this.Aa = null;
        this.EU = null;
        this.mObjTp = null;
        this.EV = false;
        this.mA = str;
        this.Aa = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.EV) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        ac acVar = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        if (!this.EV) {
            String mu = ak.mr().mu();
            if (!az.aA(mu)) {
                ak.mr().mt();
                acVar.k("st_record", mu);
            }
        }
        acVar.k("st_type", this.mA);
        if (this.Aa != null) {
            acVar.k("st_param", this.Aa);
        }
        if (this.EU != null) {
            acVar.k("obj", this.EU);
        }
        if (this.mObjTp != null) {
            acVar.k("obj_tp", this.mObjTp);
        }
        acVar.lA();
    }
}
