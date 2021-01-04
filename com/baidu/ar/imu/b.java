package com.baidu.ar.imu;
/* loaded from: classes6.dex */
public enum b {
    WORLD(0),
    RELATIVE(1);
    
    private int rF;

    b(int i) {
        this.rF = i;
    }

    public static b L(int i) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.getTypeValue() == i) {
                return bVar;
            }
        }
        return null;
    }

    public int getTypeValue() {
        return this.rF;
    }
}
