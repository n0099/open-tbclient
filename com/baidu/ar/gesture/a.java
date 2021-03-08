package com.baidu.ar.gesture;

import com.baidu.ar.d.b;
/* loaded from: classes3.dex */
public class a extends b {
    private float[] qt;

    public a(String str, float[] fArr, long j) {
        this.qt = fArr;
        W(str);
        setTimestamp(j);
    }

    public float[] eG() {
        return this.qt;
    }
}
