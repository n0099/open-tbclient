package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class YuyinFollowRoomMessage extends CustomResponsedMessage<FollowRoom> {
    private FollowRoom brF;

    public YuyinFollowRoomMessage(FollowRoom followRoom) {
        super(2501028);
        this.brF = followRoom;
    }

    public FollowRoom Nb() {
        return this.brF;
    }
}
