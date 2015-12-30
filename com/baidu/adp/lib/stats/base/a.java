package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.p;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String wP;
    protected String wZ;
    protected String xb;
    protected p xc;
    private StringBuffer wQ = new StringBuffer();
    private StringBuffer wR = new StringBuffer();
    private int wS = 0;
    private int wT = 0;
    private long wH = 0;
    private long wU = 0;
    protected long wV = 0;
    private long wW = 0;
    private long wX = 0;
    protected int wY = 50;
    protected final String xa = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(p pVar) {
        this.xc = pVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.wQ.append(dVar.toString());
                this.wQ.append("\r\n");
                this.wS++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xc != null) {
            this.xc.g(this);
        }
        this.wH = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.wR.append(dVar.toString());
                this.wR.append("\r\n");
                this.wT++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xc != null) {
            this.xc.g(this);
        }
        this.wU = System.currentTimeMillis();
    }

    public int hM() {
        return this.wS;
    }

    public int hN() {
        return this.wT;
    }

    public long hO() {
        return this.wV;
    }

    public void f(long j) {
        this.wV = j;
    }

    public long hP() {
        return this.wH;
    }

    public long hQ() {
        return this.wU;
    }

    public String hR() {
        if (TextUtils.isEmpty(this.xb)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.wZ);
            sb.append(com.baidu.adp.lib.stats.a.hl().hr());
            sb.append("Writing");
            sb.append(".log");
            this.xb = sb.toString();
        }
        return this.xb;
    }

    public String hS() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.wZ);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.stats.a.hl().hr());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long hT() {
        return this.wW;
    }

    public long hU() {
        return this.wX;
    }

    public void g(long j) {
        this.wW = j;
    }

    public void h(long j) {
        this.wX = j;
    }

    public synchronized void hV() {
        this.wQ = new StringBuffer();
        this.wS = 0;
        this.wW = 0L;
    }

    public synchronized void hW() {
        this.wR = new StringBuffer();
        this.wT = 0;
        this.wX = 0L;
    }

    public void av(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wP = str;
        }
    }

    public String hX() {
        return this.wP;
    }

    public boolean hY() {
        return this.isUploading;
    }

    public void D(boolean z) {
        this.isUploading = z;
    }

    public String hZ() {
        return "omp";
    }

    public StringBuffer ia() {
        return this.wQ;
    }

    public StringBuffer ib() {
        return this.wR;
    }

    public boolean ic() {
        return this.mUseSdCard;
    }

    public boolean id() {
        return this.mMustSuccess;
    }

    public String ie() {
        return this.wZ;
    }

    public static String aw(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
