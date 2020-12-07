package com.baidu.cyberplayer.sdk.utils;

import android.os.HandlerThread;
import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes17.dex */
public class DuplayerHandlerThread extends HandlerThread {
    public static final int STATE_IDLE = 0;
    public static final int STATE_IN_USE = 1;
    public static final String TAG = "DuplayerHandlerThread";

    /* renamed from: a  reason: collision with root package name */
    private long f1440a;
    private volatile int b;

    public DuplayerHandlerThread(String str) {
        super(str);
        this.b = 0;
        this.f1440a = -1L;
    }

    public DuplayerHandlerThread(String str, int i) {
        super(str, i);
        this.b = 0;
        this.f1440a = -1L;
    }

    public long getIdleBeginTime() {
        return this.f1440a;
    }

    public int getRunState() {
        return this.b;
    }

    public void setIdleBeginTime(long j) {
        this.f1440a = j;
    }

    public void setRunState(int i) {
        this.b = i;
    }
}
