package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String Oc;
    protected String Or;
    protected String Ou;
    protected j Ow;
    private StringBuffer Od = new StringBuffer();
    private StringBuffer Oe = new StringBuffer();
    private StringBuffer Of = new StringBuffer();
    private int Og = 0;
    private int Oh = 0;
    private int Oi = 0;
    private long NP = 0;
    private long Oj = 0;
    private long Ok = 0;
    protected long Ol = 0;
    private long Om = 0;
    private long Oo = 0;
    private long Op = 0;
    protected int Oq = 50;
    protected final String Os = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean Ot = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean Ov = false;

    public a(j jVar) {
        this.Ow = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Od.append(aVar.toString());
                    this.Od.append("\r\n");
                    this.Og++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Ow != null) {
            this.Ow.o(this);
        }
        this.NP = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Oe.append(aVar.toString());
                    this.Oe.append("\r\n");
                    this.Oh++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Ow != null) {
            this.Ow.o(this);
        }
        this.Oj = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.nb() != null) {
                    this.Of.append(aVar.nb().no().toString());
                    this.Of.append("\r\n");
                    this.Oi++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Ow != null) {
            this.Ow.o(this);
        }
        this.Ok = System.currentTimeMillis();
    }

    public int nq() {
        return this.Og;
    }

    public int nr() {
        return this.Oh;
    }

    public int ns() {
        return this.Oi;
    }

    public long nt() {
        return this.Ol;
    }

    public void J(long j) {
        this.Ol = j;
    }

    public long nu() {
        return this.NP;
    }

    public long nv() {
        return this.Oj;
    }

    public long nw() {
        return this.Ok;
    }

    public String nx() {
        if (TextUtils.isEmpty(this.Ou)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Or);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.Ou = sb.toString();
        }
        return this.Ou;
    }

    public String ny() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Or);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long nz() {
        return this.Om;
    }

    public long nA() {
        return this.Oo;
    }

    public long nB() {
        return this.Op;
    }

    public void K(long j) {
        this.Om = j;
    }

    public void L(long j) {
        this.Oo = j;
    }

    public void M(long j) {
        this.Op = j;
    }

    public synchronized void nC() {
        this.Od = new StringBuffer();
        this.Og = 0;
        this.Om = 0L;
    }

    public synchronized void nD() {
        this.Oe = new StringBuffer();
        this.Oh = 0;
        this.Oo = 0L;
    }

    public synchronized void nE() {
        this.Of = new StringBuffer();
        this.Oi = 0;
        this.Op = 0L;
    }

    public void cb(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Oc = str;
        }
    }

    public String nF() {
        return this.Oc;
    }

    public boolean nG() {
        return this.isUploading;
    }

    public void ar(boolean z) {
        this.isUploading = z;
    }

    public boolean nH() {
        return this.Ov;
    }

    public void as(boolean z) {
        this.Ov = z;
    }

    public String nI() {
        return BdStatsConstant.FILE_OMP;
    }

    public String nJ() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer nK() {
        return this.Od;
    }

    public StringBuffer nL() {
        return this.Oe;
    }

    public StringBuffer nM() {
        return this.Of;
    }

    public boolean nN() {
        return this.mUseSdCard;
    }

    public boolean nO() {
        return this.Ot;
    }

    public boolean nP() {
        return this.mMustSuccess;
    }

    public String nQ() {
        return this.Or;
    }

    public static String cc(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
