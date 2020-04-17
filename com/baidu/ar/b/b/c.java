package com.baidu.ar.b.b;
/* loaded from: classes3.dex */
public abstract class c extends d {
    public c(int i) {
        super(i);
        this.level = 1;
    }

    public abstract int a(com.baidu.ar.mdl.a aVar);

    @Override // com.baidu.ar.b.b.d
    public void execute() {
        if (!com.baidu.ar.b.a.ac().c(this.cK)) {
            com.baidu.ar.mdl.a f = com.baidu.ar.b.a.ac().f(this.cK);
            if (f == null) {
                com.baidu.ar.f.b.b("MdlInitTask", "can not find configs by type = " + this.cK);
                return;
            }
            int a = a(f);
            if (a != 0) {
                com.baidu.ar.f.b.b("MdlInitTask", "mdl init result =  " + a + ", mdlType = " + this.cK);
                return;
            }
            com.baidu.ar.b.a.ac().d(this.cK);
        }
        com.baidu.ar.b.a.ac().a(new Runnable() { // from class: com.baidu.ar.b.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.ar.b.a.a aVar;
                if (c.this.cL == null || (aVar = c.this.cL.get()) == null) {
                    return;
                }
                aVar.ad();
            }
        });
    }
}
