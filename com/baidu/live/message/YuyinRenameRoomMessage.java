package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class YuyinRenameRoomMessage extends CustomResponsedMessage<RenameRoom> {
    private RenameRoom brN;

    public YuyinRenameRoomMessage(RenameRoom renameRoom) {
        super(2501029);
        this.brN = renameRoom;
    }

    public RenameRoom PZ() {
        return this.brN;
    }
}
