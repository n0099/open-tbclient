package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class YuyinRenameRoomMessage extends CustomResponsedMessage<RenameRoom> {
    private RenameRoom bwv;

    public YuyinRenameRoomMessage(RenameRoom renameRoom) {
        super(2501029);
        this.bwv = renameRoom;
    }

    public RenameRoom QY() {
        return this.bwv;
    }
}
