package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
/* loaded from: classes.dex */
public class a {
    protected String EJ;
    protected String EL;
    protected i EM;
    private String Ez;
    private StringBuffer EA = new StringBuffer();
    private StringBuffer EB = new StringBuffer();
    private int EC = 0;
    private int ED = 0;
    private long Es = 0;
    private long EE = 0;
    protected long EF = 0;
    private long EG = 0;
    private long EH = 0;
    protected int EI = 50;
    protected final String EK = ".log";
    protected boolean mUseSdCard = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;

    public a(i iVar) {
        this.EM = iVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.EA.append(aVar.toString());
                    this.EA.append(SystemInfoUtil.LINE_END);
                    this.EC++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.EM != null) {
            this.EM.g(this);
        }
        this.Es = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.EB.append(aVar.toString());
                    this.EB.append(SystemInfoUtil.LINE_END);
                    this.ED++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.EM != null) {
            this.EM.g(this);
        }
        this.EE = System.currentTimeMillis();
    }

    public int jU() {
        return this.EC;
    }

    public int jV() {
        return this.ED;
    }

    public long jW() {
        return this.EF;
    }

    public void p(long j) {
        this.EF = j;
    }

    public long jX() {
        return this.Es;
    }

    public long jY() {
        return this.EE;
    }

    public String jZ() {
        if (TextUtils.isEmpty(this.EL)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.EJ);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(".log");
            this.EL = sb.toString();
        }
        return this.EL;
    }

    public String ka() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.EJ);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long kb() {
        return this.EG;
    }

    public long kc() {
        return this.EH;
    }

    public void q(long j) {
        this.EG = j;
    }

    public void r(long j) {
        this.EH = j;
    }

    public synchronized void kd() {
        this.EA = new StringBuffer();
        this.EC = 0;
        this.EG = 0L;
    }

    public synchronized void ke() {
        this.EB = new StringBuffer();
        this.ED = 0;
        this.EH = 0L;
    }

    public void aZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Ez = str;
        }
    }

    public String kf() {
        return this.Ez;
    }

    public boolean kg() {
        return this.isUploading;
    }

    public void ak(boolean z) {
        this.isUploading = z;
    }

    public String kh() {
        return "omp";
    }

    public StringBuffer ki() {
        return this.EA;
    }

    public StringBuffer kj() {
        return this.EB;
    }

    public boolean kk() {
        return this.mUseSdCard;
    }

    public boolean kl() {
        return this.mMustSuccess;
    }

    public String km() {
        return this.EJ;
    }

    public static String ba(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return AiAppsTouchHelper.TouchEventName.TOUCH_ERROR;
        }
        return str;
    }
}
