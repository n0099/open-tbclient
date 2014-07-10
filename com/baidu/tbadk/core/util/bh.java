package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bh extends Thread {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;

    public bh(String str) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = str;
        this.e = false;
    }

    public bh(String str, String str2) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.e) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        aq aqVar = new aq(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        if (!this.e) {
            String d = aw.a().d();
            if (!bm.c(d)) {
                aw.a().c();
                aqVar.a("st_record", d);
            }
        }
        aqVar.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.a);
        if (this.b != null) {
            aqVar.a("st_param", this.b);
        }
        if (this.c != null) {
            aqVar.a("obj", this.c);
        }
        if (this.d != null) {
            aqVar.a("obj_tp", this.d);
        }
        aqVar.i();
    }
}
