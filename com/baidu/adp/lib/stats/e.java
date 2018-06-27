package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.fsg.base.statistics.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e Bn;
    private HashMap<String, a> Bl = new HashMap<>();
    private HashMap<String, b> Bm = new HashMap<>();
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
        if (Bn == null) {
            synchronized (e.class) {
                if (Bn == null) {
                    Bn = new e();
                }
            }
        }
        return Bn;
    }

    public e() {
        b bVar = new b();
        bVar.ak(3000);
        bVar.al(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.am(500);
        this.Bm.put("net", bVar);
        this.Bm.put(j.d, bVar);
        this.Bm.put("stat", bVar);
        this.Bm.put("crash", bVar);
        this.Bm.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.ak(3000);
        bVar2.al(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.am(TbConfig.POST_IMAGE_SMALL);
        this.Bm.put("file", bVar2);
        this.Bm.put("db", bVar2);
        this.Bm.put(SocialConstants.PARAM_IMG_URL, bVar2);
        this.Bm.put("voice", bVar2);
        this.Bm.put("error", bVar2);
        b bVar3 = new b();
        bVar3.ak(3000);
        bVar3.al(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.am(TbConfig.POST_IMAGE_SMALL);
        this.Bm.put("dbg", bVar3);
    }

    public synchronized boolean aH(String str) {
        a aVar;
        boolean z;
        b bVar = this.Bm.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.Bl.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.M(false);
                aVar3.L(false);
                aVar3.j(currentTimeMillis);
                this.Bl.put(str, aVar3);
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
        private long Bp;
        private boolean Bq;
        private long Br;
        private boolean Bs;
        private int mCount;

        private a() {
            this.Bq = false;
            this.mCount = 0;
            this.Bs = false;
        }

        public boolean it() {
            return this.Bs;
        }

        public void L(boolean z) {
            this.Bs = z;
        }

        public long iu() {
            return this.Br;
        }

        public void i(long j) {
            this.Br = j;
        }

        public int iv() {
            return this.mCount;
        }

        public void aj(int i) {
            this.mCount = i;
        }

        public long iw() {
            return this.Bp;
        }

        public void j(long j) {
            this.Bp = j;
        }

        public boolean ix() {
            return this.Bq;
        }

        public void M(boolean z) {
            this.Bq = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int Bt;
        private int Bu;
        private int Bv;

        private b() {
        }

        public int iy() {
            return this.Bt;
        }

        public void ak(int i) {
            this.Bt = i;
        }

        public int iz() {
            return this.Bu;
        }

        public void al(int i) {
            this.Bu = i;
        }

        public int iA() {
            return this.Bv;
        }

        public void am(int i) {
            this.Bv = i;
        }
    }
}
