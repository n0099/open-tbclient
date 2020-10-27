package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class YuyinFollowRoomMessage extends CustomResponsedMessage<FollowRoom> {
    private FollowRoom bmV;

    public YuyinFollowRoomMessage(FollowRoom followRoom) {
        super(2501028);
        this.bmV = followRoom;
    }

    public FollowRoom NN() {
        return this.bmV;
    }
}
