package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String yI;
    protected String yS;
    protected String yU;
    protected i yV;
    private StringBuffer yJ = new StringBuffer();
    private StringBuffer yK = new StringBuffer();
    private int yL = 0;
    private int yM = 0;
    private long yC = 0;
    private long yN = 0;
    protected long yO = 0;
    private long yP = 0;
    private long yQ = 0;
    protected int yR = 50;
    protected final String yT = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.yV = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.yJ.append(aVar.toString());
                    this.yJ.append("\r\n");
                    this.yL++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.yV != null) {
            this.yV.g(this);
        }
        this.yC = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.yK.append(aVar.toString());
                    this.yK.append("\r\n");
                    this.yM++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.yV != null) {
            this.yV.g(this);
        }
        this.yN = System.currentTimeMillis();
    }

    public int gp() {
        return this.yL;
    }

    public int gq() {
        return this.yM;
    }

    public long gr() {
        return this.yO;
    }

    public void g(long j) {
        this.yO = j;
    }

    public long gs() {
        return this.yC;
    }

    public long gt() {
        return this.yN;
    }

    public String gu() {
        if (TextUtils.isEmpty(this.yU)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.yS);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.yU = sb.toString();
        }
        return this.yU;
    }

    public String gv() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.yS);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long gw() {
        return this.yP;
    }

    public long gx() {
        return this.yQ;
    }

    public void h(long j) {
        this.yP = j;
    }

    public void i(long j) {
        this.yQ = j;
    }

    public synchronized void gy() {
        this.yJ = new StringBuffer();
        this.yL = 0;
        this.yP = 0L;
    }

    public synchronized void gz() {
        this.yK = new StringBuffer();
        this.yM = 0;
        this.yQ = 0L;
    }

    public void au(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.yI = str;
        }
    }

    public String gA() {
        return this.yI;
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
        return this.yJ;
    }

    public StringBuffer gE() {
        return this.yK;
    }

    public boolean gF() {
        return this.mUseSdCard;
    }

    public boolean gG() {
        return this.mMustSuccess;
    }

    public String gH() {
        return this.yS;
    }

    public static String av(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
