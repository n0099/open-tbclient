package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class ThreadInfo {
    public final int mId;
    public final String mName;
    public final Call mTopLevelCall;

    public ThreadInfo(int i2, @NonNull String str, @Nullable Call call) {
        this.mId = i2;
        this.mName = str;
        this.mTopLevelCall = call;
    }

    public int getId() {
        return this.mId;
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    @Nullable
    public Call getTopLevelCall() {
        return this.mTopLevelCall;
    }
}
