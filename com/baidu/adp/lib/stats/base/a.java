package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    protected q qA;
    private String qn;
    protected String qx;
    protected String qz;
    private StringBuffer qo = new StringBuffer();
    private StringBuffer qp = new StringBuffer();
    private int qq = 0;
    private int qr = 0;
    private long qf = 0;
    private long qs = 0;
    protected long qt = 0;
    private long qu = 0;
    private long qv = 0;
    protected int qw = 50;
    protected final String qy = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(q qVar) {
        this.qA = qVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.qo.append(dVar.toString());
                this.qo.append("\r\n");
                this.qq++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.qA != null) {
            this.qA.g(this);
        }
        this.qf = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.qp.append(dVar.toString());
                this.qp.append("\r\n");
                this.qr++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.qA != null) {
            this.qA.g(this);
        }
        this.qs = System.currentTimeMillis();
    }

    public int fj() {
        return this.qq;
    }

    public int fk() {
        return this.qr;
    }

    public long fl() {
        return this.qt;
    }

    public void g(long j) {
        this.qt = j;
    }

    public long fm() {
        return this.qf;
    }

    public long fn() {
        return this.qs;
    }

    public String fo() {
        if (TextUtils.isEmpty(this.qz)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.qx);
            sb.append(com.baidu.adp.lib.stats.a.eI().eO());
            sb.append("Writing");
            sb.append(".log");
            this.qz = sb.toString();
        }
        return this.qz;
    }

    public String fp() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.qx);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.stats.a.eI().eO());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long fq() {
        return this.qu;
    }

    public long fr() {
        return this.qv;
    }

    public void h(long j) {
        this.qu = j;
    }

    public void i(long j) {
        this.qv = j;
    }

    public synchronized void fs() {
        this.qo = new StringBuffer();
        this.qq = 0;
        this.qu = 0L;
    }

    public synchronized void ft() {
        this.qp = new StringBuffer();
        this.qr = 0;
        this.qv = 0L;
    }

    public void as(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.qn = str;
        }
    }

    public String fu() {
        return this.qn;
    }

    public boolean fv() {
        return this.isUploading;
    }

    public void G(boolean z) {
        this.isUploading = z;
    }

    public String fw() {
        return "omp";
    }

    public StringBuffer fx() {
        return this.qo;
    }

    public StringBuffer fy() {
        return this.qp;
    }

    public boolean fz() {
        return this.mUseSdCard;
    }

    public boolean fA() {
        return this.mMustSuccess;
    }

    public String fB() {
        return this.qx;
    }

    public static String at(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
