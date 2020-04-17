package com.baidu.ar.b.b;
/* loaded from: classes3.dex */
public abstract class a extends d {
    public a(int i) {
        super(i);
        this.level = 1;
    }

    public abstract boolean al();

    @Override // com.baidu.ar.b.b.d
    public void execute() {
        if (com.baidu.ar.b.a.ac().c(this.cK)) {
            com.baidu.ar.b.a.ac().e(this.cK);
            al();
        }
        com.baidu.ar.b.a.ac().a(new Runnable() { // from class: com.baidu.ar.b.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.ar.b.a.a aVar;
                if (a.this.cL == null || (aVar = a.this.cL.get()) == null) {
                    return;
                }
                aVar.ae();
            }
        });
    }
}
