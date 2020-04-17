package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String LX;
    protected String Mm;
    protected String Mp;
    protected j Mr;
    private StringBuffer LY = new StringBuffer();
    private StringBuffer LZ = new StringBuffer();
    private StringBuffer Ma = new StringBuffer();
    private int Mb = 0;
    private int Mc = 0;
    private int Me = 0;
    private long LI = 0;
    private long Mf = 0;
    private long Mg = 0;
    protected long Mh = 0;
    private long Mi = 0;
    private long Mj = 0;
    private long Mk = 0;
    protected int Ml = 50;
    protected final String Mn = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean Mo = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean Mq = false;

    public a(j jVar) {
        this.Mr = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.LY.append(aVar.toString());
                    this.LY.append("\r\n");
                    this.Mb++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Mr != null) {
            this.Mr.o(this);
        }
        this.LI = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.LZ.append(aVar.toString());
                    this.LZ.append("\r\n");
                    this.Mc++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Mr != null) {
            this.Mr.o(this);
        }
        this.Mf = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.le() != null) {
                    this.Ma.append(aVar.le().lr().toString());
                    this.Ma.append("\r\n");
                    this.Me++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Mr != null) {
            this.Mr.o(this);
        }
        this.Mg = System.currentTimeMillis();
    }

    public int lt() {
        return this.Mb;
    }

    public int lu() {
        return this.Mc;
    }

    public int lv() {
        return this.Me;
    }

    public long lw() {
        return this.Mh;
    }

    public void J(long j) {
        this.Mh = j;
    }

    public long lx() {
        return this.LI;
    }

    public long ly() {
        return this.Mf;
    }

    public long lz() {
        return this.Mg;
    }

    public String lA() {
        if (TextUtils.isEmpty(this.Mp)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Mm);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.Mp = sb.toString();
        }
        return this.Mp;
    }

    public String lB() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Mm);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long lC() {
        return this.Mi;
    }

    public long lD() {
        return this.Mj;
    }

    public long lE() {
        return this.Mk;
    }

    public void K(long j) {
        this.Mi = j;
    }

    public void L(long j) {
        this.Mj = j;
    }

    public void M(long j) {
        this.Mk = j;
    }

    public synchronized void lF() {
        this.LY = new StringBuffer();
        this.Mb = 0;
        this.Mi = 0L;
    }

    public synchronized void lG() {
        this.LZ = new StringBuffer();
        this.Mc = 0;
        this.Mj = 0L;
    }

    public synchronized void lH() {
        this.Ma = new StringBuffer();
        this.Me = 0;
        this.Mk = 0L;
    }

    public void bU(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.LX = str;
        }
    }

    public String lI() {
        return this.LX;
    }

    public boolean lJ() {
        return this.isUploading;
    }

    public void an(boolean z) {
        this.isUploading = z;
    }

    public boolean lK() {
        return this.Mq;
    }

    public void ao(boolean z) {
        this.Mq = z;
    }

    public String lL() {
        return BdStatsConstant.FILE_OMP;
    }

    public String lM() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer lN() {
        return this.LY;
    }

    public StringBuffer lO() {
        return this.LZ;
    }

    public StringBuffer lP() {
        return this.Ma;
    }

    public boolean lQ() {
        return this.mUseSdCard;
    }

    public boolean lR() {
        return this.Mo;
    }

    public boolean lS() {
        return this.mMustSuccess;
    }

    public String lT() {
        return this.Mm;
    }

    public static String bV(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
