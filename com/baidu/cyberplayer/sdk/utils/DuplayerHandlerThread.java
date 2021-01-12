package com.baidu.cyberplayer.sdk.utils;

import android.os.HandlerThread;
import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes5.dex */
public class DuplayerHandlerThread extends HandlerThread {
    public static final int STATE_IDLE = 0;
    public static final int STATE_IN_USE = 1;
    public static final String TAG = "DuplayerHandlerThread";

    /* renamed from: a  reason: collision with root package name */
    private long f1848a;

    /* renamed from: b  reason: collision with root package name */
    private volatile int f1849b;

    public DuplayerHandlerThread(String str) {
        super(str);
        this.f1849b = 0;
        this.f1848a = -1L;
    }

    public DuplayerHandlerThread(String str, int i) {
        super(str, i);
        this.f1849b = 0;
        this.f1848a = -1L;
    }

    public long getIdleBeginTime() {
        return this.f1848a;
    }

    public int getRunState() {
        return this.f1849b;
    }

    public void setIdleBeginTime(long j) {
        this.f1848a = j;
    }

    public void setRunState(int i) {
        this.f1849b = i;
    }
}
