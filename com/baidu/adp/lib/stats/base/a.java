package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    protected String nB;
    protected q nC;
    private String np;
    protected String nz;
    private StringBuffer nq = new StringBuffer();
    private StringBuffer nr = new StringBuffer();
    private int ns = 0;
    private int nt = 0;
    private long ng = 0;
    private long nu = 0;
    protected long nv = 0;
    private long nw = 0;
    private long nx = 0;
    protected int ny = 50;
    protected final String nA = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(q qVar) {
        this.nC = qVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.nq.append(dVar.toString());
                this.nq.append("\r\n");
                this.ns++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.nC != null) {
            this.nC.g(this);
        }
        this.ng = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.nr.append(dVar.toString());
                this.nr.append("\r\n");
                this.nt++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.nC != null) {
            this.nC.g(this);
        }
        this.nu = System.currentTimeMillis();
    }

    public int eo() {
        return this.ns;
    }

    public int ep() {
        return this.nt;
    }

    public long eq() {
        return this.nv;
    }

    public void f(long j) {
        this.nv = j;
    }

    public long er() {
        return this.ng;
    }

    public long es() {
        return this.nu;
    }

    public String et() {
        if (TextUtils.isEmpty(this.nB)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.nz);
            sb.append(com.baidu.adp.lib.stats.a.dN().dT());
            sb.append("Writing");
            sb.append(".log");
            this.nB = sb.toString();
        }
        return this.nB;
    }

    public String eu() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.nz);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.stats.a.dN().dT());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long ev() {
        return this.nw;
    }

    public long ew() {
        return this.nx;
    }

    public void g(long j) {
        this.nw = j;
    }

    public void h(long j) {
        this.nx = j;
    }

    public synchronized void ex() {
        this.nq = new StringBuffer();
        this.ns = 0;
        this.nw = 0L;
    }

    public synchronized void ey() {
        this.nr = new StringBuffer();
        this.nt = 0;
        this.nx = 0L;
    }

    public void ap(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.np = str;
        }
    }

    public String ez() {
        return this.np;
    }

    public boolean eA() {
        return this.isUploading;
    }

    public void C(boolean z) {
        this.isUploading = z;
    }

    public String eB() {
        return "omp";
    }

    public StringBuffer eC() {
        return this.nq;
    }

    public StringBuffer eD() {
        return this.nr;
    }

    public boolean eE() {
        return this.mUseSdCard;
    }

    public boolean eF() {
        return this.mMustSuccess;
    }

    public String eG() {
        return this.nz;
    }

    public static String aq(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
