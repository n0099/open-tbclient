package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String NK;
    protected String Oa;
    protected String Od;
    protected j Of;
    private StringBuffer NL = new StringBuffer();
    private StringBuffer NM = new StringBuffer();
    private StringBuffer NN = new StringBuffer();
    private int NP = 0;
    private int NQ = 0;
    private int NR = 0;
    private long Nx = 0;
    private long NT = 0;
    private long NU = 0;
    protected long NV = 0;
    private long NW = 0;
    private long NX = 0;
    private long NY = 0;
    protected int NZ = 50;
    protected final String Ob = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean Oc = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean Oe = false;

    public a(j jVar) {
        this.Of = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.NL.append(aVar.toString());
                    this.NL.append("\r\n");
                    this.NP++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Of != null) {
            this.Of.o(this);
        }
        this.Nx = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.NM.append(aVar.toString());
                    this.NM.append("\r\n");
                    this.NQ++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Of != null) {
            this.Of.o(this);
        }
        this.NT = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.na() != null) {
                    this.NN.append(aVar.na().nn().toString());
                    this.NN.append("\r\n");
                    this.NR++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Of != null) {
            this.Of.o(this);
        }
        this.NU = System.currentTimeMillis();
    }

    public int np() {
        return this.NP;
    }

    public int nq() {
        return this.NQ;
    }

    public int nr() {
        return this.NR;
    }

    public long ns() {
        return this.NV;
    }

    public void J(long j) {
        this.NV = j;
    }

    public long nt() {
        return this.Nx;
    }

    public long nu() {
        return this.NT;
    }

    public long nv() {
        return this.NU;
    }

    public String nw() {
        if (TextUtils.isEmpty(this.Od)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Oa);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.Od = sb.toString();
        }
        return this.Od;
    }

    public String nx() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Oa);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long ny() {
        return this.NW;
    }

    public long nz() {
        return this.NX;
    }

    public long nA() {
        return this.NY;
    }

    public void K(long j) {
        this.NW = j;
    }

    public void L(long j) {
        this.NX = j;
    }

    public void M(long j) {
        this.NY = j;
    }

    public synchronized void nB() {
        this.NL = new StringBuffer();
        this.NP = 0;
        this.NW = 0L;
    }

    public synchronized void nC() {
        this.NM = new StringBuffer();
        this.NQ = 0;
        this.NX = 0L;
    }

    public synchronized void nD() {
        this.NN = new StringBuffer();
        this.NR = 0;
        this.NY = 0L;
    }

    public void cb(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.NK = str;
        }
    }

    public String nE() {
        return this.NK;
    }

    public boolean nF() {
        return this.isUploading;
    }

    public void ar(boolean z) {
        this.isUploading = z;
    }

    public boolean nG() {
        return this.Oe;
    }

    public void as(boolean z) {
        this.Oe = z;
    }

    public String nH() {
        return BdStatsConstant.FILE_OMP;
    }

    public String nI() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer nJ() {
        return this.NL;
    }

    public StringBuffer nK() {
        return this.NM;
    }

    public StringBuffer nL() {
        return this.NN;
    }

    public boolean nM() {
        return this.mUseSdCard;
    }

    public boolean nN() {
        return this.Oc;
    }

    public boolean nO() {
        return this.mMustSuccess;
    }

    public String nP() {
        return this.Oa;
    }

    public static String cc(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
