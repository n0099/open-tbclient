package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e yA;
    private HashMap<String, a> yy = new HashMap<>();
    private HashMap<String, b> yz = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.F(false);
                        aVar.G(false);
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

    public static e gg() {
        if (yA == null) {
            synchronized (e.class) {
                if (yA == null) {
                    yA = new e();
                }
            }
        }
        return yA;
    }

    public e() {
        b bVar = new b();
        bVar.aq(3000);
        bVar.ar(120000);
        bVar.as(500);
        this.yz.put("net", bVar);
        this.yz.put("op", bVar);
        this.yz.put("stat", bVar);
        this.yz.put("crash", bVar);
        this.yz.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.aq(3000);
        bVar2.ar(120000);
        bVar2.as(1500);
        this.yz.put("file", bVar2);
        this.yz.put("db", bVar2);
        this.yz.put("img", bVar2);
        this.yz.put("voice", bVar2);
        this.yz.put("error", bVar2);
        b bVar3 = new b();
        bVar3.aq(3000);
        bVar3.ar(120000);
        bVar3.as(1500);
        this.yz.put("dbg", bVar3);
    }

    public synchronized boolean at(String str) {
        a aVar;
        boolean z;
        b bVar = this.yz.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.yy.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.G(false);
                aVar3.F(false);
                aVar3.f(currentTimeMillis);
                this.yy.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.gh()) {
                z = true;
            } else {
                if (aVar.gl()) {
                    aVar.ap(aVar.gj() + 1);
                    if (currentTimeMillis - aVar.gi() < bVar.gn()) {
                        if (aVar.gj() >= bVar.go()) {
                            aVar.F(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.G(false);
                        aVar.ap(0);
                        aVar.f(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.gk() < bVar.gm()) {
                    aVar.G(true);
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
        private boolean mIsRunning;
        private long yC;
        private long yD;
        private boolean yE;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.yE = false;
        }

        public boolean gh() {
            return this.yE;
        }

        public void F(boolean z) {
            this.yE = z;
        }

        public long gi() {
            return this.yD;
        }

        public void e(long j) {
            this.yD = j;
        }

        public int gj() {
            return this.mCount;
        }

        public void ap(int i) {
            this.mCount = i;
        }

        public long gk() {
            return this.yC;
        }

        public void f(long j) {
            this.yC = j;
        }

        public boolean gl() {
            return this.mIsRunning;
        }

        public void G(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int yF;
        private int yG;
        private int yH;

        private b() {
        }

        public int gm() {
            return this.yF;
        }

        public void aq(int i) {
            this.yF = i;
        }

        public int gn() {
            return this.yG;
        }

        public void ar(int i) {
            this.yG = i;
        }

        public int go() {
            return this.yH;
        }

        public void as(int i) {
            this.yH = i;
        }
    }
}
