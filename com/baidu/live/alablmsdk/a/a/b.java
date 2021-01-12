package com.baidu.live.alablmsdk.a.a;

import android.os.CountDownTimer;
import com.baidu.live.alablmsdk.a.e;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private long awI;
    private long awJ;
    private boolean awK;
    private List<com.baidu.live.alablmsdk.a.a.a> awL;
    private a awM;
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
        com.baidu.live.alablmsdk.a.b.a.ai(" BLMCountDown structure ，mId=" + this.mId + " , type=" + i + " , sInFuture=" + j2 + " , sInterval=" + j3, "");
        this.mId = j;
        this.type = i;
        this.awI = j2;
        this.awJ = j3;
        this.object = obj;
        this.awK = z;
        this.awL = list;
        this.awM = aVar;
    }

    public void startTimer() {
        if (this.awI > 0 && this.awJ > 0) {
            cancelTimer();
            e.xq().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.mTimer == null) {
                        b.this.mTimer = new CountDownTimer(b.this.awI * 1000, b.this.awJ * 1000) { // from class: com.baidu.live.alablmsdk.a.a.b.1.1
                            @Override // android.os.CountDownTimer
                            public void onTick(long j) {
                                float f = (float) (b.this.awI - (j / 1000));
                                com.baidu.live.alablmsdk.a.b.a.d(" onTick ，mId=" + b.this.mId + " time=" + f);
                                if (b.this.awM != null && !com.baidu.live.alablmsdk.a.a.isEmpty(b.this.awL)) {
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= b.this.awL.size()) {
                                            break;
                                        }
                                        com.baidu.live.alablmsdk.a.a.a aVar = (com.baidu.live.alablmsdk.a.a.a) b.this.awL.get(i2);
                                        if (aVar != null && !aVar.awH && f >= aVar.time) {
                                            aVar.awH = true;
                                            com.baidu.live.alablmsdk.a.b.a.ai(" countDown onNodeCallback mId=" + b.this.mId, "");
                                            b.this.awM.a(b.this.type, b.this.object, aVar.time);
                                        }
                                        i = i2 + 1;
                                    }
                                }
                                if (b.this.awK && b.this.awM != null) {
                                    b.this.awM.a(b.this.type, j, b.this.object);
                                }
                            }

                            @Override // android.os.CountDownTimer
                            public void onFinish() {
                                if (b.this.awM != null) {
                                    b.this.awM.a(b.this.type, b.this.object, b.this.awI);
                                }
                            }
                        };
                    }
                    com.baidu.live.alablmsdk.a.b.a.ai(" countDown startTimer mId=" + b.this.mId, "");
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
                    com.baidu.live.alablmsdk.a.b.a.ai(" countDown cancelTimer mId=" + b.this.mId, "");
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
                    com.baidu.live.alablmsdk.a.b.a.ai(" countDown releaseTimer mId=" + b.this.mId, "");
                    b.this.mTimer.cancel();
                    b.this.mTimer = null;
                }
            }
        });
    }
}
