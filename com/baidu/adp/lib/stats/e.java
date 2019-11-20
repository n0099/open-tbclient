package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e pY;
    private HashMap<String, a> pW = new HashMap<>();
    private HashMap<String, b> pX = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.F(false);
                        aVar.G(false);
                        aVar.O(0);
                        aVar.i(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e gd() {
        if (pY == null) {
            synchronized (e.class) {
                if (pY == null) {
                    pY = new e();
                }
            }
        }
        return pY;
    }

    public e() {
        b bVar = new b();
        bVar.P(3000);
        bVar.Q(120000);
        bVar.R(500);
        this.pX.put("net", bVar);
        this.pX.put("op", bVar);
        this.pX.put("stat", bVar);
        this.pX.put("crash", bVar);
        this.pX.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.P(3000);
        bVar2.Q(120000);
        bVar2.R(1500);
        this.pX.put(BdStatsConstant.OpSubType.FILE, bVar2);
        this.pX.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.pX.put("img", bVar2);
        this.pX.put("voice", bVar2);
        this.pX.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.P(3000);
        bVar3.Q(120000);
        bVar3.R(1500);
        this.pX.put("dbg", bVar3);
    }

    public synchronized boolean ao(String str) {
        a aVar;
        boolean z;
        b bVar = this.pX.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.pW.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.G(false);
                aVar3.F(false);
                aVar3.i(currentTimeMillis);
                this.pW.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.ge()) {
                z = true;
            } else {
                if (aVar.gi()) {
                    aVar.O(aVar.gg() + 1);
                    if (currentTimeMillis - aVar.gf() < bVar.gk()) {
                        if (aVar.gg() >= bVar.gl()) {
                            aVar.F(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, BdStatsConstant.ErrorCode.ERR_LOG_FAST, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.G(false);
                        aVar.O(0);
                        aVar.i(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.gh() < bVar.gj()) {
                    aVar.G(true);
                    aVar.h(currentTimeMillis);
                } else {
                    aVar.i(currentTimeMillis);
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
        private long qa;
        private long qb;
        private boolean qc;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.qc = false;
        }

        public boolean ge() {
            return this.qc;
        }

        public void F(boolean z) {
            this.qc = z;
        }

        public long gf() {
            return this.qb;
        }

        public void h(long j) {
            this.qb = j;
        }

        public int gg() {
            return this.mCount;
        }

        public void O(int i) {
            this.mCount = i;
        }

        public long gh() {
            return this.qa;
        }

        public void i(long j) {
            this.qa = j;
        }

        public boolean gi() {
            return this.mIsRunning;
        }

        public void G(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int mInterval;
        private int qd;
        private int qe;

        private b() {
        }

        public int gj() {
            return this.mInterval;
        }

        public void P(int i) {
            this.mInterval = i;
        }

        public int gk() {
            return this.qd;
        }

        public void Q(int i) {
            this.qd = i;
        }

        public int gl() {
            return this.qe;
        }

        public void R(int i) {
            this.qe = i;
        }
    }
}
