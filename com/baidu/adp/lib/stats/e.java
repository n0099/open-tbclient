package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e NN;
    private HashMap<String, a> NL = new HashMap<>();
    private HashMap<String, b> NM = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.ao(false);
                        aVar.ap(false);
                        aVar.av(0);
                        aVar.I(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e nc() {
        if (NN == null) {
            synchronized (e.class) {
                if (NN == null) {
                    NN = new e();
                }
            }
        }
        return NN;
    }

    public e() {
        b bVar = new b();
        bVar.aw(3000);
        bVar.ax(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.ay(500);
        this.NM.put("net", bVar);
        this.NM.put("op", bVar);
        this.NM.put("stat", bVar);
        this.NM.put("crash", bVar);
        this.NM.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.aw(3000);
        bVar2.ax(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.ay(1500);
        this.NM.put("file", bVar2);
        this.NM.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.NM.put("img", bVar2);
        this.NM.put("voice", bVar2);
        this.NM.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.aw(3000);
        bVar3.ax(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.ay(1500);
        this.NM.put("dbg", bVar3);
    }

    public synchronized boolean bW(String str) {
        a aVar;
        boolean z;
        b bVar = this.NM.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.NL.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.ap(false);
                aVar3.ao(false);
                aVar3.I(currentTimeMillis);
                this.NL.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.nd()) {
                z = true;
            } else {
                if (aVar.nh()) {
                    aVar.av(aVar.nf() + 1);
                    if (currentTimeMillis - aVar.ne() < bVar.nj()) {
                        if (aVar.nf() >= bVar.nk()) {
                            aVar.ao(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, BdStatsConstant.ErrorCode.ERR_LOG_FAST, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.ap(false);
                        aVar.av(0);
                        aVar.I(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.ng() < bVar.ni()) {
                    aVar.ap(true);
                    aVar.H(currentTimeMillis);
                } else {
                    aVar.I(currentTimeMillis);
                }
                z = false;
            }
        }
        return z;
    }

    private void a(a aVar) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = aVar;
        this.mHandler.removeMessages(5);
        this.mHandler.sendMessageDelayed(obtainMessage, 300000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private long NQ;
        private long NR;
        private boolean NT;
        private int mCount;
        private boolean mIsRunning;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.NT = false;
        }

        public boolean nd() {
            return this.NT;
        }

        public void ao(boolean z) {
            this.NT = z;
        }

        public long ne() {
            return this.NR;
        }

        public void H(long j) {
            this.NR = j;
        }

        public int nf() {
            return this.mCount;
        }

        public void av(int i) {
            this.mCount = i;
        }

        public long ng() {
            return this.NQ;
        }

        public void I(long j) {
            this.NQ = j;
        }

        public boolean nh() {
            return this.mIsRunning;
        }

        public void ap(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int NU;
        private int NV;
        private int mInterval;

        private b() {
        }

        public int ni() {
            return this.mInterval;
        }

        public void aw(int i) {
            this.mInterval = i;
        }

        public int nj() {
            return this.NU;
        }

        public void ax(int i) {
            this.NU = i;
        }

        public int nk() {
            return this.NV;
        }

        public void ay(int i) {
            this.NV = i;
        }
    }
}
