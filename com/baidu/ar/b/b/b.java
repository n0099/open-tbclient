package com.baidu.ar.b.b;

import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class b extends d {
    public b(int i) {
        super(i);
        this.level = 2;
    }

    public abstract HashMap am();

    @Override // com.baidu.ar.b.b.d
    public void execute() {
        if (com.baidu.ar.b.a.ac().c(this.cK)) {
            final HashMap am = am();
            com.baidu.ar.b.a.ac().b(new Runnable() { // from class: com.baidu.ar.b.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.ar.b.a.a aVar;
                    if (b.this.cL == null || (aVar = b.this.cL.get()) == null) {
                        return;
                    }
                    aVar.e(am);
                }
            });
        }
    }
}
