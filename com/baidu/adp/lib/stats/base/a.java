package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String qF;
    protected String qP;
    protected String qR;
    protected i qS;
    private StringBuffer qG = new StringBuffer();
    private StringBuffer qH = new StringBuffer();
    private int qI = 0;
    private int qJ = 0;
    private long qA = 0;
    private long qK = 0;
    protected long qL = 0;
    private long qM = 0;
    private long qN = 0;
    protected int qO = 50;
    protected final String qQ = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.qS = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.qG.append(aVar.toString());
                    this.qG.append("\r\n");
                    this.qI++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.qS != null) {
            this.qS.g(this);
        }
        this.qA = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.qH.append(aVar.toString());
                    this.qH.append("\r\n");
                    this.qJ++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.qS != null) {
            this.qS.g(this);
        }
        this.qK = System.currentTimeMillis();
    }

    public int gm() {
        return this.qI;
    }

    public int gn() {
        return this.qJ;
    }

    public long go() {
        return this.qL;
    }

    public void k(long j) {
        this.qL = j;
    }

    public long gp() {
        return this.qA;
    }

    public long gq() {
        return this.qK;
    }

    public String gr() {
        if (TextUtils.isEmpty(this.qR)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.qP);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.qR = sb.toString();
        }
        return this.qR;
    }

    public String gs() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.qP);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long gt() {
        return this.qM;
    }

    public long gu() {
        return this.qN;
    }

    public void l(long j) {
        this.qM = j;
    }

    public void m(long j) {
        this.qN = j;
    }

    public synchronized void gv() {
        this.qG = new StringBuffer();
        this.qI = 0;
        this.qM = 0L;
    }

    public synchronized void gw() {
        this.qH = new StringBuffer();
        this.qJ = 0;
        this.qN = 0L;
    }

    public void ap(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.qF = str;
        }
    }

    public String gx() {
        return this.qF;
    }

    public boolean gy() {
        return this.isUploading;
    }

    public void H(boolean z) {
        this.isUploading = z;
    }

    public String gz() {
        return BdStatsConstant.FILE_OMP;
    }

    public StringBuffer gA() {
        return this.qG;
    }

    public StringBuffer gB() {
        return this.qH;
    }

    public boolean gC() {
        return this.mUseSdCard;
    }

    public boolean gD() {
        return this.mMustSuccess;
    }

    public String gE() {
        return this.qP;
    }

    public static String aq(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
