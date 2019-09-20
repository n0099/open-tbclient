package com.baidu.media.duplayer.a;

import android.os.HandlerThread;
/* loaded from: classes.dex */
public class a extends HandlerThread {
    private long a;
    private volatile int b;

    public a(String str) {
        super(str);
        this.b = 0;
        this.a = -1L;
    }

    public long a() {
        return this.a;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(long j) {
        this.a = j;
    }
}
