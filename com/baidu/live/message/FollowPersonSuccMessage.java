package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class FollowPersonSuccMessage extends CustomResponsedMessage<FollowPersonSucc> {
    private FollowPersonSucc bwE;

    public FollowPersonSuccMessage(FollowPersonSucc followPersonSucc) {
        super(2501055);
        this.bwE = followPersonSucc;
    }
}
