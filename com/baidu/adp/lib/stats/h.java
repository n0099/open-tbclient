package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static h wy;
    private HashMap<String, a> ww = new HashMap<>();
    private HashMap<String, b> wx = new HashMap<>();
    private Handler mHandler = new i(this, Looper.getMainLooper());

    public static h hC() {
        if (wy == null) {
            synchronized (h.class) {
                if (wy == null) {
                    wy = new h();
                }
            }
        }
        return wy;
    }

    public h() {
        b bVar = new b(this, null);
        bVar.Y(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar.Z(120000);
        bVar.aa(500);
        this.wx.put("net", bVar);
        this.wx.put("op", bVar);
        this.wx.put("stat", bVar);
        this.wx.put("crash", bVar);
        this.wx.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.Y(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar2.Z(120000);
        bVar2.aa(1500);
        this.wx.put("file", bVar2);
        this.wx.put("db", bVar2);
        this.wx.put("img", bVar2);
        this.wx.put("voice", bVar2);
        this.wx.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.Y(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar3.Z(120000);
        bVar3.aa(1500);
        this.wx.put("dbg", bVar3);
    }

    public boolean as(String str) {
        a aVar;
        b bVar = this.wx.get(str);
        if (bVar == null) {
            return false;
        }
        a aVar2 = this.ww.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar2 == null) {
            a aVar3 = new a(this, null);
            aVar3.C(false);
            aVar3.B(false);
            aVar3.e(currentTimeMillis);
            this.ww.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.hD()) {
            return true;
        }
        if (aVar.hH()) {
            aVar.X(aVar.hF() + 1);
            if (currentTimeMillis - aVar.hE() < bVar.hJ()) {
                if (aVar.hF() >= bVar.hK()) {
                    aVar.B(true);
                    com.baidu.adp.lib.stats.a.hk().a(false, "d", "logfast", (String) null, 0L, 99999, str, new Object[0]);
                    a(aVar);
                    return true;
                }
                return false;
            }
            aVar.C(false);
            aVar.X(0);
            aVar.e(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - aVar.hG() < bVar.hI()) {
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
        private long wA;
        private boolean wB;
        private int wC;
        private long wD;
        private boolean wE;

        private a() {
            this.wB = false;
            this.wC = 0;
            this.wE = false;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        public boolean hD() {
            return this.wE;
        }

        public void B(boolean z) {
            this.wE = z;
        }

        public long hE() {
            return this.wD;
        }

        public void d(long j) {
            this.wD = j;
        }

        public int hF() {
            return this.wC;
        }

        public void X(int i) {
            this.wC = i;
        }

        public long hG() {
            return this.wA;
        }

        public void e(long j) {
            this.wA = j;
        }

        public boolean hH() {
            return this.wB;
        }

        public void C(boolean z) {
            this.wB = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int wF;
        private int wG;
        private int wH;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }

        public int hI() {
            return this.wF;
        }

        public void Y(int i) {
            this.wF = i;
        }

        public int hJ() {
            return this.wG;
        }

        public void Z(int i) {
            this.wG = i;
        }

        public int hK() {
            return this.wH;
        }

        public void aa(int i) {
            this.wH = i;
        }
    }
}
