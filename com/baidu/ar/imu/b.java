package com.baidu.ar.imu;
/* loaded from: classes11.dex */
public enum b {
    WORLD(0),
    RELATIVE(1);
    
    private int qJ;

    b(int i) {
        this.qJ = i;
    }

    public static b H(int i) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.getTypeValue() == i) {
                return bVar;
            }
        }
        return null;
    }

    public int getTypeValue() {
        return this.qJ;
    }
}
