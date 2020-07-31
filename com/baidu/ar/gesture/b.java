package com.baidu.ar.gesture;
/* loaded from: classes11.dex */
public class b extends com.baidu.ar.c.b {
    private float[] px;

    public b(String str, float[] fArr, long j) {
        this.px = fArr;
        S(str);
        setTimestamp(j);
    }

    public float[] dx() {
        return this.px;
    }
}
