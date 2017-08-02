package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String xi;
    protected String xs;
    protected String xu;
    protected i xv;
    private StringBuffer xj = new StringBuffer();
    private StringBuffer xk = new StringBuffer();
    private int xl = 0;
    private int xm = 0;
    private long xc = 0;
    private long xn = 0;
    protected long xo = 0;
    private long xp = 0;
    private long xq = 0;
    protected int xr = 50;
    protected final String xt = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.xv = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.xj.append(aVar.toString());
                    this.xj.append("\r\n");
                    this.xl++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xv != null) {
            this.xv.g(this);
        }
        this.xc = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.xk.append(aVar.toString());
                    this.xk.append("\r\n");
                    this.xm++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xv != null) {
            this.xv.g(this);
        }
        this.xn = System.currentTimeMillis();
    }

    public int gf() {
        return this.xl;
    }

    public int gg() {
        return this.xm;
    }

    public long gh() {
        return this.xo;
    }

    public void g(long j) {
        this.xo = j;
    }

    public long gi() {
        return this.xc;
    }

    public long gj() {
        return this.xn;
    }

    public String gk() {
        if (TextUtils.isEmpty(this.xu)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.xs);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.xu = sb.toString();
        }
        return this.xu;
    }

    public String gl() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.xs);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long gm() {
        return this.xp;
    }

    public long gn() {
        return this.xq;
    }

    public void h(long j) {
        this.xp = j;
    }

    public void i(long j) {
        this.xq = j;
    }

    public synchronized void go() {
        this.xj = new StringBuffer();
        this.xl = 0;
        this.xp = 0L;
    }

    public synchronized void gp() {
        this.xk = new StringBuffer();
        this.xm = 0;
        this.xq = 0L;
    }

    public void ao(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.xi = str;
        }
    }

    public String gq() {
        return this.xi;
    }

    public boolean gr() {
        return this.isUploading;
    }

    public void H(boolean z) {
        this.isUploading = z;
    }

    public String gs() {
        return "omp";
    }

    public StringBuffer gt() {
        return this.xj;
    }

    public StringBuffer gu() {
        return this.xk;
    }

    public boolean gv() {
        return this.mUseSdCard;
    }

    public boolean gw() {
        return this.mMustSuccess;
    }

    public String gx() {
        return this.xs;
    }

    public static String ap(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
