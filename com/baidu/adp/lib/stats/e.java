package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e LG;
    private HashMap<String, a> LC = new HashMap<>();
    private HashMap<String, b> LD = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.ak(false);
                        aVar.al(false);
                        aVar.ah(0);
                        aVar.I(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e lf() {
        if (LG == null) {
            synchronized (e.class) {
                if (LG == null) {
                    LG = new e();
                }
            }
        }
        return LG;
    }

    public e() {
        b bVar = new b();
        bVar.ai(3000);
        bVar.aj(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.ak(500);
        this.LD.put("net", bVar);
        this.LD.put("op", bVar);
        this.LD.put("stat", bVar);
        this.LD.put("crash", bVar);
        this.LD.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.ai(3000);
        bVar2.aj(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.ak(1500);
        this.LD.put("file", bVar2);
        this.LD.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.LD.put("img", bVar2);
        this.LD.put("voice", bVar2);
        this.LD.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.ai(3000);
        bVar3.aj(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.ak(1500);
        this.LD.put("dbg", bVar3);
    }

    public synchronized boolean bP(String str) {
        a aVar;
        boolean z;
        b bVar = this.LD.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.LC.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.al(false);
                aVar3.ak(false);
                aVar3.I(currentTimeMillis);
                this.LC.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.lg()) {
                z = true;
            } else {
                if (aVar.lk()) {
                    aVar.ah(aVar.li() + 1);
                    if (currentTimeMillis - aVar.lh() < bVar.lm()) {
                        if (aVar.li() >= bVar.ln()) {
                            aVar.ak(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, BdStatsConstant.ErrorCode.ERR_LOG_FAST, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.al(false);
                        aVar.ah(0);
                        aVar.I(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.lj() < bVar.ll()) {
                    aVar.al(true);
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
        private long LI;
        private long LJ;
        private boolean LK;
        private int mCount;
        private boolean mIsRunning;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.LK = false;
        }

        public boolean lg() {
            return this.LK;
        }

        public void ak(boolean z) {
            this.LK = z;
        }

        public long lh() {
            return this.LJ;
        }

        public void H(long j) {
            this.LJ = j;
        }

        public int li() {
            return this.mCount;
        }

        public void ah(int i) {
            this.mCount = i;
        }

        public long lj() {
            return this.LI;
        }

        public void I(long j) {
            this.LI = j;
        }

        public boolean lk() {
            return this.mIsRunning;
        }

        public void al(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int LM;
        private int LN;
        private int mInterval;

        private b() {
        }

        public int ll() {
            return this.mInterval;
        }

        public void ai(int i) {
            this.mInterval = i;
        }

        public int lm() {
            return this.LM;
        }

        public void aj(int i) {
            this.LM = i;
        }

        public int ln() {
            return this.LN;
        }

        public void ak(int i) {
            this.LN = i;
        }
    }
}
