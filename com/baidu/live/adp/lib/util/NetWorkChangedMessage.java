package com.baidu.live.adp.lib.util;

import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class NetWorkChangedMessage extends CustomResponsedMessage<NetworkState> {
    public final long mCurChangedTime;
    public final int mCurNetState;
    public final int mLastNetState;
    public final long mlastChangedTime;

    public NetWorkChangedMessage(NetworkState networkState) {
        super(MessageConfig.CMD_NETWORK_CHANGED);
        if (networkState == null) {
            throw new NullPointerException("NetworkState is Null");
        }
        this.mLastNetState = networkState.mLastNetState;
        this.mCurNetState = networkState.mCurNetState;
        this.mlastChangedTime = networkState.mlastChangedTime;
        this.mCurChangedTime = networkState.mCurChangedTime;
    }
}
