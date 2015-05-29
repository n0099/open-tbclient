package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aw extends Thread {
    private String Qv;
    private String VQ;
    private boolean VR;
    private String mObjTp;
    private String wV;

    public aw(String str) {
        this.wV = null;
        this.Qv = null;
        this.VQ = null;
        this.mObjTp = null;
        this.VR = false;
        this.wV = str;
        this.VR = false;
    }

    public aw(String str, boolean z) {
        this.wV = null;
        this.Qv = null;
        this.VQ = null;
        this.mObjTp = null;
        this.VR = false;
        this.wV = str;
        this.VR = z;
    }

    public aw(String str, String str2) {
        this.wV = null;
        this.Qv = null;
        this.VQ = null;
        this.mObjTp = null;
        this.VR = false;
        this.wV = str;
        this.Qv = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.VR) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        if (!this.VR) {
            String tk = af.th().tk();
            if (!bb.isEmpty(tk)) {
                af.th().tj();
                aaVar.o("st_record", tk);
            }
        }
        aaVar.o("st_type", this.wV);
        if (this.Qv != null) {
            aaVar.o("st_param", this.Qv);
        }
        if (this.VQ != null) {
            aaVar.o("obj", this.VQ);
        }
        if (this.mObjTp != null) {
            aaVar.o("obj_tp", this.mObjTp);
        }
        aaVar.sw();
    }
}
