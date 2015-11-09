package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static h wx;
    private HashMap<String, a> wv = new HashMap<>();
    private HashMap<String, b> ww = new HashMap<>();
    private Handler mHandler = new i(this, Looper.getMainLooper());

    public static h hB() {
        if (wx == null) {
            synchronized (h.class) {
                if (wx == null) {
                    wx = new h();
                }
            }
        }
        return wx;
    }

    public h() {
        b bVar = new b(this, null);
        bVar.Y(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar.Z(120000);
        bVar.aa(500);
        this.ww.put("net", bVar);
        this.ww.put("op", bVar);
        this.ww.put("stat", bVar);
        this.ww.put("crash", bVar);
        this.ww.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.Y(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar2.Z(120000);
        bVar2.aa(1500);
        this.ww.put("file", bVar2);
        this.ww.put("db", bVar2);
        this.ww.put("img", bVar2);
        this.ww.put("voice", bVar2);
        this.ww.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.Y(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar3.Z(120000);
        bVar3.aa(1500);
        this.ww.put("dbg", bVar3);
    }

    public boolean aq(String str) {
        a aVar;
        b bVar = this.ww.get(str);
        if (bVar == null) {
            return false;
        }
        a aVar2 = this.wv.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar2 == null) {
            a aVar3 = new a(this, null);
            aVar3.C(false);
            aVar3.B(false);
            aVar3.e(currentTimeMillis);
            this.wv.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.hC()) {
            return true;
        }
        if (aVar.hG()) {
            aVar.X(aVar.hE() + 1);
            if (currentTimeMillis - aVar.hD() < bVar.hI()) {
                if (aVar.hE() >= bVar.hJ()) {
                    aVar.B(true);
                    com.baidu.adp.lib.stats.a.hj().a(false, "d", "logfast", (String) null, 0L, 99999, str, new Object[0]);
                    a(aVar);
                    return true;
                }
                return false;
            }
            aVar.C(false);
            aVar.X(0);
            aVar.e(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - aVar.hF() < bVar.hH()) {
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
        private boolean wA;
        private int wB;
        private long wC;
        private boolean wD;
        private long wz;

        private a() {
            this.wA = false;
            this.wB = 0;
            this.wD = false;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        public boolean hC() {
            return this.wD;
        }

        public void B(boolean z) {
            this.wD = z;
        }

        public long hD() {
            return this.wC;
        }

        public void d(long j) {
            this.wC = j;
        }

        public int hE() {
            return this.wB;
        }

        public void X(int i) {
            this.wB = i;
        }

        public long hF() {
            return this.wz;
        }

        public void e(long j) {
            this.wz = j;
        }

        public boolean hG() {
            return this.wA;
        }

        public void C(boolean z) {
            this.wA = z;
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

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }

        public int hH() {
            return this.wE;
        }

        public void Y(int i) {
            this.wE = i;
        }

        public int hI() {
            return this.wF;
        }

        public void Z(int i) {
            this.wF = i;
        }

        public int hJ() {
            return this.wG;
        }

        public void aa(int i) {
            this.wG = i;
        }
    }
}
