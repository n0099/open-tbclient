package com.baidu.ar.a.c;

import android.os.Bundle;
/* loaded from: classes3.dex */
public class c extends com.baidu.ar.a.a.c {
    b d;

    public c(byte[] bArr, int i, int i2, b bVar, com.baidu.ar.a.a.a aVar) {
        super(aVar);
        a(bArr, i, i2);
        this.d = bVar;
    }

    @Override // com.baidu.ar.a.a.c
    public void b() {
        if (this.d != null) {
            Bundle a = this.d.a(c(), this.a, this.b);
            if (this.c != null) {
                this.c.a(a);
            }
        }
    }
}
