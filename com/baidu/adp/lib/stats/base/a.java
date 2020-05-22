package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    protected String MD;
    protected j MF;
    private String Ml;
    protected String Mz;
    private StringBuffer Mm = new StringBuffer();
    private StringBuffer Mn = new StringBuffer();
    private StringBuffer Mo = new StringBuffer();
    private int Mp = 0;
    private int Mq = 0;
    private int Mr = 0;
    private long LZ = 0;
    private long Ms = 0;
    private long Mt = 0;
    protected long Mu = 0;
    private long Mv = 0;
    private long Mw = 0;
    private long Mx = 0;
    protected int My = 50;
    protected final String MA = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean MC = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean ME = false;

    public a(j jVar) {
        this.MF = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Mm.append(aVar.toString());
                    this.Mm.append("\r\n");
                    this.Mp++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.MF != null) {
            this.MF.o(this);
        }
        this.LZ = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Mn.append(aVar.toString());
                    this.Mn.append("\r\n");
                    this.Mq++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.MF != null) {
            this.MF.o(this);
        }
        this.Ms = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.lg() != null) {
                    this.Mo.append(aVar.lg().lt().toString());
                    this.Mo.append("\r\n");
                    this.Mr++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.MF != null) {
            this.MF.o(this);
        }
        this.Mt = System.currentTimeMillis();
    }

    public int lv() {
        return this.Mp;
    }

    public int lw() {
        return this.Mq;
    }

    public int lx() {
        return this.Mr;
    }

    public long ly() {
        return this.Mu;
    }

    public void J(long j) {
        this.Mu = j;
    }

    public long lz() {
        return this.LZ;
    }

    public long lA() {
        return this.Ms;
    }

    public long lB() {
        return this.Mt;
    }

    public String lC() {
        if (TextUtils.isEmpty(this.MD)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Mz);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.MD = sb.toString();
        }
        return this.MD;
    }

    public String lD() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Mz);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long lE() {
        return this.Mv;
    }

    public long lF() {
        return this.Mw;
    }

    public long lG() {
        return this.Mx;
    }

    public void K(long j) {
        this.Mv = j;
    }

    public void L(long j) {
        this.Mw = j;
    }

    public void M(long j) {
        this.Mx = j;
    }

    public synchronized void lH() {
        this.Mm = new StringBuffer();
        this.Mp = 0;
        this.Mv = 0L;
    }

    public synchronized void lI() {
        this.Mn = new StringBuffer();
        this.Mq = 0;
        this.Mw = 0L;
    }

    public synchronized void lJ() {
        this.Mo = new StringBuffer();
        this.Mr = 0;
        this.Mx = 0L;
    }

    public void bV(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Ml = str;
        }
    }

    public String lK() {
        return this.Ml;
    }

    public boolean lL() {
        return this.isUploading;
    }

    public void ap(boolean z) {
        this.isUploading = z;
    }

    public boolean lM() {
        return this.ME;
    }

    public void aq(boolean z) {
        this.ME = z;
    }

    public String lN() {
        return BdStatsConstant.FILE_OMP;
    }

    public String lO() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer lP() {
        return this.Mm;
    }

    public StringBuffer lQ() {
        return this.Mn;
    }

    public StringBuffer lR() {
        return this.Mo;
    }

    public boolean lS() {
        return this.mUseSdCard;
    }

    public boolean lT() {
        return this.MC;
    }

    public boolean lU() {
        return this.mMustSuccess;
    }

    public String lV() {
        return this.Mz;
    }

    public static String bW(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
