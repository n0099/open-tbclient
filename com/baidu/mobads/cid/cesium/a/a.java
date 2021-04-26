package com.baidu.mobads.cid.cesium.a;

import java.util.Arrays;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public g[] f8321a = {new h(8, 0), new i(0, 1), new i(1, 1), new h(7, 1)};

    public byte[] a(byte[] bArr) {
        f fVar = new f();
        byte[] a2 = c.a(bArr, bArr.length + ((this.f8321a.length + 1) * f.f8327a));
        c.a(a2, fVar.a(), bArr.length);
        int i2 = 0;
        while (true) {
            g[] gVarArr = this.f8321a;
            if (i2 >= gVarArr.length) {
                return Arrays.copyOf(fVar.a(), f.f8327a);
            }
            g gVar = gVarArr[i2];
            i2++;
            int length = bArr.length + (f.f8327a * i2);
            fVar.a(gVar.a(a2, 0, length), gVar.a(), gVar.b(), gVar.c());
            c.a(a2, fVar.a(), length);
        }
    }
}
