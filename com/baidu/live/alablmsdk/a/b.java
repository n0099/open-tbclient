package com.baidu.live.alablmsdk.a;

import android.os.CountDownTimer;
/* loaded from: classes4.dex */
public class b {
    private long aAr;
    private CountDownTimer mTimer;
    private Object object;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, long j, Object obj);

        void b(int i, Object obj);
    }

    public void a(final int i, long j, long j2, final a aVar) {
        cancelTimer();
        this.aAr = j;
        this.mTimer = new CountDownTimer(j, j2) { // from class: com.baidu.live.alablmsdk.a.b.1
            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                if (aVar != null) {
                    aVar.a(i, j3, b.this.object);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (aVar != null) {
                    aVar.b(i, b.this.object);
                }
            }
        };
        this.mTimer.start();
    }

    public long Bf() {
        return this.aAr / 1000;
    }

    public void I(Object obj) {
        this.object = obj;
    }

    public void cancelTimer() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }
}
