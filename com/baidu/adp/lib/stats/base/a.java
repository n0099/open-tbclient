package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.p;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String wY;
    protected String xi;
    protected String xk;
    protected p xl;
    private StringBuffer wZ = new StringBuffer();
    private StringBuffer xa = new StringBuffer();
    private int xb = 0;
    private int xc = 0;
    private long wQ = 0;
    private long xd = 0;
    protected long xe = 0;
    private long xf = 0;
    private long xg = 0;
    protected int xh = 50;
    protected final String xj = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(p pVar) {
        this.xl = pVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.wZ.append(dVar.toString());
                this.wZ.append("\r\n");
                this.xb++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xl != null) {
            this.xl.g(this);
        }
        this.wQ = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.xa.append(dVar.toString());
                this.xa.append("\r\n");
                this.xc++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xl != null) {
            this.xl.g(this);
        }
        this.xd = System.currentTimeMillis();
    }

    public int hU() {
        return this.xb;
    }

    public int hV() {
        return this.xc;
    }

    public long hW() {
        return this.xe;
    }

    public void f(long j) {
        this.xe = j;
    }

    public long hX() {
        return this.wQ;
    }

    public long hY() {
        return this.xd;
    }

    public String hZ() {
        if (TextUtils.isEmpty(this.xk)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.xi);
            sb.append(com.baidu.adp.lib.stats.a.ht().hz());
            sb.append("Writing");
            sb.append(".log");
            this.xk = sb.toString();
        }
        return this.xk;
    }

    public String ia() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.xi);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.stats.a.ht().hz());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long ib() {
        return this.xf;
    }

    public long ic() {
        return this.xg;
    }

    public void g(long j) {
        this.xf = j;
    }

    public void h(long j) {
        this.xg = j;
    }

    public synchronized void ie() {
        this.wZ = new StringBuffer();
        this.xb = 0;
        this.xf = 0L;
    }

    public synchronized void ig() {
        this.xa = new StringBuffer();
        this.xc = 0;
        this.xg = 0L;
    }

    public void au(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wY = str;
        }
    }

    public String ih() {
        return this.wY;
    }

    public boolean ii() {
        return this.isUploading;
    }

    public void D(boolean z) {
        this.isUploading = z;
    }

    public String ij() {
        return "omp";
    }

    public StringBuffer ik() {
        return this.wZ;
    }

    public StringBuffer il() {
        return this.xa;
    }

    public boolean in() {
        return this.mUseSdCard;
    }

    public boolean io() {
        return this.mMustSuccess;
    }

    public String ip() {
        return this.xi;
    }

    public static String av(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
