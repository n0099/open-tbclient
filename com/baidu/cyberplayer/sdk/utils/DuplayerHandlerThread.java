package com.baidu.cyberplayer.sdk.utils;

import android.os.HandlerThread;
import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes3.dex */
public class DuplayerHandlerThread extends HandlerThread {
    public static final int STATE_IDLE = 0;
    public static final int STATE_IN_USE = 1;
    public static final String TAG = "DuplayerHandlerThread";
    public long mIdleBeginTime;
    public volatile int mState;

    public DuplayerHandlerThread(String str) {
        super(str);
        this.mState = 0;
        this.mIdleBeginTime = -1L;
    }

    public void setIdleBeginTime(long j) {
        this.mIdleBeginTime = j;
    }

    public void setRunState(int i) {
        this.mState = i;
    }

    public DuplayerHandlerThread(String str, int i) {
        super(str, i);
        this.mState = 0;
        this.mIdleBeginTime = -1L;
    }

    public long getIdleBeginTime() {
        return this.mIdleBeginTime;
    }

    public int getRunState() {
        return this.mState;
    }
}
