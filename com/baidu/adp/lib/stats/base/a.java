package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.fsg.base.statistics.j;
/* loaded from: classes.dex */
public class a {
    private String akL;
    protected String akV;
    protected String akX;
    protected i akY;
    private StringBuffer akM = new StringBuffer();
    private StringBuffer akN = new StringBuffer();
    private int akO = 0;
    private int akP = 0;
    private long akF = 0;
    private long akQ = 0;
    protected long akR = 0;
    private long akS = 0;
    private long akT = 0;
    protected int akU = 50;
    protected final String akW = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.akY = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.akM.append(aVar.toString());
                    this.akM.append("\r\n");
                    this.akO++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.akY != null) {
            this.akY.g(this);
        }
        this.akF = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.akN.append(aVar.toString());
                    this.akN.append("\r\n");
                    this.akP++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.akY != null) {
            this.akY.g(this);
        }
        this.akQ = System.currentTimeMillis();
    }

    public int nH() {
        return this.akO;
    }

    public int nI() {
        return this.akP;
    }

    public long nJ() {
        return this.akR;
    }

    public void q(long j) {
        this.akR = j;
    }

    public long nK() {
        return this.akF;
    }

    public long nL() {
        return this.akQ;
    }

    public String nM() {
        if (TextUtils.isEmpty(this.akX)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.akV);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.akX = sb.toString();
        }
        return this.akX;
    }

    public String nN() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.akV);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long nO() {
        return this.akS;
    }

    public long nP() {
        return this.akT;
    }

    public void r(long j) {
        this.akS = j;
    }

    public void s(long j) {
        this.akT = j;
    }

    public synchronized void nQ() {
        this.akM = new StringBuffer();
        this.akO = 0;
        this.akS = 0L;
    }

    public synchronized void nR() {
        this.akN = new StringBuffer();
        this.akP = 0;
        this.akT = 0L;
    }

    public void ax(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.akL = str;
        }
    }

    public String nS() {
        return this.akL;
    }

    public boolean nT() {
        return this.isUploading;
    }

    public void as(boolean z) {
        this.isUploading = z;
    }

    public String nU() {
        return "omp";
    }

    public StringBuffer nV() {
        return this.akM;
    }

    public StringBuffer nW() {
        return this.akN;
    }

    public boolean nX() {
        return this.mUseSdCard;
    }

    public boolean nY() {
        return this.mMustSuccess;
    }

    public String nZ() {
        return this.akV;
    }

    public static String ay(String str) {
        if ("net".equals(str) || j.d.equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
