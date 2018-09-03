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
    private static e Bj;
    private HashMap<String, a> Bh = new HashMap<>();
    private HashMap<String, b> Bi = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.K(false);
                        aVar.L(false);
                        aVar.ak(0);
                        aVar.j(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e it() {
        if (Bj == null) {
            synchronized (e.class) {
                if (Bj == null) {
                    Bj = new e();
                }
            }
        }
        return Bj;
    }

    public e() {
        b bVar = new b();
        bVar.al(3000);
        bVar.am(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.an(500);
        this.Bi.put("net", bVar);
        this.Bi.put(j.d, bVar);
        this.Bi.put("stat", bVar);
        this.Bi.put("crash", bVar);
        this.Bi.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.al(3000);
        bVar2.am(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.an(TbConfig.POST_IMAGE_SMALL);
        this.Bi.put("file", bVar2);
        this.Bi.put("db", bVar2);
        this.Bi.put(SocialConstants.PARAM_IMG_URL, bVar2);
        this.Bi.put("voice", bVar2);
        this.Bi.put("error", bVar2);
        b bVar3 = new b();
        bVar3.al(3000);
        bVar3.am(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.an(TbConfig.POST_IMAGE_SMALL);
        this.Bi.put("dbg", bVar3);
    }

    public synchronized boolean aI(String str) {
        a aVar;
        boolean z;
        b bVar = this.Bi.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.Bh.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.L(false);
                aVar3.K(false);
                aVar3.j(currentTimeMillis);
                this.Bh.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.iu()) {
                z = true;
            } else {
                if (aVar.iy()) {
                    aVar.ak(aVar.iw() + 1);
                    if (currentTimeMillis - aVar.iv() < bVar.iA()) {
                        if (aVar.iw() >= bVar.iB()) {
                            aVar.K(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.L(false);
                        aVar.ak(0);
                        aVar.j(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.ix() < bVar.iz()) {
                    aVar.L(true);
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
        private long Bl;
        private boolean Bm;
        private long Bn;
        private boolean Bo;
        private int mCount;

        private a() {
            this.Bm = false;
            this.mCount = 0;
            this.Bo = false;
        }

        public boolean iu() {
            return this.Bo;
        }

        public void K(boolean z) {
            this.Bo = z;
        }

        public long iv() {
            return this.Bn;
        }

        public void i(long j) {
            this.Bn = j;
        }

        public int iw() {
            return this.mCount;
        }

        public void ak(int i) {
            this.mCount = i;
        }

        public long ix() {
            return this.Bl;
        }

        public void j(long j) {
            this.Bl = j;
        }

        public boolean iy() {
            return this.Bm;
        }

        public void L(boolean z) {
            this.Bm = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int Bp;
        private int Bq;
        private int Br;

        private b() {
        }

        public int iz() {
            return this.Bp;
        }

        public void al(int i) {
            this.Bp = i;
        }

        public int iA() {
            return this.Bq;
        }

        public void am(int i) {
            this.Bq = i;
        }

        public int iB() {
            return this.Br;
        }

        public void an(int i) {
            this.Br = i;
        }
    }
}
