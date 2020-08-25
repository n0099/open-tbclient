package com.baidu.b.a;

import java.util.Arrays;
/* loaded from: classes20.dex */
public class a {
    g[] acb = {new h(8, 0), new j(0, 1), new j(1, 1), new h(7, 1)};

    public byte[] a(byte[] bArr) {
        f fVar = new f();
        byte[] a = c.a(bArr, bArr.length + ((this.acb.length + 1) * f.a));
        c.a(a, fVar.a(), bArr.length);
        for (int i = 0; i < this.acb.length; i++) {
            g gVar = this.acb[i];
            int length = bArr.length + ((i + 1) * f.a);
            fVar.a(gVar.i(a, 0, length), gVar.a(), gVar.b(), gVar.c());
            c.a(a, fVar.a(), length);
        }
        return Arrays.copyOf(fVar.a(), f.a);
    }
}
