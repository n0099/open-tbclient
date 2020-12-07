package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.c.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String OY;
    protected String Pm;
    protected String Pp;
    protected j Pr;
    private StringBuffer OZ = new StringBuffer();
    private StringBuffer Pa = new StringBuffer();
    private StringBuffer Pb = new StringBuffer();
    private int Pc = 0;
    private int Pd = 0;
    private int Pe = 0;
    private long OJ = 0;
    private long Pf = 0;
    private long Pg = 0;
    protected long Ph = 0;
    private long Pi = 0;
    private long Pj = 0;
    private long Pk = 0;
    protected int Pl = 50;
    protected final String Pn = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean Po = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean Pq = false;

    public a(j jVar) {
        this.Pr = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.OZ.append(aVar.toString());
                    this.OZ.append("\r\n");
                    this.Pc++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Pr != null) {
            this.Pr.o(this);
        }
        this.OJ = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Pa.append(aVar.toString());
                    this.Pa.append("\r\n");
                    this.Pd++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Pr != null) {
            this.Pr.o(this);
        }
        this.Pf = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.nb() != null) {
                    this.Pb.append(aVar.nb().no().toString());
                    this.Pb.append("\r\n");
                    this.Pe++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Pr != null) {
            this.Pr.o(this);
        }
        this.Pg = System.currentTimeMillis();
    }

    public int np() {
        return this.Pc;
    }

    public int nq() {
        return this.Pd;
    }

    public int nr() {
        return this.Pe;
    }

    public long ns() {
        return this.Ph;
    }

    public void H(long j) {
        this.Ph = j;
    }

    public long nt() {
        return this.OJ;
    }

    public long nu() {
        return this.Pf;
    }

    public long nv() {
        return this.Pg;
    }

    public String nw() {
        if (TextUtils.isEmpty(this.Pp)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Pm);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.Pp = sb.toString();
        }
        return this.Pp;
    }

    public String nx() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Pm);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long ny() {
        return this.Pi;
    }

    public long nz() {
        return this.Pj;
    }

    public long nA() {
        return this.Pk;
    }

    public void I(long j) {
        this.Pi = j;
    }

    public void J(long j) {
        this.Pj = j;
    }

    public void K(long j) {
        this.Pk = j;
    }

    public synchronized void nB() {
        this.OZ = new StringBuffer();
        this.Pc = 0;
        this.Pi = 0L;
    }

    public synchronized void nC() {
        this.Pa = new StringBuffer();
        this.Pd = 0;
        this.Pj = 0L;
    }

    public synchronized void nD() {
        this.Pb = new StringBuffer();
        this.Pe = 0;
        this.Pk = 0L;
    }

    public void ce(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.OY = str;
        }
    }

    public String nE() {
        return this.OY;
    }

    public boolean nF() {
        return this.isUploading;
    }

    public void aq(boolean z) {
        this.isUploading = z;
    }

    public boolean nG() {
        return this.Pq;
    }

    public void ar(boolean z) {
        this.Pq = z;
    }

    public String nH() {
        return BdStatsConstant.FILE_OMP;
    }

    public String nI() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer nJ() {
        return this.OZ;
    }

    public StringBuffer nK() {
        return this.Pa;
    }

    public StringBuffer nL() {
        return this.Pb;
    }

    public boolean nM() {
        return this.mUseSdCard;
    }

    public boolean nN() {
        return this.Po;
    }

    public boolean nO() {
        return this.mMustSuccess;
    }

    public String nP() {
        return this.Pm;
    }

    public static String cf(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
