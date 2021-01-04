package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class YuyinFollowRoomMessage extends CustomResponsedMessage<FollowRoom> {
    private FollowRoom bwt;

    public YuyinFollowRoomMessage(FollowRoom followRoom) {
        super(2501028);
        this.bwt = followRoom;
    }

    public FollowRoom QW() {
        return this.bwt;
    }
}
