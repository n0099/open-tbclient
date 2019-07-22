package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class a {
    private String Cm;
    protected String Cw;
    protected String Cy;
    protected i Cz;
    private StringBuffer Cn = new StringBuffer();
    private StringBuffer Co = new StringBuffer();
    private int Cp = 0;
    private int Cq = 0;
    private long Cf = 0;
    private long Cr = 0;
    protected long Cs = 0;
    private long Ct = 0;
    private long Cu = 0;
    protected int Cv = 50;
    protected final String Cx = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.Cz = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Cn.append(aVar.toString());
                    this.Cn.append("\r\n");
                    this.Cp++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Cz != null) {
            this.Cz.g(this);
        }
        this.Cf = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Co.append(aVar.toString());
                    this.Co.append("\r\n");
                    this.Cq++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Cz != null) {
            this.Cz.g(this);
        }
        this.Cr = System.currentTimeMillis();
    }

    public int iZ() {
        return this.Cp;
    }

    public int ja() {
        return this.Cq;
    }

    public long jb() {
        return this.Cs;
    }

    public void k(long j) {
        this.Cs = j;
    }

    public long jc() {
        return this.Cf;
    }

    public long jd() {
        return this.Cr;
    }

    public String je() {
        if (TextUtils.isEmpty(this.Cy)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Cw);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.Cy = sb.toString();
        }
        return this.Cy;
    }

    public String jf() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Cw);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long jg() {
        return this.Ct;
    }

    public long jh() {
        return this.Cu;
    }

    public void l(long j) {
        this.Ct = j;
    }

    public void m(long j) {
        this.Cu = j;
    }

    public synchronized void ji() {
        this.Cn = new StringBuffer();
        this.Cp = 0;
        this.Ct = 0L;
    }

    public synchronized void jj() {
        this.Co = new StringBuffer();
        this.Cq = 0;
        this.Cu = 0L;
    }

    public void aL(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Cm = str;
        }
    }

    public String jk() {
        return this.Cm;
    }

    public boolean jl() {
        return this.isUploading;
    }

    public void ad(boolean z) {
        this.isUploading = z;
    }

    public String jm() {
        return "omp";
    }

    public StringBuffer jn() {
        return this.Cn;
    }

    public StringBuffer jo() {
        return this.Co;
    }

    public boolean jp() {
        return this.mUseSdCard;
    }

    public boolean jq() {
        return this.mMustSuccess;
    }

    public String jr() {
        return this.Cw;
    }

    public static String aM(String str) {
        if ("net".equals(str) || Config.OPERATOR.equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
