package com.baidu.ar.pose;

import com.baidu.ar.d.b;
/* loaded from: classes12.dex */
public class a extends b {
    private float[] tf;

    public a(String str, float[] fArr, long j) {
        this.tf = fArr;
        T(str);
        setTimestamp(j);
    }

    public float[] fs() {
        return this.tf;
    }
}
