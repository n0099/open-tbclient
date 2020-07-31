package com.baidu.live.adp.lib.util;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class NetworkState implements Serializable {
    private static final long serialVersionUID = 6342610950738914764L;
    public long mCurChangedTime;
    public int mCurNetState;
    public int mLastNetState;
    public long mlastChangedTime;

    public NetworkState() {
    }

    public NetworkState(int i, int i2, long j, long j2) {
        this.mLastNetState = i;
        this.mCurNetState = i2;
        this.mlastChangedTime = j;
        this.mCurChangedTime = j2;
    }
}
