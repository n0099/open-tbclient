package com.baidu.b.a;

import java.util.Arrays;
/* loaded from: classes7.dex */
public class a {
    g[] acU = {new h(8, 0), new j(0, 1), new j(1, 1), new h(7, 1)};

    public byte[] a(byte[] bArr) {
        f fVar = new f();
        byte[] a2 = c.a(bArr, bArr.length + ((this.acU.length + 1) * f.f1245a));
        c.a(a2, fVar.a(), bArr.length);
        for (int i = 0; i < this.acU.length; i++) {
            g gVar = this.acU[i];
            int length = bArr.length + ((i + 1) * f.f1245a);
            fVar.a(gVar.i(a2, 0, length), gVar.a(), gVar.b(), gVar.c());
            c.a(a2, fVar.a(), length);
        }
        return Arrays.copyOf(fVar.a(), f.f1245a);
    }
}
