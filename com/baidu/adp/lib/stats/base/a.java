package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class a {
    private String wH;
    protected String wR;
    protected String wT;
    protected i wU;
    private StringBuffer wI = new StringBuffer();
    private StringBuffer wJ = new StringBuffer();
    private int wK = 0;
    private int wL = 0;
    private long wA = 0;
    private long wM = 0;
    protected long wN = 0;
    private long wO = 0;
    private long wP = 0;
    protected int wQ = 50;
    protected final String wS = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.wU = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
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
        if (this.wU != null) {
            this.wU.g(this);
        }
        this.wA = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.wJ.append(aVar.toString());
                    this.wJ.append("\r\n");
                    this.wL++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.wU != null) {
            this.wU.g(this);
        }
        this.wM = System.currentTimeMillis();
    }

    public int gf() {
        return this.wK;
    }

    public int gg() {
        return this.wL;
    }

    public long gh() {
        return this.wN;
    }

    public void h(long j) {
        this.wN = j;
    }

    public long gi() {
        return this.wA;
    }

    public long gj() {
        return this.wM;
    }

    public String gk() {
        if (TextUtils.isEmpty(this.wT)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.wR);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.wT = sb.toString();
        }
        return this.wT;
    }

    public String gl() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.wR);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long gm() {
        return this.wO;
    }

    public long gn() {
        return this.wP;
    }

    public void i(long j) {
        this.wO = j;
    }

    public void j(long j) {
        this.wP = j;
    }

    public synchronized void go() {
        this.wI = new StringBuffer();
        this.wK = 0;
        this.wO = 0L;
    }

    public synchronized void gp() {
        this.wJ = new StringBuffer();
        this.wL = 0;
        this.wP = 0L;
    }

    public void ap(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wH = str;
        }
    }

    public String gq() {
        return this.wH;
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
        return this.wI;
    }

    public StringBuffer gu() {
        return this.wJ;
    }

    public boolean gv() {
        return this.mUseSdCard;
    }

    public boolean gw() {
        return this.mMustSuccess;
    }

    public String gx() {
        return this.wR;
    }

    public static String aq(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
