package com.baidu.tbadk.core.util;

import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class e {
    private static Object Hy = new Object();
    private static volatile e Hz;
    private com.baidu.tbadk.core.data.h Hm;
    private int Hs;
    private int Ht;
    private int Hu;
    private int Hv;
    private Handler mHandler;
    private final int Hf = 5;
    private final int Hg = 0;
    private final int Hh = 1;
    private final int Hi = 2;
    private final int Hj = 3;
    private final byte Hk = 0;
    private final byte Hl = 1;
    private int Hn = 0;
    private final int Ho = 5;
    private boolean mIsUploading = false;
    private long mLastUploadTime = 0;
    private final long Hp = 86400000;
    private final float Hq = 100.0f;
    private float Hr = 0.0f;
    private BdAsyncTaskParallel Hw = null;
    private final h Hx = new h(this, null);

    public static e oh() {
        if (Hz == null) {
            synchronized (e.class) {
                if (Hz == null) {
                    Hz = new e();
                }
            }
        }
        return Hz;
    }

    private e() {
        this.mHandler = null;
        this.mHandler = new f(this);
    }

    public com.baidu.tbadk.core.data.h oi() {
        return this.Hm;
    }

    public void a(com.baidu.tbadk.core.data.h hVar) {
        synchronized (Hy) {
            this.Hm = hVar;
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
        synchronized (Hy) {
            if (oi() == null) {
                this.Hr += 25.0f;
            } else {
                this.Hr += oi().mw();
            }
            this.Hu++;
            this.Ht++;
            this.Hx.bQ(i);
            int i3 = this.Hu;
            int i4 = this.Ht;
            int i5 = this.Hs;
            int i6 = this.Hs != 0 ? this.Hv / this.Hs : 0;
            String hVar = this.Hx.toString();
            if (oi() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                oi().af(true);
                this.Hn = 0;
            }
            if (oi() != null && oi().my()) {
                if (this.Hu < 5) {
                    i2 = 0;
                } else if (this.Hr < 100.0f || this.Ht < oi().mA() || this.Hs < oi().mz()) {
                    if (this.Hr >= 100.0f && this.Ht >= oi().mA()) {
                        i2 = 2;
                    } else {
                        i2 = (this.Hr < 100.0f || this.Hs < oi().mz()) ? 0 : 3;
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
        if (oi() != null) {
            i3 = oi().getTime();
        }
        synchronized (Hy) {
            if (j >= i3) {
                if (oi() == null) {
                    this.Hr += 10.0f;
                } else {
                    this.Hr += oi().mx();
                }
                this.Hs++;
                this.Hv = (int) (this.Hv + j);
                this.Hu++;
                int i4 = this.Hu;
                int i5 = this.Ht;
                int i6 = this.Hs;
                if (this.Hs != 0) {
                    i = this.Hv / this.Hs;
                }
                String hVar = this.Hx.toString();
                if (oi() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                    oi().af(true);
                    this.Hn = 0;
                }
                if (oi() != null && oi().my()) {
                    if (this.Hu >= 5) {
                        if (this.Hr >= 100.0f && this.Ht >= oi().mA() && this.Hs >= oi().mz()) {
                            i2 = 1;
                        } else if (this.Hr >= 100.0f && this.Ht >= oi().mA()) {
                            i2 = 2;
                        } else if (this.Hr >= 100.0f && this.Hs >= oi().mz()) {
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
            if (oi() == null) {
                this.Hr -= 25.0f;
            } else {
                this.Hr -= oi().mv();
            }
            if (this.Hr < 0.0f) {
                this.Hr = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (oi() != null && oi().my() && i != 0 && !this.mIsUploading) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.Hw == null) {
            this.Hw = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        g gVar = new g(this, i, i2, i3, str, i4, str2);
        gVar.setParallel(this.Hw);
        gVar.execute(new Object[0]);
        this.mIsUploading = true;
        com.baidu.adp.lib.stats.q ed = w.ed();
        ed.r("act", "fallback");
        ed.r("type", com.baidu.tbadk.core.frameworkData.a.START);
        com.baidu.adp.lib.stats.f.eq().a("img", ed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.Hu = 0;
        this.Hs = 0;
        this.Ht = 0;
        this.Hv = 0;
        this.Hr = 0.0f;
        this.Hx.clear();
    }
}
