package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class YuyinRenameRoomMessage extends CustomResponsedMessage<RenameRoom> {
    private RenameRoom bmX;

    public YuyinRenameRoomMessage(RenameRoom renameRoom) {
        super(2501029);
        this.bmX = renameRoom;
    }

    public RenameRoom NP() {
        return this.bmX;
    }
}
