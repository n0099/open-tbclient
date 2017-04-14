package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String xd;
    protected String xn;
    protected String xp;
    protected q xq;
    private StringBuffer xe = new StringBuffer();
    private StringBuffer xf = new StringBuffer();
    private int xg = 0;
    private int xh = 0;
    private long wX = 0;
    private long xi = 0;
    protected long xj = 0;
    private long xk = 0;
    private long xl = 0;
    protected int xm = 50;
    protected final String xo = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(q qVar) {
        this.xq = qVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.c cVar) {
        if (cVar != null) {
            try {
                this.xe.append(cVar.toString());
                this.xe.append("\r\n");
                this.xg++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xq != null) {
            this.xq.g(this);
        }
        this.wX = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.c cVar) {
        if (cVar != null) {
            try {
                this.xf.append(cVar.toString());
                this.xf.append("\r\n");
                this.xh++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xq != null) {
            this.xq.g(this);
        }
        this.xi = System.currentTimeMillis();
    }

    public int gh() {
        return this.xg;
    }

    public int gi() {
        return this.xh;
    }

    public long gj() {
        return this.xj;
    }

    public void g(long j) {
        this.xj = j;
    }

    public long gk() {
        return this.wX;
    }

    public long gl() {
        return this.xi;
    }

    public String gm() {
        if (TextUtils.isEmpty(this.xp)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.xn);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.xp = sb.toString();
        }
        return this.xp;
    }

    public String gn() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.xn);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long go() {
        return this.xk;
    }

    public long gp() {
        return this.xl;
    }

    public void h(long j) {
        this.xk = j;
    }

    public void i(long j) {
        this.xl = j;
    }

    public synchronized void gq() {
        this.xe = new StringBuffer();
        this.xg = 0;
        this.xk = 0L;
    }

    public synchronized void gr() {
        this.xf = new StringBuffer();
        this.xh = 0;
        this.xl = 0L;
    }

    public void ah(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.xd = str;
        }
    }

    public String gs() {
        return this.xd;
    }

    public boolean gt() {
        return this.isUploading;
    }

    public void H(boolean z) {
        this.isUploading = z;
    }

    public String gu() {
        return "omp";
    }

    public StringBuffer gv() {
        return this.xe;
    }

    public StringBuffer gw() {
        return this.xf;
    }

    public boolean gx() {
        return this.mUseSdCard;
    }

    public boolean gy() {
        return this.mMustSuccess;
    }

    public String gz() {
        return this.xn;
    }

    public static String ai(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
