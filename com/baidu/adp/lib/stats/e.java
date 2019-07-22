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
    private static e Cd;
    private HashMap<String, a> Cb = new HashMap<>();
    private HashMap<String, b> Cc = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.ab(false);
                        aVar.ac(false);
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

    public static e iQ() {
        if (Cd == null) {
            synchronized (e.class) {
                if (Cd == null) {
                    Cd = new e();
                }
            }
        }
        return Cd;
    }

    public e() {
        b bVar = new b();
        bVar.am(3000);
        bVar.an(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar.ao(500);
        this.Cc.put("net", bVar);
        this.Cc.put(Config.OPERATOR, bVar);
        this.Cc.put("stat", bVar);
        this.Cc.put("crash", bVar);
        this.Cc.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.am(3000);
        bVar2.an(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar2.ao(TbConfig.POST_IMAGE_SMALL);
        this.Cc.put("file", bVar2);
        this.Cc.put("db", bVar2);
        this.Cc.put(SocialConstants.PARAM_IMG_URL, bVar2);
        this.Cc.put("voice", bVar2);
        this.Cc.put("error", bVar2);
        b bVar3 = new b();
        bVar3.am(3000);
        bVar3.an(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
        bVar3.ao(TbConfig.POST_IMAGE_SMALL);
        this.Cc.put("dbg", bVar3);
    }

    public synchronized boolean aK(String str) {
        a aVar;
        boolean z;
        b bVar = this.Cc.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.Cb.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.ac(false);
                aVar3.ab(false);
                aVar3.j(currentTimeMillis);
                this.Cb.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.iR()) {
                z = true;
            } else {
                if (aVar.iV()) {
                    aVar.al(aVar.iT() + 1);
                    if (currentTimeMillis - aVar.iS() < bVar.iX()) {
                        if (aVar.iT() >= bVar.iY()) {
                            aVar.ab(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.ac(false);
                        aVar.al(0);
                        aVar.j(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.iU() < bVar.iW()) {
                    aVar.ac(true);
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
        private long Cf;
        private boolean Cg;
        private long Ch;
        private boolean Ci;
        private int mCount;

        private a() {
            this.Cg = false;
            this.mCount = 0;
            this.Ci = false;
        }

        public boolean iR() {
            return this.Ci;
        }

        public void ab(boolean z) {
            this.Ci = z;
        }

        public long iS() {
            return this.Ch;
        }

        public void i(long j) {
            this.Ch = j;
        }

        public int iT() {
            return this.mCount;
        }

        public void al(int i) {
            this.mCount = i;
        }

        public long iU() {
            return this.Cf;
        }

        public void j(long j) {
            this.Cf = j;
        }

        public boolean iV() {
            return this.Cg;
        }

        public void ac(boolean z) {
            this.Cg = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int Cj;
        private int Ck;
        private int Cl;

        private b() {
        }

        public int iW() {
            return this.Cj;
        }

        public void am(int i) {
            this.Cj = i;
        }

        public int iX() {
            return this.Ck;
        }

        public void an(int i) {
            this.Ck = i;
        }

        public int iY() {
            return this.Cl;
        }

        public void ao(int i) {
            this.Cl = i;
        }
    }
}
