package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class g {
    private static g wY;
    private HashMap<String, a> wW = new HashMap<>();
    private HashMap<String, b> wX = new HashMap<>();
    private Handler mHandler = new h(this, Looper.getMainLooper());

    public static g fY() {
        if (wY == null) {
            synchronized (g.class) {
                if (wY == null) {
                    wY = new g();
                }
            }
        }
        return wY;
    }

    public g() {
        b bVar = new b(this, null);
        bVar.an(3000);
        bVar.ao(120000);
        bVar.ap(500);
        this.wX.put("net", bVar);
        this.wX.put("op", bVar);
        this.wX.put("stat", bVar);
        this.wX.put("crash", bVar);
        this.wX.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.an(3000);
        bVar2.ao(120000);
        bVar2.ap(1500);
        this.wX.put("file", bVar2);
        this.wX.put("db", bVar2);
        this.wX.put("img", bVar2);
        this.wX.put("voice", bVar2);
        this.wX.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.an(3000);
        bVar3.ao(120000);
        bVar3.ap(1500);
        this.wX.put("dbg", bVar3);
    }

    public synchronized boolean ag(String str) {
        a aVar;
        boolean z;
        b bVar = this.wX.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.wW.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a(this, null);
                aVar3.G(false);
                aVar3.F(false);
                aVar3.f(currentTimeMillis);
                this.wW.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.fZ()) {
                z = true;
            } else {
                if (aVar.ge()) {
                    aVar.am(aVar.gb() + 1);
                    if (currentTimeMillis - aVar.ga() < bVar.gg()) {
                        if (aVar.gb() >= bVar.gh()) {
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
                } else if (currentTimeMillis - aVar.gd() < bVar.gf()) {
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
        private long xa;
        private long xb;
        private boolean xc;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.xc = false;
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }

        public boolean fZ() {
            return this.xc;
        }

        public void F(boolean z) {
            this.xc = z;
        }

        public long ga() {
            return this.xb;
        }

        public void e(long j) {
            this.xb = j;
        }

        public int gb() {
            return this.mCount;
        }

        public void am(int i) {
            this.mCount = i;
        }

        public long gd() {
            return this.xa;
        }

        public void f(long j) {
            this.xa = j;
        }

        public boolean ge() {
            return this.mIsRunning;
        }

        public void G(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int xd;
        private int xe;
        private int xf;

        private b() {
        }

        /* synthetic */ b(g gVar, b bVar) {
            this();
        }

        public int gf() {
            return this.xd;
        }

        public void an(int i) {
            this.xd = i;
        }

        public int gg() {
            return this.xe;
        }

        public void ao(int i) {
            this.xe = i;
        }

        public int gh() {
            return this.xf;
        }

        public void ap(int i) {
            this.xf = i;
        }
    }
}
