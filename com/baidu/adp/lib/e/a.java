package com.baidu.adp.lib.e;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private static C0016a Nk = new C0016a();
    private static final Object mSyncLock = new Object();

    public static void b(boolean z, long j) {
        f mr = mr();
        mr.NG++;
        if (z) {
            mr.NH++;
            mr.NI += j;
        }
    }

    public static void c(boolean z, long j) {
        synchronized (mSyncLock) {
            f mr = mr();
            mr.NJ++;
            if (z) {
                mr.NK++;
                mr.NM += j;
            }
        }
    }

    public static void a(boolean z, String str, com.baidu.adp.lib.network.http.d dVar, long j, long j2) {
        if (l.isNetOk()) {
            synchronized (mSyncLock) {
                boolean isCdn = isCdn(str);
                boolean z2 = false;
                if (dVar != null && !StringUtils.isNull(dVar.Mi)) {
                    z2 = true;
                }
                f mr = mr();
                if (isCdn) {
                    mr.Od++;
                }
                if (z2) {
                    mr.Oe++;
                }
                if (isCdn && z2) {
                    mr.Of++;
                }
                mr.NN++;
                if (z) {
                    mr.NP++;
                    mr.NQ += j;
                    mr.Og += j2;
                }
                if (Nk.mw() > 100) {
                    mq();
                }
            }
        }
    }

    public static void d(boolean z, long j) {
        synchronized (mSyncLock) {
            f mr = mr();
            if (z) {
                mr.NR++;
                mr.NT += j;
            }
        }
    }

    public static void e(boolean z, long j) {
        synchronized (mSyncLock) {
            f mr = mr();
            if (z) {
                mr.NU++;
                mr.NV += j;
            }
        }
    }

    public static void f(boolean z, long j) {
        synchronized (mSyncLock) {
            f mr = mr();
            if (z) {
                mr.NY++;
                mr.NZ += j;
            }
        }
    }

    public static void g(boolean z, long j) {
        f mr = mr();
        if (z) {
            mr.NW++;
            mr.NX += j;
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        f mr = mr();
        if (z) {
            mr.Oa++;
        }
        if (z2) {
            mr.Ob++;
        }
        if (z3) {
            mr.Oc++;
        }
    }

    public static void h(boolean z, long j) {
        f mr = mr();
        if (z) {
            mr.totalCount++;
            mr.totalTime += j;
        }
    }

    public static void mq() {
        if (Nk.mw() > 10) {
            if (Nk.mv()) {
                a(Nk.No, 5);
            }
            if (Nk.mu()) {
                a(Nk.Nn, 3);
            }
            if (Nk.mt()) {
                a(Nk.Nm, 2);
            }
            if (Nk.ms()) {
                a(Nk.Nl, 1);
            }
            Nk.reset();
        }
    }

    private static void a(f fVar, int i) {
        if (fVar != null && BdBaseApplication.getInst().isSmallFlow()) {
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem(BdStatsConstant.StatsType.PERFORMANCE);
            statsItem.append("action", "imgStat");
            statsItem.append("memoryCount", String.valueOf(fVar.NG));
            statsItem.append("memorySucCount", String.valueOf(fVar.NH));
            statsItem.append("memoryTime", String.valueOf(fVar.NI));
            statsItem.append("localCount", String.valueOf(fVar.NJ));
            statsItem.append("localSucCount", String.valueOf(fVar.NK));
            statsItem.append("localTime", String.valueOf(fVar.NM));
            statsItem.append("netCount", String.valueOf(fVar.NN));
            statsItem.append("netSucCount", String.valueOf(fVar.NP));
            statsItem.append("netTime", String.valueOf(fVar.NQ));
            statsItem.append("taskCount", String.valueOf(fVar.NR));
            statsItem.append("taskTime", String.valueOf(fVar.NT));
            statsItem.append("decodeCount", String.valueOf(fVar.NU));
            statsItem.append("decodeTime", String.valueOf(fVar.NV));
            statsItem.append("saveMemoryCount", String.valueOf(fVar.NW));
            statsItem.append("saveMemoryTime", String.valueOf(fVar.NX));
            statsItem.append("saveLocalCount", String.valueOf(fVar.NY));
            statsItem.append("saveLocalTime", String.valueOf(fVar.NZ));
            statsItem.append("memoryHitCount", String.valueOf(fVar.Oa));
            statsItem.append("localHitCount", String.valueOf(fVar.Ob));
            statsItem.append("netHitCount", String.valueOf(fVar.Oc));
            statsItem.append("totalHitCount", String.valueOf(fVar.Oa + fVar.Ob + fVar.Oc));
            statsItem.append("totalCount", String.valueOf(fVar.totalCount));
            statsItem.append("totalTime", String.valueOf(fVar.totalTime));
            statsItem.append("cdnCount", String.valueOf(fVar.Od));
            statsItem.append("ipCount", String.valueOf(fVar.Oe));
            statsItem.append("cdnAndIpCount", String.valueOf(fVar.Of));
            statsItem.append("imgSize", String.valueOf(fVar.Og));
            statsItem.append("nettype", aw(i));
            BdStatisticsManager.getInstance().performance("image", statsItem);
        }
    }

    private static f mr() {
        if (j.isWifiNet()) {
            return Nk.No;
        }
        if (j.is4GNet()) {
            return Nk.Nn;
        }
        if (j.is3GNet()) {
            return Nk.Nm;
        }
        return Nk.Nl;
    }

    public static boolean isCdn(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf("hiphotos");
        if (indexOf <= 0 || indexOf >= 20) {
            int indexOf2 = str.indexOf("tiebapic");
            return indexOf2 > 0 && indexOf2 < 20;
        }
        return true;
    }

    public static String aw(int i) {
        if (1 == i) {
            return "2G";
        }
        if (2 == i) {
            return "3G";
        }
        if (3 == i) {
            return "4G";
        }
        if (4 == i) {
            return "5G";
        }
        if (5 != i) {
            return "N";
        }
        return "WIFI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.lib.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0016a {
        f Nl;
        f Nm;
        f Nn;
        f No;

        private C0016a() {
            this.Nl = new f();
            this.Nm = new f();
            this.Nn = new f();
            this.No = new f();
        }

        public boolean ms() {
            return this.Nl.NN > 0;
        }

        public boolean mt() {
            return this.Nm.NN > 0;
        }

        public boolean mu() {
            return this.Nn.NN > 0;
        }

        public boolean mv() {
            return this.No.NN > 0;
        }

        public int mw() {
            return this.Nl.NN + this.Nm.NN + this.Nn.NN + this.No.NN;
        }

        public void reset() {
            this.Nl.reset();
            this.Nm.reset();
            this.Nn.reset();
            this.No.reset();
        }
    }
}
