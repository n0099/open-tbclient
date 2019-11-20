package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private String qf;
    protected String qq;
    protected String qs;
    protected i qt;
    private StringBuffer qg = new StringBuffer();
    private StringBuffer qh = new StringBuffer();
    private int qi = 0;
    private int qj = 0;
    private long qa = 0;
    private long ql = 0;
    protected long qm = 0;
    private long qn = 0;
    private long qo = 0;
    protected int qp = 50;
    protected final String qr = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.qt = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.qg.append(aVar.toString());
                    this.qg.append("\r\n");
                    this.qi++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.qt != null) {
            this.qt.g(this);
        }
        this.qa = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.qh.append(aVar.toString());
                    this.qh.append("\r\n");
                    this.qj++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.qt != null) {
            this.qt.g(this);
        }
        this.ql = System.currentTimeMillis();
    }

    public int gm() {
        return this.qi;
    }

    public int gn() {
        return this.qj;
    }

    public long go() {
        return this.qm;
    }

    public void j(long j) {
        this.qm = j;
    }

    public long gp() {
        return this.qa;
    }

    public long gq() {
        return this.ql;
    }

    public String gr() {
        if (TextUtils.isEmpty(this.qs)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.qq);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.qs = sb.toString();
        }
        return this.qs;
    }

    public String gs() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.qq);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long gt() {
        return this.qn;
    }

    public long gu() {
        return this.qo;
    }

    public void k(long j) {
        this.qn = j;
    }

    public void l(long j) {
        this.qo = j;
    }

    public synchronized void gv() {
        this.qg = new StringBuffer();
        this.qi = 0;
        this.qn = 0L;
    }

    public synchronized void gw() {
        this.qh = new StringBuffer();
        this.qj = 0;
        this.qo = 0L;
    }

    public void ap(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.qf = str;
        }
    }

    public String gx() {
        return this.qf;
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
        return this.qg;
    }

    public StringBuffer gB() {
        return this.qh;
    }

    public boolean gC() {
        return this.mUseSdCard;
    }

    public boolean gD() {
        return this.mMustSuccess;
    }

    public String gE() {
        return this.qq;
    }

    public static String aq(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
