package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.fsg.base.statistics.j;
/* loaded from: classes.dex */
public class a {
    private String akR;
    protected String alb;
    protected String ald;
    protected i ale;
    private StringBuffer akS = new StringBuffer();
    private StringBuffer akT = new StringBuffer();
    private int akU = 0;
    private int akV = 0;
    private long akL = 0;
    private long akW = 0;
    protected long akX = 0;
    private long akY = 0;
    private long akZ = 0;
    protected int ala = 50;
    protected final String alc = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.ale = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.akS.append(aVar.toString());
                    this.akS.append("\r\n");
                    this.akU++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.ale != null) {
            this.ale.g(this);
        }
        this.akL = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.akT.append(aVar.toString());
                    this.akT.append("\r\n");
                    this.akV++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.ale != null) {
            this.ale.g(this);
        }
        this.akW = System.currentTimeMillis();
    }

    public int nH() {
        return this.akU;
    }

    public int nI() {
        return this.akV;
    }

    public long nJ() {
        return this.akX;
    }

    public void q(long j) {
        this.akX = j;
    }

    public long nK() {
        return this.akL;
    }

    public long nL() {
        return this.akW;
    }

    public String nM() {
        if (TextUtils.isEmpty(this.ald)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.alb);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.ald = sb.toString();
        }
        return this.ald;
    }

    public String nN() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.alb);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long nO() {
        return this.akY;
    }

    public long nP() {
        return this.akZ;
    }

    public void r(long j) {
        this.akY = j;
    }

    public void s(long j) {
        this.akZ = j;
    }

    public synchronized void nQ() {
        this.akS = new StringBuffer();
        this.akU = 0;
        this.akY = 0L;
    }

    public synchronized void nR() {
        this.akT = new StringBuffer();
        this.akV = 0;
        this.akZ = 0L;
    }

    public void ax(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.akR = str;
        }
    }

    public String nS() {
        return this.akR;
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
        return this.akS;
    }

    public StringBuffer nW() {
        return this.akT;
    }

    public boolean nX() {
        return this.mUseSdCard;
    }

    public boolean nY() {
        return this.mMustSuccess;
    }

    public String nZ() {
        return this.alb;
    }

    public static String ay(String str) {
        if ("net".equals(str) || j.d.equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
