package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.c.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String Pb;
    protected String Pp;
    protected String Ps;
    protected j Pu;
    private StringBuffer Pc = new StringBuffer();
    private StringBuffer Pd = new StringBuffer();
    private StringBuffer Pe = new StringBuffer();
    private int Pf = 0;
    private int Pg = 0;
    private int Ph = 0;
    private long OO = 0;
    private long Pi = 0;
    private long Pj = 0;
    protected long Pk = 0;
    private long Pl = 0;
    private long Pm = 0;
    private long Pn = 0;
    protected int Po = 50;
    protected final String Pq = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean Pr = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean Pt = false;

    public a(j jVar) {
        this.Pu = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Pc.append(aVar.toString());
                    this.Pc.append("\r\n");
                    this.Pf++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Pu != null) {
            this.Pu.o(this);
        }
        this.OO = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Pd.append(aVar.toString());
                    this.Pd.append("\r\n");
                    this.Pg++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Pu != null) {
            this.Pu.o(this);
        }
        this.Pi = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.mE() != null) {
                    this.Pe.append(aVar.mE().mQ().toString());
                    this.Pe.append("\r\n");
                    this.Ph++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Pu != null) {
            this.Pu.o(this);
        }
        this.Pj = System.currentTimeMillis();
    }

    public int mR() {
        return this.Pf;
    }

    public int mS() {
        return this.Pg;
    }

    public int mT() {
        return this.Ph;
    }

    public long mU() {
        return this.Pk;
    }

    public void H(long j) {
        this.Pk = j;
    }

    public long mV() {
        return this.OO;
    }

    public long mW() {
        return this.Pi;
    }

    public long mX() {
        return this.Pj;
    }

    public String mY() {
        if (TextUtils.isEmpty(this.Ps)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Pp);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.Ps = sb.toString();
        }
        return this.Ps;
    }

    public String mZ() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Pp);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long na() {
        return this.Pl;
    }

    public long nb() {
        return this.Pm;
    }

    public long nc() {
        return this.Pn;
    }

    public void I(long j) {
        this.Pl = j;
    }

    public void J(long j) {
        this.Pm = j;
    }

    public void K(long j) {
        this.Pn = j;
    }

    public synchronized void nd() {
        this.Pc = new StringBuffer();
        this.Pf = 0;
        this.Pl = 0L;
    }

    public synchronized void ne() {
        this.Pd = new StringBuffer();
        this.Pg = 0;
        this.Pm = 0L;
    }

    public synchronized void nf() {
        this.Pe = new StringBuffer();
        this.Ph = 0;
        this.Pn = 0L;
    }

    public void bX(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Pb = str;
        }
    }

    public String ng() {
        return this.Pb;
    }

    public boolean nh() {
        return this.isUploading;
    }

    public void ap(boolean z) {
        this.isUploading = z;
    }

    public boolean ni() {
        return this.Pt;
    }

    public void aq(boolean z) {
        this.Pt = z;
    }

    public String nj() {
        return BdStatsConstant.FILE_OMP;
    }

    public String nk() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer nl() {
        return this.Pc;
    }

    public StringBuffer nm() {
        return this.Pd;
    }

    public StringBuffer nn() {
        return this.Pe;
    }

    public boolean no() {
        return this.mUseSdCard;
    }

    public boolean np() {
        return this.Pr;
    }

    public boolean nq() {
        return this.mMustSuccess;
    }

    public String nr() {
        return this.Pp;
    }

    public static String bY(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
