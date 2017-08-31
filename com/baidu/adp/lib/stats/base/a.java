package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String wE;
    protected String wO;
    protected String wQ;
    protected i wR;
    private StringBuffer wF = new StringBuffer();
    private StringBuffer wG = new StringBuffer();
    private int wH = 0;
    private int wI = 0;
    private long wx = 0;
    private long wJ = 0;
    protected long wK = 0;
    private long wL = 0;
    private long wM = 0;
    protected int wN = 50;
    protected final String wP = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.wR = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.wF.append(aVar.toString());
                    this.wF.append("\r\n");
                    this.wH++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.wR != null) {
            this.wR.g(this);
        }
        this.wx = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
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
        if (this.wR != null) {
            this.wR.g(this);
        }
        this.wJ = System.currentTimeMillis();
    }

    public int gg() {
        return this.wH;
    }

    public int gh() {
        return this.wI;
    }

    public long gi() {
        return this.wK;
    }

    public void g(long j) {
        this.wK = j;
    }

    public long gj() {
        return this.wx;
    }

    public long gk() {
        return this.wJ;
    }

    public String gl() {
        if (TextUtils.isEmpty(this.wQ)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.wO);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.wQ = sb.toString();
        }
        return this.wQ;
    }

    public String gm() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.wO);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long gn() {
        return this.wL;
    }

    public long go() {
        return this.wM;
    }

    public void h(long j) {
        this.wL = j;
    }

    public void i(long j) {
        this.wM = j;
    }

    public synchronized void gp() {
        this.wF = new StringBuffer();
        this.wH = 0;
        this.wL = 0L;
    }

    public synchronized void gq() {
        this.wG = new StringBuffer();
        this.wI = 0;
        this.wM = 0L;
    }

    public void ap(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wE = str;
        }
    }

    public String gr() {
        return this.wE;
    }

    public boolean gs() {
        return this.isUploading;
    }

    public void I(boolean z) {
        this.isUploading = z;
    }

    public String gt() {
        return "omp";
    }

    public StringBuffer gu() {
        return this.wF;
    }

    public StringBuffer gv() {
        return this.wG;
    }

    public boolean gw() {
        return this.mUseSdCard;
    }

    public boolean gx() {
        return this.mMustSuccess;
    }

    public String gy() {
        return this.wO;
    }

    public static String aq(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
