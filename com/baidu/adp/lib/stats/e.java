package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e wy;
    private HashMap<String, a> ww = new HashMap<>();
    private HashMap<String, b> wx = new HashMap<>();
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
        if (wy == null) {
            synchronized (e.class) {
                if (wy == null) {
                    wy = new e();
                }
            }
        }
        return wy;
    }

    public e() {
        b bVar = new b();
        bVar.aq(3000);
        bVar.ar(120000);
        bVar.as(500);
        this.wx.put("net", bVar);
        this.wx.put("op", bVar);
        this.wx.put("stat", bVar);
        this.wx.put("crash", bVar);
        this.wx.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.aq(3000);
        bVar2.ar(120000);
        bVar2.as(TbConfig.POST_IMAGE_SMALL);
        this.wx.put("file", bVar2);
        this.wx.put("db", bVar2);
        this.wx.put("img", bVar2);
        this.wx.put("voice", bVar2);
        this.wx.put("error", bVar2);
        b bVar3 = new b();
        bVar3.aq(3000);
        bVar3.ar(120000);
        bVar3.as(TbConfig.POST_IMAGE_SMALL);
        this.wx.put("dbg", bVar3);
    }

    public synchronized boolean ao(String str) {
        a aVar;
        boolean z;
        b bVar = this.wx.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.ww.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.H(false);
                aVar3.G(false);
                aVar3.g(currentTimeMillis);
                this.ww.put(str, aVar3);
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
        private long wC;
        private boolean wD;

        private a() {
            this.wB = false;
            this.mCount = 0;
            this.wD = false;
        }

        public boolean fW() {
            return this.wD;
        }

        public void G(boolean z) {
            this.wD = z;
        }

        public long fX() {
            return this.wC;
        }

        public void f(long j) {
            this.wC = j;
        }

        public int fY() {
            return this.mCount;
        }

        public void ap(int i) {
            this.mCount = i;
        }

        public long fZ() {
            return this.wA;
        }

        public void g(long j) {
            this.wA = j;
        }

        public boolean ga() {
            return this.wB;
        }

        public void H(boolean z) {
            this.wB = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int wE;
        private int wF;
        private int wG;

        private b() {
        }

        public int gb() {
            return this.wE;
        }

        public void aq(int i) {
            this.wE = i;
        }

        public int gd() {
            return this.wF;
        }

        public void ar(int i) {
            this.wF = i;
        }

        public int ge() {
            return this.wG;
        }

        public void as(int i) {
            this.wG = i;
        }
    }
}
