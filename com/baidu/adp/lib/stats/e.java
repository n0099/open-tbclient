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
    private static e akJ;
    private HashMap<String, a> akH = new HashMap<>();
    private HashMap<String, b> akI = new HashMap<>();
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
        if (akJ == null) {
            synchronized (e.class) {
                if (akJ == null) {
                    akJ = new e();
                }
            }
        }
        return akJ;
    }

    public e() {
        b bVar = new b();
        bVar.dj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar.dk(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.dl(500);
        this.akI.put("net", bVar);
        this.akI.put(j.d, bVar);
        this.akI.put("stat", bVar);
        this.akI.put("crash", bVar);
        this.akI.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.dj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar2.dk(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.dl(TbConfig.POST_IMAGE_SMALL);
        this.akI.put("file", bVar2);
        this.akI.put("db", bVar2);
        this.akI.put("img", bVar2);
        this.akI.put("voice", bVar2);
        this.akI.put("error", bVar2);
        b bVar3 = new b();
        bVar3.dj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar3.dk(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.dl(TbConfig.POST_IMAGE_SMALL);
        this.akI.put("dbg", bVar3);
    }

    public synchronized boolean aw(String str) {
        a aVar;
        boolean z;
        b bVar = this.akI.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.akH.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.ar(false);
                aVar3.aq(false);
                aVar3.p(currentTimeMillis);
                this.akH.put(str, aVar3);
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
        private long akL;
        private long akM;
        private boolean akN;
        private int mCount;
        private boolean sx;

        private a() {
            this.sx = false;
            this.mCount = 0;
            this.akN = false;
        }

        public boolean nz() {
            return this.akN;
        }

        public void aq(boolean z) {
            this.akN = z;
        }

        public long nA() {
            return this.akM;
        }

        public void o(long j) {
            this.akM = j;
        }

        public int nB() {
            return this.mCount;
        }

        public void di(int i) {
            this.mCount = i;
        }

        public long nC() {
            return this.akL;
        }

        public void p(long j) {
            this.akL = j;
        }

        public boolean nD() {
            return this.sx;
        }

        public void ar(boolean z) {
            this.sx = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int akO;
        private int akP;
        private int akQ;

        private b() {
        }

        public int nE() {
            return this.akO;
        }

        public void dj(int i) {
            this.akO = i;
        }

        public int nF() {
            return this.akP;
        }

        public void dk(int i) {
            this.akP = i;
        }

        public int nG() {
            return this.akQ;
        }

        public void dl(int i) {
            this.akQ = i;
        }
    }
}
