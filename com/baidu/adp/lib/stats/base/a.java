package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String xg;
    protected String xq;
    protected String xs;
    protected q xt;
    private StringBuffer xh = new StringBuffer();
    private StringBuffer xi = new StringBuffer();
    private int xj = 0;
    private int xk = 0;
    private long xa = 0;
    private long xl = 0;
    protected long xm = 0;
    private long xn = 0;
    private long xo = 0;
    protected int xp = 50;
    protected final String xr = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(q qVar) {
        this.xt = qVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.c cVar) {
        if (cVar != null) {
            try {
                this.xh.append(cVar.toString());
                this.xh.append("\r\n");
                this.xj++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xt != null) {
            this.xt.g(this);
        }
        this.xa = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.c cVar) {
        if (cVar != null) {
            try {
                this.xi.append(cVar.toString());
                this.xi.append("\r\n");
                this.xk++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xt != null) {
            this.xt.g(this);
        }
        this.xl = System.currentTimeMillis();
    }

    public int gi() {
        return this.xj;
    }

    public int gj() {
        return this.xk;
    }

    public long gk() {
        return this.xm;
    }

    public void g(long j) {
        this.xm = j;
    }

    public long gl() {
        return this.xa;
    }

    public long gm() {
        return this.xl;
    }

    public String gn() {
        if (TextUtils.isEmpty(this.xs)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.xq);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.xs = sb.toString();
        }
        return this.xs;
    }

    public String go() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.xq);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long gp() {
        return this.xn;
    }

    public long gq() {
        return this.xo;
    }

    public void h(long j) {
        this.xn = j;
    }

    public void i(long j) {
        this.xo = j;
    }

    public synchronized void gr() {
        this.xh = new StringBuffer();
        this.xj = 0;
        this.xn = 0L;
    }

    public synchronized void gs() {
        this.xi = new StringBuffer();
        this.xk = 0;
        this.xo = 0L;
    }

    public void ah(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.xg = str;
        }
    }

    public String gt() {
        return this.xg;
    }

    public boolean gu() {
        return this.isUploading;
    }

    public void H(boolean z) {
        this.isUploading = z;
    }

    public String gv() {
        return "omp";
    }

    public StringBuffer gw() {
        return this.xh;
    }

    public StringBuffer gx() {
        return this.xi;
    }

    public boolean gy() {
        return this.mUseSdCard;
    }

    public boolean gz() {
        return this.mMustSuccess;
    }

    public String gA() {
        return this.xq;
    }

    public static String ai(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
