package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e My;
    private HashMap<String, a> Mw = new HashMap<>();
    private HashMap<String, b> Mx = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.an(false);
                        aVar.ao(false);
                        aVar.ao(0);
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
        if (My == null) {
            synchronized (e.class) {
                if (My == null) {
                    My = new e();
                }
            }
        }
        return My;
    }

    public e() {
        b bVar = new b();
        bVar.ap(3000);
        bVar.aq(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.ar(500);
        this.Mx.put("net", bVar);
        this.Mx.put("op", bVar);
        this.Mx.put("stat", bVar);
        this.Mx.put("crash", bVar);
        this.Mx.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.ap(3000);
        bVar2.aq(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.ar(1500);
        this.Mx.put("file", bVar2);
        this.Mx.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.Mx.put("img", bVar2);
        this.Mx.put("voice", bVar2);
        this.Mx.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.ap(3000);
        bVar3.aq(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.ar(1500);
        this.Mx.put("dbg", bVar3);
    }

    public synchronized boolean bR(String str) {
        a aVar;
        boolean z;
        b bVar = this.Mx.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.Mw.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.ao(false);
                aVar3.an(false);
                aVar3.I(currentTimeMillis);
                this.Mw.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.ly()) {
                z = true;
            } else {
                if (aVar.lC()) {
                    aVar.ao(aVar.lA() + 1);
                    if (currentTimeMillis - aVar.lz() < bVar.lE()) {
                        if (aVar.lA() >= bVar.lF()) {
                            aVar.an(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, BdStatsConstant.ErrorCode.ERR_LOG_FAST, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.ao(false);
                        aVar.ao(0);
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
        private long MC;
        private boolean MD;
        private int mCount;
        private boolean mIsRunning;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.MD = false;
        }

        public boolean ly() {
            return this.MD;
        }

        public void an(boolean z) {
            this.MD = z;
        }

        public long lz() {
            return this.MC;
        }

        public void H(long j) {
            this.MC = j;
        }

        public int lA() {
            return this.mCount;
        }

        public void ao(int i) {
            this.mCount = i;
        }

        public long lB() {
            return this.MA;
        }

        public void I(long j) {
            this.MA = j;
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
        private int ME;
        private int MF;
        private int mInterval;

        private b() {
        }

        public int lD() {
            return this.mInterval;
        }

        public void ap(int i) {
            this.mInterval = i;
        }

        public int lE() {
            return this.ME;
        }

        public void aq(int i) {
            this.ME = i;
        }

        public int lF() {
            return this.MF;
        }

        public void ar(int i) {
            this.MF = i;
        }
    }
}
