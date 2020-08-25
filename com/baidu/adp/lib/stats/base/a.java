package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    protected String NG;
    protected String NJ;
    protected j NL;
    private String Nr;
    private StringBuffer Ns = new StringBuffer();
    private StringBuffer Nt = new StringBuffer();
    private StringBuffer Nu = new StringBuffer();
    private int Nv = 0;
    private int Nw = 0;
    private int Nx = 0;
    private long Nf = 0;
    private long Ny = 0;
    private long Nz = 0;
    protected long NA = 0;
    private long NB = 0;
    private long NC = 0;
    private long ND = 0;
    protected int NF = 50;
    protected final String NH = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean NI = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean NK = false;

    public a(j jVar) {
        this.NL = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Ns.append(aVar.toString());
                    this.Ns.append("\r\n");
                    this.Nv++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.NL != null) {
            this.NL.o(this);
        }
        this.Nf = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Nt.append(aVar.toString());
                    this.Nt.append("\r\n");
                    this.Nw++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.NL != null) {
            this.NL.o(this);
        }
        this.Ny = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.mV() != null) {
                    this.Nu.append(aVar.mV().ni().toString());
                    this.Nu.append("\r\n");
                    this.Nx++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.NL != null) {
            this.NL.o(this);
        }
        this.Nz = System.currentTimeMillis();
    }

    public int nk() {
        return this.Nv;
    }

    public int nl() {
        return this.Nw;
    }

    public int nm() {
        return this.Nx;
    }

    public long nn() {
        return this.NA;
    }

    public void J(long j) {
        this.NA = j;
    }

    public long no() {
        return this.Nf;
    }

    public long np() {
        return this.Ny;
    }

    public long nq() {
        return this.Nz;
    }

    public String nr() {
        if (TextUtils.isEmpty(this.NJ)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.NG);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.NJ = sb.toString();
        }
        return this.NJ;
    }

    public String ns() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.NG);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long nt() {
        return this.NB;
    }

    public long nu() {
        return this.NC;
    }

    public long nv() {
        return this.ND;
    }

    public void K(long j) {
        this.NB = j;
    }

    public void L(long j) {
        this.NC = j;
    }

    public void M(long j) {
        this.ND = j;
    }

    public synchronized void nw() {
        this.Ns = new StringBuffer();
        this.Nv = 0;
        this.NB = 0L;
    }

    public synchronized void nx() {
        this.Nt = new StringBuffer();
        this.Nw = 0;
        this.NC = 0L;
    }

    public synchronized void ny() {
        this.Nu = new StringBuffer();
        this.Nx = 0;
        this.ND = 0L;
    }

    public void bZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Nr = str;
        }
    }

    public String nz() {
        return this.Nr;
    }

    public boolean nA() {
        return this.isUploading;
    }

    public void ar(boolean z) {
        this.isUploading = z;
    }

    public boolean nB() {
        return this.NK;
    }

    public void as(boolean z) {
        this.NK = z;
    }

    public String nC() {
        return BdStatsConstant.FILE_OMP;
    }

    public String nD() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer nE() {
        return this.Ns;
    }

    public StringBuffer nF() {
        return this.Nt;
    }

    public StringBuffer nG() {
        return this.Nu;
    }

    public boolean nH() {
        return this.mUseSdCard;
    }

    public boolean nI() {
        return this.NI;
    }

    public boolean nJ() {
        return this.mMustSuccess;
    }

    public String nK() {
        return this.NG;
    }

    public static String ca(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
