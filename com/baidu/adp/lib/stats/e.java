package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e sL;
    private HashMap<String, a> sJ = new HashMap<>();
    private HashMap<String, b> sK = new HashMap<>();
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

    public static e gA() {
        if (sL == null) {
            synchronized (e.class) {
                if (sL == null) {
                    sL = new e();
                }
            }
        }
        return sL;
    }

    public e() {
        b bVar = new b();
        bVar.T(3000);
        bVar.U(120000);
        bVar.V(500);
        this.sK.put("net", bVar);
        this.sK.put("op", bVar);
        this.sK.put("stat", bVar);
        this.sK.put("crash", bVar);
        this.sK.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.T(3000);
        bVar2.U(120000);
        bVar2.V(1500);
        this.sK.put("file", bVar2);
        this.sK.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.sK.put("img", bVar2);
        this.sK.put("voice", bVar2);
        this.sK.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.T(3000);
        bVar3.U(120000);
        bVar3.V(1500);
        this.sK.put("dbg", bVar3);
    }

    public synchronized boolean aA(String str) {
        a aVar;
        boolean z;
        b bVar = this.sK.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.sJ.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.M(false);
                aVar3.L(false);
                aVar3.k(currentTimeMillis);
                this.sJ.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.gB()) {
                z = true;
            } else {
                if (aVar.gF()) {
                    aVar.S(aVar.gD() + 1);
                    if (currentTimeMillis - aVar.gC() < bVar.gH()) {
                        if (aVar.gD() >= bVar.gI()) {
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
                } else if (currentTimeMillis - aVar.gE() < bVar.gG()) {
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
        private long sN;
        private long sO;
        private boolean sP;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.sP = false;
        }

        public boolean gB() {
            return this.sP;
        }

        public void L(boolean z) {
            this.sP = z;
        }

        public long gC() {
            return this.sO;
        }

        public void j(long j) {
            this.sO = j;
        }

        public int gD() {
            return this.mCount;
        }

        public void S(int i) {
            this.mCount = i;
        }

        public long gE() {
            return this.sN;
        }

        public void k(long j) {
            this.sN = j;
        }

        public boolean gF() {
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
        private int sQ;
        private int sR;

        private b() {
        }

        public int gG() {
            return this.mInterval;
        }

        public void T(int i) {
            this.mInterval = i;
        }

        public int gH() {
            return this.sQ;
        }

        public void U(int i) {
            this.sQ = i;
        }

        public int gI() {
            return this.sR;
        }

        public void V(int i) {
            this.sR = i;
        }
    }
}
