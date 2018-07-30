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
    private static e Bi;
    private HashMap<String, a> Bg = new HashMap<>();
    private HashMap<String, b> Bh = new HashMap<>();
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
        if (Bi == null) {
            synchronized (e.class) {
                if (Bi == null) {
                    Bi = new e();
                }
            }
        }
        return Bi;
    }

    public e() {
        b bVar = new b();
        bVar.al(3000);
        bVar.am(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.an(500);
        this.Bh.put("net", bVar);
        this.Bh.put(j.d, bVar);
        this.Bh.put("stat", bVar);
        this.Bh.put("crash", bVar);
        this.Bh.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.al(3000);
        bVar2.am(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.an(TbConfig.POST_IMAGE_SMALL);
        this.Bh.put("file", bVar2);
        this.Bh.put("db", bVar2);
        this.Bh.put(SocialConstants.PARAM_IMG_URL, bVar2);
        this.Bh.put("voice", bVar2);
        this.Bh.put("error", bVar2);
        b bVar3 = new b();
        bVar3.al(3000);
        bVar3.am(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.an(TbConfig.POST_IMAGE_SMALL);
        this.Bh.put("dbg", bVar3);
    }

    public synchronized boolean aI(String str) {
        a aVar;
        boolean z;
        b bVar = this.Bh.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.Bg.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.L(false);
                aVar3.K(false);
                aVar3.j(currentTimeMillis);
                this.Bg.put(str, aVar3);
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
        private long Bk;
        private boolean Bl;
        private long Bm;
        private boolean Bn;
        private int mCount;

        private a() {
            this.Bl = false;
            this.mCount = 0;
            this.Bn = false;
        }

        public boolean iu() {
            return this.Bn;
        }

        public void K(boolean z) {
            this.Bn = z;
        }

        public long iv() {
            return this.Bm;
        }

        public void i(long j) {
            this.Bm = j;
        }

        public int iw() {
            return this.mCount;
        }

        public void ak(int i) {
            this.mCount = i;
        }

        public long ix() {
            return this.Bk;
        }

        public void j(long j) {
            this.Bk = j;
        }

        public boolean iy() {
            return this.Bl;
        }

        public void L(boolean z) {
            this.Bl = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int Bo;
        private int Bp;
        private int Bq;

        private b() {
        }

        public int iz() {
            return this.Bo;
        }

        public void al(int i) {
            this.Bo = i;
        }

        public int iA() {
            return this.Bp;
        }

        public void am(int i) {
            this.Bp = i;
        }

        public int iB() {
            return this.Bq;
        }

        public void an(int i) {
            this.Bq = i;
        }
    }
}
