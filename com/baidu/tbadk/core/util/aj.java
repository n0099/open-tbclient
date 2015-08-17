package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aj extends Thread {
    private String aaN;
    private boolean aaO;
    private String mObjTp;
    private String mParam;
    private String mType;

    public aj(String str) {
        this.mType = null;
        this.mParam = null;
        this.aaN = null;
        this.mObjTp = null;
        this.aaO = false;
        this.mType = str;
        this.aaO = false;
    }

    public aj(String str, boolean z) {
        this.mType = null;
        this.mParam = null;
        this.aaN = null;
        this.mObjTp = null;
        this.aaO = false;
        this.mType = str;
        this.aaO = z;
    }

    public aj(String str, String str2) {
        this.mType = null;
        this.mParam = null;
        this.aaN = null;
        this.mObjTp = null;
        this.aaO = false;
        this.mType = str;
        this.mParam = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.aaO) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        v vVar = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        vVar.o("st_type", this.mType);
        if (this.mParam != null) {
            vVar.o("st_param", this.mParam);
        }
        if (this.aaN != null) {
            vVar.o("obj", this.aaN);
        }
        if (this.mObjTp != null) {
            vVar.o("obj_tp", this.mObjTp);
        }
        vVar.tD();
    }
}
