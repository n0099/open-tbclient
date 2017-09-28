package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e wx;
    private HashMap<String, a> wv = new HashMap<>();
    private HashMap<String, b> ww = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.G(false);
                        aVar.H(false);
                        aVar.ap(0);
                        aVar.f(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e fV() {
        if (wx == null) {
            synchronized (e.class) {
                if (wx == null) {
                    wx = new e();
                }
            }
        }
        return wx;
    }

    public e() {
        b bVar = new b();
        bVar.aq(3000);
        bVar.ar(120000);
        bVar.as(500);
        this.ww.put("net", bVar);
        this.ww.put("op", bVar);
        this.ww.put("stat", bVar);
        this.ww.put("crash", bVar);
        this.ww.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.aq(3000);
        bVar2.ar(120000);
        bVar2.as(1500);
        this.ww.put("file", bVar2);
        this.ww.put("db", bVar2);
        this.ww.put("img", bVar2);
        this.ww.put("voice", bVar2);
        this.ww.put("error", bVar2);
        b bVar3 = new b();
        bVar3.aq(3000);
        bVar3.ar(120000);
        bVar3.as(1500);
        this.ww.put("dbg", bVar3);
    }

    public synchronized boolean ao(String str) {
        a aVar;
        boolean z;
        b bVar = this.ww.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.wv.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.H(false);
                aVar3.G(false);
                aVar3.f(currentTimeMillis);
                this.wv.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.fW()) {
                z = true;
            } else {
                if (aVar.ga()) {
                    aVar.ap(aVar.fY() + 1);
                    if (currentTimeMillis - aVar.fX() < bVar.gd()) {
                        if (aVar.fY() >= bVar.ge()) {
                            aVar.G(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.H(false);
                        aVar.ap(0);
                        aVar.f(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.fZ() < bVar.gb()) {
                    aVar.H(true);
                    aVar.e(currentTimeMillis);
                } else {
                    aVar.f(currentTimeMillis);
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
        private boolean wA;
        private long wB;
        private boolean wC;
        private long wz;

        private a() {
            this.wA = false;
            this.mCount = 0;
            this.wC = false;
        }

        public boolean fW() {
            return this.wC;
        }

        public void G(boolean z) {
            this.wC = z;
        }

        public long fX() {
            return this.wB;
        }

        public void e(long j) {
            this.wB = j;
        }

        public int fY() {
            return this.mCount;
        }

        public void ap(int i) {
            this.mCount = i;
        }

        public long fZ() {
            return this.wz;
        }

        public void f(long j) {
            this.wz = j;
        }

        public boolean ga() {
            return this.wA;
        }

        public void H(boolean z) {
            this.wA = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int wD;
        private int wE;
        private int wF;

        private b() {
        }

        public int gb() {
            return this.wD;
        }

        public void aq(int i) {
            this.wD = i;
        }

        public int gd() {
            return this.wE;
        }

        public void ar(int i) {
            this.wE = i;
        }

        public int ge() {
            return this.wF;
        }

        public void as(int i) {
            this.wF = i;
        }
    }
}
