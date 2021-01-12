package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class YuyinModifyRoomMessage extends CustomResponsedMessage<ModifyRoomCover> {
    private ModifyRoomCover brG;

    public YuyinModifyRoomMessage(ModifyRoomCover modifyRoomCover) {
        super(2501030);
        this.brG = modifyRoomCover;
    }

    public ModifyRoomCover Nc() {
        return this.brG;
    }
}
