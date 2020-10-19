package com.baidu.ar.imu;
/* loaded from: classes14.dex */
public enum b {
    WORLD(0),
    RELATIVE(1);
    
    private int ro;

    b(int i) {
        this.ro = i;
    }

    public static b J(int i) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.getTypeValue() == i) {
                return bVar;
            }
        }
        return null;
    }

    public int getTypeValue() {
        return this.ro;
    }
}
