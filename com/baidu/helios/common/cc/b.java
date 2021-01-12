package com.baidu.helios.common.cc;

import java.util.Arrays;
/* loaded from: classes14.dex */
public class b {
    e[] asO = {new f(8, 0), new g(0, 1), new g(1, 1), new f(7, 1)};

    public byte[] u(byte[] bArr) {
        d dVar = new d();
        byte[] a2 = c.a(bArr, bArr.length + ((this.asO.length + 1) * d.c));
        c.b(a2, dVar.b(), bArr.length);
        for (int i = 0; i < this.asO.length; i++) {
            e eVar = this.asO[i];
            int length = bArr.length + ((i + 1) * d.c);
            dVar.a(eVar.m(a2, 0, length), eVar.a(), eVar.b(), eVar.c());
            c.b(a2, dVar.b(), length);
        }
        return Arrays.copyOf(dVar.b(), d.c);
    }
}
