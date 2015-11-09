package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.p;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String wH;
    protected String wR;
    protected String wT;
    protected p wU;
    private StringBuffer wI = new StringBuffer();
    private StringBuffer wJ = new StringBuffer();
    private int wK = 0;
    private int wL = 0;
    private long wz = 0;
    private long wM = 0;
    protected long wN = 0;
    private long wO = 0;
    private long wP = 0;
    protected int wQ = 50;
    protected final String wS = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(p pVar) {
        this.wU = pVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.wI.append(dVar.toString());
                this.wI.append("\r\n");
                this.wK++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.wU != null) {
            this.wU.g(this);
        }
        this.wz = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.d dVar) {
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
        if (this.wU != null) {
            this.wU.g(this);
        }
        this.wM = System.currentTimeMillis();
    }

    public int hK() {
        return this.wK;
    }

    public int hL() {
        return this.wL;
    }

    public long hM() {
        return this.wN;
    }

    public void f(long j) {
        this.wN = j;
    }

    public long hN() {
        return this.wz;
    }

    public long hO() {
        return this.wM;
    }

    public String hP() {
        if (TextUtils.isEmpty(this.wT)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.wR);
            sb.append(com.baidu.adp.lib.stats.a.hj().hp());
            sb.append("Writing");
            sb.append(".log");
            this.wT = sb.toString();
        }
        return this.wT;
    }

    public String hQ() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.wR);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.stats.a.hj().hp());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long hR() {
        return this.wO;
    }

    public long hS() {
        return this.wP;
    }

    public void g(long j) {
        this.wO = j;
    }

    public void h(long j) {
        this.wP = j;
    }

    public synchronized void hT() {
        this.wI = new StringBuffer();
        this.wK = 0;
        this.wO = 0L;
    }

    public synchronized void hU() {
        this.wJ = new StringBuffer();
        this.wL = 0;
        this.wP = 0L;
    }

    public void ar(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wH = str;
        }
    }

    public String hV() {
        return this.wH;
    }

    public boolean hW() {
        return this.isUploading;
    }

    public void D(boolean z) {
        this.isUploading = z;
    }

    public String hX() {
        return "omp";
    }

    public StringBuffer hY() {
        return this.wI;
    }

    public StringBuffer hZ() {
        return this.wJ;
    }

    public boolean ia() {
        return this.mUseSdCard;
    }

    public boolean ib() {
        return this.mMustSuccess;
    }

    public String ic() {
        return this.wR;
    }

    public static String as(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
