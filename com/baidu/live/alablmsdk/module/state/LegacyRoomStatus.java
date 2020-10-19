package com.baidu.live.alablmsdk.module.state;
/* loaded from: classes4.dex */
public enum LegacyRoomStatus {
    LOGIC_ACTIVE(1),
    LOGIC_END_SUCCESS(2),
    LOGIC_END_FAIL(3);
    
    private int status;

    LegacyRoomStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }
}
