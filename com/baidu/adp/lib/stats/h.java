package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static h ww;
    private HashMap<String, a> wu = new HashMap<>();
    private HashMap<String, b> wv = new HashMap<>();
    private Handler mHandler = new i(this, Looper.getMainLooper());

    public static h hz() {
        if (ww == null) {
            synchronized (h.class) {
                if (ww == null) {
                    ww = new h();
                }
            }
        }
        return ww;
    }

    public h() {
        b bVar = new b(this, null);
        bVar.Y(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar.Z(120000);
        bVar.aa(500);
        this.wv.put("net", bVar);
        this.wv.put("op", bVar);
        this.wv.put("stat", bVar);
        this.wv.put("crash", bVar);
        this.wv.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.Y(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar2.Z(120000);
        bVar2.aa(1500);
        this.wv.put("file", bVar2);
        this.wv.put("db", bVar2);
        this.wv.put("img", bVar2);
        this.wv.put("voice", bVar2);
        this.wv.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.Y(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar3.Z(120000);
        bVar3.aa(1500);
        this.wv.put("dbg", bVar3);
    }

    public boolean as(String str) {
        a aVar;
        b bVar = this.wv.get(str);
        if (bVar == null) {
            return false;
        }
        a aVar2 = this.wu.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar2 == null) {
            a aVar3 = new a(this, null);
            aVar3.C(false);
            aVar3.B(false);
            aVar3.e(currentTimeMillis);
            this.wu.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.hA()) {
            return true;
        }
        if (aVar.hE()) {
            aVar.X(aVar.hC() + 1);
            if (currentTimeMillis - aVar.hB() < bVar.hG()) {
                if (aVar.hC() >= bVar.hH()) {
                    aVar.B(true);
                    com.baidu.adp.lib.stats.a.hh().a(false, "d", "logfast", (String) null, 0L, 99999, str, new Object[0]);
                    a(aVar);
                    return true;
                }
                return false;
            }
            aVar.C(false);
            aVar.X(0);
            aVar.e(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - aVar.hD() < bVar.hF()) {
            aVar.C(true);
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
        private int wA;
        private long wB;
        private boolean wC;
        private long wy;
        private boolean wz;

        private a() {
            this.wz = false;
            this.wA = 0;
            this.wC = false;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        public boolean hA() {
            return this.wC;
        }

        public void B(boolean z) {
            this.wC = z;
        }

        public long hB() {
            return this.wB;
        }

        public void d(long j) {
            this.wB = j;
        }

        public int hC() {
            return this.wA;
        }

        public void X(int i) {
            this.wA = i;
        }

        public long hD() {
            return this.wy;
        }

        public void e(long j) {
            this.wy = j;
        }

        public boolean hE() {
            return this.wz;
        }

        public void C(boolean z) {
            this.wz = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int wD;
        private int wE;
        private int wF;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }

        public int hF() {
            return this.wD;
        }

        public void Y(int i) {
            this.wD = i;
        }

        public int hG() {
            return this.wE;
        }

        public void Z(int i) {
            this.wE = i;
        }

        public int hH() {
            return this.wF;
        }

        public void aa(int i) {
            this.wF = i;
        }
    }
}
