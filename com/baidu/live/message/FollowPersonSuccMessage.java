package com.baidu.live.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class FollowPersonSuccMessage extends CustomResponsedMessage<FollowPersonSucc> {
    private FollowPersonSucc bve;

    public FollowPersonSuccMessage(FollowPersonSucc followPersonSucc) {
        super(2501055);
        this.bve = followPersonSucc;
    }
}
