package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e sK;
    private HashMap<String, a> sI = new HashMap<>();
    private HashMap<String, b> sJ = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.L(false);
                        aVar.M(false);
                        aVar.S(0);
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
        if (sK == null) {
            synchronized (e.class) {
                if (sK == null) {
                    sK = new e();
                }
            }
        }
        return sK;
    }

    public e() {
        b bVar = new b();
        bVar.T(3000);
        bVar.U(120000);
        bVar.V(500);
        this.sJ.put("net", bVar);
        this.sJ.put("op", bVar);
        this.sJ.put("stat", bVar);
        this.sJ.put("crash", bVar);
        this.sJ.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.T(3000);
        bVar2.U(120000);
        bVar2.V(1500);
        this.sJ.put("file", bVar2);
        this.sJ.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.sJ.put("img", bVar2);
        this.sJ.put("voice", bVar2);
        this.sJ.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.T(3000);
        bVar3.U(120000);
        bVar3.V(1500);
        this.sJ.put("dbg", bVar3);
    }

    public synchronized boolean aA(String str) {
        a aVar;
        boolean z;
        b bVar = this.sJ.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.sI.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.M(false);
                aVar3.L(false);
                aVar3.k(currentTimeMillis);
                this.sI.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.gC()) {
                z = true;
            } else {
                if (aVar.gG()) {
                    aVar.S(aVar.gE() + 1);
                    if (currentTimeMillis - aVar.gD() < bVar.gI()) {
                        if (aVar.gE() >= bVar.gJ()) {
                            aVar.L(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, BdStatsConstant.ErrorCode.ERR_LOG_FAST, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.M(false);
                        aVar.S(0);
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
        private long sM;
        private long sN;
        private boolean sO;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.sO = false;
        }

        public boolean gC() {
            return this.sO;
        }

        public void L(boolean z) {
            this.sO = z;
        }

        public long gD() {
            return this.sN;
        }

        public void j(long j) {
            this.sN = j;
        }

        public int gE() {
            return this.mCount;
        }

        public void S(int i) {
            this.mCount = i;
        }

        public long gF() {
            return this.sM;
        }

        public void k(long j) {
            this.sM = j;
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
        private int sP;
        private int sQ;

        private b() {
        }

        public int gH() {
            return this.mInterval;
        }

        public void T(int i) {
            this.mInterval = i;
        }

        public int gI() {
            return this.sP;
        }

        public void U(int i) {
            this.sP = i;
        }

        public int gJ() {
            return this.sQ;
        }

        public void V(int i) {
            this.sQ = i;
        }
    }
}
