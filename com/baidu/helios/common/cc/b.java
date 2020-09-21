package com.baidu.helios.common.cc;

import java.util.Arrays;
/* loaded from: classes6.dex */
public class b {
    e[] axk = {new f(8, 0), new g(0, 1), new g(1, 1), new f(7, 1)};

    public byte[] y(byte[] bArr) {
        d dVar = new d();
        byte[] a = c.a(bArr, bArr.length + ((this.axk.length + 1) * d.c));
        c.a(a, dVar.b(), bArr.length);
        for (int i = 0; i < this.axk.length; i++) {
            e eVar = this.axk[i];
            int length = bArr.length + ((i + 1) * d.c);
            dVar.a(eVar.n(a, 0, length), eVar.a(), eVar.b(), eVar.c());
            c.a(a, dVar.b(), length);
        }
        return Arrays.copyOf(dVar.b(), d.c);
    }
}
