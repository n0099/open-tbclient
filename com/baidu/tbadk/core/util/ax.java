package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public final class ax extends Thread {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;

    public ax(String str) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = str;
        this.e = false;
    }

    public ax(String str, String str2) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = str;
        this.b = str2;
    }

    public ax(String str, String str2, String str3) {
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
    public final void run() {
        String str;
        String str2;
        super.run();
        if (this.e) {
            str = "c/s/inpv";
        } else {
            str = "c/s/pv";
        }
        ak akVar = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + str);
        if (this.e) {
            str2 = null;
        } else {
            str2 = aq.a().d();
            if (!bc.c(str2)) {
                aq.a().c();
                akVar.a("st_record", str2);
            }
        }
        akVar.a("st_type", this.a);
        if (this.b != null) {
            akVar.a("st_param", this.b);
        }
        if (this.c != null) {
            akVar.a("obj", this.c);
        }
        if (this.d != null) {
            akVar.a("obj_tp", this.d);
        }
        akVar.i();
        if (!this.e) {
            if (!akVar.a().b().b() || akVar.d() != 0) {
                aq.a().b(str2);
            }
        }
    }
}
