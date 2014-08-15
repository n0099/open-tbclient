package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aw extends Thread {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;

    public aw(String str) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = str;
        this.e = false;
    }

    public aw(String str, String str2) {
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
        ae aeVar = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        if (!this.e) {
            String d = ak.a().d();
            if (!ba.c(d)) {
                ak.a().c();
                aeVar.a("st_record", d);
            }
        }
        aeVar.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.a);
        if (this.b != null) {
            aeVar.a("st_param", this.b);
        }
        if (this.c != null) {
            aeVar.a("obj", this.c);
        }
        if (this.d != null) {
            aeVar.a("obj_tp", this.d);
        }
        aeVar.h();
    }
}
