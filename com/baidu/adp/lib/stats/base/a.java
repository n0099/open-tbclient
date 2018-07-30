package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.fsg.base.statistics.j;
/* loaded from: classes.dex */
public class a {
    protected String BB;
    protected String BD;
    protected i BE;
    private String Br;
    private StringBuffer Bs = new StringBuffer();
    private StringBuffer Bt = new StringBuffer();
    private int Bu = 0;
    private int Bv = 0;
    private long Bk = 0;
    private long Bw = 0;
    protected long Bx = 0;
    private long By = 0;
    private long Bz = 0;
    protected int BA = 50;
    protected final String BC = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.BE = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Bs.append(aVar.toString());
                    this.Bs.append(SystemInfoUtil.LINE_END);
                    this.Bu++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.BE != null) {
            this.BE.g(this);
        }
        this.Bk = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Bt.append(aVar.toString());
                    this.Bt.append(SystemInfoUtil.LINE_END);
                    this.Bv++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.BE != null) {
            this.BE.g(this);
        }
        this.Bw = System.currentTimeMillis();
    }

    public int iC() {
        return this.Bu;
    }

    public int iD() {
        return this.Bv;
    }

    public long iE() {
        return this.Bx;
    }

    public void k(long j) {
        this.Bx = j;
    }

    public long iF() {
        return this.Bk;
    }

    public long iG() {
        return this.Bw;
    }

    public String iH() {
        if (TextUtils.isEmpty(this.BD)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.BB);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.BD = sb.toString();
        }
        return this.BD;
    }

    public String iI() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.BB);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long iJ() {
        return this.By;
    }

    public long iK() {
        return this.Bz;
    }

    public void l(long j) {
        this.By = j;
    }

    public void m(long j) {
        this.Bz = j;
    }

    public synchronized void iL() {
        this.Bs = new StringBuffer();
        this.Bu = 0;
        this.By = 0L;
    }

    public synchronized void iM() {
        this.Bt = new StringBuffer();
        this.Bv = 0;
        this.Bz = 0L;
    }

    public void aJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Br = str;
        }
    }

    public String iN() {
        return this.Br;
    }

    public boolean iO() {
        return this.isUploading;
    }

    public void M(boolean z) {
        this.isUploading = z;
    }

    public String iP() {
        return "omp";
    }

    public StringBuffer iQ() {
        return this.Bs;
    }

    public StringBuffer iR() {
        return this.Bt;
    }

    public boolean iS() {
        return this.mUseSdCard;
    }

    public boolean iT() {
        return this.mMustSuccess;
    }

    public String iU() {
        return this.BB;
    }

    public static String aK(String str) {
        if ("net".equals(str) || j.d.equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
