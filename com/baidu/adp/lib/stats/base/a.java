package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String sS;
    protected String td;
    protected String tf;
    protected i tg;
    private StringBuffer sT = new StringBuffer();
    private StringBuffer sU = new StringBuffer();
    private int sV = 0;
    private int sW = 0;
    private long sN = 0;
    private long sX = 0;
    protected long sY = 0;
    private long sZ = 0;
    private long tb = 0;
    protected int tc = 50;
    protected final String te = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.tg = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.sT.append(aVar.toString());
                    this.sT.append("\r\n");
                    this.sV++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.tg != null) {
            this.tg.g(this);
        }
        this.sN = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.sU.append(aVar.toString());
                    this.sU.append("\r\n");
                    this.sW++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.tg != null) {
            this.tg.g(this);
        }
        this.sX = System.currentTimeMillis();
    }

    public int gJ() {
        return this.sV;
    }

    public int gK() {
        return this.sW;
    }

    public long gL() {
        return this.sY;
    }

    public void l(long j) {
        this.sY = j;
    }

    public long gM() {
        return this.sN;
    }

    public long gN() {
        return this.sX;
    }

    public String gO() {
        if (TextUtils.isEmpty(this.tf)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.td);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.tf = sb.toString();
        }
        return this.tf;
    }

    public String gP() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.td);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long gQ() {
        return this.sZ;
    }

    public long gR() {
        return this.tb;
    }

    public void m(long j) {
        this.sZ = j;
    }

    public void n(long j) {
        this.tb = j;
    }

    public synchronized void gS() {
        this.sT = new StringBuffer();
        this.sV = 0;
        this.sZ = 0L;
    }

    public synchronized void gT() {
        this.sU = new StringBuffer();
        this.sW = 0;
        this.tb = 0L;
    }

    public void aB(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.sS = str;
        }
    }

    public String gU() {
        return this.sS;
    }

    public boolean gV() {
        return this.isUploading;
    }

    public void N(boolean z) {
        this.isUploading = z;
    }

    public String gW() {
        return BdStatsConstant.FILE_OMP;
    }

    public StringBuffer gX() {
        return this.sT;
    }

    public StringBuffer gY() {
        return this.sU;
    }

    public boolean gZ() {
        return this.mUseSdCard;
    }

    public boolean ha() {
        return this.mMustSuccess;
    }

    public String hb() {
        return this.td;
    }

    public static String aC(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
