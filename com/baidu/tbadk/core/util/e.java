package com.baidu.tbadk.core.util;

import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class e {
    private static Object HB = new Object();
    private static volatile e HC;
    private com.baidu.tbadk.core.data.h Hp;
    private int Hv;
    private int Hw;
    private int Hx;
    private int Hy;
    private Handler mHandler;
    private final int Hi = 5;
    private final int Hj = 0;
    private final int Hk = 1;
    private final int Hl = 2;
    private final int Hm = 3;
    private final byte Hn = 0;
    private final byte Ho = 1;
    private int Hq = 0;
    private final int Hr = 5;
    private boolean mIsUploading = false;
    private long mLastUploadTime = 0;
    private final long Hs = 86400000;
    private final float Ht = 100.0f;
    private float Hu = 0.0f;
    private BdAsyncTaskParallel Hz = null;
    private final h HA = new h(this, null);

    public static e oo() {
        if (HC == null) {
            synchronized (e.class) {
                if (HC == null) {
                    HC = new e();
                }
            }
        }
        return HC;
    }

    private e() {
        this.mHandler = null;
        this.mHandler = new f(this);
    }

    public com.baidu.tbadk.core.data.h op() {
        return this.Hp;
    }

    public void a(com.baidu.tbadk.core.data.h hVar) {
        synchronized (HB) {
            this.Hp = hVar;
        }
    }

    public void m(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    public void a(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void n(int i, String str) {
        int i2 = 1;
        synchronized (HB) {
            if (op() == null) {
                this.Hu += 25.0f;
            } else {
                this.Hu += op().mD();
            }
            this.Hx++;
            this.Hw++;
            this.HA.bQ(i);
            int i3 = this.Hx;
            int i4 = this.Hw;
            int i5 = this.Hv;
            int i6 = this.Hv != 0 ? this.Hy / this.Hv : 0;
            String hVar = this.HA.toString();
            if (op() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                op().af(true);
                this.Hq = 0;
            }
            if (op() != null && op().mF()) {
                if (this.Hx < 5) {
                    i2 = 0;
                } else if (this.Hu < 100.0f || this.Hw < op().mH() || this.Hv < op().mG()) {
                    if (this.Hu >= 100.0f && this.Hw >= op().mH()) {
                        i2 = 2;
                    } else {
                        i2 = (this.Hu < 100.0f || this.Hv < op().mG()) ? 0 : 3;
                    }
                }
                a(i2, i3, i4, hVar, i5, i6);
            }
        }
    }

    public void b(long j, String str) {
        int i = 0;
        int i2 = 0;
        int i3 = 5000;
        if (op() != null) {
            i3 = op().getTime();
        }
        synchronized (HB) {
            if (j >= i3) {
                if (op() == null) {
                    this.Hu += 10.0f;
                } else {
                    this.Hu += op().mE();
                }
                this.Hv++;
                this.Hy = (int) (this.Hy + j);
                this.Hx++;
                int i4 = this.Hx;
                int i5 = this.Hw;
                int i6 = this.Hv;
                if (this.Hv != 0) {
                    i = this.Hy / this.Hv;
                }
                String hVar = this.HA.toString();
                if (op() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                    op().af(true);
                    this.Hq = 0;
                }
                if (op() != null && op().mF()) {
                    if (this.Hx >= 5) {
                        if (this.Hu >= 100.0f && this.Hw >= op().mH() && this.Hv >= op().mG()) {
                            i2 = 1;
                        } else if (this.Hu >= 100.0f && this.Hw >= op().mH()) {
                            i2 = 2;
                        } else if (this.Hu >= 100.0f && this.Hv >= op().mG()) {
                            i2 = 3;
                        } else {
                            i2 = 0;
                        }
                    }
                    a(i2, i4, i5, hVar, i6, i);
                    return;
                }
                return;
            }
            if (op() == null) {
                this.Hu -= 25.0f;
            } else {
                this.Hu -= op().mC();
            }
            if (this.Hu < 0.0f) {
                this.Hu = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (op() != null && op().mF() && i != 0 && !this.mIsUploading) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.Hz == null) {
            this.Hz = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        g gVar = new g(this, i, i2, i3, str, i4, str2);
        gVar.setParallel(this.Hz);
        gVar.execute(new Object[0]);
        this.mIsUploading = true;
        com.baidu.adp.lib.stats.q ed = w.ed();
        ed.r("act", "fallback");
        ed.r("type", com.baidu.tbadk.core.frameworkData.a.START);
        com.baidu.adp.lib.stats.f.eq().a("img", ed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.Hx = 0;
        this.Hv = 0;
        this.Hw = 0;
        this.Hy = 0;
        this.Hu = 0.0f;
        this.HA.clear();
    }
}
