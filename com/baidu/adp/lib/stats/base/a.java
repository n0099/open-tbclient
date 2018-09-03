package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.fsg.base.statistics.j;
/* loaded from: classes.dex */
public class a {
    protected String BC;
    protected String BE;
    protected i BF;
    private String Bs;
    private StringBuffer Bt = new StringBuffer();
    private StringBuffer Bu = new StringBuffer();
    private int Bv = 0;
    private int Bw = 0;
    private long Bl = 0;
    private long Bx = 0;
    protected long By = 0;
    private long Bz = 0;
    private long BA = 0;
    protected int BB = 50;
    protected final String BD = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.BF = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
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
        if (this.BF != null) {
            this.BF.g(this);
        }
        this.Bl = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Bu.append(aVar.toString());
                    this.Bu.append(SystemInfoUtil.LINE_END);
                    this.Bw++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.BF != null) {
            this.BF.g(this);
        }
        this.Bx = System.currentTimeMillis();
    }

    public int iC() {
        return this.Bv;
    }

    public int iD() {
        return this.Bw;
    }

    public long iE() {
        return this.By;
    }

    public void k(long j) {
        this.By = j;
    }

    public long iF() {
        return this.Bl;
    }

    public long iG() {
        return this.Bx;
    }

    public String iH() {
        if (TextUtils.isEmpty(this.BE)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.BC);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.BE = sb.toString();
        }
        return this.BE;
    }

    public String iI() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.BC);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long iJ() {
        return this.Bz;
    }

    public long iK() {
        return this.BA;
    }

    public void l(long j) {
        this.Bz = j;
    }

    public void m(long j) {
        this.BA = j;
    }

    public synchronized void iL() {
        this.Bt = new StringBuffer();
        this.Bv = 0;
        this.Bz = 0L;
    }

    public synchronized void iM() {
        this.Bu = new StringBuffer();
        this.Bw = 0;
        this.BA = 0L;
    }

    public void aJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Bs = str;
        }
    }

    public String iN() {
        return this.Bs;
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
        return this.Bt;
    }

    public StringBuffer iR() {
        return this.Bu;
    }

    public boolean iS() {
        return this.mUseSdCard;
    }

    public boolean iT() {
        return this.mMustSuccess;
    }

    public String iU() {
        return this.BC;
    }

    public static String aK(String str) {
        if ("net".equals(str) || j.d.equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
