package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class YuyinFollowRoomMessage extends CustomResponsedMessage<FollowRoom> {
    private FollowRoom bvi;

    public YuyinFollowRoomMessage(FollowRoom followRoom) {
        super(2501028);
        this.bvi = followRoom;
    }

    public FollowRoom Oz() {
        return this.bvi;
    }
}
