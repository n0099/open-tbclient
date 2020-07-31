package com.baidu.ar.b.b;
/* loaded from: classes11.dex */
public abstract class a extends d {
    public a(int i) {
        super(i);
        this.level = 1;
    }

    public abstract boolean az();

    @Override // com.baidu.ar.b.b.d
    public void execute() {
        if (com.baidu.ar.b.a.aq().d(this.cX)) {
            com.baidu.ar.b.a.aq().f(this.cX);
            az();
        }
        com.baidu.ar.b.a.aq().a(new Runnable() { // from class: com.baidu.ar.b.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.ar.b.a.a aVar;
                if (a.this.cY == null || (aVar = a.this.cY.get()) == null) {
                    return;
                }
                aVar.as();
            }
        });
    }
}
