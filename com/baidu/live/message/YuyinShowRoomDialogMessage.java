package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class YuyinShowRoomDialogMessage extends CustomResponsedMessage<SupportRoom> {
    private ShowRoomCard bmY;

    public YuyinShowRoomDialogMessage(ShowRoomCard showRoomCard) {
        super(2501054);
        this.bmY = showRoomCard;
    }

    public ShowRoomCard NQ() {
        return this.bmY;
    }
}
