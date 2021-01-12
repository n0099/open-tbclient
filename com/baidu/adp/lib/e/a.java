package com.baidu.adp.lib.e;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private static C0016a Ni = new C0016a();
    private static final Object mSyncLock = new Object();

    public static void b(boolean z, long j) {
        f mr = mr();
        mr.ND++;
        if (z) {
            mr.NF++;
            mr.NG += j;
        }
    }

    public static void c(boolean z, long j) {
        synchronized (mSyncLock) {
            f mr = mr();
            mr.NH++;
            if (z) {
                mr.NI++;
                mr.NJ += j;
            }
        }
    }

    public static void a(boolean z, String str, com.baidu.adp.lib.network.http.d dVar, long j, long j2) {
        if (l.isNetOk()) {
            synchronized (mSyncLock) {
                boolean isCdn = isCdn(str);
                boolean z2 = false;
                if (dVar != null && !StringUtils.isNull(dVar.Mg)) {
                    z2 = true;
                }
                f mr = mr();
                if (isCdn) {
                    mr.Ob++;
                }
                if (z2) {
                    mr.Oc++;
                }
                if (isCdn && z2) {
                    mr.Od++;
                }
                mr.NK++;
                if (z) {
                    mr.NM++;
                    mr.NN += j;
                    mr.Oe += j2;
                }
                if (Ni.mw() > 100) {
                    mq();
                }
            }
        }
    }

    public static void d(boolean z, long j) {
        synchronized (mSyncLock) {
            f mr = mr();
            if (z) {
                mr.NP++;
                mr.NQ += j;
            }
        }
    }

    public static void e(boolean z, long j) {
        synchronized (mSyncLock) {
            f mr = mr();
            if (z) {
                mr.NR++;
                mr.NT += j;
            }
        }
    }

    public static void f(boolean z, long j) {
        synchronized (mSyncLock) {
            f mr = mr();
            if (z) {
                mr.NW++;
                mr.NX += j;
            }
        }
    }

    public static void g(boolean z, long j) {
        f mr = mr();
        if (z) {
            mr.NU++;
            mr.NV += j;
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        f mr = mr();
        if (z) {
            mr.NY++;
        }
        if (z2) {
            mr.NZ++;
        }
        if (z3) {
            mr.Oa++;
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
        if (Ni.mw() > 10) {
            if (Ni.mv()) {
                a(Ni.Nm, 5);
            }
            if (Ni.mu()) {
                a(Ni.Nl, 3);
            }
            if (Ni.mt()) {
                a(Ni.Nk, 2);
            }
            if (Ni.ms()) {
                a(Ni.Nj, 1);
            }
            Ni.reset();
        }
    }

    private static void a(f fVar, int i) {
        if (fVar != null && BdBaseApplication.getInst().isSmallFlow()) {
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem(BdStatsConstant.StatsType.PERFORMANCE);
            statsItem.append("action", "imgStat");
            statsItem.append("memoryCount", String.valueOf(fVar.ND));
            statsItem.append("memorySucCount", String.valueOf(fVar.NF));
            statsItem.append("memoryTime", String.valueOf(fVar.NG));
            statsItem.append("localCount", String.valueOf(fVar.NH));
            statsItem.append("localSucCount", String.valueOf(fVar.NI));
            statsItem.append("localTime", String.valueOf(fVar.NJ));
            statsItem.append("netCount", String.valueOf(fVar.NK));
            statsItem.append("netSucCount", String.valueOf(fVar.NM));
            statsItem.append("netTime", String.valueOf(fVar.NN));
            statsItem.append("taskCount", String.valueOf(fVar.NP));
            statsItem.append("taskTime", String.valueOf(fVar.NQ));
            statsItem.append("decodeCount", String.valueOf(fVar.NR));
            statsItem.append("decodeTime", String.valueOf(fVar.NT));
            statsItem.append("saveMemoryCount", String.valueOf(fVar.NU));
            statsItem.append("saveMemoryTime", String.valueOf(fVar.NV));
            statsItem.append("saveLocalCount", String.valueOf(fVar.NW));
            statsItem.append("saveLocalTime", String.valueOf(fVar.NX));
            statsItem.append("memoryHitCount", String.valueOf(fVar.NY));
            statsItem.append("localHitCount", String.valueOf(fVar.NZ));
            statsItem.append("netHitCount", String.valueOf(fVar.Oa));
            statsItem.append("totalHitCount", String.valueOf(fVar.NY + fVar.NZ + fVar.Oa));
            statsItem.append("totalCount", String.valueOf(fVar.totalCount));
            statsItem.append("totalTime", String.valueOf(fVar.totalTime));
            statsItem.append("cdnCount", String.valueOf(fVar.Ob));
            statsItem.append("ipCount", String.valueOf(fVar.Oc));
            statsItem.append("cdnAndIpCount", String.valueOf(fVar.Od));
            statsItem.append("imgSize", String.valueOf(fVar.Oe));
            statsItem.append("nettype", aw(i));
            BdStatisticsManager.getInstance().performance("image", statsItem);
        }
    }

    private static f mr() {
        if (j.isWifiNet()) {
            return Ni.Nm;
        }
        if (j.is4GNet()) {
            return Ni.Nl;
        }
        if (j.is3GNet()) {
            return Ni.Nk;
        }
        return Ni.Nj;
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
        f Nj;
        f Nk;
        f Nl;
        f Nm;

        private C0016a() {
            this.Nj = new f();
            this.Nk = new f();
            this.Nl = new f();
            this.Nm = new f();
        }

        public boolean ms() {
            return this.Nj.NK > 0;
        }

        public boolean mt() {
            return this.Nk.NK > 0;
        }

        public boolean mu() {
            return this.Nl.NK > 0;
        }

        public boolean mv() {
            return this.Nm.NK > 0;
        }

        public int mw() {
            return this.Nj.NK + this.Nk.NK + this.Nl.NK + this.Nm.NK;
        }

        public void reset() {
            this.Nj.reset();
            this.Nk.reset();
            this.Nl.reset();
            this.Nm.reset();
        }
    }
}
