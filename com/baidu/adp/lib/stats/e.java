package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e OH;
    private HashMap<String, a> OF = new HashMap<>();
    private HashMap<String, b> OG = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.an(false);
                        aVar.ao(false);
                        aVar.ay(0);
                        aVar.G(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e nc() {
        if (OH == null) {
            synchronized (e.class) {
                if (OH == null) {
                    OH = new e();
                }
            }
        }
        return OH;
    }

    public e() {
        b bVar = new b();
        bVar.az(3000);
        bVar.aA(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.aB(500);
        this.OG.put("net", bVar);
        this.OG.put("op", bVar);
        this.OG.put("stat", bVar);
        this.OG.put("crash", bVar);
        this.OG.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.az(3000);
        bVar2.aA(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.aB(1500);
        this.OG.put("file", bVar2);
        this.OG.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.OG.put("img", bVar2);
        this.OG.put("voice", bVar2);
        this.OG.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.az(3000);
        bVar3.aA(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.aB(1500);
        this.OG.put("dbg", bVar3);
    }

    public synchronized boolean bZ(String str) {
        a aVar;
        boolean z;
        b bVar = this.OG.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.OF.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.ao(false);
                aVar3.an(false);
                aVar3.G(currentTimeMillis);
                this.OF.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.nd()) {
                z = true;
            } else {
                if (aVar.nh()) {
                    aVar.ay(aVar.nf() + 1);
                    if (currentTimeMillis - aVar.ne() < bVar.nj()) {
                        if (aVar.nf() >= bVar.nk()) {
                            aVar.an(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, BdStatsConstant.ErrorCode.ERR_LOG_FAST, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.ao(false);
                        aVar.ay(0);
                        aVar.G(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.ng() < bVar.ni()) {
                    aVar.ao(true);
                    aVar.F(currentTimeMillis);
                } else {
                    aVar.G(currentTimeMillis);
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
        private long OJ;
        private long OL;
        private boolean OM;
        private int mCount;
        private boolean mIsRunning;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.OM = false;
        }

        public boolean nd() {
            return this.OM;
        }

        public void an(boolean z) {
            this.OM = z;
        }

        public long ne() {
            return this.OL;
        }

        public void F(long j) {
            this.OL = j;
        }

        public int nf() {
            return this.mCount;
        }

        public void ay(int i) {
            this.mCount = i;
        }

        public long ng() {
            return this.OJ;
        }

        public void G(long j) {
            this.OJ = j;
        }

        public boolean nh() {
            return this.mIsRunning;
        }

        public void ao(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int OO;
        private int OP;
        private int mInterval;

        private b() {
        }

        public int ni() {
            return this.mInterval;
        }

        public void az(int i) {
            this.mInterval = i;
        }

        public int nj() {
            return this.OO;
        }

        public void aA(int i) {
            this.OO = i;
        }

        public int nk() {
            return this.OP;
        }

        public void aB(int i) {
            this.OP = i;
        }
    }
}
