package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class YuyinSupportRoomMessage extends CustomResponsedMessage<SupportRoom> {
    private SupportRoom bmZ;

    public YuyinSupportRoomMessage(SupportRoom supportRoom) {
        super(2501034);
        this.bmZ = supportRoom;
    }
}
