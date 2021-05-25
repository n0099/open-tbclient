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
    public long f5003a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f5004b;

    public DuplayerHandlerThread(String str) {
        super(str);
        this.f5004b = 0;
        this.f5003a = -1L;
    }

    public DuplayerHandlerThread(String str, int i2) {
        super(str, i2);
        this.f5004b = 0;
        this.f5003a = -1L;
    }

    public long getIdleBeginTime() {
        return this.f5003a;
    }

    public int getRunState() {
        return this.f5004b;
    }

    public void setIdleBeginTime(long j) {
        this.f5003a = j;
    }

    public void setRunState(int i2) {
        this.f5004b = i2;
    }
}
