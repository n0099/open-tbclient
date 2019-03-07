package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e Ep;
    private HashMap<String, a> En = new HashMap<>();
    private HashMap<String, b> Eo = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.ai(false);
                        aVar.aj(false);
                        aVar.at(0);
                        aVar.m(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e jN() {
        if (Ep == null) {
            synchronized (e.class) {
                if (Ep == null) {
                    Ep = new e();
                }
            }
        }
        return Ep;
    }

    public e() {
        b bVar = new b();
        bVar.au(3000);
        bVar.av(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.aw(500);
        this.Eo.put("net", bVar);
        this.Eo.put("op", bVar);
        this.Eo.put("stat", bVar);
        this.Eo.put("crash", bVar);
        this.Eo.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.au(3000);
        bVar2.av(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.aw(TbConfig.POST_IMAGE_SMALL);
        this.Eo.put("file", bVar2);
        this.Eo.put("db", bVar2);
        this.Eo.put(SocialConstants.PARAM_IMG_URL, bVar2);
        this.Eo.put("voice", bVar2);
        this.Eo.put("error", bVar2);
        b bVar3 = new b();
        bVar3.au(3000);
        bVar3.av(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.aw(TbConfig.POST_IMAGE_SMALL);
        this.Eo.put("dbg", bVar3);
    }

    public synchronized boolean aZ(String str) {
        a aVar;
        boolean z;
        b bVar = this.Eo.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.En.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.aj(false);
                aVar3.ai(false);
                aVar3.m(currentTimeMillis);
                this.En.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.jO()) {
                z = true;
            } else {
                if (aVar.jS()) {
                    aVar.at(aVar.jQ() + 1);
                    if (currentTimeMillis - aVar.jP() < bVar.jU()) {
                        if (aVar.jQ() >= bVar.jV()) {
                            aVar.ai(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.aj(false);
                        aVar.at(0);
                        aVar.m(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.jR() < bVar.jT()) {
                    aVar.aj(true);
                    aVar.l(currentTimeMillis);
                } else {
                    aVar.m(currentTimeMillis);
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
        private long Er;
        private boolean Es;
        private long Et;
        private boolean Eu;
        private int mCount;

        private a() {
            this.Es = false;
            this.mCount = 0;
            this.Eu = false;
        }

        public boolean jO() {
            return this.Eu;
        }

        public void ai(boolean z) {
            this.Eu = z;
        }

        public long jP() {
            return this.Et;
        }

        public void l(long j) {
            this.Et = j;
        }

        public int jQ() {
            return this.mCount;
        }

        public void at(int i) {
            this.mCount = i;
        }

        public long jR() {
            return this.Er;
        }

        public void m(long j) {
            this.Er = j;
        }

        public boolean jS() {
            return this.Es;
        }

        public void aj(boolean z) {
            this.Es = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int Ev;
        private int Ew;
        private int Ex;

        private b() {
        }

        public int jT() {
            return this.Ev;
        }

        public void au(int i) {
            this.Ev = i;
        }

        public int jU() {
            return this.Ew;
        }

        public void av(int i) {
            this.Ew = i;
        }

        public int jV() {
            return this.Ex;
        }

        public void aw(int i) {
            this.Ex = i;
        }
    }
}
