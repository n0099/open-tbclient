package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e Nv;
    private HashMap<String, a> Nt = new HashMap<>();
    private HashMap<String, b> Nu = new HashMap<>();
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

    public static e nb() {
        if (Nv == null) {
            synchronized (e.class) {
                if (Nv == null) {
                    Nv = new e();
                }
            }
        }
        return Nv;
    }

    public e() {
        b bVar = new b();
        bVar.aw(3000);
        bVar.ax(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.ay(500);
        this.Nu.put("net", bVar);
        this.Nu.put("op", bVar);
        this.Nu.put("stat", bVar);
        this.Nu.put("crash", bVar);
        this.Nu.put(BdStatsConstant.StatsType.PERFORMANCE, bVar);
        b bVar2 = new b();
        bVar2.aw(3000);
        bVar2.ax(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.ay(1500);
        this.Nu.put("file", bVar2);
        this.Nu.put(BdStatsConstant.OpSubType.DB, bVar2);
        this.Nu.put("img", bVar2);
        this.Nu.put("voice", bVar2);
        this.Nu.put(BdStatsConstant.StatsType.ERROR, bVar2);
        b bVar3 = new b();
        bVar3.aw(3000);
        bVar3.ax(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.ay(1500);
        this.Nu.put("dbg", bVar3);
    }

    public synchronized boolean bW(String str) {
        a aVar;
        boolean z;
        b bVar = this.Nu.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.Nt.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.ap(false);
                aVar3.ao(false);
                aVar3.I(currentTimeMillis);
                this.Nt.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.nc()) {
                z = true;
            } else {
                if (aVar.ng()) {
                    aVar.av(aVar.ne() + 1);
                    if (currentTimeMillis - aVar.nd() < bVar.ni()) {
                        if (aVar.ne() >= bVar.nj()) {
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
                } else if (currentTimeMillis - aVar.nf() < bVar.nh()) {
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
        private long Nx;
        private long Ny;
        private boolean Nz;
        private int mCount;
        private boolean mIsRunning;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.Nz = false;
        }

        public boolean nc() {
            return this.Nz;
        }

        public void ao(boolean z) {
            this.Nz = z;
        }

        public long nd() {
            return this.Ny;
        }

        public void H(long j) {
            this.Ny = j;
        }

        public int ne() {
            return this.mCount;
        }

        public void av(int i) {
            this.mCount = i;
        }

        public long nf() {
            return this.Nx;
        }

        public void I(long j) {
            this.Nx = j;
        }

        public boolean ng() {
            return this.mIsRunning;
        }

        public void ap(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int NA;
        private int NB;
        private int mInterval;

        private b() {
        }

        public int nh() {
            return this.mInterval;
        }

        public void aw(int i) {
            this.mInterval = i;
        }

        public int ni() {
            return this.NA;
        }

        public void ax(int i) {
            this.NA = i;
        }

        public int nj() {
            return this.NB;
        }

        public void ay(int i) {
            this.NB = i;
        }
    }
}
