package com.baidu.live.alablmsdk.a.a;

import android.os.CountDownTimer;
import com.baidu.live.alablmsdk.a.e;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private long axX;
    private long axY;
    private boolean axZ;
    private List<com.baidu.live.alablmsdk.a.a.a> aya;
    private a ayb;
    private long mId;
    private CountDownTimer mTimer;
    private Object object;
    private int type;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, long j, Object obj);

        void a(int i, Object obj, long j);
    }

    public b(long j, int i, long j2, long j3, Object obj, boolean z, List<com.baidu.live.alablmsdk.a.a.a> list, a aVar) {
        com.baidu.live.alablmsdk.a.b.a.ag(" BLMCountDown structure ，mId=" + this.mId + " , type=" + i + " , sInFuture=" + j2 + " , sInterval=" + j3, "");
        this.mId = j;
        this.type = i;
        this.axX = j2;
        this.axY = j3;
        this.object = obj;
        this.axZ = z;
        this.aya = list;
        this.ayb = aVar;
    }

    public void startTimer() {
        if (this.axX > 0 && this.axY > 0) {
            cancelTimer();
            e.xt().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.mTimer == null) {
                        b.this.mTimer = new CountDownTimer(b.this.axX * 1000, b.this.axY * 1000) { // from class: com.baidu.live.alablmsdk.a.a.b.1.1
                            @Override // android.os.CountDownTimer
                            public void onTick(long j) {
                                float f = (float) (b.this.axX - (j / 1000));
                                com.baidu.live.alablmsdk.a.b.a.d(" onTick ，mId=" + b.this.mId + " time=" + f);
                                if (b.this.ayb != null && !com.baidu.live.alablmsdk.a.a.isEmpty(b.this.aya)) {
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= b.this.aya.size()) {
                                            break;
                                        }
                                        com.baidu.live.alablmsdk.a.a.a aVar = (com.baidu.live.alablmsdk.a.a.a) b.this.aya.get(i2);
                                        if (aVar != null && !aVar.axW && f >= aVar.time) {
                                            aVar.axW = true;
                                            com.baidu.live.alablmsdk.a.b.a.ag(" countDown onNodeCallback mId=" + b.this.mId, "");
                                            b.this.ayb.a(b.this.type, b.this.object, aVar.time);
                                        }
                                        i = i2 + 1;
                                    }
                                }
                                if (b.this.axZ && b.this.ayb != null) {
                                    b.this.ayb.a(b.this.type, j, b.this.object);
                                }
                            }

                            @Override // android.os.CountDownTimer
                            public void onFinish() {
                                if (b.this.ayb != null) {
                                    b.this.ayb.a(b.this.type, b.this.object, b.this.axX);
                                }
                            }
                        };
                    }
                    com.baidu.live.alablmsdk.a.b.a.ag(" countDown startTimer mId=" + b.this.mId, "");
                    b.this.mTimer.start();
                }
            });
        }
    }

    public void cancelTimer() {
        e.xt().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTimer != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag(" countDown cancelTimer mId=" + b.this.mId, "");
                    b.this.mTimer.cancel();
                }
            }
        });
    }

    public void xv() {
        e.xt().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTimer != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag(" countDown releaseTimer mId=" + b.this.mId, "");
                    b.this.mTimer.cancel();
                    b.this.mTimer = null;
                }
            }
        });
    }
}
