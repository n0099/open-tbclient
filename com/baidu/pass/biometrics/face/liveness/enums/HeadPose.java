package com.baidu.pass.biometrics.face.liveness.enums;
/* loaded from: classes2.dex */
public enum HeadPose {
    EYES_BLINK(0, 1),
    DOWN(1, 2),
    UP(2, 4),
    TURN_LEFT(3, 8),
    TURN_RIGHT(4, 16),
    MOUTH_OPEN(5, 32);
    
    public int index;
    public int value;

    HeadPose(int i2, int i3) {
        this.index = i2;
        this.value = i3;
    }

    public static HeadPose getHeadPoseByIndex(Integer num) {
        HeadPose[] values;
        for (HeadPose headPose : values()) {
            if (num.intValue() == headPose.index) {
                return headPose;
            }
        }
        return EYES_BLINK;
    }

    public static HeadPose getHeadPoseByValues(Integer num) {
        HeadPose[] values;
        for (HeadPose headPose : values()) {
            if (num.intValue() == headPose.value) {
                return headPose;
            }
        }
        return EYES_BLINK;
    }
}
