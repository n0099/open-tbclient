package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e qy;
    private HashMap<String, a> qw = new HashMap<>();
    private HashMap<String, b> qx = new HashMap<>();
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
                        aVar.j(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e gd() {
        if (qy == null) {
            synchronized (e.class) {
                if (qy == null) {
                    qy = new e();
                }
            }
        }
        return qy;
    }

    public e() {
        b bVar = new b();
        bVar.P(3000);
        bVar.Q(120000);
        bVar.R(500);
        this.qx.put("net", bVar);
        this.qx.put("op", bVar);
        this.qx.put("stat", bVar);
        this.qx.put("crash", bVar);
        this.qx.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.P(3000);
        bVar2.Q(120000);
        bVar2.R(1500);
        this.qx.put(BdStatsConstant.OpSubType.FILE, bVar2);
        this.qx.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.qx.put("img", bVar2);
        this.qx.put("voice", bVar2);
        this.qx.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.P(3000);
        bVar3.Q(120000);
        bVar3.R(1500);
        this.qx.put("dbg", bVar3);
    }

    public synchronized boolean ao(String str) {
        a aVar;
        boolean z;
        b bVar = this.qx.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.qw.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.G(false);
                aVar3.F(false);
                aVar3.j(currentTimeMillis);
                this.qw.put(str, aVar3);
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
                        aVar.j(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.gh() < bVar.gj()) {
                    aVar.G(true);
                    aVar.i(currentTimeMillis);
                } else {
                    aVar.j(currentTimeMillis);
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
        this.mHandler.sendMessageDelayed(obtainMessage, ReportUserInfoModel.TIME_INTERVAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private int mCount;
        private boolean mIsRunning;
        private long qA;
        private long qB;
        private boolean qC;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.qC = false;
        }

        public boolean ge() {
            return this.qC;
        }

        public void F(boolean z) {
            this.qC = z;
        }

        public long gf() {
            return this.qB;
        }

        public void i(long j) {
            this.qB = j;
        }

        public int gg() {
            return this.mCount;
        }

        public void O(int i) {
            this.mCount = i;
        }

        public long gh() {
            return this.qA;
        }

        public void j(long j) {
            this.qA = j;
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
        private int qD;
        private int qE;

        private b() {
        }

        public int gj() {
            return this.mInterval;
        }

        public void P(int i) {
            this.mInterval = i;
        }

        public int gk() {
            return this.qD;
        }

        public void Q(int i) {
            this.qD = i;
        }

        public int gl() {
            return this.qE;
        }

        public void R(int i) {
            this.qE = i;
        }
    }
}
