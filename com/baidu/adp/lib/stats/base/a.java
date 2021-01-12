package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.c.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String OZ;
    protected String Pn;
    protected String Pq;
    protected j Ps;
    private StringBuffer Pa = new StringBuffer();
    private StringBuffer Pb = new StringBuffer();
    private StringBuffer Pc = new StringBuffer();
    private int Pd = 0;
    private int Pe = 0;
    private int Pf = 0;
    private long OL = 0;
    private long Pg = 0;
    private long Ph = 0;
    protected long Pi = 0;
    private long Pj = 0;
    private long Pk = 0;
    private long Pl = 0;
    protected int Pm = 50;
    protected final String Po = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean Pp = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean Pr = false;

    public a(j jVar) {
        this.Ps = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
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
        if (this.Ps != null) {
            this.Ps.o(this);
        }
        this.OL = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Pb.append(aVar.toString());
                    this.Pb.append("\r\n");
                    this.Pe++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Ps != null) {
            this.Ps.o(this);
        }
        this.Pg = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.mE() != null) {
                    this.Pc.append(aVar.mE().mQ().toString());
                    this.Pc.append("\r\n");
                    this.Pf++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Ps != null) {
            this.Ps.o(this);
        }
        this.Ph = System.currentTimeMillis();
    }

    public int mR() {
        return this.Pd;
    }

    public int mS() {
        return this.Pe;
    }

    public int mT() {
        return this.Pf;
    }

    public long mU() {
        return this.Pi;
    }

    public void H(long j) {
        this.Pi = j;
    }

    public long mV() {
        return this.OL;
    }

    public long mW() {
        return this.Pg;
    }

    public long mX() {
        return this.Ph;
    }

    public String mY() {
        if (TextUtils.isEmpty(this.Pq)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Pn);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.Pq = sb.toString();
        }
        return this.Pq;
    }

    public String mZ() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Pn);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long na() {
        return this.Pj;
    }

    public long nb() {
        return this.Pk;
    }

    public long nc() {
        return this.Pl;
    }

    public void I(long j) {
        this.Pj = j;
    }

    public void J(long j) {
        this.Pk = j;
    }

    public void K(long j) {
        this.Pl = j;
    }

    public synchronized void nd() {
        this.Pa = new StringBuffer();
        this.Pd = 0;
        this.Pj = 0L;
    }

    public synchronized void ne() {
        this.Pb = new StringBuffer();
        this.Pe = 0;
        this.Pk = 0L;
    }

    public synchronized void nf() {
        this.Pc = new StringBuffer();
        this.Pf = 0;
        this.Pl = 0L;
    }

    public void bX(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.OZ = str;
        }
    }

    public String ng() {
        return this.OZ;
    }

    public boolean nh() {
        return this.isUploading;
    }

    public void ap(boolean z) {
        this.isUploading = z;
    }

    public boolean ni() {
        return this.Pr;
    }

    public void aq(boolean z) {
        this.Pr = z;
    }

    public String nj() {
        return BdStatsConstant.FILE_OMP;
    }

    public String nk() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer nl() {
        return this.Pa;
    }

    public StringBuffer nm() {
        return this.Pb;
    }

    public StringBuffer nn() {
        return this.Pc;
    }

    public boolean no() {
        return this.mUseSdCard;
    }

    public boolean np() {
        return this.Pp;
    }

    public boolean nq() {
        return this.mMustSuccess;
    }

    public String nr() {
        return this.Pn;
    }

    public static String bY(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
