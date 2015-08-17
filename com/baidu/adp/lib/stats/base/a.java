package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.p;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String wI;
    protected String wS;
    protected String wU;
    protected p wV;
    private StringBuffer wJ = new StringBuffer();
    private StringBuffer wK = new StringBuffer();
    private int wL = 0;
    private int wM = 0;
    private long wA = 0;
    private long wN = 0;
    protected long wO = 0;
    private long wP = 0;
    private long wQ = 0;
    protected int wR = 50;
    protected final String wT = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(p pVar) {
        this.wV = pVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.wJ.append(dVar.toString());
                this.wJ.append("\r\n");
                this.wL++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.wV != null) {
            this.wV.g(this);
        }
        this.wA = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.wK.append(dVar.toString());
                this.wK.append("\r\n");
                this.wM++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.wV != null) {
            this.wV.g(this);
        }
        this.wN = System.currentTimeMillis();
    }

    public int hL() {
        return this.wL;
    }

    public int hM() {
        return this.wM;
    }

    public long hN() {
        return this.wO;
    }

    public void f(long j) {
        this.wO = j;
    }

    public long hO() {
        return this.wA;
    }

    public long hP() {
        return this.wN;
    }

    public String hQ() {
        if (TextUtils.isEmpty(this.wU)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.wS);
            sb.append(com.baidu.adp.lib.stats.a.hk().hq());
            sb.append("Writing");
            sb.append(".log");
            this.wU = sb.toString();
        }
        return this.wU;
    }

    public String hR() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.wS);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.stats.a.hk().hq());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long hS() {
        return this.wP;
    }

    public long hT() {
        return this.wQ;
    }

    public void g(long j) {
        this.wP = j;
    }

    public void h(long j) {
        this.wQ = j;
    }

    public synchronized void hU() {
        this.wJ = new StringBuffer();
        this.wL = 0;
        this.wP = 0L;
    }

    public synchronized void hV() {
        this.wK = new StringBuffer();
        this.wM = 0;
        this.wQ = 0L;
    }

    public void at(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wI = str;
        }
    }

    public String hW() {
        return this.wI;
    }

    public boolean hX() {
        return this.isUploading;
    }

    public void D(boolean z) {
        this.isUploading = z;
    }

    public String hY() {
        return "omp";
    }

    public StringBuffer hZ() {
        return this.wJ;
    }

    public StringBuffer ia() {
        return this.wK;
    }

    public boolean ib() {
        return this.mUseSdCard;
    }

    public boolean ic() {
        return this.mMustSuccess;
    }

    public String id() {
        return this.wS;
    }

    public static String au(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
