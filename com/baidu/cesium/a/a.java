package com.baidu.cesium.a;

import java.util.Arrays;
/* loaded from: classes6.dex */
public class a {
    f[] amR = {new g(8, 0), new h(0, 1), new h(1, 1), new g(7, 1)};

    public byte[] a(byte[] bArr) {
        e eVar = new e();
        byte[] a2 = c.a(bArr, bArr.length + ((this.amR.length + 1) * e.c));
        c.b(a2, eVar.b(), bArr.length);
        for (int i = 0; i < this.amR.length; i++) {
            f fVar = this.amR[i];
            int length = bArr.length + ((i + 1) * e.c);
            eVar.a(fVar.i(a2, 0, length), fVar.a(), fVar.b(), fVar.c());
            c.b(a2, eVar.b(), length);
        }
        return Arrays.copyOf(eVar.b(), e.c);
    }
}
