package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.fsg.base.statistics.j;
/* loaded from: classes.dex */
public class a {
    protected String BG;
    protected String BI;
    protected i BJ;
    private String Bw;
    private StringBuffer Bx = new StringBuffer();
    private StringBuffer By = new StringBuffer();
    private int Bz = 0;
    private int BA = 0;
    private long Bp = 0;
    private long BB = 0;
    protected long BC = 0;
    private long BD = 0;
    private long BE = 0;
    protected int BF = 50;
    protected final String BH = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.BJ = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Bx.append(aVar.toString());
                    this.Bx.append(SystemInfoUtil.LINE_END);
                    this.Bz++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.BJ != null) {
            this.BJ.g(this);
        }
        this.Bp = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.By.append(aVar.toString());
                    this.By.append(SystemInfoUtil.LINE_END);
                    this.BA++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.BJ != null) {
            this.BJ.g(this);
        }
        this.BB = System.currentTimeMillis();
    }

    public int iB() {
        return this.Bz;
    }

    public int iC() {
        return this.BA;
    }

    public long iD() {
        return this.BC;
    }

    public void k(long j) {
        this.BC = j;
    }

    public long iE() {
        return this.Bp;
    }

    public long iF() {
        return this.BB;
    }

    public String iG() {
        if (TextUtils.isEmpty(this.BI)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.BG);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.BI = sb.toString();
        }
        return this.BI;
    }

    public String iH() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.BG);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long iI() {
        return this.BD;
    }

    public long iJ() {
        return this.BE;
    }

    public void l(long j) {
        this.BD = j;
    }

    public void m(long j) {
        this.BE = j;
    }

    public synchronized void iK() {
        this.Bx = new StringBuffer();
        this.Bz = 0;
        this.BD = 0L;
    }

    public synchronized void iL() {
        this.By = new StringBuffer();
        this.BA = 0;
        this.BE = 0L;
    }

    public void aI(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Bw = str;
        }
    }

    public String iM() {
        return this.Bw;
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
        return this.Bx;
    }

    public StringBuffer iQ() {
        return this.By;
    }

    public boolean iR() {
        return this.mUseSdCard;
    }

    public boolean iS() {
        return this.mMustSuccess;
    }

    public String iT() {
        return this.BG;
    }

    public static String aJ(String str) {
        if ("net".equals(str) || j.d.equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
