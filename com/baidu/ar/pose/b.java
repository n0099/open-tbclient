package com.baidu.ar.pose;
/* loaded from: classes3.dex */
public class b extends com.baidu.ar.c.b {
    private float[] sa;

    public b(String str, float[] fArr, long j) {
        this.sa = fArr;
        S(str);
        setTimestamp(j);
    }

    public float[] dQ() {
        return this.sa;
    }
}
