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
    private static e akH;
    private HashMap<String, a> akF = new HashMap<>();
    private HashMap<String, b> akG = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.am(false);
                        aVar.an(false);
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

    public static e nx() {
        if (akH == null) {
            synchronized (e.class) {
                if (akH == null) {
                    akH = new e();
                }
            }
        }
        return akH;
    }

    public e() {
        b bVar = new b();
        bVar.dj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar.dk(120000);
        bVar.dl(500);
        this.akG.put("net", bVar);
        this.akG.put("op", bVar);
        this.akG.put("stat", bVar);
        this.akG.put("crash", bVar);
        this.akG.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.dj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar2.dk(120000);
        bVar2.dl(TbConfig.POST_IMAGE_SMALL);
        this.akG.put("file", bVar2);
        this.akG.put("db", bVar2);
        this.akG.put("img", bVar2);
        this.akG.put("voice", bVar2);
        this.akG.put("error", bVar2);
        b bVar3 = new b();
        bVar3.dj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar3.dk(120000);
        bVar3.dl(TbConfig.POST_IMAGE_SMALL);
        this.akG.put("dbg", bVar3);
    }

    public synchronized boolean aw(String str) {
        a aVar;
        boolean z;
        b bVar = this.akG.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.akF.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.an(false);
                aVar3.am(false);
                aVar3.p(currentTimeMillis);
                this.akF.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.ny()) {
                z = true;
            } else {
                if (aVar.nC()) {
                    aVar.di(aVar.nA() + 1);
                    if (currentTimeMillis - aVar.nz() < bVar.nE()) {
                        if (aVar.nA() >= bVar.nF()) {
                            aVar.am(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.an(false);
                        aVar.di(0);
                        aVar.p(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.nB() < bVar.nD()) {
                    aVar.an(true);
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
        private long akJ;
        private long akK;
        private boolean akL;
        private int mCount;
        private boolean sx;

        private a() {
            this.sx = false;
            this.mCount = 0;
            this.akL = false;
        }

        public boolean ny() {
            return this.akL;
        }

        public void am(boolean z) {
            this.akL = z;
        }

        public long nz() {
            return this.akK;
        }

        public void o(long j) {
            this.akK = j;
        }

        public int nA() {
            return this.mCount;
        }

        public void di(int i) {
            this.mCount = i;
        }

        public long nB() {
            return this.akJ;
        }

        public void p(long j) {
            this.akJ = j;
        }

        public boolean nC() {
            return this.sx;
        }

        public void an(boolean z) {
            this.sx = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int akM;
        private int akN;
        private int akO;

        private b() {
        }

        public int nD() {
            return this.akM;
        }

        public void dj(int i) {
            this.akM = i;
        }

        public int nE() {
            return this.akN;
        }

        public void dk(int i) {
            this.akN = i;
        }

        public int nF() {
            return this.akO;
        }

        public void dl(int i) {
            this.akO = i;
        }
    }
}
