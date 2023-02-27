package com.baidu.ar.pose;

import com.baidu.ar.d.b;
/* loaded from: classes.dex */
public class a extends b {
    public float[] tS;

    public a(String str, float[] fArr, long j) {
        this.tS = fArr;
        W(str);
        setTimestamp(j);
    }

    public float[] fr() {
        return this.tS;
    }
}
