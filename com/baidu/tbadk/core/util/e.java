package com.baidu.tbadk.core.util;

import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class e {
    private static Object De = new Object();
    private static volatile e Df;
    private com.baidu.tbadk.core.data.f CT;
    private int CZ;
    private int Da;
    private int Db;
    private int mErrorNum;
    private Handler mHandler;
    private final int CM = 5;
    private final int CN = 0;
    private final int CO = 1;
    private final int CP = 2;
    private final int CQ = 3;
    private final byte CR = 0;
    private final byte CS = 1;
    private int CU = 0;
    private final int CV = 5;
    private boolean mIsUploading = false;
    private long mLastUploadTime = 0;
    private final long CW = 86400000;
    private final float CX = 100.0f;
    private float CY = 0.0f;
    private BdAsyncTaskParallel Dc = null;
    private final h Dd = new h(this, null);

    public static e lq() {
        if (Df == null) {
            synchronized (e.class) {
                if (Df == null) {
                    Df = new e();
                }
            }
        }
        return Df;
    }

    private e() {
        this.mHandler = null;
        this.mHandler = new f(this);
    }

    public com.baidu.tbadk.core.data.f lr() {
        return this.CT;
    }

    public void a(com.baidu.tbadk.core.data.f fVar) {
        synchronized (De) {
            this.CT = fVar;
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
        synchronized (De) {
            if (lr() == null) {
                this.CY += 25.0f;
            } else {
                this.CY += lr().jO();
            }
            this.Da++;
            this.mErrorNum++;
            this.Dd.bo(i);
            int i3 = this.Da;
            int i4 = this.mErrorNum;
            int i5 = this.CZ;
            int i6 = this.CZ != 0 ? this.Db / this.CZ : 0;
            String hVar = this.Dd.toString();
            if (lr() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                lr().O(true);
                this.CU = 0;
            }
            if (lr() != null && lr().jQ()) {
                if (this.Da < 5) {
                    i2 = 0;
                } else if (this.CY < 100.0f || this.mErrorNum < lr().jS() || this.CZ < lr().jR()) {
                    if (this.CY >= 100.0f && this.mErrorNum >= lr().jS()) {
                        i2 = 2;
                    } else {
                        i2 = (this.CY < 100.0f || this.CZ < lr().jR()) ? 0 : 3;
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
        synchronized (De) {
            if (j >= i3) {
                if (lr() == null) {
                    this.CY += 10.0f;
                } else {
                    this.CY += lr().jP();
                }
                this.CZ++;
                this.Db = (int) (this.Db + j);
                this.Da++;
                int i4 = this.Da;
                int i5 = this.mErrorNum;
                int i6 = this.CZ;
                if (this.CZ != 0) {
                    i = this.Db / this.CZ;
                }
                String hVar = this.Dd.toString();
                if (lr() != null && this.mLastUploadTime > 0 && System.currentTimeMillis() - this.mLastUploadTime > 86400000) {
                    lr().O(true);
                    this.CU = 0;
                }
                if (lr() != null && lr().jQ()) {
                    if (this.Da >= 5) {
                        if (this.CY >= 100.0f && this.mErrorNum >= lr().jS() && this.CZ >= lr().jR()) {
                            i2 = 1;
                        } else if (this.CY >= 100.0f && this.mErrorNum >= lr().jS()) {
                            i2 = 2;
                        } else if (this.CY >= 100.0f && this.CZ >= lr().jR()) {
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
                this.CY -= 25.0f;
            } else {
                this.CY -= lr().jN();
            }
            if (this.CY < 0.0f) {
                this.CY = 0.0f;
            }
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (lr() != null && lr().jQ() && i != 0 && !this.mIsUploading) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        if (this.Dc == null) {
            this.Dc = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        g gVar = new g(this, i, i2, i3, str, i4, str2);
        gVar.setParallel(this.Dc);
        gVar.execute(new Object[0]);
        this.mIsUploading = true;
        com.baidu.adp.lib.stats.q logItem = v.getLogItem();
        logItem.n("act", "fallback");
        logItem.n("type", com.baidu.tbadk.core.frameworkData.a.START);
        com.baidu.adp.lib.stats.f.er().a("img", logItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.Da = 0;
        this.CZ = 0;
        this.mErrorNum = 0;
        this.Db = 0;
        this.CY = 0.0f;
        this.Dd.clear();
    }
}
