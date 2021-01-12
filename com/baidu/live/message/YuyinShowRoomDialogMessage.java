package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class YuyinShowRoomDialogMessage extends CustomResponsedMessage<SupportRoom> {
    private ShowRoomCard brI;

    public YuyinShowRoomDialogMessage(ShowRoomCard showRoomCard) {
        super(2501054);
        this.brI = showRoomCard;
    }

    public ShowRoomCard Ne() {
        return this.brI;
    }
}
