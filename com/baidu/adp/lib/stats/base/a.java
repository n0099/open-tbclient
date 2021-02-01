package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.c.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String OX;
    protected String Pl;
    protected String Po;
    protected j Pq;
    private StringBuffer OY = new StringBuffer();
    private StringBuffer OZ = new StringBuffer();
    private StringBuffer Pa = new StringBuffer();
    private int Pb = 0;
    private int Pc = 0;
    private int Pd = 0;
    private long OI = 0;
    private long Pe = 0;
    private long Pf = 0;
    protected long Pg = 0;
    private long Ph = 0;
    private long Pi = 0;
    private long Pj = 0;
    protected int Pk = 50;
    protected final String Pm = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean Pn = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean Pp = false;

    public a(j jVar) {
        this.Pq = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.OY.append(aVar.toString());
                    this.OY.append("\r\n");
                    this.Pb++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Pq != null) {
            this.Pq.o(this);
        }
        this.OI = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
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
        if (this.Pq != null) {
            this.Pq.o(this);
        }
        this.Pe = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.mD() != null) {
                    this.Pa.append(aVar.mD().mP().toString());
                    this.Pa.append("\r\n");
                    this.Pd++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Pq != null) {
            this.Pq.o(this);
        }
        this.Pf = System.currentTimeMillis();
    }

    public int mQ() {
        return this.Pb;
    }

    public int mR() {
        return this.Pc;
    }

    public int mS() {
        return this.Pd;
    }

    public long mT() {
        return this.Pg;
    }

    public void H(long j) {
        this.Pg = j;
    }

    public long mU() {
        return this.OI;
    }

    public long mV() {
        return this.Pe;
    }

    public long mW() {
        return this.Pf;
    }

    public String mX() {
        if (TextUtils.isEmpty(this.Po)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Pl);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.Po = sb.toString();
        }
        return this.Po;
    }

    public String mY() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Pl);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long mZ() {
        return this.Ph;
    }

    public long na() {
        return this.Pi;
    }

    public long nb() {
        return this.Pj;
    }

    public void I(long j) {
        this.Ph = j;
    }

    public void J(long j) {
        this.Pi = j;
    }

    public void K(long j) {
        this.Pj = j;
    }

    public synchronized void nc() {
        this.OY = new StringBuffer();
        this.Pb = 0;
        this.Ph = 0L;
    }

    public synchronized void nd() {
        this.OZ = new StringBuffer();
        this.Pc = 0;
        this.Pi = 0L;
    }

    public synchronized void ne() {
        this.Pa = new StringBuffer();
        this.Pd = 0;
        this.Pj = 0L;
    }

    public void bX(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.OX = str;
        }
    }

    public String nf() {
        return this.OX;
    }

    public boolean ng() {
        return this.isUploading;
    }

    public void ap(boolean z) {
        this.isUploading = z;
    }

    public boolean nh() {
        return this.Pp;
    }

    public void aq(boolean z) {
        this.Pp = z;
    }

    public String ni() {
        return BdStatsConstant.FILE_OMP;
    }

    public String nj() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer nk() {
        return this.OY;
    }

    public StringBuffer nl() {
        return this.OZ;
    }

    public StringBuffer nm() {
        return this.Pa;
    }

    public boolean nn() {
        return this.mUseSdCard;
    }

    public boolean no() {
        return this.Pn;
    }

    public boolean np() {
        return this.mMustSuccess;
    }

    public String nq() {
        return this.Pl;
    }

    public static String bY(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
