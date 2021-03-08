package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class YuyinSupportRoomMessage extends CustomResponsedMessage<SupportRoom> {
    private SupportRoom bwM;

    public YuyinSupportRoomMessage(SupportRoom supportRoom) {
        super(2501034);
        this.bwM = supportRoom;
    }
}
