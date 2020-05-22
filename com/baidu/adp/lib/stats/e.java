package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e LX;
    private HashMap<String, a> LV = new HashMap<>();
    private HashMap<String, b> LW = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.am(false);
                        aVar.an(false);
                        aVar.ai(0);
                        aVar.I(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e lh() {
        if (LX == null) {
            synchronized (e.class) {
                if (LX == null) {
                    LX = new e();
                }
            }
        }
        return LX;
    }

    public e() {
        b bVar = new b();
        bVar.aj(3000);
        bVar.ak(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.al(500);
        this.LW.put("net", bVar);
        this.LW.put("op", bVar);
        this.LW.put("stat", bVar);
        this.LW.put("crash", bVar);
        this.LW.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.aj(3000);
        bVar2.ak(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.al(1500);
        this.LW.put("file", bVar2);
        this.LW.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.LW.put("img", bVar2);
        this.LW.put("voice", bVar2);
        this.LW.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.aj(3000);
        bVar3.ak(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.al(1500);
        this.LW.put("dbg", bVar3);
    }

    public synchronized boolean bQ(String str) {
        a aVar;
        boolean z;
        b bVar = this.LW.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.LV.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.an(false);
                aVar3.am(false);
                aVar3.I(currentTimeMillis);
                this.LV.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.li()) {
                z = true;
            } else {
                if (aVar.lm()) {
                    aVar.ai(aVar.lk() + 1);
                    if (currentTimeMillis - aVar.lj() < bVar.lo()) {
                        if (aVar.lk() >= bVar.lp()) {
                            aVar.am(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, BdStatsConstant.ErrorCode.ERR_LOG_FAST, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.an(false);
                        aVar.ai(0);
                        aVar.I(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.ll() < bVar.ln()) {
                    aVar.an(true);
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
        private long LZ;
        private long Ma;
        private boolean Mb;
        private int mCount;
        private boolean mIsRunning;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.Mb = false;
        }

        public boolean li() {
            return this.Mb;
        }

        public void am(boolean z) {
            this.Mb = z;
        }

        public long lj() {
            return this.Ma;
        }

        public void H(long j) {
            this.Ma = j;
        }

        public int lk() {
            return this.mCount;
        }

        public void ai(int i) {
            this.mCount = i;
        }

        public long ll() {
            return this.LZ;
        }

        public void I(long j) {
            this.LZ = j;
        }

        public boolean lm() {
            return this.mIsRunning;
        }

        public void an(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int Mc;
        private int Md;
        private int mInterval;

        private b() {
        }

        public int ln() {
            return this.mInterval;
        }

        public void aj(int i) {
            this.mInterval = i;
        }

        public int lo() {
            return this.Mc;
        }

        public void ak(int i) {
            this.Mc = i;
        }

        public int lp() {
            return this.Md;
        }

        public void al(int i) {
            this.Md = i;
        }
    }
}
