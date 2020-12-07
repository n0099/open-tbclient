package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class YuyinShowRoomDialogMessage extends CustomResponsedMessage<SupportRoom> {
    private ShowRoomCard brO;

    public YuyinShowRoomDialogMessage(ShowRoomCard showRoomCard) {
        super(2501054);
        this.brO = showRoomCard;
    }

    public ShowRoomCard Qa() {
        return this.brO;
    }
}
