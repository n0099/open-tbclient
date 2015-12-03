package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.p;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String wN;
    protected String wX;
    protected String wZ;
    protected p xa;
    private StringBuffer wO = new StringBuffer();
    private StringBuffer wP = new StringBuffer();
    private int wQ = 0;
    private int wR = 0;
    private long wF = 0;
    private long wS = 0;
    protected long wT = 0;
    private long wU = 0;
    private long wV = 0;
    protected int wW = 50;
    protected final String wY = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(p pVar) {
        this.xa = pVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.wO.append(dVar.toString());
                this.wO.append("\r\n");
                this.wQ++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xa != null) {
            this.xa.g(this);
        }
        this.wF = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.wP.append(dVar.toString());
                this.wP.append("\r\n");
                this.wR++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xa != null) {
            this.xa.g(this);
        }
        this.wS = System.currentTimeMillis();
    }

    public int hM() {
        return this.wQ;
    }

    public int hN() {
        return this.wR;
    }

    public long hO() {
        return this.wT;
    }

    public void f(long j) {
        this.wT = j;
    }

    public long hP() {
        return this.wF;
    }

    public long hQ() {
        return this.wS;
    }

    public String hR() {
        if (TextUtils.isEmpty(this.wZ)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.wX);
            sb.append(com.baidu.adp.lib.stats.a.hl().hr());
            sb.append("Writing");
            sb.append(".log");
            this.wZ = sb.toString();
        }
        return this.wZ;
    }

    public String hS() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.wX);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.stats.a.hl().hr());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long hT() {
        return this.wU;
    }

    public long hU() {
        return this.wV;
    }

    public void g(long j) {
        this.wU = j;
    }

    public void h(long j) {
        this.wV = j;
    }

    public synchronized void hV() {
        this.wO = new StringBuffer();
        this.wQ = 0;
        this.wU = 0L;
    }

    public synchronized void hW() {
        this.wP = new StringBuffer();
        this.wR = 0;
        this.wV = 0L;
    }

    public void av(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wN = str;
        }
    }

    public String hX() {
        return this.wN;
    }

    public boolean hY() {
        return this.isUploading;
    }

    public void D(boolean z) {
        this.isUploading = z;
    }

    public String hZ() {
        return "omp";
    }

    public StringBuffer ia() {
        return this.wO;
    }

    public StringBuffer ib() {
        return this.wP;
    }

    public boolean ic() {
        return this.mUseSdCard;
    }

    public boolean id() {
        return this.mMustSuccess;
    }

    public String ie() {
        return this.wX;
    }

    public static String aw(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
