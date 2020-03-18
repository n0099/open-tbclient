package com.baidu.cesium.a;

import java.util.Arrays;
/* loaded from: classes13.dex */
public class a {
    f[] Pp = {new g(8, 0), new h(0, 1), new h(1, 1), new g(7, 1)};

    public byte[] a(byte[] bArr) {
        e eVar = new e();
        byte[] a = c.a(bArr, bArr.length + ((this.Pp.length + 1) * e.c));
        c.a(a, eVar.b(), bArr.length);
        for (int i = 0; i < this.Pp.length; i++) {
            f fVar = this.Pp[i];
            int length = bArr.length + ((i + 1) * e.c);
            eVar.a(fVar.g(a, 0, length), fVar.a(), fVar.b(), fVar.c());
            c.a(a, eVar.b(), length);
        }
        return Arrays.copyOf(eVar.b(), e.c);
    }
}
