package com.baidu.tbadk.core.util;

import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class e {
    private static Object Df = new Object();
    private static volatile e Dg;
    private com.baidu.tbadk.core.data.f CU;
    private int Da;
    private int Db;
    private int Dc;
    private int mErrorNum;
    private Handler mHandler;
    private final int CN = 5;
    private final int CO = 0;
    private final int CP = 1;
    private final int CQ = 2;
    private final int CR = 3;
    private final byte CS = 0;
    private final byte CT = 1;
    private int CV = 0;
    private final int CW = 5;
    private boolean mIsUploading = false;
    private long mLastUploadTime = 0;
    private final long CX = 86400000;
    private final float CY = 100.0f;
    private float CZ = 0.0f;
    private BdAsyncTaskParallel Dd = null;
    private final h De = new h(this, null);

    public static e lq() {
        if (Dg == null) {
            synchronized (e.class) {
                if (Dg == null) {
                    Dg = new e();
                }
            }
        }
        return Dg;
    }

    private e() {
        this.mHandler = null;
        this.mHandler = new f(this);
    }

    public com.baidu.tbadk.core.data.f lr() {
        return this.CU;
    }

    public void a(com.baidu.tbadk.core.data.f fVar) {
        synchronized (Df) {
            this.CU = fVar;
        }
    }

    public void d(int i, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, str));
    }

    public void a(long j, String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, (int) j, 0, str));
    }

    public void e(int i, String str) {
        int i2 = 1;
        synchronized (Df) {
            if (lr() == null) {
                this.CZ += 25.0f;
            } else {
                this.CZ += lr().jO();
            }
            this.Db++;
            this.mErrorNum++;
            this.De.bo(i);
            int i3 = this.Db;
            int i4 = this.mErrorNum;
            int i5 = this.Da;
            int i6 = this.Da != 0 ? this.Dc / this.Da : 0;
            String hVar = this.De.toString();
            if (lr() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                lr().O(true);
                this.CV = 0;
            }
            if (lr() != null && lr().jQ()) {
                if (this.Db < 5) {
                    i2 = 0;
                } else if (this.CZ < 100.0f || this.mErrorNum < lr().jS() || this.Da < lr().jR()) {
                    if (this.CZ >= 100.0f && this.mErrorNum >= lr().jS()) {
                        i2 = 2;
                    } else {
                        i2 = (this.CZ < 100.0f || this.Da < lr().jR()) ? 0 : 3;
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
        if (lr() != null) {
            i3 = lr().getTime();
        }
        synchronized (Df) {
            if (j >= i3) {
                if (lr() == null) {
                    this.CZ += 10.0f;
                } else {
                    this.CZ += lr().jP();
                }
                this.Da++;
                this.Dc = (int) (this.Dc + j);
                this.Db++;
                int i4 = this.Db;
                int i5 = this.mErrorNum;
                int i6 = this.Da;
                if (this.Da != 0) {
                    i = this.Dc / this.Da;
                }
                String hVar = this.De.toString();
                if (lr() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                    lr().O(true);
                    this.CV = 0;
                }
                if (lr() != null && lr().jQ()) {
                    if (this.Db >= 5) {
                        if (this.CZ >= 100.0f && this.mErrorNum >= lr().jS() && this.Da >= lr().jR()) {
                            i2 = 1;
                        } else if (this.CZ >= 100.0f && this.mErrorNum >= lr().jS()) {
                            i2 = 2;
                        } else if (this.CZ >= 100.0f && this.Da >= lr().jR()) {
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
            if (lr() == null) {
                this.CZ -= 25.0f;
            } else {
                this.CZ -= lr().jN();
            }
            if (this.CZ < 0.0f) {
                this.CZ = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (lr() != null && lr().jQ() && i != 0 && !this.mIsUploading) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.Dd == null) {
            this.Dd = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        g gVar = new g(this, i, i2, i3, str, i4, str2);
        gVar.setParallel(this.Dd);
        gVar.execute(new Object[0]);
        this.mIsUploading = true;
        com.baidu.adp.lib.stats.q logItem = v.getLogItem();
        logItem.n("act", "fallback");
        logItem.n("type", com.baidu.tbadk.core.frameworkData.a.START);
        com.baidu.adp.lib.stats.f.er().a("img", logItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.Db = 0;
        this.Da = 0;
        this.mErrorNum = 0;
        this.Dc = 0;
        this.CZ = 0.0f;
        this.De.clear();
    }
}
