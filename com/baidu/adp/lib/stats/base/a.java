package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String xh;
    protected String xr;
    protected String xt;
    protected q xu;
    private StringBuffer xi = new StringBuffer();
    private StringBuffer xj = new StringBuffer();
    private int xk = 0;
    private int xl = 0;
    private long xb = 0;
    private long xm = 0;
    protected long xn = 0;
    private long xo = 0;
    private long xp = 0;
    protected int xq = 50;
    protected final String xs = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(q qVar) {
        this.xu = qVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.c cVar) {
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
        if (this.xu != null) {
            this.xu.g(this);
        }
        this.xb = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.c cVar) {
        if (cVar != null) {
            try {
                this.xj.append(cVar.toString());
                this.xj.append("\r\n");
                this.xl++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xu != null) {
            this.xu.g(this);
        }
        this.xm = System.currentTimeMillis();
    }

    public int gi() {
        return this.xk;
    }

    public int gj() {
        return this.xl;
    }

    public long gk() {
        return this.xn;
    }

    public void g(long j) {
        this.xn = j;
    }

    public long gl() {
        return this.xb;
    }

    public long gm() {
        return this.xm;
    }

    public String gn() {
        if (TextUtils.isEmpty(this.xt)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.xr);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.xt = sb.toString();
        }
        return this.xt;
    }

    public String go() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.xr);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long gp() {
        return this.xo;
    }

    public long gq() {
        return this.xp;
    }

    public void h(long j) {
        this.xo = j;
    }

    public void i(long j) {
        this.xp = j;
    }

    public synchronized void gr() {
        this.xi = new StringBuffer();
        this.xk = 0;
        this.xo = 0L;
    }

    public synchronized void gs() {
        this.xj = new StringBuffer();
        this.xl = 0;
        this.xp = 0L;
    }

    public void ah(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.xh = str;
        }
    }

    public String gt() {
        return this.xh;
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
        return this.xi;
    }

    public StringBuffer gx() {
        return this.xj;
    }

    public boolean gy() {
        return this.mUseSdCard;
    }

    public boolean gz() {
        return this.mMustSuccess;
    }

    public String gA() {
        return this.xr;
    }

    public static String ai(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
