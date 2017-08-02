package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static e xa;
    private HashMap<String, a> wY = new HashMap<>();
    private HashMap<String, b> wZ = new HashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.F(false);
                        aVar.G(false);
                        aVar.am(0);
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
        if (xa == null) {
            synchronized (e.class) {
                if (xa == null) {
                    xa = new e();
                }
            }
        }
        return xa;
    }

    public e() {
        b bVar = new b();
        bVar.an(3000);
        bVar.ao(120000);
        bVar.ap(500);
        this.wZ.put("net", bVar);
        this.wZ.put("op", bVar);
        this.wZ.put("stat", bVar);
        this.wZ.put("crash", bVar);
        this.wZ.put("pfmonitor", bVar);
        b bVar2 = new b();
        bVar2.an(3000);
        bVar2.ao(120000);
        bVar2.ap(1500);
        this.wZ.put("file", bVar2);
        this.wZ.put("db", bVar2);
        this.wZ.put("img", bVar2);
        this.wZ.put("voice", bVar2);
        this.wZ.put("error", bVar2);
        b bVar3 = new b();
        bVar3.an(3000);
        bVar3.ao(120000);
        bVar3.ap(1500);
        this.wZ.put("dbg", bVar3);
    }

    public synchronized boolean an(String str) {
        a aVar;
        boolean z;
        b bVar = this.wZ.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.wY.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.G(false);
                aVar3.F(false);
                aVar3.f(currentTimeMillis);
                this.wY.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.fW()) {
                z = true;
            } else {
                if (aVar.ga()) {
                    aVar.am(aVar.fY() + 1);
                    if (currentTimeMillis - aVar.fX() < bVar.gd()) {
                        if (aVar.fY() >= bVar.ge()) {
                            aVar.F(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.G(false);
                        aVar.am(0);
                        aVar.f(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.fZ() < bVar.gb()) {
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
        private long xc;
        private long xd;
        private boolean xe;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.xe = false;
        }

        public boolean fW() {
            return this.xe;
        }

        public void F(boolean z) {
            this.xe = z;
        }

        public long fX() {
            return this.xd;
        }

        public void e(long j) {
            this.xd = j;
        }

        public int fY() {
            return this.mCount;
        }

        public void am(int i) {
            this.mCount = i;
        }

        public long fZ() {
            return this.xc;
        }

        public void f(long j) {
            this.xc = j;
        }

        public boolean ga() {
            return this.mIsRunning;
        }

        public void G(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int xf;
        private int xg;
        private int xh;

        private b() {
        }

        public int gb() {
            return this.xf;
        }

        public void an(int i) {
            this.xf = i;
        }

        public int gd() {
            return this.xg;
        }

        public void ao(int i) {
            this.xg = i;
        }

        public int ge() {
            return this.xh;
        }

        public void ap(int i) {
            this.xh = i;
        }
    }
}
