package com.baidu.tbadk.core.util;

import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class e {
    private static Object Hs = new Object();
    private static volatile e Ht;
    private com.baidu.tbadk.core.data.h Hg;
    private int Hm;
    private int Hn;
    private int Ho;
    private int Hp;
    private Handler mHandler;
    private final int GZ = 5;
    private final int Ha = 0;
    private final int Hb = 1;
    private final int Hc = 2;
    private final int Hd = 3;
    private final byte He = 0;
    private final byte Hf = 1;
    private int Hh = 0;
    private final int Hi = 5;
    private boolean mIsUploading = false;
    private long mLastUploadTime = 0;
    private final long Hj = 86400000;
    private final float Hk = 100.0f;
    private float Hl = 0.0f;
    private BdAsyncTaskParallel Hq = null;
    private final h Hr = new h(this, null);

    public static e ol() {
        if (Ht == null) {
            synchronized (e.class) {
                if (Ht == null) {
                    Ht = new e();
                }
            }
        }
        return Ht;
    }

    private e() {
        this.mHandler = null;
        this.mHandler = new f(this);
    }

    public com.baidu.tbadk.core.data.h om() {
        return this.Hg;
    }

    public void a(com.baidu.tbadk.core.data.h hVar) {
        synchronized (Hs) {
            this.Hg = hVar;
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
        synchronized (Hs) {
            if (om() == null) {
                this.Hl += 25.0f;
            } else {
                this.Hl += om().mD();
            }
            this.Ho++;
            this.Hn++;
            this.Hr.bL(i);
            int i3 = this.Ho;
            int i4 = this.Hn;
            int i5 = this.Hm;
            int i6 = this.Hm != 0 ? this.Hp / this.Hm : 0;
            String hVar = this.Hr.toString();
            if (om() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                om().ae(true);
                this.Hh = 0;
            }
            if (om() != null && om().mF()) {
                if (this.Ho < 5) {
                    i2 = 0;
                } else if (this.Hl < 100.0f || this.Hn < om().mH() || this.Hm < om().mG()) {
                    if (this.Hl >= 100.0f && this.Hn >= om().mH()) {
                        i2 = 2;
                    } else {
                        i2 = (this.Hl < 100.0f || this.Hm < om().mG()) ? 0 : 3;
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
        if (om() != null) {
            i3 = om().getTime();
        }
        synchronized (Hs) {
            if (j >= i3) {
                if (om() == null) {
                    this.Hl += 10.0f;
                } else {
                    this.Hl += om().mE();
                }
                this.Hm++;
                this.Hp = (int) (this.Hp + j);
                this.Ho++;
                int i4 = this.Ho;
                int i5 = this.Hn;
                int i6 = this.Hm;
                if (this.Hm != 0) {
                    i = this.Hp / this.Hm;
                }
                String hVar = this.Hr.toString();
                if (om() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                    om().ae(true);
                    this.Hh = 0;
                }
                if (om() != null && om().mF()) {
                    if (this.Ho >= 5) {
                        if (this.Hl >= 100.0f && this.Hn >= om().mH() && this.Hm >= om().mG()) {
                            i2 = 1;
                        } else if (this.Hl >= 100.0f && this.Hn >= om().mH()) {
                            i2 = 2;
                        } else if (this.Hl >= 100.0f && this.Hm >= om().mG()) {
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
            if (om() == null) {
                this.Hl -= 25.0f;
            } else {
                this.Hl -= om().mC();
            }
            if (this.Hl < 0.0f) {
                this.Hl = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (om() != null && om().mF() && i != 0 && !this.mIsUploading) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.Hq == null) {
            this.Hq = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        g gVar = new g(this, i, i2, i3, str, i4, str2);
        gVar.setParallel(this.Hq);
        gVar.execute(new Object[0]);
        this.mIsUploading = true;
        com.baidu.adp.lib.stats.q ef = w.ef();
        ef.r("act", "fallback");
        ef.r("type", com.baidu.tbadk.core.frameworkData.a.START);
        com.baidu.adp.lib.stats.f.es().a("img", ef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.Ho = 0;
        this.Hm = 0;
        this.Hn = 0;
        this.Hp = 0;
        this.Hl = 0.0f;
        this.Hr.clear();
    }
}
