package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class YuyinFollowRoomMessage extends CustomResponsedMessage<FollowRoom> {
    private FollowRoom brL;

    public YuyinFollowRoomMessage(FollowRoom followRoom) {
        super(2501028);
        this.brL = followRoom;
    }

    public FollowRoom PX() {
        return this.brL;
    }
}
