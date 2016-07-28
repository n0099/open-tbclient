package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String nR;
    protected String ob;
    protected String od;
    protected q oe;
    private StringBuffer nS = new StringBuffer();
    private StringBuffer nT = new StringBuffer();
    private int nU = 0;
    private int nV = 0;
    private long nJ = 0;
    private long nW = 0;
    protected long nX = 0;
    private long nY = 0;
    private long nZ = 0;
    protected int oa = 50;
    protected final String oc = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(q qVar) {
        this.oe = qVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.nS.append(dVar.toString());
                this.nS.append("\r\n");
                this.nU++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.oe != null) {
            this.oe.g(this);
        }
        this.nJ = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.nT.append(dVar.toString());
                this.nT.append("\r\n");
                this.nV++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.oe != null) {
            this.oe.g(this);
        }
        this.nW = System.currentTimeMillis();
    }

    public int eo() {
        return this.nU;
    }

    public int ep() {
        return this.nV;
    }

    public long eq() {
        return this.nX;
    }

    public void g(long j) {
        this.nX = j;
    }

    public long er() {
        return this.nJ;
    }

    public long es() {
        return this.nW;
    }

    public String et() {
        if (TextUtils.isEmpty(this.od)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.ob);
            sb.append(com.baidu.adp.lib.stats.a.dN().dT());
            sb.append("Writing");
            sb.append(".log");
            this.od = sb.toString();
        }
        return this.od;
    }

    public String eu() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.ob);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.stats.a.dN().dT());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long ev() {
        return this.nY;
    }

    public long ew() {
        return this.nZ;
    }

    public void h(long j) {
        this.nY = j;
    }

    public void i(long j) {
        this.nZ = j;
    }

    public synchronized void ex() {
        this.nS = new StringBuffer();
        this.nU = 0;
        this.nY = 0L;
    }

    public synchronized void ey() {
        this.nT = new StringBuffer();
        this.nV = 0;
        this.nZ = 0L;
    }

    public void ar(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nR = str;
        }
    }

    public String ez() {
        return this.nR;
    }

    public boolean eA() {
        return this.isUploading;
    }

    public void E(boolean z) {
        this.isUploading = z;
    }

    public String eB() {
        return "omp";
    }

    public StringBuffer eC() {
        return this.nS;
    }

    public StringBuffer eD() {
        return this.nT;
    }

    public boolean eE() {
        return this.mUseSdCard;
    }

    public boolean eF() {
        return this.mMustSuccess;
    }

    public String eG() {
        return this.ob;
    }

    public static String as(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
