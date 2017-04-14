package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class g {
    private static g wV;
    private HashMap<String, a> wT = new HashMap<>();
    private HashMap<String, b> wU = new HashMap<>();
    private Handler mHandler = new h(this, Looper.getMainLooper());

    public static g fX() {
        if (wV == null) {
            synchronized (g.class) {
                if (wV == null) {
                    wV = new g();
                }
            }
        }
        return wV;
    }

    public g() {
        b bVar = new b(this, null);
        bVar.an(3000);
        bVar.ao(120000);
        bVar.ap(500);
        this.wU.put("net", bVar);
        this.wU.put("op", bVar);
        this.wU.put("stat", bVar);
        this.wU.put("crash", bVar);
        this.wU.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.an(3000);
        bVar2.ao(120000);
        bVar2.ap(1500);
        this.wU.put("file", bVar2);
        this.wU.put("db", bVar2);
        this.wU.put("img", bVar2);
        this.wU.put("voice", bVar2);
        this.wU.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.an(3000);
        bVar3.ao(120000);
        bVar3.ap(1500);
        this.wU.put("dbg", bVar3);
    }

    public synchronized boolean ag(String str) {
        a aVar;
        boolean z;
        b bVar = this.wU.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.wT.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a(this, null);
                aVar3.G(false);
                aVar3.F(false);
                aVar3.f(currentTimeMillis);
                this.wT.put(str, aVar3);
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
        private long wX;
        private long wY;
        private boolean wZ;

        private a() {
            this.mIsRunning = false;
            this.mCount = 0;
            this.wZ = false;
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }

        public boolean fY() {
            return this.wZ;
        }

        public void F(boolean z) {
            this.wZ = z;
        }

        public long fZ() {
            return this.wY;
        }

        public void e(long j) {
            this.wY = j;
        }

        public int ga() {
            return this.mCount;
        }

        public void am(int i) {
            this.mCount = i;
        }

        public long gb() {
            return this.wX;
        }

        public void f(long j) {
            this.wX = j;
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
        private int xa;
        private int xb;
        private int xc;

        private b() {
        }

        /* synthetic */ b(g gVar, b bVar) {
            this();
        }

        public int ge() {
            return this.xa;
        }

        public void an(int i) {
            this.xa = i;
        }

        public int gf() {
            return this.xb;
        }

        public void ao(int i) {
            this.xb = i;
        }

        public int gg() {
            return this.xc;
        }

        public void ap(int i) {
            this.xc = i;
        }
    }
}
