package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e sN;
    private HashMap<String, a> sL = new HashMap<>();
    private HashMap<String, b> sM = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.L(false);
                        aVar.M(false);
                        aVar.V(0);
                        aVar.k(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e gB() {
        if (sN == null) {
            synchronized (e.class) {
                if (sN == null) {
                    sN = new e();
                }
            }
        }
        return sN;
    }

    public e() {
        b bVar = new b();
        bVar.W(3000);
        bVar.X(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.Y(500);
        this.sM.put("net", bVar);
        this.sM.put("op", bVar);
        this.sM.put("stat", bVar);
        this.sM.put("crash", bVar);
        this.sM.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.W(3000);
        bVar2.X(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.Y(1500);
        this.sM.put("file", bVar2);
        this.sM.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.sM.put("img", bVar2);
        this.sM.put("voice", bVar2);
        this.sM.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.W(3000);
        bVar3.X(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.Y(1500);
        this.sM.put("dbg", bVar3);
    }

    public synchronized boolean aA(String str) {
        a aVar;
        boolean z;
        b bVar = this.sM.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.sL.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.M(false);
                aVar3.L(false);
                aVar3.k(currentTimeMillis);
                this.sL.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.gC()) {
                z = true;
            } else {
                if (aVar.gG()) {
                    aVar.V(aVar.gE() + 1);
                    if (currentTimeMillis - aVar.gD() < bVar.gI()) {
                        if (aVar.gE() >= bVar.gJ()) {
                            aVar.L(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, BdStatsConstant.ErrorCode.ERR_LOG_FAST, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.M(false);
                        aVar.V(0);
                        aVar.k(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.gF() < bVar.gH()) {
                    aVar.M(true);
                    aVar.j(currentTimeMillis);
                } else {
                    aVar.k(currentTimeMillis);
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
        private int mCount;
        private boolean mIsRunning;
        private long sP;
        private long sQ;
        private boolean sR;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.sR = false;
        }

        public boolean gC() {
            return this.sR;
        }

        public void L(boolean z) {
            this.sR = z;
        }

        public long gD() {
            return this.sQ;
        }

        public void j(long j) {
            this.sQ = j;
        }

        public int gE() {
            return this.mCount;
        }

        public void V(int i) {
            this.mCount = i;
        }

        public long gF() {
            return this.sP;
        }

        public void k(long j) {
            this.sP = j;
        }

        public boolean gG() {
            return this.mIsRunning;
        }

        public void M(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int mInterval;
        private int sS;
        private int sT;

        private b() {
        }

        public int gH() {
            return this.mInterval;
        }

        public void W(int i) {
            this.mInterval = i;
        }

        public int gI() {
            return this.sS;
        }

        public void X(int i) {
            this.sS = i;
        }

        public int gJ() {
            return this.sT;
        }

        public void Y(int i) {
            this.sT = i;
        }
    }
}
