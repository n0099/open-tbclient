package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class YuyinModifyRoomMessage extends CustomResponsedMessage<ModifyRoomCover> {
    private ModifyRoomCover bop;

    public YuyinModifyRoomMessage(ModifyRoomCover modifyRoomCover) {
        super(2501030);
        this.bop = modifyRoomCover;
    }

    public ModifyRoomCover Oo() {
        return this.bop;
    }
}
