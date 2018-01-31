package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class a {
    private String akS;
    protected String alc;
    protected String ale;
    protected i alf;
    private StringBuffer akT = new StringBuffer();
    private StringBuffer akU = new StringBuffer();
    private int akV = 0;
    private int akW = 0;
    private long akM = 0;
    private long akX = 0;
    protected long akY = 0;
    private long akZ = 0;
    private long ala = 0;
    protected int alb = 50;
    protected final String ald = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.alf = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
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
        if (this.alf != null) {
            this.alf.g(this);
        }
        this.akM = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.akU.append(aVar.toString());
                    this.akU.append("\r\n");
                    this.akW++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.alf != null) {
            this.alf.g(this);
        }
        this.akX = System.currentTimeMillis();
    }

    public int nH() {
        return this.akV;
    }

    public int nI() {
        return this.akW;
    }

    public long nJ() {
        return this.akY;
    }

    public void q(long j) {
        this.akY = j;
    }

    public long nK() {
        return this.akM;
    }

    public long nL() {
        return this.akX;
    }

    public String nM() {
        if (TextUtils.isEmpty(this.ale)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.alc);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.ale = sb.toString();
        }
        return this.ale;
    }

    public String nN() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.alc);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long nO() {
        return this.akZ;
    }

    public long nP() {
        return this.ala;
    }

    public void r(long j) {
        this.akZ = j;
    }

    public void s(long j) {
        this.ala = j;
    }

    public synchronized void nQ() {
        this.akT = new StringBuffer();
        this.akV = 0;
        this.akZ = 0L;
    }

    public synchronized void nR() {
        this.akU = new StringBuffer();
        this.akW = 0;
        this.ala = 0L;
    }

    public void ax(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.akS = str;
        }
    }

    public String nS() {
        return this.akS;
    }

    public boolean nT() {
        return this.isUploading;
    }

    public void ap(boolean z) {
        this.isUploading = z;
    }

    public String nU() {
        return "omp";
    }

    public StringBuffer nV() {
        return this.akT;
    }

    public StringBuffer nW() {
        return this.akU;
    }

    public boolean nX() {
        return this.mUseSdCard;
    }

    public boolean nY() {
        return this.mMustSuccess;
    }

    public String nZ() {
        return this.alc;
    }

    public static String ay(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
