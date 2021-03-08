package com.baidu.live.alablmsdk.module.state;
/* loaded from: classes10.dex */
public enum BLMLegacyRoomStatus {
    LOGIC_ACTIVE(1),
    LOGIC_END_SUCCESS(2),
    LOGIC_END_FAIL(3);
    
    private int status;

    BLMLegacyRoomStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }
}
