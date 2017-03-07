package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class g {
    private static g xt;
    private HashMap<String, a> xr = new HashMap<>();
    private HashMap<String, b> xs = new HashMap<>();
    private Handler mHandler = new h(this, Looper.getMainLooper());

    public static g fS() {
        if (xt == null) {
            synchronized (g.class) {
                if (xt == null) {
                    xt = new g();
                }
            }
        }
        return xt;
    }

    public g() {
        b bVar = new b(this, null);
        bVar.ao(3000);
        bVar.ap(120000);
        bVar.aq(500);
        this.xs.put("net", bVar);
        this.xs.put("op", bVar);
        this.xs.put("stat", bVar);
        this.xs.put("crash", bVar);
        this.xs.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.ao(3000);
        bVar2.ap(120000);
        bVar2.aq(1500);
        this.xs.put("file", bVar2);
        this.xs.put("db", bVar2);
        this.xs.put("img", bVar2);
        this.xs.put("voice", bVar2);
        this.xs.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.ao(3000);
        bVar3.ap(120000);
        bVar3.aq(1500);
        this.xs.put("dbg", bVar3);
    }

    public synchronized boolean ak(String str) {
        a aVar;
        boolean z;
        b bVar = this.xs.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.xr.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a(this, null);
                aVar3.G(false);
                aVar3.F(false);
                aVar3.f(currentTimeMillis);
                this.xr.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.fT()) {
                z = true;
            } else {
                if (aVar.fX()) {
                    aVar.an(aVar.fV() + 1);
                    if (currentTimeMillis - aVar.fU() < bVar.fZ()) {
                        if (aVar.fV() >= bVar.ga()) {
                            aVar.F(true);
                            BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.G(false);
                        aVar.an(0);
                        aVar.f(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.fW() < bVar.fY()) {
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
        private long xv;
        private boolean xw;
        private long xx;
        private boolean xy;

        private a() {
            this.xw = false;
            this.mCount = 0;
            this.xy = false;
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }

        public boolean fT() {
            return this.xy;
        }

        public void F(boolean z) {
            this.xy = z;
        }

        public long fU() {
            return this.xx;
        }

        public void e(long j) {
            this.xx = j;
        }

        public int fV() {
            return this.mCount;
        }

        public void an(int i) {
            this.mCount = i;
        }

        public long fW() {
            return this.xv;
        }

        public void f(long j) {
            this.xv = j;
        }

        public boolean fX() {
            return this.xw;
        }

        public void G(boolean z) {
            this.xw = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int xA;
        private int xB;
        private int xz;

        private b() {
        }

        /* synthetic */ b(g gVar, b bVar) {
            this();
        }

        public int fY() {
            return this.xz;
        }

        public void ao(int i) {
            this.xz = i;
        }

        public int fZ() {
            return this.xA;
        }

        public void ap(int i) {
            this.xA = i;
        }

        public int ga() {
            return this.xB;
        }

        public void aq(int i) {
            this.xB = i;
        }
    }
}
