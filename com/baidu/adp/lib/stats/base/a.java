package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.b.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    protected j tB;
    private String tc;
    protected String tt;
    protected String tz;
    private StringBuffer td = new StringBuffer();
    private StringBuffer te = new StringBuffer();
    private StringBuffer tf = new StringBuffer();
    private int tg = 0;
    private int th = 0;
    private int ti = 0;
    private long sP = 0;
    private long tj = 0;
    private long tk = 0;
    protected long tl = 0;
    private long tm = 0;
    private long tp = 0;
    private long tq = 0;
    protected int tr = 50;
    protected final String tu = BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
    protected boolean mUseSdCard = false;
    protected boolean tw = false;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private boolean tA = false;

    public a(j jVar) {
        this.tB = jVar;
    }

    public synchronized void a(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.td.append(aVar.toString());
                    this.td.append("\r\n");
                    this.tg++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.tB != null) {
            this.tB.o(this);
        }
        this.sP = System.currentTimeMillis();
    }

    public synchronized void b(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                try {
                    this.te.append(aVar.toString());
                    this.te.append("\r\n");
                    this.th++;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.tB != null) {
            this.tB.o(this);
        }
        this.tj = System.currentTimeMillis();
    }

    public synchronized void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.gA() != null) {
                    this.tf.append(aVar.gA().gN().toString());
                    this.tf.append("\r\n");
                    this.ti++;
                }
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        if (this.tB != null) {
            this.tB.o(this);
        }
        this.tk = System.currentTimeMillis();
    }

    public int gP() {
        return this.tg;
    }

    public int gQ() {
        return this.th;
    }

    public int gR() {
        return this.ti;
    }

    public long gS() {
        return this.tl;
    }

    public void l(long j) {
        this.tl = j;
    }

    public long gT() {
        return this.sP;
    }

    public long gU() {
        return this.tj;
    }

    public long gV() {
        return this.tk;
    }

    public String gW() {
        if (TextUtils.isEmpty(this.tz)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.tt);
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Writing");
            sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            this.tz = sb.toString();
        }
        return this.tz;
    }

    public String gX() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.tt);
        sb.append(System.currentTimeMillis());
        sb.append(BdStatisticsManager.getInstance().getProcessName());
        sb.append("Uploading");
        sb.append(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        return sb.toString();
    }

    public long gY() {
        return this.tm;
    }

    public long gZ() {
        return this.tp;
    }

    public long ha() {
        return this.tq;
    }

    public void m(long j) {
        this.tm = j;
    }

    public void n(long j) {
        this.tp = j;
    }

    public void o(long j) {
        this.tq = j;
    }

    public synchronized void hb() {
        this.td = new StringBuffer();
        this.tg = 0;
        this.tm = 0L;
    }

    public synchronized void hc() {
        this.te = new StringBuffer();
        this.th = 0;
        this.tp = 0L;
    }

    public synchronized void hd() {
        this.tf = new StringBuffer();
        this.ti = 0;
        this.tq = 0L;
    }

    public void aF(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.tc = str;
        }
    }

    public String he() {
        return this.tc;
    }

    public boolean hf() {
        return this.isUploading;
    }

    public void O(boolean z) {
        this.isUploading = z;
    }

    public boolean hg() {
        return this.tA;
    }

    public void P(boolean z) {
        this.tA = z;
    }

    public String hh() {
        return BdStatsConstant.FILE_OMP;
    }

    public String hi() {
        return "track";
    }

    public StringBuffer hj() {
        return this.td;
    }

    public StringBuffer hk() {
        return this.te;
    }

    public StringBuffer hl() {
        return this.tf;
    }

    public boolean hm() {
        return this.mUseSdCard;
    }

    public boolean hn() {
        return this.tw;
    }

    public boolean ho() {
        return this.mMustSuccess;
    }

    public String hp() {
        return this.tt;
    }

    public static String aG(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
            return BdStatsConstant.StatsType.ERROR;
        }
        return str;
    }
}
