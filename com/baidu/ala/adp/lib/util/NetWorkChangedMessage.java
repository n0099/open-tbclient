package com.baidu.ala.adp.lib.util;
/* loaded from: classes5.dex */
public class NetWorkChangedMessage {
    public final long mCurChangedTime;
    public final int mCurNetState;
    public final int mLastNetState;
    public final long mlastChangedTime;

    public NetWorkChangedMessage(NetworkState networkState) {
        if (networkState == null) {
            throw new NullPointerException("NetworkState is Null");
        }
        this.mLastNetState = networkState.mLastNetState;
        this.mCurNetState = networkState.mCurNetState;
        this.mlastChangedTime = networkState.mlastChangedTime;
        this.mCurChangedTime = networkState.mCurChangedTime;
    }
}
