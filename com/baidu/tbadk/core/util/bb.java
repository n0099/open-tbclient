package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bb extends Thread {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;

    public bb(String str) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = str;
        this.e = false;
    }

    public bb(String str, String str2) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = str;
        this.b = str2;
    }

    public bb(String str, String str2, String str3) {
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
        an anVar = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
        if (this.e) {
            str2 = null;
        } else {
            str2 = at.a().d();
            if (!bg.c(str2)) {
                at.a().c();
                anVar.a("st_record", str2);
            }
        }
        anVar.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.a);
        if (this.b != null) {
            anVar.a("st_param", this.b);
        }
        if (this.c != null) {
            anVar.a("obj", this.c);
        }
        if (this.d != null) {
            anVar.a("obj_tp", this.d);
        }
        anVar.i();
        if (!this.e) {
            if (!anVar.a().b().b() || anVar.d() != 0) {
                at.a().b(str2);
            }
        }
    }
}
