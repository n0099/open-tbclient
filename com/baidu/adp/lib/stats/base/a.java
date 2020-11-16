package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.c.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String Od;
    protected String Os;
    protected String Ov;
    protected j Ox;
    private StringBuffer Oe = new StringBuffer();
    private StringBuffer Of = new StringBuffer();
    private StringBuffer Og = new StringBuffer();
    private int Oh = 0;
    private int Oi = 0;
    private int Oj = 0;
    private long NQ = 0;
    private long Ok = 0;
    private long Ol = 0;
    protected long Om = 0;
    private long Oo = 0;
    private long Op = 0;
    private long Oq = 0;
    protected int Or = 50;
    protected final String Ot = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean Ou = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean Ow = false;

    public a(j jVar) {
        this.Ox = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
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
        if (this.Ox != null) {
            this.Ox.o(this);
        }
        this.NQ = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Of.append(aVar.toString());
                    this.Of.append("\r\n");
                    this.Oi++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Ox != null) {
            this.Ox.o(this);
        }
        this.Ok = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.nb() != null) {
                    this.Og.append(aVar.nb().no().toString());
                    this.Og.append("\r\n");
                    this.Oj++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.Ox != null) {
            this.Ox.o(this);
        }
        this.Ol = System.currentTimeMillis();
    }

    public int nq() {
        return this.Oh;
    }

    public int nr() {
        return this.Oi;
    }

    public int ns() {
        return this.Oj;
    }

    public long nt() {
        return this.Om;
    }

    public void J(long j) {
        this.Om = j;
    }

    public long nu() {
        return this.NQ;
    }

    public long nv() {
        return this.Ok;
    }

    public long nw() {
        return this.Ol;
    }

    public String nx() {
        if (TextUtils.isEmpty(this.Ov)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.Os);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.Ov = sb.toString();
        }
        return this.Ov;
    }

    public String ny() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.Os);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long nz() {
        return this.Oo;
    }

    public long nA() {
        return this.Op;
    }

    public long nB() {
        return this.Oq;
    }

    public void K(long j) {
        this.Oo = j;
    }

    public void L(long j) {
        this.Op = j;
    }

    public void M(long j) {
        this.Oq = j;
    }

    public synchronized void nC() {
        this.Oe = new StringBuffer();
        this.Oh = 0;
        this.Oo = 0L;
    }

    public synchronized void nD() {
        this.Of = new StringBuffer();
        this.Oi = 0;
        this.Op = 0L;
    }

    public synchronized void nE() {
        this.Og = new StringBuffer();
        this.Oj = 0;
        this.Oq = 0L;
    }

    public void cb(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Od = str;
        }
    }

    public String nF() {
        return this.Od;
    }

    public boolean nG() {
        return this.isUploading;
    }

    public void ar(boolean z) {
        this.isUploading = z;
    }

    public boolean nH() {
        return this.Ow;
    }

    public void as(boolean z) {
        this.Ow = z;
    }

    public String nI() {
        return BdStatsConstant.FILE_OMP;
    }

    public String nJ() {
        return ARPScriptEnvironment.KEY_DATA_PIP_TRACK;
    }

    public StringBuffer nK() {
        return this.Oe;
    }

    public StringBuffer nL() {
        return this.Of;
    }

    public StringBuffer nM() {
        return this.Og;
    }

    public boolean nN() {
        return this.mUseSdCard;
    }

    public boolean nO() {
        return this.Ou;
    }

    public boolean nP() {
        return this.mMustSuccess;
    }

    public String nQ() {
        return this.Os;
    }

    public static String cc(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
