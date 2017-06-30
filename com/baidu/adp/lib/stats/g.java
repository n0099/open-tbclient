package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class g {
    private static g wZ;
    private HashMap<String, a> wX = new HashMap<>();
    private HashMap<String, b> wY = new HashMap<>();
    private Handler mHandler = new h(this, Looper.getMainLooper());

    public static g fX() {
        if (wZ == null) {
            synchronized (g.class) {
                if (wZ == null) {
                    wZ = new g();
                }
            }
        }
        return wZ;
    }

    public g() {
        b bVar = new b(this, null);
        bVar.an(3000);
        bVar.ao(120000);
        bVar.ap(500);
        this.wY.put("net", bVar);
        this.wY.put("op", bVar);
        this.wY.put("stat", bVar);
        this.wY.put("crash", bVar);
        this.wY.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.an(3000);
        bVar2.ao(120000);
        bVar2.ap(1500);
        this.wY.put("file", bVar2);
        this.wY.put("db", bVar2);
        this.wY.put("img", bVar2);
        this.wY.put("voice", bVar2);
        this.wY.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.an(3000);
        bVar3.ao(120000);
        bVar3.ap(1500);
        this.wY.put("dbg", bVar3);
    }

    public synchronized boolean al(String str) {
        a aVar;
        boolean z;
        b bVar = this.wY.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.wX.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a(this, null);
                aVar3.G(false);
                aVar3.F(false);
                aVar3.f(currentTimeMillis);
                this.wX.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.fY()) {
                z = true;
            } else {
                if (aVar.gd()) {
                    aVar.am(aVar.ga() + 1);
                    if (currentTimeMillis - aVar.fZ() < bVar.gf()) {
                        if (aVar.ga() >= bVar.gg()) {
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
                } else if (currentTimeMillis - aVar.gb() < bVar.ge()) {
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
        private long xb;
        private long xc;
        private boolean xd;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.xd = false;
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }

        public boolean fY() {
            return this.xd;
        }

        public void F(boolean z) {
            this.xd = z;
        }

        public long fZ() {
            return this.xc;
        }

        public void e(long j) {
            this.xc = j;
        }

        public int ga() {
            return this.mCount;
        }

        public void am(int i) {
            this.mCount = i;
        }

        public long gb() {
            return this.xb;
        }

        public void f(long j) {
            this.xb = j;
        }

        public boolean gd() {
            return this.mIsRunning;
        }

        public void G(boolean z) {
            this.mIsRunning = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int xe;
        private int xf;
        private int xg;

        private b() {
        }

        /* synthetic */ b(g gVar, b bVar) {
            this();
        }

        public int ge() {
            return this.xe;
        }

        public void an(int i) {
            this.xe = i;
        }

        public int gf() {
            return this.xf;
        }

        public void ao(int i) {
            this.xf = i;
        }

        public int gg() {
            return this.xg;
        }

        public void ap(int i) {
            this.xg = i;
        }
    }
}
