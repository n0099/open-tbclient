package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
/* loaded from: classes.dex */
public class a {
    protected String EF;
    protected String EH;
    protected i EI;
    private String Ev;
    private StringBuffer Ew = new StringBuffer();
    private StringBuffer Ex = new StringBuffer();
    private int Ey = 0;
    private int Ez = 0;
    private long Eo = 0;
    private long EA = 0;
    protected long EB = 0;
    private long EC = 0;
    private long ED = 0;
    protected int EE = 50;
    protected final String EG = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.EI = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Ew.append(aVar.toString());
                    this.Ew.append(SystemInfoUtil.LINE_END);
                    this.Ey++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.EI != null) {
            this.EI.g(this);
        }
        this.Eo = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.Ex.append(aVar.toString());
                    this.Ex.append(SystemInfoUtil.LINE_END);
                    this.Ez++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.EI != null) {
            this.EI.g(this);
        }
        this.EA = System.currentTimeMillis();
    }

    public int jW() {
        return this.Ey;
    }

    public int jX() {
        return this.Ez;
    }

    public long jY() {
        return this.EB;
    }

    public void n(long j) {
        this.EB = j;
    }

    public long jZ() {
        return this.Eo;
    }

    public long ka() {
        return this.EA;
    }

    public String kb() {
        if (TextUtils.isEmpty(this.EH)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.EF);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.EH = sb.toString();
        }
        return this.EH;
    }

    public String kc() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.EF);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long kd() {
        return this.EC;
    }

    public long ke() {
        return this.ED;
    }

    public void o(long j) {
        this.EC = j;
    }

    public void p(long j) {
        this.ED = j;
    }

    public synchronized void kf() {
        this.Ew = new StringBuffer();
        this.Ey = 0;
        this.EC = 0L;
    }

    public synchronized void kg() {
        this.Ex = new StringBuffer();
        this.Ez = 0;
        this.ED = 0L;
    }

    public void aZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Ev = str;
        }
    }

    public String kh() {
        return this.Ev;
    }

    public boolean ki() {
        return this.isUploading;
    }

    public void W(boolean z) {
        this.isUploading = z;
    }

    public String kj() {
        return "omp";
    }

    public StringBuffer kk() {
        return this.Ew;
    }

    public StringBuffer kl() {
        return this.Ex;
    }

    public boolean km() {
        return this.mUseSdCard;
    }

    public boolean kn() {
        return this.mMustSuccess;
    }

    public String ko() {
        return this.EF;
    }

    public static String ba(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return AiAppsTouchHelper.TouchEventName.TOUCH_ERROR;
        }
        return str;
    }
}
