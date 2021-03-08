package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class YuyinRenameRoomMessage extends CustomResponsedMessage<RenameRoom> {
    private RenameRoom bwK;

    public YuyinRenameRoomMessage(RenameRoom renameRoom) {
        super(2501029);
        this.bwK = renameRoom;
    }

    public RenameRoom OE() {
        return this.bwK;
    }
}
