package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.fsg.base.statistics.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e Bl;
    private HashMap<String, a> Bj = new HashMap<>();
    private HashMap<String, b> Bk = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.L(false);
                        aVar.M(false);
                        aVar.aj(0);
                        aVar.j(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e is() {
        if (Bl == null) {
            synchronized (e.class) {
                if (Bl == null) {
                    Bl = new e();
                }
            }
        }
        return Bl;
    }

    public e() {
        b bVar = new b();
        bVar.ak(3000);
        bVar.al(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.am(500);
        this.Bk.put("net", bVar);
        this.Bk.put(j.d, bVar);
        this.Bk.put("stat", bVar);
        this.Bk.put("crash", bVar);
        this.Bk.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.ak(3000);
        bVar2.al(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.am(TbConfig.POST_IMAGE_SMALL);
        this.Bk.put("file", bVar2);
        this.Bk.put("db", bVar2);
        this.Bk.put("img", bVar2);
        this.Bk.put("voice", bVar2);
        this.Bk.put("error", bVar2);
        b bVar3 = new b();
        bVar3.ak(3000);
        bVar3.al(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.am(TbConfig.POST_IMAGE_SMALL);
        this.Bk.put("dbg", bVar3);
    }

    public synchronized boolean aF(String str) {
        a aVar;
        boolean z;
        b bVar = this.Bk.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.Bj.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.M(false);
                aVar3.L(false);
                aVar3.j(currentTimeMillis);
                this.Bj.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.it()) {
                z = true;
            } else {
                if (aVar.ix()) {
                    aVar.aj(aVar.iv() + 1);
                    if (currentTimeMillis - aVar.iu() < bVar.iz()) {
                        if (aVar.iv() >= bVar.iA()) {
                            aVar.L(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.M(false);
                        aVar.aj(0);
                        aVar.j(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.iw() < bVar.iy()) {
                    aVar.M(true);
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
        private long Bn;
        private boolean Bo;
        private long Bp;
        private boolean Bq;
        private int mCount;

        private a() {
            this.Bo = false;
            this.mCount = 0;
            this.Bq = false;
        }

        public boolean it() {
            return this.Bq;
        }

        public void L(boolean z) {
            this.Bq = z;
        }

        public long iu() {
            return this.Bp;
        }

        public void i(long j) {
            this.Bp = j;
        }

        public int iv() {
            return this.mCount;
        }

        public void aj(int i) {
            this.mCount = i;
        }

        public long iw() {
            return this.Bn;
        }

        public void j(long j) {
            this.Bn = j;
        }

        public boolean ix() {
            return this.Bo;
        }

        public void M(boolean z) {
            this.Bo = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int Br;
        private int Bs;
        private int Bt;

        private b() {
        }

        public int iy() {
            return this.Br;
        }

        public void ak(int i) {
            this.Br = i;
        }

        public int iz() {
            return this.Bs;
        }

        public void al(int i) {
            this.Bs = i;
        }

        public int iA() {
            return this.Bt;
        }

        public void am(int i) {
            this.Bt = i;
        }
    }
}
