package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String wF;
    protected String wP;
    protected String wR;
    protected i wS;
    private StringBuffer wG = new StringBuffer();
    private StringBuffer wH = new StringBuffer();
    private int wI = 0;
    private int wJ = 0;
    private long wy = 0;
    private long wK = 0;
    protected long wL = 0;
    private long wM = 0;
    private long wN = 0;
    protected int wO = 50;
    protected final String wQ = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.wS = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.wG.append(aVar.toString());
                    this.wG.append("\r\n");
                    this.wI++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.wS != null) {
            this.wS.g(this);
        }
        this.wy = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.wH.append(aVar.toString());
                    this.wH.append("\r\n");
                    this.wJ++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.wS != null) {
            this.wS.g(this);
        }
        this.wK = System.currentTimeMillis();
    }

    public int gf() {
        return this.wI;
    }

    public int gg() {
        return this.wJ;
    }

    public long gh() {
        return this.wL;
    }

    public void h(long j) {
        this.wL = j;
    }

    public long gi() {
        return this.wy;
    }

    public long gj() {
        return this.wK;
    }

    public String gk() {
        if (TextUtils.isEmpty(this.wR)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.wP);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.wR = sb.toString();
        }
        return this.wR;
    }

    public String gl() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.wP);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long gm() {
        return this.wM;
    }

    public long gn() {
        return this.wN;
    }

    public void i(long j) {
        this.wM = j;
    }

    public void j(long j) {
        this.wN = j;
    }

    public synchronized void go() {
        this.wG = new StringBuffer();
        this.wI = 0;
        this.wM = 0L;
    }

    public synchronized void gp() {
        this.wH = new StringBuffer();
        this.wJ = 0;
        this.wN = 0L;
    }

    public void ap(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wF = str;
        }
    }

    public String gq() {
        return this.wF;
    }

    public boolean gr() {
        return this.isUploading;
    }

    public void I(boolean z) {
        this.isUploading = z;
    }

    public String gs() {
        return "omp";
    }

    public StringBuffer gt() {
        return this.wG;
    }

    public StringBuffer gu() {
        return this.wH;
    }

    public boolean gv() {
        return this.mUseSdCard;
    }

    public boolean gw() {
        return this.mMustSuccess;
    }

    public String gx() {
        return this.wP;
    }

    public static String aq(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
