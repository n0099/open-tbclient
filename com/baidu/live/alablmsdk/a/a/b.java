package com.baidu.live.alablmsdk.a.a;

import android.os.CountDownTimer;
import com.baidu.live.alablmsdk.a.e;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private long aBe;
    private long aBf;
    private boolean aBg;
    private List<com.baidu.live.alablmsdk.a.a.a> aBh;
    private a aBi;
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
        com.baidu.live.alablmsdk.a.b.a.ak(" BLMCountDown structure ，mId=" + this.mId + " , type=" + i + " , sInFuture=" + j2 + " , sInterval=" + j3, "");
        this.mId = j;
        this.type = i;
        this.aBe = j2;
        this.aBf = j3;
        this.object = obj;
        this.aBg = z;
        this.aBh = list;
        this.aBi = aVar;
    }

    public void startTimer() {
        if (this.aBe > 0 && this.aBf > 0) {
            cancelTimer();
            e.BU().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.mTimer == null) {
                        b.this.mTimer = new CountDownTimer(b.this.aBe * 1000, b.this.aBf * 1000) { // from class: com.baidu.live.alablmsdk.a.a.b.1.1
                            @Override // android.os.CountDownTimer
                            public void onTick(long j) {
                                float f = (float) (b.this.aBe - (j / 1000));
                                com.baidu.live.alablmsdk.a.b.a.d(" onTick ，mId=" + b.this.mId + " time=" + f);
                                if (b.this.aBi != null && !com.baidu.live.alablmsdk.a.a.isEmpty(b.this.aBh)) {
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= b.this.aBh.size()) {
                                            break;
                                        }
                                        com.baidu.live.alablmsdk.a.a.a aVar = (com.baidu.live.alablmsdk.a.a.a) b.this.aBh.get(i2);
                                        if (aVar != null && !aVar.aBd && f >= aVar.time) {
                                            aVar.aBd = true;
                                            com.baidu.live.alablmsdk.a.b.a.ak(" countDown onNodeCallback mId=" + b.this.mId, "");
                                            b.this.aBi.a(b.this.type, b.this.object, aVar.time);
                                        }
                                        i = i2 + 1;
                                    }
                                }
                                if (b.this.aBg && b.this.aBi != null) {
                                    b.this.aBi.a(b.this.type, j, b.this.object);
                                }
                            }

                            @Override // android.os.CountDownTimer
                            public void onFinish() {
                                if (b.this.aBi != null) {
                                    b.this.aBi.a(b.this.type, b.this.object, b.this.aBe);
                                }
                            }
                        };
                    }
                    com.baidu.live.alablmsdk.a.b.a.ak(" countDown startTimer mId=" + b.this.mId, "");
                    b.this.mTimer.start();
                }
            });
        }
    }

    public void cancelTimer() {
        e.BU().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTimer != null) {
                    com.baidu.live.alablmsdk.a.b.a.ak(" countDown cancelTimer mId=" + b.this.mId, "");
                    b.this.mTimer.cancel();
                }
            }
        });
    }

    public void BW() {
        e.BU().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTimer != null) {
                    com.baidu.live.alablmsdk.a.b.a.ak(" countDown releaseTimer mId=" + b.this.mId, "");
                    b.this.mTimer.cancel();
                    b.this.mTimer = null;
                }
            }
        });
    }
}
