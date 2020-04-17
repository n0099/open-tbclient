package com.baidu.ar.imu;
/* loaded from: classes3.dex */
public enum b {
    WORLD(0),
    RELATIVE(1);
    
    private int qk;

    b(int i) {
        this.qk = i;
    }

    public static b B(int i) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.getTypeValue() == i) {
                return bVar;
            }
        }
        return null;
    }

    public int getTypeValue() {
        return this.qk;
    }
}
