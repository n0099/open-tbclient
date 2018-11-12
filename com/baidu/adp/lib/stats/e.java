package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e Eq;
    private HashMap<String, a> Eo = new HashMap<>();
    private HashMap<String, b> Ep = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.ai(false);
                        aVar.aj(false);
                        aVar.aJ(0);
                        aVar.o(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e jL() {
        if (Eq == null) {
            synchronized (e.class) {
                if (Eq == null) {
                    Eq = new e();
                }
            }
        }
        return Eq;
    }

    public e() {
        b bVar = new b();
        bVar.aK(3000);
        bVar.aL(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.aM(500);
        this.Ep.put("net", bVar);
        this.Ep.put("op", bVar);
        this.Ep.put("stat", bVar);
        this.Ep.put("crash", bVar);
        this.Ep.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.aK(3000);
        bVar2.aL(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.aM(TbConfig.POST_IMAGE_SMALL);
        this.Ep.put("file", bVar2);
        this.Ep.put("db", bVar2);
        this.Ep.put(SocialConstants.PARAM_IMG_URL, bVar2);
        this.Ep.put("voice", bVar2);
        this.Ep.put(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, bVar2);
        b bVar3 = new b();
        bVar3.aK(3000);
        bVar3.aL(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.aM(TbConfig.POST_IMAGE_SMALL);
        this.Ep.put("dbg", bVar3);
    }

    public synchronized boolean aY(String str) {
        a aVar;
        boolean z;
        b bVar = this.Ep.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.Eo.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.aj(false);
                aVar3.ai(false);
                aVar3.o(currentTimeMillis);
                this.Eo.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.jM()) {
                z = true;
            } else {
                if (aVar.jQ()) {
                    aVar.aJ(aVar.jO() + 1);
                    if (currentTimeMillis - aVar.jN() < bVar.jS()) {
                        if (aVar.jO() >= bVar.jT()) {
                            aVar.ai(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.aj(false);
                        aVar.aJ(0);
                        aVar.o(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.jP() < bVar.jR()) {
                    aVar.aj(true);
                    aVar.n(currentTimeMillis);
                } else {
                    aVar.o(currentTimeMillis);
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
        private long Es;
        private boolean Et;
        private long Eu;
        private boolean Ev;
        private int mCount;

        private a() {
            this.Et = false;
            this.mCount = 0;
            this.Ev = false;
        }

        public boolean jM() {
            return this.Ev;
        }

        public void ai(boolean z) {
            this.Ev = z;
        }

        public long jN() {
            return this.Eu;
        }

        public void n(long j) {
            this.Eu = j;
        }

        public int jO() {
            return this.mCount;
        }

        public void aJ(int i) {
            this.mCount = i;
        }

        public long jP() {
            return this.Es;
        }

        public void o(long j) {
            this.Es = j;
        }

        public boolean jQ() {
            return this.Et;
        }

        public void aj(boolean z) {
            this.Et = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int Ew;
        private int Ex;
        private int Ey;

        private b() {
        }

        public int jR() {
            return this.Ew;
        }

        public void aK(int i) {
            this.Ew = i;
        }

        public int jS() {
            return this.Ex;
        }

        public void aL(int i) {
            this.Ex = i;
        }

        public int jT() {
            return this.Ey;
        }

        public void aM(int i) {
            this.Ey = i;
        }
    }
}
