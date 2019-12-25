package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String sR;
    protected String tc;
    protected String te;
    protected i tf;
    private StringBuffer sS = new StringBuffer();
    private StringBuffer sT = new StringBuffer();
    private int sU = 0;
    private int sV = 0;
    private long sM = 0;
    private long sW = 0;
    protected long sX = 0;
    private long sY = 0;
    private long sZ = 0;
    protected int tb = 50;
    protected final String td = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.tf = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.sS.append(aVar.toString());
                    this.sS.append("\r\n");
                    this.sU++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.tf != null) {
            this.tf.g(this);
        }
        this.sM = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
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
        if (this.tf != null) {
            this.tf.g(this);
        }
        this.sW = System.currentTimeMillis();
    }

    public int gK() {
        return this.sU;
    }

    public int gL() {
        return this.sV;
    }

    public long gM() {
        return this.sX;
    }

    public void l(long j) {
        this.sX = j;
    }

    public long gN() {
        return this.sM;
    }

    public long gO() {
        return this.sW;
    }

    public String gP() {
        if (TextUtils.isEmpty(this.te)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.tc);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.te = sb.toString();
        }
        return this.te;
    }

    public String gQ() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.tc);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long gR() {
        return this.sY;
    }

    public long gS() {
        return this.sZ;
    }

    public void m(long j) {
        this.sY = j;
    }

    public void n(long j) {
        this.sZ = j;
    }

    public synchronized void gT() {
        this.sS = new StringBuffer();
        this.sU = 0;
        this.sY = 0L;
    }

    public synchronized void gU() {
        this.sT = new StringBuffer();
        this.sV = 0;
        this.sZ = 0L;
    }

    public void aB(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.sR = str;
        }
    }

    public String gV() {
        return this.sR;
    }

    public boolean gW() {
        return this.isUploading;
    }

    public void N(boolean z) {
        this.isUploading = z;
    }

    public String gX() {
        return BdStatsConstant.FILE_OMP;
    }

    public StringBuffer gY() {
        return this.sS;
    }

    public StringBuffer gZ() {
        return this.sT;
    }

    public boolean ha() {
        return this.mUseSdCard;
    }

    public boolean hb() {
        return this.mMustSuccess;
    }

    public String hc() {
        return this.tc;
    }

    public static String aC(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
