package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.fsg.base.statistics.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e akD;
    private HashMap<String, a> akB = new HashMap<>();
    private HashMap<String, b> akC = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.aq(false);
                        aVar.ar(false);
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
        if (akD == null) {
            synchronized (e.class) {
                if (akD == null) {
                    akD = new e();
                }
            }
        }
        return akD;
    }

    public e() {
        b bVar = new b();
        bVar.dj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar.dk(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.dl(500);
        this.akC.put("net", bVar);
        this.akC.put(j.d, bVar);
        this.akC.put("stat", bVar);
        this.akC.put("crash", bVar);
        this.akC.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.dj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar2.dk(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.dl(TbConfig.POST_IMAGE_SMALL);
        this.akC.put("file", bVar2);
        this.akC.put("db", bVar2);
        this.akC.put("img", bVar2);
        this.akC.put("voice", bVar2);
        this.akC.put("error", bVar2);
        b bVar3 = new b();
        bVar3.dj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar3.dk(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.dl(TbConfig.POST_IMAGE_SMALL);
        this.akC.put("dbg", bVar3);
    }

    public synchronized boolean aw(String str) {
        a aVar;
        boolean z;
        b bVar = this.akC.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.akB.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.ar(false);
                aVar3.aq(false);
                aVar3.p(currentTimeMillis);
                this.akB.put(str, aVar3);
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
                            aVar.aq(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.ar(false);
                        aVar.di(0);
                        aVar.p(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.nC() < bVar.nE()) {
                    aVar.ar(true);
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
        private long akF;
        private long akG;
        private boolean akH;
        private int mCount;
        private boolean sw;

        private a() {
            this.sw = false;
            this.mCount = 0;
            this.akH = false;
        }

        public boolean nz() {
            return this.akH;
        }

        public void aq(boolean z) {
            this.akH = z;
        }

        public long nA() {
            return this.akG;
        }

        public void o(long j) {
            this.akG = j;
        }

        public int nB() {
            return this.mCount;
        }

        public void di(int i) {
            this.mCount = i;
        }

        public long nC() {
            return this.akF;
        }

        public void p(long j) {
            this.akF = j;
        }

        public boolean nD() {
            return this.sw;
        }

        public void ar(boolean z) {
            this.sw = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int akI;
        private int akJ;
        private int akK;

        private b() {
        }

        public int nE() {
            return this.akI;
        }

        public void dj(int i) {
            this.akI = i;
        }

        public int nF() {
            return this.akJ;
        }

        public void dk(int i) {
            this.akJ = i;
        }

        public int nG() {
            return this.akK;
        }

        public void dl(int i) {
            this.akK = i;
        }
    }
}
