package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.p;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String wG;
    protected String wQ;
    protected String wS;
    protected p wT;
    private StringBuffer wH = new StringBuffer();
    private StringBuffer wI = new StringBuffer();
    private int wJ = 0;
    private int wK = 0;
    private long wy = 0;
    private long wL = 0;
    protected long wM = 0;
    private long wN = 0;
    private long wO = 0;
    protected int wP = 50;
    protected final String wR = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(p pVar) {
        this.wT = pVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null) {
            try {
                this.wH.append(dVar.toString());
                this.wH.append("\r\n");
                this.wJ++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.wT != null) {
            this.wT.g(this);
        }
        this.wy = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.d dVar) {
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
        if (this.wT != null) {
            this.wT.g(this);
        }
        this.wL = System.currentTimeMillis();
    }

    public int hI() {
        return this.wJ;
    }

    public int hJ() {
        return this.wK;
    }

    public long hK() {
        return this.wM;
    }

    public void f(long j) {
        this.wM = j;
    }

    public long hL() {
        return this.wy;
    }

    public long hM() {
        return this.wL;
    }

    public String hN() {
        if (TextUtils.isEmpty(this.wS)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.wQ);
            sb.append(com.baidu.adp.lib.stats.a.hh().hn());
            sb.append("Writing");
            sb.append(".log");
            this.wS = sb.toString();
        }
        return this.wS;
    }

    public String hO() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.wQ);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.stats.a.hh().hn());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long hP() {
        return this.wN;
    }

    public long hQ() {
        return this.wO;
    }

    public void g(long j) {
        this.wN = j;
    }

    public void h(long j) {
        this.wO = j;
    }

    public synchronized void hR() {
        this.wH = new StringBuffer();
        this.wJ = 0;
        this.wN = 0L;
    }

    public synchronized void hS() {
        this.wI = new StringBuffer();
        this.wK = 0;
        this.wO = 0L;
    }

    public void at(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wG = str;
        }
    }

    public String hT() {
        return this.wG;
    }

    public boolean hU() {
        return this.isUploading;
    }

    public void D(boolean z) {
        this.isUploading = z;
    }

    public String hV() {
        return "omp";
    }

    public StringBuffer hW() {
        return this.wH;
    }

    public StringBuffer hX() {
        return this.wI;
    }

    public boolean hY() {
        return this.mUseSdCard;
    }

    public boolean hZ() {
        return this.mMustSuccess;
    }

    public String ia() {
        return this.wQ;
    }

    public static String au(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
