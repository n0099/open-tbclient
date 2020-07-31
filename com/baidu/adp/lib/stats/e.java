package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e Mx;
    private HashMap<String, a> Mv = new HashMap<>();
    private HashMap<String, b> Mw = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.an(false);
                        aVar.ao(false);
                        aVar.aq(0);
                        aVar.I(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e lx() {
        if (Mx == null) {
            synchronized (e.class) {
                if (Mx == null) {
                    Mx = new e();
                }
            }
        }
        return Mx;
    }

    public e() {
        b bVar = new b();
        bVar.ar(3000);
        bVar.as(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.at(500);
        this.Mw.put("net", bVar);
        this.Mw.put("op", bVar);
        this.Mw.put("stat", bVar);
        this.Mw.put("crash", bVar);
        this.Mw.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.ar(3000);
        bVar2.as(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.at(1500);
        this.Mw.put("file", bVar2);
        this.Mw.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.Mw.put("img", bVar2);
        this.Mw.put("voice", bVar2);
        this.Mw.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.ar(3000);
        bVar3.as(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.at(1500);
        this.Mw.put("dbg", bVar3);
    }

    public synchronized boolean bP(String str) {
        a aVar;
        boolean z;
        b bVar = this.Mw.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.Mv.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.ao(false);
                aVar3.an(false);
                aVar3.I(currentTimeMillis);
                this.Mv.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.ly()) {
                z = true;
            } else {
                if (aVar.lC()) {
                    aVar.aq(aVar.lA() + 1);
                    if (currentTimeMillis - aVar.lz() < bVar.lE()) {
                        if (aVar.lA() >= bVar.lF()) {
                            aVar.an(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, BdStatsConstant.ErrorCode.ERR_LOG_FAST, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.ao(false);
                        aVar.aq(0);
                        aVar.I(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.lB() < bVar.lD()) {
                    aVar.ao(true);
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
        private long MA;
        private boolean MC;
        private long Mz;
        private int mCount;
        private boolean mIsRunning;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.MC = false;
        }

        public boolean ly() {
            return this.MC;
        }

        public void an(boolean z) {
            this.MC = z;
        }

        public long lz() {
            return this.MA;
        }

        public void H(long j) {
            this.MA = j;
        }

        public int lA() {
            return this.mCount;
        }

        public void aq(int i) {
            this.mCount = i;
        }

        public long lB() {
            return this.Mz;
        }

        public void I(long j) {
            this.Mz = j;
        }

        public boolean lC() {
            return this.mIsRunning;
        }

        public void ao(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int MD;
        private int ME;
        private int mInterval;

        private b() {
        }

        public int lD() {
            return this.mInterval;
        }

        public void ar(int i) {
            this.mInterval = i;
        }

        public int lE() {
            return this.MD;
        }

        public void as(int i) {
            this.MD = i;
        }

        public int lF() {
            return this.ME;
        }

        public void at(int i) {
            this.ME = i;
        }
    }
}
