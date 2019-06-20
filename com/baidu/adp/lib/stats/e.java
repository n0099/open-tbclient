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
    private static e BX;
    private HashMap<String, a> BV = new HashMap<>();
    private HashMap<String, b> BW = new HashMap<>();
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
        if (BX == null) {
            synchronized (e.class) {
                if (BX == null) {
                    BX = new e();
                }
            }
        }
        return BX;
    }

    public e() {
        b bVar = new b();
        bVar.am(3000);
        bVar.an(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.ao(500);
        this.BW.put("net", bVar);
        this.BW.put(Config.OPERATOR, bVar);
        this.BW.put("stat", bVar);
        this.BW.put("crash", bVar);
        this.BW.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.am(3000);
        bVar2.an(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.ao(TbConfig.POST_IMAGE_SMALL);
        this.BW.put("file", bVar2);
        this.BW.put("db", bVar2);
        this.BW.put(SocialConstants.PARAM_IMG_URL, bVar2);
        this.BW.put("voice", bVar2);
        this.BW.put("error", bVar2);
        b bVar3 = new b();
        bVar3.am(3000);
        bVar3.an(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.ao(TbConfig.POST_IMAGE_SMALL);
        this.BW.put("dbg", bVar3);
    }

    public synchronized boolean aJ(String str) {
        a aVar;
        boolean z;
        b bVar = this.BW.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.BV.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.ab(false);
                aVar3.aa(false);
                aVar3.j(currentTimeMillis);
                this.BV.put(str, aVar3);
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
        private long BZ;
        private boolean Ca;
        private long Cb;
        private boolean Cc;
        private int mCount;

        private a() {
            this.Ca = false;
            this.mCount = 0;
            this.Cc = false;
        }

        public boolean iI() {
            return this.Cc;
        }

        public void aa(boolean z) {
            this.Cc = z;
        }

        public long iJ() {
            return this.Cb;
        }

        public void i(long j) {
            this.Cb = j;
        }

        public int iK() {
            return this.mCount;
        }

        public void al(int i) {
            this.mCount = i;
        }

        public long iL() {
            return this.BZ;
        }

        public void j(long j) {
            this.BZ = j;
        }

        public boolean iM() {
            return this.Ca;
        }

        public void ab(boolean z) {
            this.Ca = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int Cd;
        private int Ce;
        private int Cf;

        private b() {
        }

        public int iN() {
            return this.Cd;
        }

        public void am(int i) {
            this.Cd = i;
        }

        public int iO() {
            return this.Ce;
        }

        public void an(int i) {
            this.Ce = i;
        }

        public int iP() {
            return this.Cf;
        }

        public void ao(int i) {
            this.Cf = i;
        }
    }
}
