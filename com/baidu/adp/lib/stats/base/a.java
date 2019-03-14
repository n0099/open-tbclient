package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class a {
    protected String EI;
    protected String EK;
    protected i EL;
    private String Ey;
    private StringBuffer Ez = new StringBuffer();
    private StringBuffer EA = new StringBuffer();
    private int EB = 0;
    private int EC = 0;
    private long Er = 0;
    private long ED = 0;
    protected long EE = 0;
    private long EF = 0;
    private long EG = 0;
    protected int EH = 50;
    protected final String EJ = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.EL = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Ez.append(aVar.toString());
                    this.Ez.append("\r\n");
                    this.EB++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.EL != null) {
            this.EL.g(this);
        }
        this.Er = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.EA.append(aVar.toString());
                    this.EA.append("\r\n");
                    this.EC++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.EL != null) {
            this.EL.g(this);
        }
        this.ED = System.currentTimeMillis();
    }

    public int jW() {
        return this.EB;
    }

    public int jX() {
        return this.EC;
    }

    public long jY() {
        return this.EE;
    }

    public void n(long j) {
        this.EE = j;
    }

    public long jZ() {
        return this.Er;
    }

    public long ka() {
        return this.ED;
    }

    public String kb() {
        if (TextUtils.isEmpty(this.EK)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.EI);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.EK = sb.toString();
        }
        return this.EK;
    }

    public String kc() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.EI);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long kd() {
        return this.EF;
    }

    public long ke() {
        return this.EG;
    }

    public void o(long j) {
        this.EF = j;
    }

    public void p(long j) {
        this.EG = j;
    }

    public synchronized void kf() {
        this.Ez = new StringBuffer();
        this.EB = 0;
        this.EF = 0L;
    }

    public synchronized void kg() {
        this.EA = new StringBuffer();
        this.EC = 0;
        this.EG = 0L;
    }

    public void ba(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Ey = str;
        }
    }

    public String kh() {
        return this.Ey;
    }

    public boolean ki() {
        return this.isUploading;
    }

    public void ak(boolean z) {
        this.isUploading = z;
    }

    public String kj() {
        return "omp";
    }

    public StringBuffer kk() {
        return this.Ez;
    }

    public StringBuffer kl() {
        return this.EA;
    }

    public boolean km() {
        return this.mUseSdCard;
    }

    public boolean kn() {
        return this.mMustSuccess;
    }

    public String ko() {
        return this.EI;
    }

    public static String bb(String str) {
        if ("net".equals(str) || Config.OPERATOR.equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
