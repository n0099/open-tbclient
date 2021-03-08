package com.baidu.adp.lib.e;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private static C0022a OF = new C0022a();
    private static final Object mSyncLock = new Object();

    public static void c(boolean z, long j) {
        f mq = mq();
        mq.Pb++;
        if (z) {
            mq.Pc++;
            mq.Pd += j;
        }
    }

    public static void d(boolean z, long j) {
        synchronized (mSyncLock) {
            f mq = mq();
            mq.Pe++;
            if (z) {
                mq.Pf++;
                mq.Pg += j;
            }
        }
    }

    public static void a(boolean z, String str, com.baidu.adp.lib.network.http.d dVar, long j, long j2) {
        if (l.isNetOk()) {
            synchronized (mSyncLock) {
                boolean isCdn = isCdn(str);
                boolean z2 = false;
                if (dVar != null && !StringUtils.isNull(dVar.Nz)) {
                    z2 = true;
                }
                f mq = mq();
                if (isCdn) {
                    mq.Pv++;
                }
                if (z2) {
                    mq.Pw++;
                }
                if (isCdn && z2) {
                    mq.Px++;
                }
                mq.Ph++;
                if (z) {
                    mq.Pi++;
                    mq.Pj += j;
                    mq.Py += j2;
                }
                if (OF.mv() > 100) {
                    mp();
                }
            }
        }
    }

    public static void e(boolean z, long j) {
        synchronized (mSyncLock) {
            f mq = mq();
            if (z) {
                mq.Pk++;
                mq.Pl += j;
            }
        }
    }

    public static void f(boolean z, long j) {
        synchronized (mSyncLock) {
            f mq = mq();
            if (z) {
                mq.Pm++;
                mq.Pn += j;
            }
        }
    }

    public static void g(boolean z, long j) {
        synchronized (mSyncLock) {
            f mq = mq();
            if (z) {
                mq.Pq++;
                mq.Pr += j;
            }
        }
    }

    public static void h(boolean z, long j) {
        f mq = mq();
        if (z) {
            mq.Po++;
            mq.Pp += j;
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        f mq = mq();
        if (z) {
            mq.Ps++;
        }
        if (z2) {
            mq.Pt++;
        }
        if (z3) {
            mq.Pu++;
        }
    }

    public static void i(boolean z, long j) {
        f mq = mq();
        if (z) {
            mq.totalCount++;
            mq.totalTime += j;
        }
    }

    public static void mp() {
        if (OF.mv() > 10) {
            if (OF.mu()) {
                a(OF.OJ, 5);
            }
            if (OF.mt()) {
                a(OF.OI, 3);
            }
            if (OF.ms()) {
                a(OF.OH, 2);
            }
            if (OF.mr()) {
                a(OF.OG, 1);
            }
            OF.reset();
        }
    }

    private static void a(f fVar, int i) {
        if (fVar != null && BdBaseApplication.getInst().isSmallFlow()) {
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem(BdStatsConstant.StatsType.PERFORMANCE);
            statsItem.append("action", "imgStat");
            statsItem.append("memoryCount", String.valueOf(fVar.Pb));
            statsItem.append("memorySucCount", String.valueOf(fVar.Pc));
            statsItem.append("memoryTime", String.valueOf(fVar.Pd));
            statsItem.append("localCount", String.valueOf(fVar.Pe));
            statsItem.append("localSucCount", String.valueOf(fVar.Pf));
            statsItem.append("localTime", String.valueOf(fVar.Pg));
            statsItem.append("netCount", String.valueOf(fVar.Ph));
            statsItem.append("netSucCount", String.valueOf(fVar.Pi));
            statsItem.append("netTime", String.valueOf(fVar.Pj));
            statsItem.append("taskCount", String.valueOf(fVar.Pk));
            statsItem.append("taskTime", String.valueOf(fVar.Pl));
            statsItem.append("decodeCount", String.valueOf(fVar.Pm));
            statsItem.append("decodeTime", String.valueOf(fVar.Pn));
            statsItem.append("saveMemoryCount", String.valueOf(fVar.Po));
            statsItem.append("saveMemoryTime", String.valueOf(fVar.Pp));
            statsItem.append("saveLocalCount", String.valueOf(fVar.Pq));
            statsItem.append("saveLocalTime", String.valueOf(fVar.Pr));
            statsItem.append("memoryHitCount", String.valueOf(fVar.Ps));
            statsItem.append("localHitCount", String.valueOf(fVar.Pt));
            statsItem.append("netHitCount", String.valueOf(fVar.Pu));
            statsItem.append("totalHitCount", String.valueOf(fVar.Ps + fVar.Pt + fVar.Pu));
            statsItem.append("totalCount", String.valueOf(fVar.totalCount));
            statsItem.append("totalTime", String.valueOf(fVar.totalTime));
            statsItem.append("cdnCount", String.valueOf(fVar.Pv));
            statsItem.append("ipCount", String.valueOf(fVar.Pw));
            statsItem.append("cdnAndIpCount", String.valueOf(fVar.Px));
            statsItem.append("imgSize", String.valueOf(fVar.Py));
            statsItem.append("nettype", aw(i));
            BdStatisticsManager.getInstance().performance("image", statsItem);
        }
    }

    private static f mq() {
        if (j.isWifiNet()) {
            return OF.OJ;
        }
        if (j.is4GNet()) {
            return OF.OI;
        }
        if (j.is3GNet()) {
            return OF.OH;
        }
        return OF.OG;
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
    public static class C0022a {
        f OG;
        f OH;
        f OI;
        f OJ;

        private C0022a() {
            this.OG = new f();
            this.OH = new f();
            this.OI = new f();
            this.OJ = new f();
        }

        public boolean mr() {
            return this.OG.Ph > 0;
        }

        public boolean ms() {
            return this.OH.Ph > 0;
        }

        public boolean mt() {
            return this.OI.Ph > 0;
        }

        public boolean mu() {
            return this.OJ.Ph > 0;
        }

        public int mv() {
            return this.OG.Ph + this.OH.Ph + this.OI.Ph + this.OJ.Ph;
        }

        public void reset() {
            this.OG.reset();
            this.OH.reset();
            this.OI.reset();
            this.OJ.reset();
        }
    }
}
