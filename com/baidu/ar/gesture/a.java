package com.baidu.ar.gesture;

import com.baidu.ar.d.b;
/* loaded from: classes.dex */
public class a extends b {
    public float[] qt;

    public a(String str, float[] fArr, long j) {
        this.qt = fArr;
        W(str);
        setTimestamp(j);
    }

    public float[] eG() {
        return this.qt;
    }
}
