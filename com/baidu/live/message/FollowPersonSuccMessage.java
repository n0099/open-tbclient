package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class FollowPersonSuccMessage extends CustomResponsedMessage<FollowPersonSucc> {
    private FollowPersonSucc bmz;

    public FollowPersonSuccMessage(FollowPersonSucc followPersonSucc) {
        super(2501055);
        this.bmz = followPersonSucc;
    }
}
