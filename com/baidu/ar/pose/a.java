package com.baidu.ar.pose;

import com.baidu.ar.d.b;
/* loaded from: classes10.dex */
public class a extends b {
    private float[] tS;

    public a(String str, float[] fArr, long j) {
        this.tS = fArr;
        W(str);
        setTimestamp(j);
    }

    public float[] fr() {
        return this.tS;
    }
}
