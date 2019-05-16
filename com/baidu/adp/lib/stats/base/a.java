package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class a {
    private String Ch;
    protected String Cr;
    protected String Ct;
    protected i Cu;
    private StringBuffer Ci = new StringBuffer();
    private StringBuffer Cj = new StringBuffer();
    private int Ck = 0;
    private int Cl = 0;
    private long Ca = 0;
    private long Cm = 0;
    protected long Cn = 0;
    private long Co = 0;
    private long Cp = 0;
    protected int Cq = 50;
    protected final String Cs = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.Cu = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Ci.append(aVar.toString());
                    this.Ci.append("\r\n");
                    this.Ck++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Cu != null) {
            this.Cu.g(this);
        }
        this.Ca = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Cj.append(aVar.toString());
                    this.Cj.append("\r\n");
                    this.Cl++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Cu != null) {
            this.Cu.g(this);
        }
        this.Cm = System.currentTimeMillis();
    }

    public int iQ() {
        return this.Ck;
    }

    public int iR() {
        return this.Cl;
    }

    public long iS() {
        return this.Cn;
    }

    public void k(long j) {
        this.Cn = j;
    }

    public long iT() {
        return this.Ca;
    }

    public long iU() {
        return this.Cm;
    }

    public String iV() {
        if (TextUtils.isEmpty(this.Ct)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Cr);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.Ct = sb.toString();
        }
        return this.Ct;
    }

    public String iW() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Cr);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long iX() {
        return this.Co;
    }

    public long iY() {
        return this.Cp;
    }

    public void l(long j) {
        this.Co = j;
    }

    public void m(long j) {
        this.Cp = j;
    }

    public synchronized void iZ() {
        this.Ci = new StringBuffer();
        this.Ck = 0;
        this.Co = 0L;
    }

    public synchronized void ja() {
        this.Cj = new StringBuffer();
        this.Cl = 0;
        this.Cp = 0L;
    }

    public void aK(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Ch = str;
        }
    }

    public String jb() {
        return this.Ch;
    }

    public boolean jc() {
        return this.isUploading;
    }

    public void ac(boolean z) {
        this.isUploading = z;
    }

    public String jd() {
        return "omp";
    }

    public StringBuffer je() {
        return this.Ci;
    }

    public StringBuffer jf() {
        return this.Cj;
    }

    public boolean jg() {
        return this.mUseSdCard;
    }

    public boolean jh() {
        return this.mMustSuccess;
    }

    public String ji() {
        return this.Cr;
    }

    public static String aL(String str) {
        if ("net".equals(str) || Config.OPERATOR.equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
