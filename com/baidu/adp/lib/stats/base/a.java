package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String xC;
    protected String xM;
    protected String xO;
    protected q xP;
    private StringBuffer xD = new StringBuffer();
    private StringBuffer xE = new StringBuffer();
    private int xF = 0;
    private int xG = 0;
    private long xv = 0;
    private long xH = 0;
    protected long xI = 0;
    private long xJ = 0;
    private long xK = 0;
    protected int xL = 50;
    protected final String xN = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(q qVar) {
        this.xP = qVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.c cVar) {
        if (cVar != null) {
            try {
                this.xD.append(cVar.toString());
                this.xD.append("\r\n");
                this.xF++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xP != null) {
            this.xP.g(this);
        }
        this.xv = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.c cVar) {
        if (cVar != null) {
            try {
                this.xE.append(cVar.toString());
                this.xE.append("\r\n");
                this.xG++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.xP != null) {
            this.xP.g(this);
        }
        this.xH = System.currentTimeMillis();
    }

    public int gb() {
        return this.xF;
    }

    public int gd() {
        return this.xG;
    }

    public long ge() {
        return this.xI;
    }

    public void g(long j) {
        this.xI = j;
    }

    public long gf() {
        return this.xv;
    }

    public long gg() {
        return this.xH;
    }

    public String gh() {
        if (TextUtils.isEmpty(this.xO)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.xM);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.xO = sb.toString();
        }
        return this.xO;
    }

    public String gi() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.xM);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long gj() {
        return this.xJ;
    }

    public long gk() {
        return this.xK;
    }

    public void h(long j) {
        this.xJ = j;
    }

    public void i(long j) {
        this.xK = j;
    }

    public synchronized void gl() {
        this.xD = new StringBuffer();
        this.xF = 0;
        this.xJ = 0L;
    }

    public synchronized void gm() {
        this.xE = new StringBuffer();
        this.xG = 0;
        this.xK = 0L;
    }

    public void al(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.xC = str;
        }
    }

    public String gn() {
        return this.xC;
    }

    public boolean go() {
        return this.isUploading;
    }

    public void H(boolean z) {
        this.isUploading = z;
    }

    public String gp() {
        return "omp";
    }

    public StringBuffer gq() {
        return this.xD;
    }

    public StringBuffer gr() {
        return this.xE;
    }

    public boolean gs() {
        return this.mUseSdCard;
    }

    public boolean gt() {
        return this.mMustSuccess;
    }

    public String gu() {
        return this.xM;
    }

    public static String am(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
