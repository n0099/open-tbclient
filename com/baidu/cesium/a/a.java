package com.baidu.cesium.a;

import java.util.Arrays;
/* loaded from: classes14.dex */
public class a {
    f[] and = {new g(8, 0), new h(0, 1), new h(1, 1), new g(7, 1)};

    public byte[] a(byte[] bArr) {
        e eVar = new e();
        byte[] a2 = c.a(bArr, bArr.length + ((this.and.length + 1) * e.c));
        c.a(a2, eVar.b(), bArr.length);
        for (int i = 0; i < this.and.length; i++) {
            f fVar = this.and[i];
            int length = bArr.length + ((i + 1) * e.c);
            eVar.a(fVar.l(a2, 0, length), fVar.a(), fVar.b(), fVar.c());
            c.a(a2, eVar.b(), length);
        }
        return Arrays.copyOf(eVar.b(), e.c);
    }
}
