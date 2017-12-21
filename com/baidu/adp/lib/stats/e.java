package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e ww;
    private HashMap<String, a> wu = new HashMap<>();
    private HashMap<String, b> wv = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.G(false);
                        aVar.H(false);
                        aVar.ao(0);
                        aVar.g(System.currentTimeMillis());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public static e fV() {
        if (ww == null) {
            synchronized (e.class) {
                if (ww == null) {
                    ww = new e();
                }
            }
        }
        return ww;
    }

    public e() {
        b bVar = new b();
        bVar.ap(3000);
        bVar.aq(120000);
        bVar.ar(500);
        this.wv.put("net", bVar);
        this.wv.put("op", bVar);
        this.wv.put("stat", bVar);
        this.wv.put("crash", bVar);
        this.wv.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.ap(3000);
        bVar2.aq(120000);
        bVar2.ar(TbConfig.POST_IMAGE_SMALL);
        this.wv.put("file", bVar2);
        this.wv.put("db", bVar2);
        this.wv.put("img", bVar2);
        this.wv.put("voice", bVar2);
        this.wv.put("error", bVar2);
        b bVar3 = new b();
        bVar3.ap(3000);
        bVar3.aq(120000);
        bVar3.ar(TbConfig.POST_IMAGE_SMALL);
        this.wv.put("dbg", bVar3);
    }

    public synchronized boolean ao(String str) {
        a aVar;
        boolean z;
        b bVar = this.wv.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.wu.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.H(false);
                aVar3.G(false);
                aVar3.g(currentTimeMillis);
                this.wu.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.fW()) {
                z = true;
            } else {
                if (aVar.ga()) {
                    aVar.ao(aVar.fY() + 1);
                    if (currentTimeMillis - aVar.fX() < bVar.gd()) {
                        if (aVar.fY() >= bVar.ge()) {
                            aVar.G(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.H(false);
                        aVar.ao(0);
                        aVar.g(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.fZ() < bVar.gb()) {
                    aVar.H(true);
                    aVar.f(currentTimeMillis);
                } else {
                    aVar.g(currentTimeMillis);
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
        private long wA;
        private boolean wB;
        private long wy;
        private boolean wz;

        private a() {
            this.wz = false;
            this.mCount = 0;
            this.wB = false;
        }

        public boolean fW() {
            return this.wB;
        }

        public void G(boolean z) {
            this.wB = z;
        }

        public long fX() {
            return this.wA;
        }

        public void f(long j) {
            this.wA = j;
        }

        public int fY() {
            return this.mCount;
        }

        public void ao(int i) {
            this.mCount = i;
        }

        public long fZ() {
            return this.wy;
        }

        public void g(long j) {
            this.wy = j;
        }

        public boolean ga() {
            return this.wz;
        }

        public void H(boolean z) {
            this.wz = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int wC;
        private int wD;
        private int wE;

        private b() {
        }

        public int gb() {
            return this.wC;
        }

        public void ap(int i) {
            this.wC = i;
        }

        public int gd() {
            return this.wD;
        }

        public void aq(int i) {
            this.wD = i;
        }

        public int ge() {
            return this.wE;
        }

        public void ar(int i) {
            this.wE = i;
        }
    }
}
