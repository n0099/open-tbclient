package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e Nd;
    private HashMap<String, a> Nb = new HashMap<>();
    private HashMap<String, b> Nc = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.ao(false);
                        aVar.ap(false);
                        aVar.as(0);
                        aVar.I(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e mW() {
        if (Nd == null) {
            synchronized (e.class) {
                if (Nd == null) {
                    Nd = new e();
                }
            }
        }
        return Nd;
    }

    public e() {
        b bVar = new b();
        bVar.at(3000);
        bVar.au(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.av(500);
        this.Nc.put("net", bVar);
        this.Nc.put("op", bVar);
        this.Nc.put("stat", bVar);
        this.Nc.put("crash", bVar);
        this.Nc.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.at(3000);
        bVar2.au(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.av(1500);
        this.Nc.put("file", bVar2);
        this.Nc.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.Nc.put("img", bVar2);
        this.Nc.put("voice", bVar2);
        this.Nc.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.at(3000);
        bVar3.au(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.av(1500);
        this.Nc.put("dbg", bVar3);
    }

    public synchronized boolean bU(String str) {
        a aVar;
        boolean z;
        b bVar = this.Nc.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.Nb.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.ap(false);
                aVar3.ao(false);
                aVar3.I(currentTimeMillis);
                this.Nb.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.mX()) {
                z = true;
            } else {
                if (aVar.nb()) {
                    aVar.as(aVar.mZ() + 1);
                    if (currentTimeMillis - aVar.mY() < bVar.nd()) {
                        if (aVar.mZ() >= bVar.ne()) {
                            aVar.ao(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, BdStatsConstant.ErrorCode.ERR_LOG_FAST, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.ap(false);
                        aVar.as(0);
                        aVar.I(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.na() < bVar.nc()) {
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
        private long Nf;
        private long Ng;
        private boolean Nh;
        private int mCount;
        private boolean mIsRunning;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.Nh = false;
        }

        public boolean mX() {
            return this.Nh;
        }

        public void ao(boolean z) {
            this.Nh = z;
        }

        public long mY() {
            return this.Ng;
        }

        public void H(long j) {
            this.Ng = j;
        }

        public int mZ() {
            return this.mCount;
        }

        public void as(int i) {
            this.mCount = i;
        }

        public long na() {
            return this.Nf;
        }

        public void I(long j) {
            this.Nf = j;
        }

        public boolean nb() {
            return this.mIsRunning;
        }

        public void ap(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int Ni;
        private int Nj;
        private int mInterval;

        private b() {
        }

        public int nc() {
            return this.mInterval;
        }

        public void at(int i) {
            this.mInterval = i;
        }

        public int nd() {
            return this.Ni;
        }

        public void au(int i) {
            this.Ni = i;
        }

        public int ne() {
            return this.Nj;
        }

        public void av(int i) {
            this.Nj = i;
        }
    }
}
