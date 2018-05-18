package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.fsg.base.statistics.j;
/* loaded from: classes.dex */
public class a {
    protected String vA;
    protected i vB;
    private String vo;
    protected String vy;
    private StringBuffer vp = new StringBuffer();
    private StringBuffer vq = new StringBuffer();
    private int vr = 0;
    private int vs = 0;
    private long vi = 0;
    private long vt = 0;
    protected long vu = 0;
    private long vv = 0;
    private long vw = 0;
    protected int vx = 50;
    protected final String vz = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.vB = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.vp.append(aVar.toString());
                    this.vp.append("\r\n");
                    this.vr++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.vB != null) {
            this.vB.g(this);
        }
        this.vi = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.vq.append(aVar.toString());
                    this.vq.append("\r\n");
                    this.vs++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.vB != null) {
            this.vB.g(this);
        }
        this.vt = System.currentTimeMillis();
    }

    public int fL() {
        return this.vr;
    }

    public int fM() {
        return this.vs;
    }

    public long fN() {
        return this.vu;
    }

    public void i(long j) {
        this.vu = j;
    }

    public long fO() {
        return this.vi;
    }

    public long fP() {
        return this.vt;
    }

    public String fQ() {
        if (TextUtils.isEmpty(this.vA)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.vy);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.vA = sb.toString();
        }
        return this.vA;
    }

    public String fR() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.vy);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long fS() {
        return this.vv;
    }

    public long fT() {
        return this.vw;
    }

    public void j(long j) {
        this.vv = j;
    }

    public void k(long j) {
        this.vw = j;
    }

    public synchronized void fU() {
        this.vp = new StringBuffer();
        this.vr = 0;
        this.vv = 0L;
    }

    public synchronized void fV() {
        this.vq = new StringBuffer();
        this.vs = 0;
        this.vw = 0L;
    }

    public void au(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.vo = str;
        }
    }

    public String fW() {
        return this.vo;
    }

    public boolean fX() {
        return this.isUploading;
    }

    public void L(boolean z) {
        this.isUploading = z;
    }

    public String fY() {
        return "omp";
    }

    public StringBuffer fZ() {
        return this.vp;
    }

    public StringBuffer ga() {
        return this.vq;
    }

    public boolean gb() {
        return this.mUseSdCard;
    }

    public boolean gd() {
        return this.mMustSuccess;
    }

    public String ge() {
        return this.vy;
    }

    public static String av(String str) {
        if ("net".equals(str) || j.d.equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
