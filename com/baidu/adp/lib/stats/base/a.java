package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String yK;
    protected String yU;
    protected String yW;
    protected i yX;
    private StringBuffer yL = new StringBuffer();
    private StringBuffer yM = new StringBuffer();
    private int yN = 0;
    private int yO = 0;
    private long yE = 0;
    private long yP = 0;
    protected long yQ = 0;
    private long yR = 0;
    private long yS = 0;
    protected int yT = 50;
    protected final String yV = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.yX = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.yL.append(aVar.toString());
                    this.yL.append("\r\n");
                    this.yN++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.yX != null) {
            this.yX.g(this);
        }
        this.yE = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.yM.append(aVar.toString());
                    this.yM.append("\r\n");
                    this.yO++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.yX != null) {
            this.yX.g(this);
        }
        this.yP = System.currentTimeMillis();
    }

    public int gp() {
        return this.yN;
    }

    public int gq() {
        return this.yO;
    }

    public long gr() {
        return this.yQ;
    }

    public void g(long j) {
        this.yQ = j;
    }

    public long gs() {
        return this.yE;
    }

    public long gt() {
        return this.yP;
    }

    public String gu() {
        if (TextUtils.isEmpty(this.yW)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.yU);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.yW = sb.toString();
        }
        return this.yW;
    }

    public String gv() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.yU);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long gw() {
        return this.yR;
    }

    public long gx() {
        return this.yS;
    }

    public void h(long j) {
        this.yR = j;
    }

    public void i(long j) {
        this.yS = j;
    }

    public synchronized void gy() {
        this.yL = new StringBuffer();
        this.yN = 0;
        this.yR = 0L;
    }

    public synchronized void gz() {
        this.yM = new StringBuffer();
        this.yO = 0;
        this.yS = 0L;
    }

    public void av(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.yK = str;
        }
    }

    public String gA() {
        return this.yK;
    }

    public boolean gB() {
        return this.isUploading;
    }

    public void H(boolean z) {
        this.isUploading = z;
    }

    public String gC() {
        return "omp";
    }

    public StringBuffer gD() {
        return this.yL;
    }

    public StringBuffer gE() {
        return this.yM;
    }

    public boolean gF() {
        return this.mUseSdCard;
    }

    public boolean gG() {
        return this.mMustSuccess;
    }

    public String gH() {
        return this.yU;
    }

    public static String aw(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
