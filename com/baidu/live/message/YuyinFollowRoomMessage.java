package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class YuyinFollowRoomMessage extends CustomResponsedMessage<FollowRoom> {
    private FollowRoom bwI;

    public YuyinFollowRoomMessage(FollowRoom followRoom) {
        super(2501028);
        this.bwI = followRoom;
    }

    public FollowRoom OC() {
        return this.bwI;
    }
}
