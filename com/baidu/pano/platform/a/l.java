package com.baidu.pano.platform.a;

import java.util.Map;
/* loaded from: classes10.dex */
public class l {
    public final int a;
    public final byte[] b;
    public final Map<String, String> c;
    public final boolean d;
    public final long e;

    public l(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.a = i;
        this.b = bArr;
        this.c = map;
        this.d = z;
        this.e = j;
    }

    public l(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }
}
