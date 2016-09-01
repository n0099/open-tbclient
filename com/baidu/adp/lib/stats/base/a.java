package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String qm;
    protected String qw;
    protected String qy;
    protected q qz;
    private StringBuffer qn = new StringBuffer();
    private StringBuffer qo = new StringBuffer();
    private int qp = 0;
    private int qq = 0;
    private long qe = 0;
    private long qr = 0;
    protected long qs = 0;
    private long qt = 0;
    private long qu = 0;
    protected int qv = 50;
    protected final String qx = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(q qVar) {
        this.qz = qVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.qn.append(dVar.toString());
                this.qn.append("\r\n");
                this.qp++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.qz != null) {
            this.qz.g(this);
        }
        this.qe = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.d dVar) {
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
        if (this.qz != null) {
            this.qz.g(this);
        }
        this.qr = System.currentTimeMillis();
    }

    public int fj() {
        return this.qp;
    }

    public int fk() {
        return this.qq;
    }

    public long fl() {
        return this.qs;
    }

    public void g(long j) {
        this.qs = j;
    }

    public long fm() {
        return this.qe;
    }

    public long fn() {
        return this.qr;
    }

    public String fo() {
        if (TextUtils.isEmpty(this.qy)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.qw);
            sb.append(com.baidu.adp.lib.stats.a.eI().eO());
            sb.append("Writing");
            sb.append(".log");
            this.qy = sb.toString();
        }
        return this.qy;
    }

    public String fp() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.qw);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.stats.a.eI().eO());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long fq() {
        return this.qt;
    }

    public long fr() {
        return this.qu;
    }

    public void h(long j) {
        this.qt = j;
    }

    public void i(long j) {
        this.qu = j;
    }

    public synchronized void fs() {
        this.qn = new StringBuffer();
        this.qp = 0;
        this.qt = 0L;
    }

    public synchronized void ft() {
        this.qo = new StringBuffer();
        this.qq = 0;
        this.qu = 0L;
    }

    public void as(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.qm = str;
        }
    }

    public String fu() {
        return this.qm;
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
        return this.qn;
    }

    public StringBuffer fy() {
        return this.qo;
    }

    public boolean fz() {
        return this.mUseSdCard;
    }

    public boolean fA() {
        return this.mMustSuccess;
    }

    public String fB() {
        return this.qw;
    }

    public static String at(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
