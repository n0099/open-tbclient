package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e wv;
    private HashMap<String, a> wt = new HashMap<>();
    private HashMap<String, b> wu = new HashMap<>();
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
        if (wv == null) {
            synchronized (e.class) {
                if (wv == null) {
                    wv = new e();
                }
            }
        }
        return wv;
    }

    public e() {
        b bVar = new b();
        bVar.ap(3000);
        bVar.aq(120000);
        bVar.ar(500);
        this.wu.put("net", bVar);
        this.wu.put("op", bVar);
        this.wu.put("stat", bVar);
        this.wu.put("crash", bVar);
        this.wu.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.ap(3000);
        bVar2.aq(120000);
        bVar2.ar(TbConfig.POST_IMAGE_SMALL);
        this.wu.put("file", bVar2);
        this.wu.put("db", bVar2);
        this.wu.put("img", bVar2);
        this.wu.put("voice", bVar2);
        this.wu.put("error", bVar2);
        b bVar3 = new b();
        bVar3.ap(3000);
        bVar3.aq(120000);
        bVar3.ar(TbConfig.POST_IMAGE_SMALL);
        this.wu.put("dbg", bVar3);
    }

    public synchronized boolean ao(String str) {
        a aVar;
        boolean z;
        b bVar = this.wu.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.wt.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.H(false);
                aVar3.G(false);
                aVar3.g(currentTimeMillis);
                this.wt.put(str, aVar3);
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
        private boolean wA;
        private long wx;
        private boolean wy;
        private long wz;

        private a() {
            this.wy = false;
            this.mCount = 0;
            this.wA = false;
        }

        public boolean fW() {
            return this.wA;
        }

        public void G(boolean z) {
            this.wA = z;
        }

        public long fX() {
            return this.wz;
        }

        public void f(long j) {
            this.wz = j;
        }

        public int fY() {
            return this.mCount;
        }

        public void ao(int i) {
            this.mCount = i;
        }

        public long fZ() {
            return this.wx;
        }

        public void g(long j) {
            this.wx = j;
        }

        public boolean ga() {
            return this.wy;
        }

        public void H(boolean z) {
            this.wy = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int wB;
        private int wC;
        private int wD;

        private b() {
        }

        public int gb() {
            return this.wB;
        }

        public void ap(int i) {
            this.wB = i;
        }

        public int gd() {
            return this.wC;
        }

        public void aq(int i) {
            this.wC = i;
        }

        public int ge() {
            return this.wD;
        }

        public void ar(int i) {
            this.wD = i;
        }
    }
}
