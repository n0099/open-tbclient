package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static h wD;
    private HashMap<String, a> wB = new HashMap<>();
    private HashMap<String, b> wC = new HashMap<>();
    private Handler mHandler = new i(this, Looper.getMainLooper());

    public static h hD() {
        if (wD == null) {
            synchronized (h.class) {
                if (wD == null) {
                    wD = new h();
                }
            }
        }
        return wD;
    }

    public h() {
        b bVar = new b(this, null);
        bVar.Z(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar.aa(120000);
        bVar.ab(500);
        this.wC.put("net", bVar);
        this.wC.put("op", bVar);
        this.wC.put("stat", bVar);
        this.wC.put("crash", bVar);
        this.wC.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.Z(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar2.aa(120000);
        bVar2.ab(1500);
        this.wC.put("file", bVar2);
        this.wC.put("db", bVar2);
        this.wC.put("img", bVar2);
        this.wC.put("voice", bVar2);
        this.wC.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.Z(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar3.aa(120000);
        bVar3.ab(1500);
        this.wC.put("dbg", bVar3);
    }

    public boolean au(String str) {
        a aVar;
        b bVar = this.wC.get(str);
        if (bVar == null) {
            return false;
        }
        a aVar2 = this.wB.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar2 == null) {
            a aVar3 = new a(this, null);
            aVar3.C(false);
            aVar3.B(false);
            aVar3.e(currentTimeMillis);
            this.wB.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.hE()) {
            return true;
        }
        if (aVar.hI()) {
            aVar.Y(aVar.hG() + 1);
            if (currentTimeMillis - aVar.hF() < bVar.hK()) {
                if (aVar.hG() >= bVar.hL()) {
                    aVar.B(true);
                    com.baidu.adp.lib.stats.a.hl().a(false, "d", "logfast", (String) null, 0L, 99999, str, new Object[0]);
                    a(aVar);
                    return true;
                }
                return false;
            }
            aVar.C(false);
            aVar.Y(0);
            aVar.e(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - aVar.hH() < bVar.hJ()) {
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
        private long wF;
        private boolean wG;
        private int wH;
        private long wI;
        private boolean wJ;

        private a() {
            this.wG = false;
            this.wH = 0;
            this.wJ = false;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        public boolean hE() {
            return this.wJ;
        }

        public void B(boolean z) {
            this.wJ = z;
        }

        public long hF() {
            return this.wI;
        }

        public void d(long j) {
            this.wI = j;
        }

        public int hG() {
            return this.wH;
        }

        public void Y(int i) {
            this.wH = i;
        }

        public long hH() {
            return this.wF;
        }

        public void e(long j) {
            this.wF = j;
        }

        public boolean hI() {
            return this.wG;
        }

        public void C(boolean z) {
            this.wG = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int wK;
        private int wL;
        private int wM;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }

        public int hJ() {
            return this.wK;
        }

        public void Z(int i) {
            this.wK = i;
        }

        public int hK() {
            return this.wL;
        }

        public void aa(int i) {
            this.wL = i;
        }

        public int hL() {
            return this.wM;
        }

        public void ab(int i) {
            this.wM = i;
        }
    }
}
