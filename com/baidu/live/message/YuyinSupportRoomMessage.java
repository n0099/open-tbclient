package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class YuyinSupportRoomMessage extends CustomResponsedMessage<SupportRoom> {
    private SupportRoom bmH;

    public YuyinSupportRoomMessage(SupportRoom supportRoom) {
        super(2501034);
        this.bmH = supportRoom;
    }
}
