package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class YuyinRenameRoomMessage extends CustomResponsedMessage<RenameRoom> {
    private RenameRoom bmF;

    public YuyinRenameRoomMessage(RenameRoom renameRoom) {
        super(2501029);
        this.bmF = renameRoom;
    }

    public RenameRoom NG() {
        return this.bmF;
    }
}
