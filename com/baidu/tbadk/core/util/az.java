package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class az extends Thread {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;

    public az(String str) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = str;
        this.e = false;
    }

    public az(String str, String str2) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = str;
        this.b = str2;
    }

    public az(String str, String str2, String str3) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        String str2;
        super.run();
        if (this.e) {
            str = TbConfig.IN_PV_ADDRESS;
        } else {
            str = TbConfig.LOAD_REG_PV_ADDRESS;
        }
        al alVar = new al(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        if (this.e) {
            str2 = null;
        } else {
            str2 = ar.a().d();
            if (!be.c(str2)) {
                ar.a().c();
                alVar.a("st_record", str2);
            }
        }
        alVar.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.a);
        if (this.b != null) {
            alVar.a("st_param", this.b);
        }
        if (this.c != null) {
            alVar.a("obj", this.c);
        }
        if (this.d != null) {
            alVar.a("obj_tp", this.d);
        }
        alVar.i();
        if (!this.e) {
            if (!alVar.a().b().b() || alVar.d() != 0) {
                ar.a().b(str2);
            }
        }
    }
}
