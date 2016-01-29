package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static h wO;
    private HashMap<String, a> wM = new HashMap<>();
    private HashMap<String, b> wN = new HashMap<>();
    private Handler mHandler = new i(this, Looper.getMainLooper());

    public static h hL() {
        if (wO == null) {
            synchronized (h.class) {
                if (wO == null) {
                    wO = new h();
                }
            }
        }
        return wO;
    }

    public h() {
        b bVar = new b(this, null);
        bVar.ak(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar.al(120000);
        bVar.am(500);
        this.wN.put("net", bVar);
        this.wN.put("op", bVar);
        this.wN.put("stat", bVar);
        this.wN.put("crash", bVar);
        this.wN.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.ak(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar2.al(120000);
        bVar2.am(1500);
        this.wN.put("file", bVar2);
        this.wN.put("db", bVar2);
        this.wN.put("img", bVar2);
        this.wN.put("voice", bVar2);
        this.wN.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.ak(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        bVar3.al(120000);
        bVar3.am(1500);
        this.wN.put("dbg", bVar3);
    }

    public boolean at(String str) {
        a aVar;
        b bVar = this.wN.get(str);
        if (bVar == null) {
            return false;
        }
        a aVar2 = this.wM.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar2 == null) {
            a aVar3 = new a(this, null);
            aVar3.C(false);
            aVar3.B(false);
            aVar3.e(currentTimeMillis);
            this.wM.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.hM()) {
            return true;
        }
        if (aVar.hQ()) {
            aVar.aj(aVar.hO() + 1);
            if (currentTimeMillis - aVar.hN() < bVar.hS()) {
                if (aVar.hO() >= bVar.hT()) {
                    aVar.B(true);
                    com.baidu.adp.lib.stats.a.ht().a(false, "d", "logfast", (String) null, 0L, 99999, str, new Object[0]);
                    a(aVar);
                    return true;
                }
                return false;
            }
            aVar.C(false);
            aVar.aj(0);
            aVar.e(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - aVar.hP() < bVar.hR()) {
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
        private long wQ;
        private boolean wR;
        private int wS;
        private long wT;
        private boolean wU;

        private a() {
            this.wR = false;
            this.wS = 0;
            this.wU = false;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        public boolean hM() {
            return this.wU;
        }

        public void B(boolean z) {
            this.wU = z;
        }

        public long hN() {
            return this.wT;
        }

        public void d(long j) {
            this.wT = j;
        }

        public int hO() {
            return this.wS;
        }

        public void aj(int i) {
            this.wS = i;
        }

        public long hP() {
            return this.wQ;
        }

        public void e(long j) {
            this.wQ = j;
        }

        public boolean hQ() {
            return this.wR;
        }

        public void C(boolean z) {
            this.wR = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int wV;
        private int wW;
        private int wX;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }

        public int hR() {
            return this.wV;
        }

        public void ak(int i) {
            this.wV = i;
        }

        public int hS() {
            return this.wW;
        }

        public void al(int i) {
            this.wW = i;
        }

        public int hT() {
            return this.wX;
        }

        public void am(int i) {
            this.wX = i;
        }
    }
}
