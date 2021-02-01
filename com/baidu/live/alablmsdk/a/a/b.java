package com.baidu.live.alablmsdk.a.a;

import android.os.CountDownTimer;
import com.baidu.live.alablmsdk.a.e;
import java.util.List;
/* loaded from: classes11.dex */
public class b {
    private List<com.baidu.live.alablmsdk.a.a.a> awA;
    private a awB;
    private long awx;
    private long awy;
    private boolean awz;
    private long mId;
    private CountDownTimer mTimer;
    private Object object;
    private int type;

    /* loaded from: classes11.dex */
    public interface a {
        void a(int i, long j, Object obj);

        void a(int i, Object obj, long j);
    }

    public b(long j, int i, long j2, long j3, Object obj, boolean z, List<com.baidu.live.alablmsdk.a.a.a> list, a aVar) {
        com.baidu.live.alablmsdk.a.b.a.ag(" BLMCountDown structure ，mId=" + this.mId + " , type=" + i + " , sInFuture=" + j2 + " , sInterval=" + j3, "");
        this.mId = j;
        this.type = i;
        this.awx = j2;
        this.awy = j3;
        this.object = obj;
        this.awz = z;
        this.awA = list;
        this.awB = aVar;
    }

    public void startTimer() {
        if (this.awx > 0 && this.awy > 0) {
            cancelTimer();
            e.xq().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.mTimer == null) {
                        b.this.mTimer = new CountDownTimer(b.this.awx * 1000, b.this.awy * 1000) { // from class: com.baidu.live.alablmsdk.a.a.b.1.1
                            @Override // android.os.CountDownTimer
                            public void onTick(long j) {
                                float f = (float) (b.this.awx - (j / 1000));
                                com.baidu.live.alablmsdk.a.b.a.d(" onTick ，mId=" + b.this.mId + " time=" + f);
                                if (b.this.awB != null && !com.baidu.live.alablmsdk.a.a.isEmpty(b.this.awA)) {
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= b.this.awA.size()) {
                                            break;
                                        }
                                        com.baidu.live.alablmsdk.a.a.a aVar = (com.baidu.live.alablmsdk.a.a.a) b.this.awA.get(i2);
                                        if (aVar != null && !aVar.aww && f >= aVar.time) {
                                            aVar.aww = true;
                                            com.baidu.live.alablmsdk.a.b.a.ag(" countDown onNodeCallback mId=" + b.this.mId, "");
                                            b.this.awB.a(b.this.type, b.this.object, aVar.time);
                                        }
                                        i = i2 + 1;
                                    }
                                }
                                if (b.this.awz && b.this.awB != null) {
                                    b.this.awB.a(b.this.type, j, b.this.object);
                                }
                            }

                            @Override // android.os.CountDownTimer
                            public void onFinish() {
                                if (b.this.awB != null) {
                                    b.this.awB.a(b.this.type, b.this.object, b.this.awx);
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
        e.xq().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTimer != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag(" countDown cancelTimer mId=" + b.this.mId, "");
                    b.this.mTimer.cancel();
                }
            }
        });
    }

    public void xs() {
        e.xq().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.3
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
