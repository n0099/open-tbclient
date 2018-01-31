package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e akK;
    private HashMap<String, a> akI = new HashMap<>();
    private HashMap<String, b> akJ = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.an(false);
                        aVar.ao(false);
                        aVar.di(0);
                        aVar.p(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e ny() {
        if (akK == null) {
            synchronized (e.class) {
                if (akK == null) {
                    akK = new e();
                }
            }
        }
        return akK;
    }

    public e() {
        b bVar = new b();
        bVar.dj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar.dk(120000);
        bVar.dl(500);
        this.akJ.put("net", bVar);
        this.akJ.put("op", bVar);
        this.akJ.put("stat", bVar);
        this.akJ.put("crash", bVar);
        this.akJ.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.dj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar2.dk(120000);
        bVar2.dl(TbConfig.POST_IMAGE_SMALL);
        this.akJ.put("file", bVar2);
        this.akJ.put("db", bVar2);
        this.akJ.put("img", bVar2);
        this.akJ.put("voice", bVar2);
        this.akJ.put("error", bVar2);
        b bVar3 = new b();
        bVar3.dj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar3.dk(120000);
        bVar3.dl(TbConfig.POST_IMAGE_SMALL);
        this.akJ.put("dbg", bVar3);
    }

    public synchronized boolean aw(String str) {
        a aVar;
        boolean z;
        b bVar = this.akJ.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.akI.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.ao(false);
                aVar3.an(false);
                aVar3.p(currentTimeMillis);
                this.akI.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.nz()) {
                z = true;
            } else {
                if (aVar.nD()) {
                    aVar.di(aVar.nB() + 1);
                    if (currentTimeMillis - aVar.nA() < bVar.nF()) {
                        if (aVar.nB() >= bVar.nG()) {
                            aVar.an(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.ao(false);
                        aVar.di(0);
                        aVar.p(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.nC() < bVar.nE()) {
                    aVar.ao(true);
                    aVar.o(currentTimeMillis);
                } else {
                    aVar.p(currentTimeMillis);
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
        private long akM;
        private long akN;
        private boolean akO;
        private int mCount;
        private boolean sx;

        private a() {
            this.sx = false;
            this.mCount = 0;
            this.akO = false;
        }

        public boolean nz() {
            return this.akO;
        }

        public void an(boolean z) {
            this.akO = z;
        }

        public long nA() {
            return this.akN;
        }

        public void o(long j) {
            this.akN = j;
        }

        public int nB() {
            return this.mCount;
        }

        public void di(int i) {
            this.mCount = i;
        }

        public long nC() {
            return this.akM;
        }

        public void p(long j) {
            this.akM = j;
        }

        public boolean nD() {
            return this.sx;
        }

        public void ao(boolean z) {
            this.sx = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int akP;
        private int akQ;
        private int akR;

        private b() {
        }

        public int nE() {
            return this.akP;
        }

        public void dj(int i) {
            this.akP = i;
        }

        public int nF() {
            return this.akQ;
        }

        public void dk(int i) {
            this.akQ = i;
        }

        public int nG() {
            return this.akR;
        }

        public void dl(int i) {
            this.akR = i;
        }
    }
}
