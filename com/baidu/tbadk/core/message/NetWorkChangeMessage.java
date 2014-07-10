package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NetWorkChangeMessage extends CustomResponsedMessage<Integer> {
    public int mState;

    public NetWorkChangeMessage(int i) {
        super(2001121);
        this.mState = i;
    }
}
