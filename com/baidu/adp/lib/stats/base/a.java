package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.SystemInfoUtil;
/* loaded from: classes.dex */
public class a {
    private String DM;
    protected String DX;
    protected String DZ;
    protected i Ea;
    private StringBuffer DN = new StringBuffer();
    private StringBuffer DO = new StringBuffer();
    private int DQ = 0;
    private int DR = 0;
    private long DF = 0;
    private long DS = 0;
    protected long DT = 0;
    private long DU = 0;
    private long DV = 0;
    protected int DW = 50;
    protected final String DY = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.Ea = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.DN.append(aVar.toString());
                    this.DN.append(SystemInfoUtil.LINE_END);
                    this.DQ++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Ea != null) {
            this.Ea.g(this);
        }
        this.DF = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.DO.append(aVar.toString());
                    this.DO.append(SystemInfoUtil.LINE_END);
                    this.DR++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Ea != null) {
            this.Ea.g(this);
        }
        this.DS = System.currentTimeMillis();
    }

    public int jI() {
        return this.DQ;
    }

    public int jJ() {
        return this.DR;
    }

    public long jK() {
        return this.DT;
    }

    public void n(long j) {
        this.DT = j;
    }

    public long jL() {
        return this.DF;
    }

    public long jM() {
        return this.DS;
    }

    public String jN() {
        if (TextUtils.isEmpty(this.DZ)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.DX);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.DZ = sb.toString();
        }
        return this.DZ;
    }

    public String jO() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.DX);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long jP() {
        return this.DU;
    }

    public long jQ() {
        return this.DV;
    }

    public void o(long j) {
        this.DU = j;
    }

    public void p(long j) {
        this.DV = j;
    }

    public synchronized void jR() {
        this.DN = new StringBuffer();
        this.DQ = 0;
        this.DU = 0L;
    }

    public synchronized void jS() {
        this.DO = new StringBuffer();
        this.DR = 0;
        this.DV = 0L;
    }

    public void ba(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.DM = str;
        }
    }

    public String jT() {
        return this.DM;
    }

    public boolean jU() {
        return this.isUploading;
    }

    public void W(boolean z) {
        this.isUploading = z;
    }

    public String jV() {
        return "omp";
    }

    public StringBuffer jW() {
        return this.DN;
    }

    public StringBuffer jX() {
        return this.DO;
    }

    public boolean jY() {
        return this.mUseSdCard;
    }

    public boolean jZ() {
        return this.mMustSuccess;
    }

    public String ka() {
        return this.DX;
    }

    public static String bb(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
