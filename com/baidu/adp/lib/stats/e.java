package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e OL;
    private HashMap<String, a> OI = new HashMap<>();
    private HashMap<String, b> OJ = new HashMap<>();
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
        if (OL == null) {
            synchronized (e.class) {
                if (OL == null) {
                    OL = new e();
                }
            }
        }
        return OL;
    }

    public e() {
        b bVar = new b();
        bVar.aA(3000);
        bVar.aB(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.aC(500);
        this.OJ.put("net", bVar);
        this.OJ.put("op", bVar);
        this.OJ.put("stat", bVar);
        this.OJ.put("crash", bVar);
        this.OJ.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.aA(3000);
        bVar2.aB(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.aC(1500);
        this.OJ.put("file", bVar2);
        this.OJ.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.OJ.put("img", bVar2);
        this.OJ.put("voice", bVar2);
        this.OJ.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.aA(3000);
        bVar3.aB(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.aC(1500);
        this.OJ.put("dbg", bVar3);
    }

    public synchronized boolean bT(String str) {
        a aVar;
        boolean z;
        b bVar = this.OJ.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.OI.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.an(false);
                aVar3.am(false);
                aVar3.G(currentTimeMillis);
                this.OI.put(str, aVar3);
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
        private long OO;
        private long OP;
        private boolean OQ;
        private int mCount;
        private boolean mIsRunning;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.OQ = false;
        }

        public boolean mG() {
            return this.OQ;
        }

        public void am(boolean z) {
            this.OQ = z;
        }

        public long mH() {
            return this.OP;
        }

        public void F(long j) {
            this.OP = j;
        }

        public int mI() {
            return this.mCount;
        }

        public void az(int i) {
            this.mCount = i;
        }

        public long mJ() {
            return this.OO;
        }

        public void G(long j) {
            this.OO = j;
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
        private int OR;
        private int OT;
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
            return this.OR;
        }

        public void aB(int i) {
            this.OR = i;
        }

        public int mN() {
            return this.OT;
        }

        public void aC(int i) {
            this.OT = i;
        }
    }
}
