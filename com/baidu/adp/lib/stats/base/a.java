package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.fsg.base.statistics.j;
/* loaded from: classes.dex */
public class a {
    protected String vB;
    protected i vC;
    private String vp;
    protected String vz;
    private StringBuffer vq = new StringBuffer();
    private StringBuffer vr = new StringBuffer();
    private int vs = 0;
    private int vt = 0;
    private long vj = 0;
    private long vu = 0;
    protected long vv = 0;
    private long vw = 0;
    private long vx = 0;
    protected int vy = 50;
    protected final String vA = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.vC = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
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
        if (this.vC != null) {
            this.vC.g(this);
        }
        this.vj = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.vr.append(aVar.toString());
                    this.vr.append("\r\n");
                    this.vt++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.vC != null) {
            this.vC.g(this);
        }
        this.vu = System.currentTimeMillis();
    }

    public int fL() {
        return this.vs;
    }

    public int fM() {
        return this.vt;
    }

    public long fN() {
        return this.vv;
    }

    public void i(long j) {
        this.vv = j;
    }

    public long fO() {
        return this.vj;
    }

    public long fP() {
        return this.vu;
    }

    public String fQ() {
        if (TextUtils.isEmpty(this.vB)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.vz);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.vB = sb.toString();
        }
        return this.vB;
    }

    public String fR() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.vz);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long fS() {
        return this.vw;
    }

    public long fT() {
        return this.vx;
    }

    public void j(long j) {
        this.vw = j;
    }

    public void k(long j) {
        this.vx = j;
    }

    public synchronized void fU() {
        this.vq = new StringBuffer();
        this.vs = 0;
        this.vw = 0L;
    }

    public synchronized void fV() {
        this.vr = new StringBuffer();
        this.vt = 0;
        this.vx = 0L;
    }

    public void au(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.vp = str;
        }
    }

    public String fW() {
        return this.vp;
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
        return this.vq;
    }

    public StringBuffer ga() {
        return this.vr;
    }

    public boolean gb() {
        return this.mUseSdCard;
    }

    public boolean gd() {
        return this.mMustSuccess;
    }

    public String ge() {
        return this.vz;
    }

    public static String av(String str) {
        if ("net".equals(str) || j.d.equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return "error";
        }
        return str;
    }
}
