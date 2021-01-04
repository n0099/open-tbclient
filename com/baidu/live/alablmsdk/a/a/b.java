package com.baidu.live.alablmsdk.a.a;

import android.os.CountDownTimer;
import com.baidu.live.alablmsdk.a.e;
import java.util.List;
/* loaded from: classes11.dex */
public class b {
    private long aBv;
    private long aBw;
    private boolean aBx;
    private List<com.baidu.live.alablmsdk.a.a.a> aBy;
    private a aBz;
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
        com.baidu.live.alablmsdk.a.b.a.aj(" BLMCountDown structure ，mId=" + this.mId + " , type=" + i + " , sInFuture=" + j2 + " , sInterval=" + j3, "");
        this.mId = j;
        this.type = i;
        this.aBv = j2;
        this.aBw = j3;
        this.object = obj;
        this.aBx = z;
        this.aBy = list;
        this.aBz = aVar;
    }

    public void startTimer() {
        if (this.aBv > 0 && this.aBw > 0) {
            cancelTimer();
            e.Bl().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.mTimer == null) {
                        b.this.mTimer = new CountDownTimer(b.this.aBv * 1000, b.this.aBw * 1000) { // from class: com.baidu.live.alablmsdk.a.a.b.1.1
                            @Override // android.os.CountDownTimer
                            public void onTick(long j) {
                                float f = (float) (b.this.aBv - (j / 1000));
                                com.baidu.live.alablmsdk.a.b.a.d(" onTick ，mId=" + b.this.mId + " time=" + f);
                                if (b.this.aBz != null && !com.baidu.live.alablmsdk.a.a.isEmpty(b.this.aBy)) {
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= b.this.aBy.size()) {
                                            break;
                                        }
                                        com.baidu.live.alablmsdk.a.a.a aVar = (com.baidu.live.alablmsdk.a.a.a) b.this.aBy.get(i2);
                                        if (aVar != null && !aVar.aBu && f >= aVar.time) {
                                            aVar.aBu = true;
                                            com.baidu.live.alablmsdk.a.b.a.aj(" countDown onNodeCallback mId=" + b.this.mId, "");
                                            b.this.aBz.a(b.this.type, b.this.object, aVar.time);
                                        }
                                        i = i2 + 1;
                                    }
                                }
                                if (b.this.aBx && b.this.aBz != null) {
                                    b.this.aBz.a(b.this.type, j, b.this.object);
                                }
                            }

                            @Override // android.os.CountDownTimer
                            public void onFinish() {
                                if (b.this.aBz != null) {
                                    b.this.aBz.a(b.this.type, b.this.object, b.this.aBv);
                                }
                            }
                        };
                    }
                    com.baidu.live.alablmsdk.a.b.a.aj(" countDown startTimer mId=" + b.this.mId, "");
                    b.this.mTimer.start();
                }
            });
        }
    }

    public void cancelTimer() {
        e.Bl().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTimer != null) {
                    com.baidu.live.alablmsdk.a.b.a.aj(" countDown cancelTimer mId=" + b.this.mId, "");
                    b.this.mTimer.cancel();
                }
            }
        });
    }

    public void Bn() {
        e.Bl().post(new Runnable() { // from class: com.baidu.live.alablmsdk.a.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTimer != null) {
                    com.baidu.live.alablmsdk.a.b.a.aj(" countDown releaseTimer mId=" + b.this.mId, "");
                    b.this.mTimer.cancel();
                    b.this.mTimer = null;
                }
            }
        });
    }
}
