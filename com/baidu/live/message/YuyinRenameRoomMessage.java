package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class YuyinRenameRoomMessage extends CustomResponsedMessage<RenameRoom> {
    private RenameRoom bvk;

    public YuyinRenameRoomMessage(RenameRoom renameRoom) {
        super(2501029);
        this.bvk = renameRoom;
    }

    public RenameRoom OB() {
        return this.bvk;
    }
}
