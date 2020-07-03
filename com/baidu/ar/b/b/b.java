package com.baidu.ar.b.b;

import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class b extends d {
    public b(int i) {
        super(i);
        this.level = 2;
    }

    public abstract HashMap aA();

    @Override // com.baidu.ar.b.b.d
    public void execute() {
        if (com.baidu.ar.b.a.aq().d(this.cX)) {
            final HashMap aA = aA();
            com.baidu.ar.b.a.aq().b(new Runnable() { // from class: com.baidu.ar.b.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.ar.b.a.a aVar;
                    if (b.this.cY == null || (aVar = b.this.cY.get()) == null) {
                        return;
                    }
                    aVar.e(aA);
                }
            });
        }
    }
}
