package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class NetWorkChangeMessage extends CustomResponsedMessage<Integer> {
    public int mState;

    public NetWorkChangeMessage(int i) {
        super(MessageTypes.CMD_NETWORK_CHANGE);
        this.mState = i;
    }
}
