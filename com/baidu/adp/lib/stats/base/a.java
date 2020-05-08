package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String Mb;
    protected String Mq;
    protected String Mt;
    protected j Mv;
    private StringBuffer Mc = new StringBuffer();
    private StringBuffer Me = new StringBuffer();
    private StringBuffer Mf = new StringBuffer();
    private int Mg = 0;
    private int Mh = 0;
    private int Mi = 0;
    private long LN = 0;
    private long Mj = 0;
    private long Mk = 0;
    protected long Ml = 0;
    private long Mm = 0;
    private long Mn = 0;
    private long Mo = 0;
    protected int Mp = 50;
    protected final String Mr = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean Ms = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean Mu = false;

    public a(j jVar) {
        this.Mv = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Mc.append(aVar.toString());
                    this.Mc.append("\r\n");
                    this.Mg++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Mv != null) {
            this.Mv.o(this);
        }
        this.LN = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Me.append(aVar.toString());
                    this.Me.append("\r\n");
                    this.Mh++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Mv != null) {
            this.Mv.o(this);
        }
        this.Mj = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.le() != null) {
                    this.Mf.append(aVar.le().lr().toString());
                    this.Mf.append("\r\n");
                    this.Mi++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Mv != null) {
            this.Mv.o(this);
        }
        this.Mk = System.currentTimeMillis();
    }

    public int lt() {
        return this.Mg;
    }

    public int lu() {
        return this.Mh;
    }

    public int lv() {
        return this.Mi;
    }

    public long lw() {
        return this.Ml;
    }

    public void J(long j) {
        this.Ml = j;
    }

    public long lx() {
        return this.LN;
    }

    public long ly() {
        return this.Mj;
    }

    public long lz() {
        return this.Mk;
    }

    public String lA() {
        if (TextUtils.isEmpty(this.Mt)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Mq);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.Mt = sb.toString();
        }
        return this.Mt;
    }

    public String lB() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Mq);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long lC() {
        return this.Mm;
    }

    public long lD() {
        return this.Mn;
    }

    public long lE() {
        return this.Mo;
    }

    public void K(long j) {
        this.Mm = j;
    }

    public void L(long j) {
        this.Mn = j;
    }

    public void M(long j) {
        this.Mo = j;
    }

    public synchronized void lF() {
        this.Mc = new StringBuffer();
        this.Mg = 0;
        this.Mm = 0L;
    }

    public synchronized void lG() {
        this.Me = new StringBuffer();
        this.Mh = 0;
        this.Mn = 0L;
    }

    public synchronized void lH() {
        this.Mf = new StringBuffer();
        this.Mi = 0;
        this.Mo = 0L;
    }

    public void bU(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Mb = str;
        }
    }

    public String lI() {
        return this.Mb;
    }

    public boolean lJ() {
        return this.isUploading;
    }

    public void an(boolean z) {
        this.isUploading = z;
    }

    public boolean lK() {
        return this.Mu;
    }

    public void ao(boolean z) {
        this.Mu = z;
    }

    public String lL() {
        return BdStatsConstant.FILE_OMP;
    }

    public String lM() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer lN() {
        return this.Mc;
    }

    public StringBuffer lO() {
        return this.Me;
    }

    public StringBuffer lP() {
        return this.Mf;
    }

    public boolean lQ() {
        return this.mUseSdCard;
    }

    public boolean lR() {
        return this.Ms;
    }

    public boolean lS() {
        return this.mMustSuccess;
    }

    public String lT() {
        return this.Mq;
    }

    public static String bV(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
