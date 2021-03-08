package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.c.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    protected String QL;
    protected String QO;
    protected j QR;
    private String Qw;
    private StringBuffer Qx = new StringBuffer();
    private StringBuffer Qy = new StringBuffer();
    private StringBuffer Qz = new StringBuffer();
    private int QB = 0;
    private int QC = 0;
    private int QD = 0;
    private long Qk = 0;
    private long QE = 0;
    private long QF = 0;
    protected long QG = 0;
    private long QH = 0;
    private long QI = 0;
    private long QJ = 0;
    protected int QK = 50;
    protected final String QM = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean QN = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean QP = false;

    public a(j jVar) {
        this.QR = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Qx.append(aVar.toString());
                    this.Qx.append("\r\n");
                    this.QB++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.QR != null) {
            this.QR.o(this);
        }
        this.Qk = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Qy.append(aVar.toString());
                    this.Qy.append("\r\n");
                    this.QC++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.QR != null) {
            this.QR.o(this);
        }
        this.QE = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.mD() != null) {
                    this.Qz.append(aVar.mD().mP().toString());
                    this.Qz.append("\r\n");
                    this.QD++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.QR != null) {
            this.QR.o(this);
        }
        this.QF = System.currentTimeMillis();
    }

    public int mQ() {
        return this.QB;
    }

    public int mR() {
        return this.QC;
    }

    public int mS() {
        return this.QD;
    }

    public long mT() {
        return this.QG;
    }

    public void H(long j) {
        this.QG = j;
    }

    public long mU() {
        return this.Qk;
    }

    public long mV() {
        return this.QE;
    }

    public long mW() {
        return this.QF;
    }

    public String mX() {
        if (TextUtils.isEmpty(this.QO)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.QL);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.QO = sb.toString();
        }
        return this.QO;
    }

    public String mY() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.QL);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long mZ() {
        return this.QH;
    }

    public long na() {
        return this.QI;
    }

    public long nb() {
        return this.QJ;
    }

    public void I(long j) {
        this.QH = j;
    }

    public void J(long j) {
        this.QI = j;
    }

    public void K(long j) {
        this.QJ = j;
    }

    public synchronized void nc() {
        this.Qx = new StringBuffer();
        this.QB = 0;
        this.QH = 0L;
    }

    public synchronized void nd() {
        this.Qy = new StringBuffer();
        this.QC = 0;
        this.QI = 0L;
    }

    public synchronized void ne() {
        this.Qz = new StringBuffer();
        this.QD = 0;
        this.QJ = 0L;
    }

    public void cb(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Qw = str;
        }
    }

    public String nf() {
        return this.Qw;
    }

    public boolean ng() {
        return this.isUploading;
    }

    public void ap(boolean z) {
        this.isUploading = z;
    }

    public boolean nh() {
        return this.QP;
    }

    public void aq(boolean z) {
        this.QP = z;
    }

    public String ni() {
        return BdStatsConstant.FILE_OMP;
    }

    public String nj() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer nk() {
        return this.Qx;
    }

    public StringBuffer nl() {
        return this.Qy;
    }

    public StringBuffer nm() {
        return this.Qz;
    }

    public boolean nn() {
        return this.mUseSdCard;
    }

    public boolean no() {
        return this.QN;
    }

    public boolean np() {
        return this.mMustSuccess;
    }

    public String nq() {
        return this.QL;
    }

    public static String cc(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
