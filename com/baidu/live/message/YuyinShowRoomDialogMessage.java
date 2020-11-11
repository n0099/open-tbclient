package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class YuyinShowRoomDialogMessage extends CustomResponsedMessage<SupportRoom> {
    private ShowRoomCard bor;

    public YuyinShowRoomDialogMessage(ShowRoomCard showRoomCard) {
        super(2501054);
        this.bor = showRoomCard;
    }

    public ShowRoomCard Oq() {
        return this.bor;
    }
}
