package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String qg;
    protected String qq;
    protected String qs;
    protected q qt;
    private StringBuffer qh = new StringBuffer();
    private StringBuffer qi = new StringBuffer();
    private int qj = 0;
    private int qk = 0;
    private long pZ = 0;
    private long ql = 0;
    protected long qm = 0;
    private long qn = 0;
    private long qo = 0;
    protected int qp = 50;
    protected final String qr = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(q qVar) {
        this.qt = qVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.qh.append(dVar.toString());
                this.qh.append("\r\n");
                this.qj++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.qt != null) {
            this.qt.g(this);
        }
        this.pZ = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.qi.append(dVar.toString());
                this.qi.append("\r\n");
                this.qk++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.qt != null) {
            this.qt.g(this);
        }
        this.ql = System.currentTimeMillis();
    }

    public int fh() {
        return this.qj;
    }

    public int fi() {
        return this.qk;
    }

    public long fj() {
        return this.qm;
    }

    public void g(long j) {
        this.qm = j;
    }

    public long fk() {
        return this.pZ;
    }

    public long fl() {
        return this.ql;
    }

    public String fm() {
        if (TextUtils.isEmpty(this.qs)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.qq);
            sb.append(com.baidu.adp.lib.stats.a.eG().eM());
            sb.append("Writing");
            sb.append(".log");
            this.qs = sb.toString();
        }
        return this.qs;
    }

    public String fn() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.qq);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.stats.a.eG().eM());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long fo() {
        return this.qn;
    }

    public long fp() {
        return this.qo;
    }

    public void h(long j) {
        this.qn = j;
    }

    public void i(long j) {
        this.qo = j;
    }

    public synchronized void fq() {
        this.qh = new StringBuffer();
        this.qj = 0;
        this.qn = 0L;
    }

    public synchronized void fr() {
        this.qi = new StringBuffer();
        this.qk = 0;
        this.qo = 0L;
    }

    public void ar(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.qg = str;
        }
    }

    public String fs() {
        return this.qg;
    }

    public boolean ft() {
        return this.isUploading;
    }

    public void G(boolean z) {
        this.isUploading = z;
    }

    public String fu() {
        return "omp";
    }

    public StringBuffer fv() {
        return this.qh;
    }

    public StringBuffer fw() {
        return this.qi;
    }

    public boolean fx() {
        return this.mUseSdCard;
    }

    public boolean fy() {
        return this.mMustSuccess;
    }

    public String fz() {
        return this.qq;
    }

    public static String as(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
