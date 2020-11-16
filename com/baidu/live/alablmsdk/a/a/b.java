package com.baidu.live.alablmsdk.a.a;

import android.os.CountDownTimer;
import com.baidu.live.alablmsdk.a.f;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private long ayO;
    private long ayP;
    private boolean ayQ;
    private List<com.baidu.live.alablmsdk.a.a.a> ayR;
    private a ayS;
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
        com.baidu.live.alablmsdk.a.b.ag(" BLMCountDown structure ，mId=" + this.mId + " , type=" + i + " , sInFuture=" + j2 + " , sInterval=" + j3, "");
        this.mId = j;
        this.type = i;
        this.ayO = j2;
        this.ayP = j3;
        this.object = obj;
        this.ayQ = z;
        this.ayR = list;
        this.ayS = aVar;
    }

    public void startTimer() {
        if (this.ayO > 0 && this.ayP > 0) {
            cancelTimer();
            f.AA().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.mTimer == null) {
                        b.this.mTimer = new CountDownTimer(b.this.ayO * 1000, b.this.ayP * 1000) { // from class: com.baidu.live.alablmsdk.a.a.b.1.1
                            @Override // android.os.CountDownTimer
                            public void onTick(long j) {
                                float f = (float) (b.this.ayO - (j / 1000));
                                com.baidu.live.alablmsdk.a.b.d(" onTick ，mId=" + b.this.mId + " time=" + f);
                                if (b.this.ayS != null && !com.baidu.live.alablmsdk.a.a.isEmpty(b.this.ayR)) {
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= b.this.ayR.size()) {
                                            break;
                                        }
                                        com.baidu.live.alablmsdk.a.a.a aVar = (com.baidu.live.alablmsdk.a.a.a) b.this.ayR.get(i2);
                                        if (aVar != null && !aVar.ayN && f >= aVar.time) {
                                            aVar.ayN = true;
                                            com.baidu.live.alablmsdk.a.b.ag(" countDown onNodeCallback mId=" + b.this.mId, "");
                                            b.this.ayS.a(b.this.type, b.this.object, aVar.time);
                                        }
                                        i = i2 + 1;
                                    }
                                }
                                if (b.this.ayQ && b.this.ayS != null) {
                                    b.this.ayS.a(b.this.type, j, b.this.object);
                                }
                            }

                            @Override // android.os.CountDownTimer
                            public void onFinish() {
                                if (b.this.ayS != null) {
                                    b.this.ayS.a(b.this.type, b.this.object, b.this.ayO);
                                }
                            }
                        };
                    }
                    com.baidu.live.alablmsdk.a.b.ag(" countDown startTimer mId=" + b.this.mId, "");
                    b.this.mTimer.start();
                }
            });
        }
    }

    public void cancelTimer() {
        if (this.mTimer != null) {
            com.baidu.live.alablmsdk.a.b.ag(" countDown cancelTimer mId=" + this.mId, "");
            this.mTimer.cancel();
        }
    }

    public void AC() {
        if (this.mTimer != null) {
            com.baidu.live.alablmsdk.a.b.ag(" countDown releaseTimer mId=" + this.mId, "");
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }
}
