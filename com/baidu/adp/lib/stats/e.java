package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e NM;
    private HashMap<String, a> NK = new HashMap<>();
    private HashMap<String, b> NL = new HashMap<>();
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
        if (NM == null) {
            synchronized (e.class) {
                if (NM == null) {
                    NM = new e();
                }
            }
        }
        return NM;
    }

    public e() {
        b bVar = new b();
        bVar.aw(3000);
        bVar.ax(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.ay(500);
        this.NL.put("net", bVar);
        this.NL.put("op", bVar);
        this.NL.put("stat", bVar);
        this.NL.put("crash", bVar);
        this.NL.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.aw(3000);
        bVar2.ax(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.ay(1500);
        this.NL.put("file", bVar2);
        this.NL.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.NL.put("img", bVar2);
        this.NL.put("voice", bVar2);
        this.NL.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.aw(3000);
        bVar3.ax(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.ay(1500);
        this.NL.put("dbg", bVar3);
    }

    public synchronized boolean bW(String str) {
        a aVar;
        boolean z;
        b bVar = this.NL.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.NK.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.ap(false);
                aVar3.ao(false);
                aVar3.I(currentTimeMillis);
                this.NK.put(str, aVar3);
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
        private long NP;
        private long NQ;
        private boolean NR;
        private int mCount;
        private boolean mIsRunning;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.NR = false;
        }

        public boolean nd() {
            return this.NR;
        }

        public void ao(boolean z) {
            this.NR = z;
        }

        public long ne() {
            return this.NQ;
        }

        public void H(long j) {
            this.NQ = j;
        }

        public int nf() {
            return this.mCount;
        }

        public void av(int i) {
            this.mCount = i;
        }

        public long ng() {
            return this.NP;
        }

        public void I(long j) {
            this.NP = j;
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
        private int NT;
        private int NU;
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
            return this.NT;
        }

        public void ax(int i) {
            this.NT = i;
        }

        public int nk() {
            return this.NU;
        }

        public void ay(int i) {
            this.NU = i;
        }
    }
}
