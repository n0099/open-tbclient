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
    private static e Em;
    private HashMap<String, a> Ek = new HashMap<>();
    private HashMap<String, b> El = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.U(false);
                        aVar.V(false);
                        aVar.as(0);
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
        if (Em == null) {
            synchronized (e.class) {
                if (Em == null) {
                    Em = new e();
                }
            }
        }
        return Em;
    }

    public e() {
        b bVar = new b();
        bVar.at(3000);
        bVar.au(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.av(500);
        this.El.put("net", bVar);
        this.El.put("op", bVar);
        this.El.put("stat", bVar);
        this.El.put("crash", bVar);
        this.El.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.at(3000);
        bVar2.au(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.av(TbConfig.POST_IMAGE_SMALL);
        this.El.put("file", bVar2);
        this.El.put("db", bVar2);
        this.El.put(SocialConstants.PARAM_IMG_URL, bVar2);
        this.El.put("voice", bVar2);
        this.El.put(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, bVar2);
        b bVar3 = new b();
        bVar3.at(3000);
        bVar3.au(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.av(TbConfig.POST_IMAGE_SMALL);
        this.El.put("dbg", bVar3);
    }

    public synchronized boolean aY(String str) {
        a aVar;
        boolean z;
        b bVar = this.El.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.Ek.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.V(false);
                aVar3.U(false);
                aVar3.m(currentTimeMillis);
                this.Ek.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.jO()) {
                z = true;
            } else {
                if (aVar.jS()) {
                    aVar.as(aVar.jQ() + 1);
                    if (currentTimeMillis - aVar.jP() < bVar.jU()) {
                        if (aVar.jQ() >= bVar.jV()) {
                            aVar.U(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.V(false);
                        aVar.as(0);
                        aVar.m(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.jR() < bVar.jT()) {
                    aVar.V(true);
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
        private long Eo;
        private boolean Ep;
        private long Eq;
        private boolean Er;
        private int mCount;

        private a() {
            this.Ep = false;
            this.mCount = 0;
            this.Er = false;
        }

        public boolean jO() {
            return this.Er;
        }

        public void U(boolean z) {
            this.Er = z;
        }

        public long jP() {
            return this.Eq;
        }

        public void l(long j) {
            this.Eq = j;
        }

        public int jQ() {
            return this.mCount;
        }

        public void as(int i) {
            this.mCount = i;
        }

        public long jR() {
            return this.Eo;
        }

        public void m(long j) {
            this.Eo = j;
        }

        public boolean jS() {
            return this.Ep;
        }

        public void V(boolean z) {
            this.Ep = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int Es;
        private int Et;
        private int Eu;

        private b() {
        }

        public int jT() {
            return this.Es;
        }

        public void at(int i) {
            this.Es = i;
        }

        public int jU() {
            return this.Et;
        }

        public void au(int i) {
            this.Et = i;
        }

        public int jV() {
            return this.Eu;
        }

        public void av(int i) {
            this.Eu = i;
        }
    }
}
