package com.baidu.live.alablmsdk.a.a;

import android.os.CountDownTimer;
import com.baidu.live.alablmsdk.a.f;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private long aAA;
    private boolean aAB;
    private List<com.baidu.live.alablmsdk.a.a.a> aAC;
    private a aAD;
    private long aAz;
    private long mId;
    private CountDownTimer mTimer;
    private Object object;
    private int type;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, long j, Object obj);

        void a(int i, Object obj, long j);
    }

    public b(long j, int i, long j2, long j3, Object obj, boolean z, List<com.baidu.live.alablmsdk.a.a.a> list, a aVar) {
        com.baidu.live.alablmsdk.a.b.ah(" BLMCountDown structure ，mId=" + this.mId + " , type=" + i + " , sInFuture=" + j2 + " , sInterval=" + j3, "");
        this.mId = j;
        this.type = i;
        this.aAz = j2;
        this.aAA = j3;
        this.object = obj;
        this.aAB = z;
        this.aAC = list;
        this.aAD = aVar;
    }

    public void startTimer() {
        if (this.aAz > 0 && this.aAA > 0) {
            cancelTimer();
            f.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.mTimer == null) {
                        b.this.mTimer = new CountDownTimer(b.this.aAz * 1000, b.this.aAA * 1000) { // from class: com.baidu.live.alablmsdk.a.a.b.1.1
                            @Override // android.os.CountDownTimer
                            public void onTick(long j) {
                                float f = (float) (b.this.aAz - (j / 1000));
                                com.baidu.live.alablmsdk.a.b.d(" onTick ，mId=" + b.this.mId + " time=" + f);
                                if (b.this.aAD != null && !com.baidu.live.alablmsdk.a.a.isEmpty(b.this.aAC)) {
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= b.this.aAC.size()) {
                                            break;
                                        }
                                        com.baidu.live.alablmsdk.a.a.a aVar = (com.baidu.live.alablmsdk.a.a.a) b.this.aAC.get(i2);
                                        if (aVar != null && !aVar.aAy && f >= aVar.time) {
                                            aVar.aAy = true;
                                            com.baidu.live.alablmsdk.a.b.ah(" countDown onNodeCallback mId=" + b.this.mId, "");
                                            b.this.aAD.a(b.this.type, b.this.object, aVar.time);
                                        }
                                        i = i2 + 1;
                                    }
                                }
                                if (b.this.aAB && b.this.aAD != null) {
                                    b.this.aAD.a(b.this.type, j, b.this.object);
                                }
                            }

                            @Override // android.os.CountDownTimer
                            public void onFinish() {
                                if (b.this.aAD != null) {
                                    b.this.aAD.a(b.this.type, b.this.object, b.this.aAz);
                                }
                            }
                        };
                    }
                    com.baidu.live.alablmsdk.a.b.ah(" countDown startTimer mId=" + b.this.mId, "");
                    b.this.mTimer.start();
                }
            });
        }
    }

    public void cancelTimer() {
        if (this.mTimer != null) {
            com.baidu.live.alablmsdk.a.b.ah(" countDown cancelTimer mId=" + this.mId, "");
            this.mTimer.cancel();
        }
    }

    public void Bl() {
        if (this.mTimer != null) {
            com.baidu.live.alablmsdk.a.b.ah(" countDown releaseTimer mId=" + this.mId, "");
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }
}
