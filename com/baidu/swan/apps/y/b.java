package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.core.f;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.y.b.a;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class b extends HandlerThread implements com.baidu.swan.apps.y.a {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private a dlA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super("SwanAppPageMonitor");
        init();
    }

    private void init() {
        start();
        this.dlA = new a(getLooper());
    }

    @Override // com.baidu.swan.apps.y.a
    public void a(com.baidu.swan.apps.y.a.c cVar) {
        if (!isAlive()) {
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "thread is not alive");
            }
            try {
                init();
            } catch (Error | Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (cVar != null) {
            Message.obtain(this.dlA, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends Handler {
        private d dlB;
        private Deque<d> dlC;
        private com.baidu.swan.apps.y.b.a dlD;
        private int dlE;
        private HashMap<String, Integer> dlF;
        private com.baidu.swan.apps.y.b.b dlG;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.dlC = new ArrayDeque();
            this.mIsBackground = true;
            this.dlE = 0;
            this.dlD = a.C0509a.qX("simple_parser");
            this.dlG = (com.baidu.swan.apps.y.b.b) a.C0509a.qX("hsv_parser");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "get message " + message.what);
            }
            switch (message.what) {
                case 1:
                    removeMessages(9);
                    removeMessages(10);
                    b((com.baidu.swan.apps.y.a.c) message.obj);
                    return;
                case 2:
                    a((d) message.obj);
                    return;
                case 3:
                    removeMessages(2);
                    removeMessages(8);
                    return;
                case 4:
                    if (((com.baidu.swan.apps.y.a.b) message.obj).isBackground()) {
                        onBackground();
                        return;
                    } else {
                        onForeground();
                        return;
                    }
                case 5:
                    com.baidu.swan.apps.y.a.a aVar = (com.baidu.swan.apps.y.a.a) message.obj;
                    if (aVar != null) {
                        if (aVar.isShow()) {
                            this.dlE++;
                            return;
                        } else {
                            this.dlE--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.y.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.dlC.clear();
                    this.dlB = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.y.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.y.a.c) message.obj);
                    return;
                case 10:
                    aEJ();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.y.a.c cVar) {
            com.baidu.swan.apps.core.d.e aEK = c.aEK();
            if (aEK != null) {
                String arl = aEK.arl();
                com.baidu.swan.apps.adaptation.b.c arq = aEK.arq();
                if (b.DEBUG && arq == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + arl);
                }
                if (arq != null && !qT(arl)) {
                    d dVar = new d(arl, aEK.arp().mPage, cVar.aFc(), cVar.aFd());
                    this.dlC.addLast(dVar);
                    this.dlB = dVar;
                    arq.a((com.baidu.swan.apps.core.f.c) f.aEX());
                    if (this.dlF != null && this.dlF.containsKey(arl)) {
                        this.dlB.dlT = this.dlF.remove(arl).intValue();
                    }
                    if (!this.mIsBackground && dVar.aEO() >= 0) {
                        b.this.dlA.sendMessageDelayed(Message.obtain(b.this.dlA, 2, dVar), this.dlB.aEO());
                    }
                }
            }
        }

        private boolean qT(String str) {
            return (this.dlB == null || str == null || !TextUtils.equals(str, this.dlB.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && qT(dVar.id)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.qU(dVar.id);
                        Bitmap aPo = ah.aPo();
                        if (aPo != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.y.a.d(dVar.id, aPo)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.y.a.d dVar) {
            if (dVar != null && qT(dVar.aFb())) {
                Bitmap aFe = dVar.aFe();
                com.baidu.swan.apps.core.d.e aEK = c.aEK();
                AbsoluteLayout qo = com.baidu.swan.apps.v.f.aCp().qo(dVar.aFb());
                if (aFe != null && qo != null && aEK != null) {
                    Rect a2 = c.a(aFe, aEK, qo);
                    this.dlD.jW(c.f(aEK));
                    this.dlB.aEP();
                    boolean aEG = aEG();
                    if (c.aEN() || this.dlE > 0) {
                        this.dlB.cpz = false;
                    } else {
                        this.dlB.cpz = this.dlD.a(aFe, a2);
                        if (this.dlB.cpz) {
                            if (aEG) {
                                this.dlB.p(aFe);
                                this.dlB.bHi = a2;
                            }
                            c.gf(aEG);
                            a(this.dlB, 19, false, null);
                        }
                    }
                    this.dlB.aEQ();
                    if (aEG) {
                        double c = this.dlG.c(aFe, a2);
                        if (c >= 0.5d) {
                            a(this.dlB, 28, aEI(), aFe);
                        }
                        if (!this.dlB.cpz) {
                            if (c.aiu()) {
                                if (c >= f.a.cNf) {
                                    c.ci("whiteScreen_L3", com.baidu.swan.apps.core.a.cMT);
                                }
                            } else if (this.dlE == 0 && c >= f.a.cNg) {
                                c.ci("whiteScreen_L2", com.baidu.swan.apps.core.a.cMS);
                            }
                        }
                    }
                }
            }
        }

        private boolean aEG() {
            return this.dlB != null && this.dlB.dlV;
        }

        private void onBackground() {
            this.mIsBackground = true;
            if (this.dlB != null) {
                if (!this.dlB.isChecked()) {
                    if (b.this.dlA != null) {
                        b.this.dlA.removeMessages(2);
                    }
                    this.dlB.pause();
                } else if (this.dlB.cpz && aEG()) {
                    aEH();
                }
            }
        }

        private void onForeground() {
            this.mIsBackground = false;
            if (this.dlB != null && !this.dlB.isChecked()) {
                this.dlB.resume();
                long aEO = this.dlB.aEO();
                if (aEO >= 0) {
                    b.this.dlA.sendMessageDelayed(Message.obtain(b.this.dlA, 2, this.dlB), aEO);
                }
            }
        }

        private void a(com.baidu.swan.apps.y.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String aFb = eVar.aFb();
                Iterator<d> it = this.dlC.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, aFb)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.dlT++;
                        return;
                    }
                    if (this.dlF == null) {
                        this.dlF = new HashMap<>();
                    }
                    Integer num2 = this.dlF.get(aFb);
                    this.dlF.put(aFb, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.dlT--;
                } else if (this.dlF != null && (num = this.dlF.get(aFb)) != null && num.intValue() > 0) {
                    this.dlF.put(aFb, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void qU(String str) {
            if (aEG()) {
                com.baidu.swan.apps.v.f.aCp().b(com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                com.baidu.swan.apps.v.f.aCp().a(str, com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void aEH() {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
                    if (aBZ != null && !aBZ.isFinishing() && !aBZ.isDestroyed() && a.this.dlB != null) {
                        final Bitmap aPo = ah.aPo();
                        p.aOZ().execute(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.dlD.a(aPo, a.this.dlB.bHi)) {
                                    a.this.a(a.this.dlB, 33, false, null);
                                    ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                                            }
                                            aBZ.finish();
                                        }
                                    });
                                }
                            }
                        }, "SwanPageMonitorRecheck");
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar, int i, boolean z, Bitmap bitmap) {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "errorReport: error report with error=" + i);
            }
            JSONObject aEL = c.aEL();
            try {
                aEL.put("page", dVar.url);
                aEL.put("firstPage", aEG());
                if (z && bitmap != null) {
                    aEL.put("image", c.o(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(i).uC(aEL.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.aJU() != null) {
                aVar = com.baidu.swan.apps.runtime.e.aJU().aio();
            }
            com.baidu.swan.apps.statistic.a.d hc = new com.baidu.swan.apps.statistic.a.d().i(uC).a(aVar).tK(h.kS(com.baidu.swan.apps.runtime.d.aJQ().aie())).tL(com.baidu.swan.apps.runtime.e.aJW()).tN(String.valueOf(this.dlC.size())).hc(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.dlT == 0 ? "0" : "1");
                hc.cc(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (aEG()) {
                hc.cc(com.baidu.swan.apps.ak.a.aMs().aMt());
                hc.cc(com.baidu.swan.apps.ak.a.aMs().aMu());
            }
            h.b(hc);
        }

        private boolean aEI() {
            String string = com.baidu.swan.apps.storage.c.h.aNr().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.y.a.c cVar) {
            if (cVar.aFc() >= 0) {
                com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
                if (aim == null || aim.arE() <= 0) {
                    if (b.DEBUG) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.aFc());
                    }
                    b.this.dlA.sendMessageDelayed(Message.obtain(b.this.dlA, 10, cVar), cVar.aFc());
                }
            }
        }

        private void aEJ() {
            boolean z;
            SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
            if (aBZ != null && !aBZ.isFinishing() && !aBZ.isDestroyed() && aBZ.aii() != null && aBZ.aii().dLs != null) {
                com.baidu.swan.apps.view.c aii = aBZ.aii();
                if (aii == null || aii.dLs == null) {
                    z = false;
                } else {
                    z = aii.dLs.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(19L).uC("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.aJU() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.aJU().aio();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().i(uC).a(aVar).tK(h.kS(com.baidu.swan.apps.runtime.d.aJQ().aie())).tL(com.baidu.swan.apps.runtime.d.aJQ().getAppId()).tN(String.valueOf(this.dlC.size())).hc(false));
                }
            }
        }
    }
}
