package com.baidu.adp.lib.util;

import java.io.Serializable;
/* loaded from: classes.dex */
public class NetworkState implements Serializable {
    public static final long serialVersionUID = 6342610950738914764L;
    public long mCurChangedTime;
    public int mCurNetState;
    public int mLastNetState;
    public long mlastChangedTime;

    public NetworkState() {
    }

    public NetworkState(int i2, int i3, long j, long j2) {
        this.mLastNetState = i2;
        this.mCurNetState = i3;
        this.mlastChangedTime = j;
        this.mCurChangedTime = j2;
    }
}
