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
    private static e DD;
    private HashMap<String, a> DB = new HashMap<>();
    private HashMap<String, b> DC = new HashMap<>();
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

    public static e jz() {
        if (DD == null) {
            synchronized (e.class) {
                if (DD == null) {
                    DD = new e();
                }
            }
        }
        return DD;
    }

    public e() {
        b bVar = new b();
        bVar.at(3000);
        bVar.au(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.av(500);
        this.DC.put("net", bVar);
        this.DC.put("op", bVar);
        this.DC.put("stat", bVar);
        this.DC.put("crash", bVar);
        this.DC.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.at(3000);
        bVar2.au(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.av(TbConfig.POST_IMAGE_SMALL);
        this.DC.put("file", bVar2);
        this.DC.put("db", bVar2);
        this.DC.put(SocialConstants.PARAM_IMG_URL, bVar2);
        this.DC.put("voice", bVar2);
        this.DC.put("error", bVar2);
        b bVar3 = new b();
        bVar3.at(3000);
        bVar3.au(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.av(TbConfig.POST_IMAGE_SMALL);
        this.DC.put("dbg", bVar3);
    }

    public synchronized boolean aZ(String str) {
        a aVar;
        boolean z;
        b bVar = this.DC.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.DB.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.V(false);
                aVar3.U(false);
                aVar3.m(currentTimeMillis);
                this.DB.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.jA()) {
                z = true;
            } else {
                if (aVar.jE()) {
                    aVar.as(aVar.jC() + 1);
                    if (currentTimeMillis - aVar.jB() < bVar.jG()) {
                        if (aVar.jC() >= bVar.jH()) {
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
                } else if (currentTimeMillis - aVar.jD() < bVar.jF()) {
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
        private long DF;
        private boolean DG;
        private long DH;
        private boolean DI;
        private int mCount;

        private a() {
            this.DG = false;
            this.mCount = 0;
            this.DI = false;
        }

        public boolean jA() {
            return this.DI;
        }

        public void U(boolean z) {
            this.DI = z;
        }

        public long jB() {
            return this.DH;
        }

        public void l(long j) {
            this.DH = j;
        }

        public int jC() {
            return this.mCount;
        }

        public void as(int i) {
            this.mCount = i;
        }

        public long jD() {
            return this.DF;
        }

        public void m(long j) {
            this.DF = j;
        }

        public boolean jE() {
            return this.DG;
        }

        public void V(boolean z) {
            this.DG = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int DJ;
        private int DK;
        private int DL;

        private b() {
        }

        public int jF() {
            return this.DJ;
        }

        public void at(int i) {
            this.DJ = i;
        }

        public int jG() {
            return this.DK;
        }

        public void au(int i) {
            this.DK = i;
        }

        public int jH() {
            return this.DL;
        }

        public void av(int i) {
            this.DL = i;
        }
    }
}
