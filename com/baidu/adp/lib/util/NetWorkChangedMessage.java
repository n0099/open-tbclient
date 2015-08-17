package com.baidu.adp.lib.util;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NetWorkChangedMessage extends CustomResponsedMessage<NetworkState> {
    public final long mCurChangedTime;
    public final int mCurNetState;
    public final int mLastNetState;
    public final long mlastChangedTime;

    public NetWorkChangedMessage(NetworkState networkState) {
        super(2000994);
        if (networkState == null) {
            throw new NullPointerException("NetworkState is Null");
        }
        this.mLastNetState = networkState.mLastNetState;
        this.mCurNetState = networkState.mCurNetState;
        this.mlastChangedTime = networkState.mlastChangedTime;
        this.mCurChangedTime = networkState.mCurChangedTime;
    }
}
