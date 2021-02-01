package com.baidu.cyberplayer.sdk.utils;

import android.os.HandlerThread;
import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes4.dex */
public class DuplayerHandlerThread extends HandlerThread {
    public static final int STATE_IDLE = 0;
    public static final int STATE_IN_USE = 1;
    public static final String TAG = "DuplayerHandlerThread";

    /* renamed from: a  reason: collision with root package name */
    private long f1846a;

    /* renamed from: b  reason: collision with root package name */
    private volatile int f1847b;

    public DuplayerHandlerThread(String str) {
        super(str);
        this.f1847b = 0;
        this.f1846a = -1L;
    }

    public DuplayerHandlerThread(String str, int i) {
        super(str, i);
        this.f1847b = 0;
        this.f1846a = -1L;
    }

    public long getIdleBeginTime() {
        return this.f1846a;
    }

    public int getRunState() {
        return this.f1847b;
    }

    public void setIdleBeginTime(long j) {
        this.f1846a = j;
    }

    public void setRunState(int i) {
        this.f1847b = i;
    }
}
