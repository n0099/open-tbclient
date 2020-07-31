package com.baidu.ar.b.b;
/* loaded from: classes11.dex */
public abstract class c extends d {
    public c(int i) {
        super(i);
        this.level = 1;
    }

    public abstract int a(com.baidu.ar.mdl.a aVar);

    @Override // com.baidu.ar.b.b.d
    public void execute() {
        if (!com.baidu.ar.b.a.aq().d(this.cX)) {
            com.baidu.ar.mdl.a g = com.baidu.ar.b.a.aq().g(this.cX);
            if (g == null) {
                com.baidu.ar.f.b.b("MdlInitTask", "can not find configs by type = " + this.cX);
                return;
            }
            int a = a(g);
            if (a != 0) {
                com.baidu.ar.f.b.b("MdlInitTask", "mdl init result =  " + a + ", mdlType = " + this.cX);
                return;
            }
            com.baidu.ar.b.a.aq().e(this.cX);
        }
        com.baidu.ar.b.a.aq().a(new Runnable() { // from class: com.baidu.ar.b.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.ar.b.a.a aVar;
                if (c.this.cY == null || (aVar = c.this.cY.get()) == null) {
                    return;
                }
                aVar.ar();
            }
        });
    }
}
