package com.baidu.ar.marker;
/* loaded from: classes10.dex */
public enum TrackerType {
    NO_TRACKER_DATA(0),
    STANDARD_TRACKER_DATA(1),
    VIO_ARKIT_DATA(2),
    VIO_ARCORE_DATA(3),
    IMU_IPHONE(4),
    IMU_ANDROID(5);
    
    private int value;

    TrackerType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
