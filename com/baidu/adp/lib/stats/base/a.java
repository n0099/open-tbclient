package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.p;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    protected String xB;
    protected p xC;
    private String xp;
    protected String xz;
    private StringBuffer xq = new StringBuffer();
    private StringBuffer xr = new StringBuffer();
    private int xs = 0;
    private int xt = 0;
    private long xh = 0;
    private long xu = 0;
    protected long xv = 0;
    private long xw = 0;
    private long xx = 0;
    protected int xy = 50;
    protected final String xA = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(p pVar) {
        this.xC = pVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.xq.append(dVar.toString());
                this.xq.append("\r\n");
                this.xs++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xC != null) {
            this.xC.g(this);
        }
        this.xh = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.xr.append(dVar.toString());
                this.xr.append("\r\n");
                this.xt++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xC != null) {
            this.xC.g(this);
        }
        this.xu = System.currentTimeMillis();
    }

    public int ia() {
        return this.xs;
    }

    public int ib() {
        return this.xt;
    }

    public long ic() {
        return this.xv;
    }

    public void f(long j) {
        this.xv = j;
    }

    public long ie() {
        return this.xh;
    }

    public long ig() {
        return this.xu;
    }

    public String ih() {
        if (TextUtils.isEmpty(this.xB)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.xz);
            sb.append(com.baidu.adp.lib.stats.a.hz().hF());
            sb.append("Writing");
            sb.append(".log");
            this.xB = sb.toString();
        }
        return this.xB;
    }

    public String ii() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.xz);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.stats.a.hz().hF());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long ij() {
        return this.xw;
    }

    public long ik() {
        return this.xx;
    }

    public void g(long j) {
        this.xw = j;
    }

    public void h(long j) {
        this.xx = j;
    }

    public synchronized void il() {
        this.xq = new StringBuffer();
        this.xs = 0;
        this.xw = 0L;
    }

    public synchronized void in() {
        this.xr = new StringBuffer();
        this.xt = 0;
        this.xx = 0L;
    }

    public void aw(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.xp = str;
        }
    }

    public String io() {
        return this.xp;
    }

    public boolean ip() {
        return this.isUploading;
    }

    public void C(boolean z) {
        this.isUploading = z;
    }

    public String iq() {
        return "omp";
    }

    public StringBuffer ir() {
        return this.xq;
    }

    public StringBuffer is() {
        return this.xr;
    }

    public boolean it() {
        return this.mUseSdCard;
    }

    public boolean iu() {
        return this.mMustSuccess;
    }

    public String iv() {
        return this.xz;
    }

    public static String ax(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
