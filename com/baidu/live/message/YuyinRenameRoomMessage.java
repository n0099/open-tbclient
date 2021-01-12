package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class YuyinRenameRoomMessage extends CustomResponsedMessage<RenameRoom> {
    private RenameRoom brH;

    public YuyinRenameRoomMessage(RenameRoom renameRoom) {
        super(2501029);
        this.brH = renameRoom;
    }

    public RenameRoom Nd() {
        return this.brH;
    }
}
