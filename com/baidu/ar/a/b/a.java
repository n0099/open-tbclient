package com.baidu.ar.a.b;

import android.os.Bundle;
import com.baidu.ar.a.a.c;
/* loaded from: classes3.dex */
public class a extends c {
    public a(byte[] bArr, int i, int i2, com.baidu.ar.a.a.a aVar) {
        super(bArr, i, i2, aVar);
    }

    @Override // com.baidu.ar.a.a.c
    public void b() {
        int a = com.baidu.slamlibrary.b.a(c(), this.a, this.b);
        Bundle bundle = new Bundle();
        bundle.putInt(com.baidu.ar.a.a.b.a, a);
        if (this.c != null) {
            this.c.a(bundle);
        }
    }
}
