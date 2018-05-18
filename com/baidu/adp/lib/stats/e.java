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
    private static e vg;
    private HashMap<String, a> ve = new HashMap<>();
    private HashMap<String, b> vf = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.J(false);
                        aVar.K(false);
                        aVar.ai(0);
                        aVar.h(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e fC() {
        if (vg == null) {
            synchronized (e.class) {
                if (vg == null) {
                    vg = new e();
                }
            }
        }
        return vg;
    }

    public e() {
        b bVar = new b();
        bVar.aj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar.ak(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.al(500);
        this.vf.put("net", bVar);
        this.vf.put(j.d, bVar);
        this.vf.put("stat", bVar);
        this.vf.put("crash", bVar);
        this.vf.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.aj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar2.ak(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.al(TbConfig.POST_IMAGE_SMALL);
        this.vf.put("file", bVar2);
        this.vf.put("db", bVar2);
        this.vf.put("img", bVar2);
        this.vf.put("voice", bVar2);
        this.vf.put("error", bVar2);
        b bVar3 = new b();
        bVar3.aj(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        bVar3.ak(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.al(TbConfig.POST_IMAGE_SMALL);
        this.vf.put("dbg", bVar3);
    }

    public synchronized boolean at(String str) {
        a aVar;
        boolean z;
        b bVar = this.vf.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.ve.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.K(false);
                aVar3.J(false);
                aVar3.h(currentTimeMillis);
                this.ve.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.fD()) {
                z = true;
            } else {
                if (aVar.fH()) {
                    aVar.ai(aVar.fF() + 1);
                    if (currentTimeMillis - aVar.fE() < bVar.fJ()) {
                        if (aVar.fF() >= bVar.fK()) {
                            aVar.J(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.K(false);
                        aVar.ai(0);
                        aVar.h(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.fG() < bVar.fI()) {
                    aVar.K(true);
                    aVar.g(currentTimeMillis);
                } else {
                    aVar.h(currentTimeMillis);
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
        private int mCount;
        private boolean mIsRunning;
        private long vi;
        private long vj;
        private boolean vk;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.vk = false;
        }

        public boolean fD() {
            return this.vk;
        }

        public void J(boolean z) {
            this.vk = z;
        }

        public long fE() {
            return this.vj;
        }

        public void g(long j) {
            this.vj = j;
        }

        public int fF() {
            return this.mCount;
        }

        public void ai(int i) {
            this.mCount = i;
        }

        public long fG() {
            return this.vi;
        }

        public void h(long j) {
            this.vi = j;
        }

        public boolean fH() {
            return this.mIsRunning;
        }

        public void K(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int vl;
        private int vm;
        private int vn;

        private b() {
        }

        public int fI() {
            return this.vl;
        }

        public void aj(int i) {
            this.vl = i;
        }

        public int fJ() {
            return this.vm;
        }

        public void ak(int i) {
            this.vm = i;
        }

        public int fK() {
            return this.vn;
        }

        public void al(int i) {
            this.vn = i;
        }
    }
}
