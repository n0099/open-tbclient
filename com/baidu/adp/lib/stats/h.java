package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static h xf;
    private HashMap<String, a> xd = new HashMap<>();
    private HashMap<String, b> xe = new HashMap<>();
    private Handler mHandler = new i(this, Looper.getMainLooper());

    public static h hR() {
        if (xf == null) {
            synchronized (h.class) {
                if (xf == null) {
                    xf = new h();
                }
            }
        }
        return xf;
    }

    public h() {
        b bVar = new b(this, null);
        bVar.aj(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar.ak(120000);
        bVar.al(500);
        this.xe.put("net", bVar);
        this.xe.put("op", bVar);
        this.xe.put("stat", bVar);
        this.xe.put("crash", bVar);
        this.xe.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.aj(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar2.ak(120000);
        bVar2.al(1500);
        this.xe.put("file", bVar2);
        this.xe.put("db", bVar2);
        this.xe.put("img", bVar2);
        this.xe.put("voice", bVar2);
        this.xe.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.aj(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar3.ak(120000);
        bVar3.al(1500);
        this.xe.put("dbg", bVar3);
    }

    public boolean av(String str) {
        a aVar;
        b bVar = this.xe.get(str);
        if (bVar == null) {
            return false;
        }
        a aVar2 = this.xd.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar2 == null) {
            a aVar3 = new a(this, null);
            aVar3.B(false);
            aVar3.A(false);
            aVar3.e(currentTimeMillis);
            this.xd.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.hS()) {
            return true;
        }
        if (aVar.hW()) {
            aVar.ai(aVar.hU() + 1);
            if (currentTimeMillis - aVar.hT() < bVar.hY()) {
                if (aVar.hU() >= bVar.hZ()) {
                    aVar.A(true);
                    com.baidu.adp.lib.stats.a.hz().a(false, "d", "logfast", (String) null, 0L, 99999, str, new Object[0]);
                    a(aVar);
                    return true;
                }
                return false;
            }
            aVar.B(false);
            aVar.ai(0);
            aVar.e(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - aVar.hV() < bVar.hX()) {
            aVar.B(true);
            aVar.d(currentTimeMillis);
            return false;
        } else {
            aVar.e(currentTimeMillis);
            return false;
        }
    }

    private void a(a aVar) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = aVar;
        this.mHandler.removeMessages(5);
        this.mHandler.sendMessageDelayed(obtainMessage, 300000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private long xh;
        private boolean xi;
        private int xj;
        private long xk;
        private boolean xl;

        private a() {
            this.xi = false;
            this.xj = 0;
            this.xl = false;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        public boolean hS() {
            return this.xl;
        }

        public void A(boolean z) {
            this.xl = z;
        }

        public long hT() {
            return this.xk;
        }

        public void d(long j) {
            this.xk = j;
        }

        public int hU() {
            return this.xj;
        }

        public void ai(int i) {
            this.xj = i;
        }

        public long hV() {
            return this.xh;
        }

        public void e(long j) {
            this.xh = j;
        }

        public boolean hW() {
            return this.xi;
        }

        public void B(boolean z) {
            this.xi = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int xm;
        private int xn;
        private int xo;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }

        public int hX() {
            return this.xm;
        }

        public void aj(int i) {
            this.xm = i;
        }

        public int hY() {
            return this.xn;
        }

        public void ak(int i) {
            this.xn = i;
        }

        public int hZ() {
            return this.xo;
        }

        public void al(int i) {
            this.xo = i;
        }
    }
}
