package com.baidu.live.alablmsdk.config.enums;
/* loaded from: classes11.dex */
public enum BLMLiveTransferMode {
    BLM_LIVE_TRANSFER_MODE_NONE(0),
    BLM_LIVE_TRANSFER_MODE_ROOM(1),
    BLM_LIVE_TRANSFER_MODE_ANCHOR(2),
    BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR(3);
    
    private int mValue;

    BLMLiveTransferMode(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }
}
