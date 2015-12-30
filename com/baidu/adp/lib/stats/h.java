package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static h wF;
    private HashMap<String, a> wD = new HashMap<>();
    private HashMap<String, b> wE = new HashMap<>();
    private Handler mHandler = new i(this, Looper.getMainLooper());

    public static h hD() {
        if (wF == null) {
            synchronized (h.class) {
                if (wF == null) {
                    wF = new h();
                }
            }
        }
        return wF;
    }

    public h() {
        b bVar = new b(this, null);
        bVar.Z(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar.aa(120000);
        bVar.ab(500);
        this.wE.put("net", bVar);
        this.wE.put("op", bVar);
        this.wE.put("stat", bVar);
        this.wE.put("crash", bVar);
        this.wE.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.Z(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar2.aa(120000);
        bVar2.ab(1500);
        this.wE.put("file", bVar2);
        this.wE.put("db", bVar2);
        this.wE.put("img", bVar2);
        this.wE.put("voice", bVar2);
        this.wE.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.Z(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar3.aa(120000);
        bVar3.ab(1500);
        this.wE.put("dbg", bVar3);
    }

    public boolean au(String str) {
        a aVar;
        b bVar = this.wE.get(str);
        if (bVar == null) {
            return false;
        }
        a aVar2 = this.wD.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar2 == null) {
            a aVar3 = new a(this, null);
            aVar3.C(false);
            aVar3.B(false);
            aVar3.e(currentTimeMillis);
            this.wD.put(str, aVar3);
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
        private long wH;
        private boolean wI;
        private int wJ;
        private long wK;
        private boolean wL;

        private a() {
            this.wI = false;
            this.wJ = 0;
            this.wL = false;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        public boolean hE() {
            return this.wL;
        }

        public void B(boolean z) {
            this.wL = z;
        }

        public long hF() {
            return this.wK;
        }

        public void d(long j) {
            this.wK = j;
        }

        public int hG() {
            return this.wJ;
        }

        public void Y(int i) {
            this.wJ = i;
        }

        public long hH() {
            return this.wH;
        }

        public void e(long j) {
            this.wH = j;
        }

        public boolean hI() {
            return this.wI;
        }

        public void C(boolean z) {
            this.wI = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int wM;
        private int wN;
        private int wO;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }

        public int hJ() {
            return this.wM;
        }

        public void Z(int i) {
            this.wM = i;
        }

        public int hK() {
            return this.wN;
        }

        public void aa(int i) {
            this.wN = i;
        }

        public int hL() {
            return this.wO;
        }

        public void ab(int i) {
            this.wO = i;
        }
    }
}
