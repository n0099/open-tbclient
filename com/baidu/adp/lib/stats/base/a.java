package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String MP;
    protected String Nd;
    protected String Ng;
    protected j Ni;
    private StringBuffer MQ = new StringBuffer();
    private StringBuffer MR = new StringBuffer();
    private StringBuffer MS = new StringBuffer();
    private int MT = 0;
    private int MU = 0;
    private int MV = 0;
    private long MA = 0;
    private long MW = 0;
    private long MX = 0;
    protected long MY = 0;
    private long MZ = 0;
    private long Na = 0;
    private long Nb = 0;
    protected int Nc = 50;
    protected final String Ne = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean Nf = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean Nh = false;

    public a(j jVar) {
        this.Ni = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
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
        if (this.Ni != null) {
            this.Ni.o(this);
        }
        this.MA = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.MR.append(aVar.toString());
                    this.MR.append("\r\n");
                    this.MU++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Ni != null) {
            this.Ni.o(this);
        }
        this.MW = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.lw() != null) {
                    this.MS.append(aVar.lw().lJ().toString());
                    this.MS.append("\r\n");
                    this.MV++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Ni != null) {
            this.Ni.o(this);
        }
        this.MX = System.currentTimeMillis();
    }

    public int lL() {
        return this.MT;
    }

    public int lM() {
        return this.MU;
    }

    public int lN() {
        return this.MV;
    }

    public long lO() {
        return this.MY;
    }

    public void J(long j) {
        this.MY = j;
    }

    public long lP() {
        return this.MA;
    }

    public long lQ() {
        return this.MW;
    }

    public long lR() {
        return this.MX;
    }

    public String lS() {
        if (TextUtils.isEmpty(this.Ng)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Nd);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.Ng = sb.toString();
        }
        return this.Ng;
    }

    public String lT() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Nd);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long lU() {
        return this.MZ;
    }

    public long lV() {
        return this.Na;
    }

    public long lW() {
        return this.Nb;
    }

    public void K(long j) {
        this.MZ = j;
    }

    public void L(long j) {
        this.Na = j;
    }

    public void M(long j) {
        this.Nb = j;
    }

    public synchronized void lX() {
        this.MQ = new StringBuffer();
        this.MT = 0;
        this.MZ = 0L;
    }

    public synchronized void lY() {
        this.MR = new StringBuffer();
        this.MU = 0;
        this.Na = 0L;
    }

    public synchronized void lZ() {
        this.MS = new StringBuffer();
        this.MV = 0;
        this.Nb = 0L;
    }

    public void bW(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.MP = str;
        }
    }

    public String ma() {
        return this.MP;
    }

    public boolean mb() {
        return this.isUploading;
    }

    public void aq(boolean z) {
        this.isUploading = z;
    }

    public boolean mc() {
        return this.Nh;
    }

    public void ar(boolean z) {
        this.Nh = z;
    }

    public String md() {
        return BdStatsConstant.FILE_OMP;
    }

    public String me() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer mf() {
        return this.MQ;
    }

    public StringBuffer mg() {
        return this.MR;
    }

    public StringBuffer mh() {
        return this.MS;
    }

    public boolean mi() {
        return this.mUseSdCard;
    }

    public boolean mj() {
        return this.Nf;
    }

    public boolean mk() {
        return this.mMustSuccess;
    }

    public String ml() {
        return this.Nd;
    }

    public static String bX(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
