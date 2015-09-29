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

    public int hJ() {
        return this.wK;
    }

    public int hK() {
        return this.wL;
    }

    public long hL() {
        return this.wN;
    }

    public void h(long j) {
        this.wN = j;
    }

    public long hM() {
        return this.wz;
    }

    public long hN() {
        return this.wM;
    }

    public String hO() {
        if (TextUtils.isEmpty(this.wT)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.wR);
            sb.append(com.baidu.adp.lib.stats.a.hi().ho());
            sb.append("Writing");
            sb.append(".log");
            this.wT = sb.toString();
        }
        return this.wT;
    }

    public String hP() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.wR);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.stats.a.hi().ho());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long hQ() {
        return this.wO;
    }

    public long hR() {
        return this.wP;
    }

    public void i(long j) {
        this.wO = j;
    }

    public void j(long j) {
        this.wP = j;
    }

    public synchronized void hS() {
        this.wI = new StringBuffer();
        this.wK = 0;
        this.wO = 0L;
    }

    public synchronized void hT() {
        this.wJ = new StringBuffer();
        this.wL = 0;
        this.wP = 0L;
    }

    public void at(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wH = str;
        }
    }

    public String hU() {
        return this.wH;
    }

    public boolean hV() {
        return this.isUploading;
    }

    public void D(boolean z) {
        this.isUploading = z;
    }

    public String hW() {
        return "omp";
    }

    public StringBuffer hX() {
        return this.wI;
    }

    public StringBuffer hY() {
        return this.wJ;
    }

    public boolean hZ() {
        return this.mUseSdCard;
    }

    public boolean ia() {
        return this.mMustSuccess;
    }

    public String ib() {
        return this.wR;
    }

    public static String au(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
