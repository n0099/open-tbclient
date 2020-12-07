package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class YuyinModifyRoomMessage extends CustomResponsedMessage<ModifyRoomCover> {
    private ModifyRoomCover brM;

    public YuyinModifyRoomMessage(ModifyRoomCover modifyRoomCover) {
        super(2501030);
        this.brM = modifyRoomCover;
    }

    public ModifyRoomCover PY() {
        return this.brM;
    }
}
