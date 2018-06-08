package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.fsg.base.statistics.j;
/* loaded from: classes.dex */
public class a {
    protected String BE;
    protected String BG;
    protected i BH;
    private String Bu;
    private StringBuffer Bv = new StringBuffer();
    private StringBuffer Bw = new StringBuffer();
    private int Bx = 0;
    private int By = 0;
    private long Bn = 0;
    private long Bz = 0;
    protected long BA = 0;
    private long BB = 0;
    private long BC = 0;
    protected int BD = 50;
    protected final String BF = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.BH = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Bv.append(aVar.toString());
                    this.Bv.append(SystemInfoUtil.LINE_END);
                    this.Bx++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.BH != null) {
            this.BH.g(this);
        }
        this.Bn = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Bw.append(aVar.toString());
                    this.Bw.append(SystemInfoUtil.LINE_END);
                    this.By++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.BH != null) {
            this.BH.g(this);
        }
        this.Bz = System.currentTimeMillis();
    }

    public int iB() {
        return this.Bx;
    }

    public int iC() {
        return this.By;
    }

    public long iD() {
        return this.BA;
    }

    public void k(long j) {
        this.BA = j;
    }

    public long iE() {
        return this.Bn;
    }

    public long iF() {
        return this.Bz;
    }

    public String iG() {
        if (TextUtils.isEmpty(this.BG)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.BE);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.BG = sb.toString();
        }
        return this.BG;
    }

    public String iH() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.BE);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long iI() {
        return this.BB;
    }

    public long iJ() {
        return this.BC;
    }

    public void l(long j) {
        this.BB = j;
    }

    public void m(long j) {
        this.BC = j;
    }

    public synchronized void iK() {
        this.Bv = new StringBuffer();
        this.Bx = 0;
        this.BB = 0L;
    }

    public synchronized void iL() {
        this.Bw = new StringBuffer();
        this.By = 0;
        this.BC = 0L;
    }

    public void aG(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Bu = str;
        }
    }

    public String iM() {
        return this.Bu;
    }

    public boolean iN() {
        return this.isUploading;
    }

    public void N(boolean z) {
        this.isUploading = z;
    }

    public String iO() {
        return "omp";
    }

    public StringBuffer iP() {
        return this.Bv;
    }

    public StringBuffer iQ() {
        return this.Bw;
    }

    public boolean iR() {
        return this.mUseSdCard;
    }

    public boolean iS() {
        return this.mMustSuccess;
    }

    public String iT() {
        return this.BE;
    }

    public static String aH(String str) {
        if ("net".equals(str) || j.d.equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
