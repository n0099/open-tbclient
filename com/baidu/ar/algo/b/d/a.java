package com.baidu.ar.algo.b.d;

import android.os.Bundle;
import com.baidu.ar.algo.b.a.b;
/* loaded from: classes3.dex */
public class a extends b {
    com.baidu.ar.algo.a.c.b e;

    public a(byte[] bArr, int i, int i2, com.baidu.ar.algo.a.c.b bVar, com.baidu.ar.algo.b.a.a aVar) {
        super(aVar);
        a(bArr, i, i2);
        this.e = bVar;
    }

    @Override // com.baidu.ar.algo.b.a.b
    public void b() {
        if (this.e != null) {
            Bundle a = this.e.a(c(), this.a, this.b);
            if (this.c != null) {
                this.c.a(a);
            }
        }
    }
}
