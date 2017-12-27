package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class a {
    private String akP;
    protected String akZ;
    protected String alb;
    protected i alc;
    private StringBuffer akQ = new StringBuffer();
    private StringBuffer akR = new StringBuffer();
    private int akS = 0;
    private int akT = 0;
    private long akJ = 0;
    private long akU = 0;
    protected long akV = 0;
    private long akW = 0;
    private long akX = 0;
    protected int akY = 50;
    protected final String ala = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.alc = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.akQ.append(aVar.toString());
                    this.akQ.append("\r\n");
                    this.akS++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.alc != null) {
            this.alc.g(this);
        }
        this.akJ = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.akR.append(aVar.toString());
                    this.akR.append("\r\n");
                    this.akT++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.alc != null) {
            this.alc.g(this);
        }
        this.akU = System.currentTimeMillis();
    }

    public int nG() {
        return this.akS;
    }

    public int nH() {
        return this.akT;
    }

    public long nI() {
        return this.akV;
    }

    public void q(long j) {
        this.akV = j;
    }

    public long nJ() {
        return this.akJ;
    }

    public long nK() {
        return this.akU;
    }

    public String nL() {
        if (TextUtils.isEmpty(this.alb)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.akZ);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.alb = sb.toString();
        }
        return this.alb;
    }

    public String nM() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.akZ);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long nN() {
        return this.akW;
    }

    public long nO() {
        return this.akX;
    }

    public void r(long j) {
        this.akW = j;
    }

    public void s(long j) {
        this.akX = j;
    }

    public synchronized void nP() {
        this.akQ = new StringBuffer();
        this.akS = 0;
        this.akW = 0L;
    }

    public synchronized void nQ() {
        this.akR = new StringBuffer();
        this.akT = 0;
        this.akX = 0L;
    }

    public void ax(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.akP = str;
        }
    }

    public String nR() {
        return this.akP;
    }

    public boolean nS() {
        return this.isUploading;
    }

    public void ao(boolean z) {
        this.isUploading = z;
    }

    public String nT() {
        return "omp";
    }

    public StringBuffer nU() {
        return this.akQ;
    }

    public StringBuffer nV() {
        return this.akR;
    }

    public boolean nW() {
        return this.mUseSdCard;
    }

    public boolean nX() {
        return this.mMustSuccess;
    }

    public String nY() {
        return this.akZ;
    }

    public static String ay(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
