package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String wG;
    protected String wQ;
    protected String wS;
    protected i wT;
    private StringBuffer wH = new StringBuffer();
    private StringBuffer wI = new StringBuffer();
    private int wJ = 0;
    private int wK = 0;
    private long wz = 0;
    private long wL = 0;
    protected long wM = 0;
    private long wN = 0;
    private long wO = 0;
    protected int wP = 50;
    protected final String wR = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.wT = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
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
        if (this.wT != null) {
            this.wT.g(this);
        }
        this.wz = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.wI.append(aVar.toString());
                    this.wI.append("\r\n");
                    this.wK++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.wT != null) {
            this.wT.g(this);
        }
        this.wL = System.currentTimeMillis();
    }

    public int gf() {
        return this.wJ;
    }

    public int gg() {
        return this.wK;
    }

    public long gh() {
        return this.wM;
    }

    public void g(long j) {
        this.wM = j;
    }

    public long gi() {
        return this.wz;
    }

    public long gj() {
        return this.wL;
    }

    public String gk() {
        if (TextUtils.isEmpty(this.wS)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.wQ);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.wS = sb.toString();
        }
        return this.wS;
    }

    public String gl() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.wQ);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long gm() {
        return this.wN;
    }

    public long gn() {
        return this.wO;
    }

    public void h(long j) {
        this.wN = j;
    }

    public void i(long j) {
        this.wO = j;
    }

    public synchronized void go() {
        this.wH = new StringBuffer();
        this.wJ = 0;
        this.wN = 0L;
    }

    public synchronized void gp() {
        this.wI = new StringBuffer();
        this.wK = 0;
        this.wO = 0L;
    }

    public void ap(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wG = str;
        }
    }

    public String gq() {
        return this.wG;
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
        return this.wH;
    }

    public StringBuffer gu() {
        return this.wI;
    }

    public boolean gv() {
        return this.mUseSdCard;
    }

    public boolean gw() {
        return this.mMustSuccess;
    }

    public String gx() {
        return this.wQ;
    }

    public static String aq(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
