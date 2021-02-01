package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e OG;
    private HashMap<String, a> OE = new HashMap<>();
    private HashMap<String, b> OF = new HashMap<>();
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

    public static e mE() {
        if (OG == null) {
            synchronized (e.class) {
                if (OG == null) {
                    OG = new e();
                }
            }
        }
        return OG;
    }

    public e() {
        b bVar = new b();
        bVar.aA(3000);
        bVar.aB(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.aC(500);
        this.OF.put("net", bVar);
        this.OF.put("op", bVar);
        this.OF.put("stat", bVar);
        this.OF.put("crash", bVar);
        this.OF.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.aA(3000);
        bVar2.aB(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.aC(1500);
        this.OF.put("file", bVar2);
        this.OF.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.OF.put("img", bVar2);
        this.OF.put("voice", bVar2);
        this.OF.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.aA(3000);
        bVar3.aB(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.aC(1500);
        this.OF.put("dbg", bVar3);
    }

    public synchronized boolean bT(String str) {
        a aVar;
        boolean z;
        b bVar = this.OF.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.OE.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.an(false);
                aVar3.am(false);
                aVar3.G(currentTimeMillis);
                this.OE.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.mF()) {
                z = true;
            } else {
                if (aVar.mJ()) {
                    aVar.az(aVar.mH() + 1);
                    if (currentTimeMillis - aVar.mG() < bVar.mL()) {
                        if (aVar.mH() >= bVar.mM()) {
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
                } else if (currentTimeMillis - aVar.mI() < bVar.mK()) {
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
        private long OI;
        private long OJ;
        private boolean OL;
        private int mCount;
        private boolean mIsRunning;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.OL = false;
        }

        public boolean mF() {
            return this.OL;
        }

        public void am(boolean z) {
            this.OL = z;
        }

        public long mG() {
            return this.OJ;
        }

        public void F(long j) {
            this.OJ = j;
        }

        public int mH() {
            return this.mCount;
        }

        public void az(int i) {
            this.mCount = i;
        }

        public long mI() {
            return this.OI;
        }

        public void G(long j) {
            this.OI = j;
        }

        public boolean mJ() {
            return this.mIsRunning;
        }

        public void an(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int OM;
        private int OO;
        private int mInterval;

        private b() {
        }

        public int mK() {
            return this.mInterval;
        }

        public void aA(int i) {
            this.mInterval = i;
        }

        public int mL() {
            return this.OM;
        }

        public void aB(int i) {
            this.OM = i;
        }

        public int mM() {
            return this.OO;
        }

        public void aC(int i) {
            this.OO = i;
        }
    }
}
