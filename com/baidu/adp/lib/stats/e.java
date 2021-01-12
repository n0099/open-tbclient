package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e OI;
    private HashMap<String, a> OG = new HashMap<>();
    private HashMap<String, b> OH = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.am(false);
                        aVar.an(false);
                        aVar.az(0);
                        aVar.G(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e mF() {
        if (OI == null) {
            synchronized (e.class) {
                if (OI == null) {
                    OI = new e();
                }
            }
        }
        return OI;
    }

    public e() {
        b bVar = new b();
        bVar.aA(3000);
        bVar.aB(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.aC(500);
        this.OH.put("net", bVar);
        this.OH.put("op", bVar);
        this.OH.put("stat", bVar);
        this.OH.put("crash", bVar);
        this.OH.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.aA(3000);
        bVar2.aB(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.aC(1500);
        this.OH.put("file", bVar2);
        this.OH.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.OH.put("img", bVar2);
        this.OH.put("voice", bVar2);
        this.OH.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.aA(3000);
        bVar3.aB(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.aC(1500);
        this.OH.put("dbg", bVar3);
    }

    public synchronized boolean bT(String str) {
        a aVar;
        boolean z;
        b bVar = this.OH.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.OG.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.an(false);
                aVar3.am(false);
                aVar3.G(currentTimeMillis);
                this.OG.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.mG()) {
                z = true;
            } else {
                if (aVar.mK()) {
                    aVar.az(aVar.mI() + 1);
                    if (currentTimeMillis - aVar.mH() < bVar.mM()) {
                        if (aVar.mI() >= bVar.mN()) {
                            aVar.am(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, BdStatsConstant.ErrorCode.ERR_LOG_FAST, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.an(false);
                        aVar.az(0);
                        aVar.G(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.mJ() < bVar.mL()) {
                    aVar.an(true);
                    aVar.F(currentTimeMillis);
                } else {
                    aVar.G(currentTimeMillis);
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
        private long OL;
        private long OM;
        private boolean OO;
        private int mCount;
        private boolean mIsRunning;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.OO = false;
        }

        public boolean mG() {
            return this.OO;
        }

        public void am(boolean z) {
            this.OO = z;
        }

        public long mH() {
            return this.OM;
        }

        public void F(long j) {
            this.OM = j;
        }

        public int mI() {
            return this.mCount;
        }

        public void az(int i) {
            this.mCount = i;
        }

        public long mJ() {
            return this.OL;
        }

        public void G(long j) {
            this.OL = j;
        }

        public boolean mK() {
            return this.mIsRunning;
        }

        public void an(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int OP;
        private int OQ;
        private int mInterval;

        private b() {
        }

        public int mL() {
            return this.mInterval;
        }

        public void aA(int i) {
            this.mInterval = i;
        }

        public int mM() {
            return this.OP;
        }

        public void aB(int i) {
            this.OP = i;
        }

        public int mN() {
            return this.OQ;
        }

        public void aC(int i) {
            this.OQ = i;
        }
    }
}
