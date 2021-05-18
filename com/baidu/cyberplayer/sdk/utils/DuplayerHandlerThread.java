package com.baidu.cyberplayer.sdk.utils;

import android.os.HandlerThread;
import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes2.dex */
public class DuplayerHandlerThread extends HandlerThread {
    public static final int STATE_IDLE = 0;
    public static final int STATE_IN_USE = 1;
    public static final String TAG = "DuplayerHandlerThread";

    /* renamed from: a  reason: collision with root package name */
    public long f5103a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f5104b;

    public DuplayerHandlerThread(String str) {
        super(str);
        this.f5104b = 0;
        this.f5103a = -1L;
    }

    public DuplayerHandlerThread(String str, int i2) {
        super(str, i2);
        this.f5104b = 0;
        this.f5103a = -1L;
    }

    public long getIdleBeginTime() {
        return this.f5103a;
    }

    public int getRunState() {
        return this.f5104b;
    }

    public void setIdleBeginTime(long j) {
        this.f5103a = j;
    }

    public void setRunState(int i2) {
        this.f5104b = i2;
    }
}
