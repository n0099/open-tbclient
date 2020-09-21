package com.baidu.ar;
/* loaded from: classes10.dex */
public enum ARType {
    TRACK_2D(0),
    LBS(1),
    GAME(2),
    UDT(3),
    NPC(4),
    VO(5),
    ON_DEVICE_IR(6),
    CLOUD_IR(7),
    IMU(8),
    FACE(10),
    VPAS(11);
    
    private int mTypeValue;

    ARType(int i) {
        this.mTypeValue = i;
    }

    public static ARType valueOf(int i) {
        ARType[] values;
        for (ARType aRType : values()) {
            if (aRType.getTypeValue() == i) {
                return aRType;
            }
        }
        return null;
    }

    public int getTypeValue() {
        return this.mTypeValue;
    }
}
