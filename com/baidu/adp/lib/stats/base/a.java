package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class a {
    private String Cg;
    protected String Cq;
    protected String Cs;
    protected i Ct;
    private StringBuffer Ch = new StringBuffer();
    private StringBuffer Ci = new StringBuffer();
    private int Cj = 0;
    private int Ck = 0;
    private long BZ = 0;
    private long Cl = 0;
    protected long Cm = 0;
    private long Cn = 0;
    private long Co = 0;
    protected int Cp = 50;
    protected final String Cr = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.Ct = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Ch.append(aVar.toString());
                    this.Ch.append("\r\n");
                    this.Cj++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Ct != null) {
            this.Ct.g(this);
        }
        this.BZ = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
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
        if (this.Ct != null) {
            this.Ct.g(this);
        }
        this.Cl = System.currentTimeMillis();
    }

    public int iQ() {
        return this.Cj;
    }

    public int iR() {
        return this.Ck;
    }

    public long iS() {
        return this.Cm;
    }

    public void k(long j) {
        this.Cm = j;
    }

    public long iT() {
        return this.BZ;
    }

    public long iU() {
        return this.Cl;
    }

    public String iV() {
        if (TextUtils.isEmpty(this.Cs)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Cq);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.Cs = sb.toString();
        }
        return this.Cs;
    }

    public String iW() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Cq);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long iX() {
        return this.Cn;
    }

    public long iY() {
        return this.Co;
    }

    public void l(long j) {
        this.Cn = j;
    }

    public void m(long j) {
        this.Co = j;
    }

    public synchronized void iZ() {
        this.Ch = new StringBuffer();
        this.Cj = 0;
        this.Cn = 0L;
    }

    public synchronized void ja() {
        this.Ci = new StringBuffer();
        this.Ck = 0;
        this.Co = 0L;
    }

    public void aK(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Cg = str;
        }
    }

    public String jb() {
        return this.Cg;
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
        return this.Ch;
    }

    public StringBuffer jf() {
        return this.Ci;
    }

    public boolean jg() {
        return this.mUseSdCard;
    }

    public boolean jh() {
        return this.mMustSuccess;
    }

    public String ji() {
        return this.Cq;
    }

    public static String aL(String str) {
        if ("net".equals(str) || Config.OPERATOR.equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
