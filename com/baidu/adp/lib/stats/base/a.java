package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String MO;
    protected String Nc;
    protected String Nf;
    protected j Nh;
    private StringBuffer MP = new StringBuffer();
    private StringBuffer MQ = new StringBuffer();
    private StringBuffer MR = new StringBuffer();
    private int MS = 0;
    private int MT = 0;
    private int MU = 0;
    private long Mz = 0;
    private long MV = 0;
    private long MW = 0;
    protected long MX = 0;
    private long MY = 0;
    private long MZ = 0;
    private long Na = 0;
    protected int Nb = 50;
    protected final String Nd = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean Ne = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean Ng = false;

    public a(j jVar) {
        this.Nh = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.MP.append(aVar.toString());
                    this.MP.append("\r\n");
                    this.MS++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Nh != null) {
            this.Nh.o(this);
        }
        this.Mz = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.MQ.append(aVar.toString());
                    this.MQ.append("\r\n");
                    this.MT++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Nh != null) {
            this.Nh.o(this);
        }
        this.MV = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.lw() != null) {
                    this.MR.append(aVar.lw().lJ().toString());
                    this.MR.append("\r\n");
                    this.MU++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Nh != null) {
            this.Nh.o(this);
        }
        this.MW = System.currentTimeMillis();
    }

    public int lL() {
        return this.MS;
    }

    public int lM() {
        return this.MT;
    }

    public int lN() {
        return this.MU;
    }

    public long lO() {
        return this.MX;
    }

    public void J(long j) {
        this.MX = j;
    }

    public long lP() {
        return this.Mz;
    }

    public long lQ() {
        return this.MV;
    }

    public long lR() {
        return this.MW;
    }

    public String lS() {
        if (TextUtils.isEmpty(this.Nf)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Nc);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.Nf = sb.toString();
        }
        return this.Nf;
    }

    public String lT() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Nc);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long lU() {
        return this.MY;
    }

    public long lV() {
        return this.MZ;
    }

    public long lW() {
        return this.Na;
    }

    public void K(long j) {
        this.MY = j;
    }

    public void L(long j) {
        this.MZ = j;
    }

    public void M(long j) {
        this.Na = j;
    }

    public synchronized void lX() {
        this.MP = new StringBuffer();
        this.MS = 0;
        this.MY = 0L;
    }

    public synchronized void lY() {
        this.MQ = new StringBuffer();
        this.MT = 0;
        this.MZ = 0L;
    }

    public synchronized void lZ() {
        this.MR = new StringBuffer();
        this.MU = 0;
        this.Na = 0L;
    }

    public void bU(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.MO = str;
        }
    }

    public String ma() {
        return this.MO;
    }

    public boolean mb() {
        return this.isUploading;
    }

    public void aq(boolean z) {
        this.isUploading = z;
    }

    public boolean mc() {
        return this.Ng;
    }

    public void ar(boolean z) {
        this.Ng = z;
    }

    public String md() {
        return BdStatsConstant.FILE_OMP;
    }

    public String me() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer mf() {
        return this.MP;
    }

    public StringBuffer mg() {
        return this.MQ;
    }

    public StringBuffer mh() {
        return this.MR;
    }

    public boolean mi() {
        return this.mUseSdCard;
    }

    public boolean mj() {
        return this.Ne;
    }

    public boolean mk() {
        return this.mMustSuccess;
    }

    public String ml() {
        return this.Nc;
    }

    public static String bV(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
