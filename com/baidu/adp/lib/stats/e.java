package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e BY;
    private HashMap<String, a> BW = new HashMap<>();
    private HashMap<String, b> BX = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.aa(false);
                        aVar.ab(false);
                        aVar.al(0);
                        aVar.j(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e iH() {
        if (BY == null) {
            synchronized (e.class) {
                if (BY == null) {
                    BY = new e();
                }
            }
        }
        return BY;
    }

    public e() {
        b bVar = new b();
        bVar.am(3000);
        bVar.an(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.ao(500);
        this.BX.put("net", bVar);
        this.BX.put(Config.OPERATOR, bVar);
        this.BX.put("stat", bVar);
        this.BX.put("crash", bVar);
        this.BX.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.am(3000);
        bVar2.an(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.ao(TbConfig.POST_IMAGE_SMALL);
        this.BX.put("file", bVar2);
        this.BX.put("db", bVar2);
        this.BX.put(SocialConstants.PARAM_IMG_URL, bVar2);
        this.BX.put("voice", bVar2);
        this.BX.put("error", bVar2);
        b bVar3 = new b();
        bVar3.am(3000);
        bVar3.an(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.ao(TbConfig.POST_IMAGE_SMALL);
        this.BX.put("dbg", bVar3);
    }

    public synchronized boolean aJ(String str) {
        a aVar;
        boolean z;
        b bVar = this.BX.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.BW.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.ab(false);
                aVar3.aa(false);
                aVar3.j(currentTimeMillis);
                this.BW.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.iI()) {
                z = true;
            } else {
                if (aVar.iM()) {
                    aVar.al(aVar.iK() + 1);
                    if (currentTimeMillis - aVar.iJ() < bVar.iO()) {
                        if (aVar.iK() >= bVar.iP()) {
                            aVar.aa(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.ab(false);
                        aVar.al(0);
                        aVar.j(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.iL() < bVar.iN()) {
                    aVar.ab(true);
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
        private long Ca;
        private boolean Cb;
        private long Cc;
        private boolean Cd;
        private int mCount;

        private a() {
            this.Cb = false;
            this.mCount = 0;
            this.Cd = false;
        }

        public boolean iI() {
            return this.Cd;
        }

        public void aa(boolean z) {
            this.Cd = z;
        }

        public long iJ() {
            return this.Cc;
        }

        public void i(long j) {
            this.Cc = j;
        }

        public int iK() {
            return this.mCount;
        }

        public void al(int i) {
            this.mCount = i;
        }

        public long iL() {
            return this.Ca;
        }

        public void j(long j) {
            this.Ca = j;
        }

        public boolean iM() {
            return this.Cb;
        }

        public void ab(boolean z) {
            this.Cb = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int Ce;
        private int Cf;
        private int Cg;

        private b() {
        }

        public int iN() {
            return this.Ce;
        }

        public void am(int i) {
            this.Ce = i;
        }

        public int iO() {
            return this.Cf;
        }

        public void an(int i) {
            this.Cf = i;
        }

        public int iP() {
            return this.Cg;
        }

        public void ao(int i) {
            this.Cg = i;
        }
    }
}
