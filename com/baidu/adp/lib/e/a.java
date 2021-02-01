package com.baidu.adp.lib.e;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a {
    private static C0016a Ng = new C0016a();
    private static final Object mSyncLock = new Object();

    public static void b(boolean z, long j) {
        f mq = mq();
        mq.Nz++;
        if (z) {
            mq.NC++;
            mq.ND += j;
        }
    }

    public static void c(boolean z, long j) {
        synchronized (mSyncLock) {
            f mq = mq();
            mq.NF++;
            if (z) {
                mq.NG++;
                mq.NH += j;
            }
        }
    }

    public static void a(boolean z, String str, com.baidu.adp.lib.network.http.d dVar, long j, long j2) {
        if (l.isNetOk()) {
            synchronized (mSyncLock) {
                boolean isCdn = isCdn(str);
                boolean z2 = false;
                if (dVar != null && !StringUtils.isNull(dVar.Me)) {
                    z2 = true;
                }
                f mq = mq();
                if (isCdn) {
                    mq.NZ++;
                }
                if (z2) {
                    mq.Oa++;
                }
                if (isCdn && z2) {
                    mq.Ob++;
                }
                mq.NI++;
                if (z) {
                    mq.NJ++;
                    mq.NK += j;
                    mq.Oc += j2;
                }
                if (Ng.mv() > 100) {
                    mp();
                }
            }
        }
    }

    public static void d(boolean z, long j) {
        synchronized (mSyncLock) {
            f mq = mq();
            if (z) {
                mq.NM++;
                mq.NN += j;
            }
        }
    }

    public static void e(boolean z, long j) {
        synchronized (mSyncLock) {
            f mq = mq();
            if (z) {
                mq.NP++;
                mq.NQ += j;
            }
        }
    }

    public static void f(boolean z, long j) {
        synchronized (mSyncLock) {
            f mq = mq();
            if (z) {
                mq.NU++;
                mq.NV += j;
            }
        }
    }

    public static void g(boolean z, long j) {
        f mq = mq();
        if (z) {
            mq.NR++;
            mq.NT += j;
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        f mq = mq();
        if (z) {
            mq.NW++;
        }
        if (z2) {
            mq.NX++;
        }
        if (z3) {
            mq.NY++;
        }
    }

    public static void h(boolean z, long j) {
        f mq = mq();
        if (z) {
            mq.totalCount++;
            mq.totalTime += j;
        }
    }

    public static void mp() {
        if (Ng.mv() > 10) {
            if (Ng.mu()) {
                a(Ng.Nk, 5);
            }
            if (Ng.mt()) {
                a(Ng.Nj, 3);
            }
            if (Ng.ms()) {
                a(Ng.Ni, 2);
            }
            if (Ng.mr()) {
                a(Ng.Nh, 1);
            }
            Ng.reset();
        }
    }

    private static void a(f fVar, int i) {
        if (fVar != null && BdBaseApplication.getInst().isSmallFlow()) {
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem(BdStatsConstant.StatsType.PERFORMANCE);
            statsItem.append("action", "imgStat");
            statsItem.append("memoryCount", String.valueOf(fVar.Nz));
            statsItem.append("memorySucCount", String.valueOf(fVar.NC));
            statsItem.append("memoryTime", String.valueOf(fVar.ND));
            statsItem.append("localCount", String.valueOf(fVar.NF));
            statsItem.append("localSucCount", String.valueOf(fVar.NG));
            statsItem.append("localTime", String.valueOf(fVar.NH));
            statsItem.append("netCount", String.valueOf(fVar.NI));
            statsItem.append("netSucCount", String.valueOf(fVar.NJ));
            statsItem.append("netTime", String.valueOf(fVar.NK));
            statsItem.append("taskCount", String.valueOf(fVar.NM));
            statsItem.append("taskTime", String.valueOf(fVar.NN));
            statsItem.append("decodeCount", String.valueOf(fVar.NP));
            statsItem.append("decodeTime", String.valueOf(fVar.NQ));
            statsItem.append("saveMemoryCount", String.valueOf(fVar.NR));
            statsItem.append("saveMemoryTime", String.valueOf(fVar.NT));
            statsItem.append("saveLocalCount", String.valueOf(fVar.NU));
            statsItem.append("saveLocalTime", String.valueOf(fVar.NV));
            statsItem.append("memoryHitCount", String.valueOf(fVar.NW));
            statsItem.append("localHitCount", String.valueOf(fVar.NX));
            statsItem.append("netHitCount", String.valueOf(fVar.NY));
            statsItem.append("totalHitCount", String.valueOf(fVar.NW + fVar.NX + fVar.NY));
            statsItem.append("totalCount", String.valueOf(fVar.totalCount));
            statsItem.append("totalTime", String.valueOf(fVar.totalTime));
            statsItem.append("cdnCount", String.valueOf(fVar.NZ));
            statsItem.append("ipCount", String.valueOf(fVar.Oa));
            statsItem.append("cdnAndIpCount", String.valueOf(fVar.Ob));
            statsItem.append("imgSize", String.valueOf(fVar.Oc));
            statsItem.append("nettype", aw(i));
            BdStatisticsManager.getInstance().performance("image", statsItem);
        }
    }

    private static f mq() {
        if (j.isWifiNet()) {
            return Ng.Nk;
        }
        if (j.is4GNet()) {
            return Ng.Nj;
        }
        if (j.is3GNet()) {
            return Ng.Ni;
        }
        return Ng.Nh;
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
        f Nh;
        f Ni;
        f Nj;
        f Nk;

        private C0016a() {
            this.Nh = new f();
            this.Ni = new f();
            this.Nj = new f();
            this.Nk = new f();
        }

        public boolean mr() {
            return this.Nh.NI > 0;
        }

        public boolean ms() {
            return this.Ni.NI > 0;
        }

        public boolean mt() {
            return this.Nj.NI > 0;
        }

        public boolean mu() {
            return this.Nk.NI > 0;
        }

        public int mv() {
            return this.Nh.NI + this.Ni.NI + this.Nj.NI + this.Nk.NI;
        }

        public void reset() {
            this.Nh.reset();
            this.Ni.reset();
            this.Nj.reset();
            this.Nk.reset();
        }
    }
}
