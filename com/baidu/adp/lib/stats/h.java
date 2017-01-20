package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static h pX;
    private HashMap<String, a> pV = new HashMap<>();
    private HashMap<String, b> pW = new HashMap<>();
    private Handler mHandler = new i(this, Looper.getMainLooper());

    public static h eY() {
        if (pX == null) {
            synchronized (h.class) {
                if (pX == null) {
                    pX = new h();
                }
            }
        }
        return pX;
    }

    public h() {
        b bVar = new b(this, null);
        bVar.ao(3000);
        bVar.ap(120000);
        bVar.aq(500);
        this.pW.put("net", bVar);
        this.pW.put("op", bVar);
        this.pW.put("stat", bVar);
        this.pW.put("crash", bVar);
        this.pW.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.ao(3000);
        bVar2.ap(120000);
        bVar2.aq(1500);
        this.pW.put("file", bVar2);
        this.pW.put("db", bVar2);
        this.pW.put("img", bVar2);
        this.pW.put("voice", bVar2);
        this.pW.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.ao(3000);
        bVar3.ap(120000);
        bVar3.aq(1500);
        this.pW.put("dbg", bVar3);
    }

    public synchronized boolean aq(String str) {
        a aVar;
        boolean z;
        b bVar = this.pW.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.pV.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a(this, null);
                aVar3.F(false);
                aVar3.E(false);
                aVar3.f(currentTimeMillis);
                this.pV.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.eZ()) {
                z = true;
            } else {
                if (aVar.fd()) {
                    aVar.an(aVar.fb() + 1);
                    if (currentTimeMillis - aVar.fa() < bVar.ff()) {
                        if (aVar.fb() >= bVar.fg()) {
                            aVar.E(true);
                            com.baidu.adp.lib.stats.a.eG().a(false, "d", "logfast", (String) null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.F(false);
                        aVar.an(0);
                        aVar.f(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.fc() < bVar.fe()) {
                    aVar.F(true);
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
        private long pZ;
        private boolean qa;
        private long qb;
        private boolean qc;

        private a() {
            this.qa = false;
            this.mCount = 0;
            this.qc = false;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        public boolean eZ() {
            return this.qc;
        }

        public void E(boolean z) {
            this.qc = z;
        }

        public long fa() {
            return this.qb;
        }

        public void e(long j) {
            this.qb = j;
        }

        public int fb() {
            return this.mCount;
        }

        public void an(int i) {
            this.mCount = i;
        }

        public long fc() {
            return this.pZ;
        }

        public void f(long j) {
            this.pZ = j;
        }

        public boolean fd() {
            return this.qa;
        }

        public void F(boolean z) {
            this.qa = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int qd;
        private int qe;
        private int qf;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }

        public int fe() {
            return this.qd;
        }

        public void ao(int i) {
            this.qd = i;
        }

        public int ff() {
            return this.qe;
        }

        public void ap(int i) {
            this.qe = i;
        }

        public int fg() {
            return this.qf;
        }

        public void aq(int i) {
            this.qf = i;
        }
    }
}
