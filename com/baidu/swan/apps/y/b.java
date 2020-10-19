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
/* loaded from: classes10.dex */
public class b extends HandlerThread implements com.baidu.swan.apps.y.a {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private a cRQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super("SwanAppPageMonitor");
        init();
    }

    private void init() {
        start();
        this.cRQ = new a(getLooper());
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
            Message.obtain(this.cRQ, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends Handler {
        private d cRR;
        private Deque<d> cRS;
        private com.baidu.swan.apps.y.b.a cRT;
        private int cRU;
        private HashMap<String, Integer> cRV;
        private com.baidu.swan.apps.y.b.b cRW;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.cRS = new ArrayDeque();
            this.mIsBackground = true;
            this.cRU = 0;
            this.cRT = a.C0473a.pP("simple_parser");
            this.cRW = (com.baidu.swan.apps.y.b.b) a.C0473a.pP("hsv_parser");
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
                            this.cRU++;
                            return;
                        } else {
                            this.cRU--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.y.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.cRS.clear();
                    this.cRR = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.y.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.y.a.c) message.obj);
                    return;
                case 10:
                    axO();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.y.a.c cVar) {
            com.baidu.swan.apps.core.d.e axP = c.axP();
            if (axP != null) {
                String akr = axP.akr();
                com.baidu.swan.apps.adaptation.b.c akw = axP.akw();
                if (b.DEBUG && akw == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + akr);
                }
                if (akw != null && !pL(akr)) {
                    d dVar = new d(akr, axP.akv().mPage, cVar.ayh(), cVar.ayi());
                    this.cRS.addLast(dVar);
                    this.cRR = dVar;
                    akw.a((com.baidu.swan.apps.core.f.c) f.ayc());
                    if (this.cRV != null && this.cRV.containsKey(akr)) {
                        this.cRR.cSi = this.cRV.remove(akr).intValue();
                    }
                    if (!this.mIsBackground && dVar.axT() >= 0) {
                        b.this.cRQ.sendMessageDelayed(Message.obtain(b.this.cRQ, 2, dVar), this.cRR.axT());
                    }
                }
            }
        }

        private boolean pL(String str) {
            return (this.cRR == null || str == null || !TextUtils.equals(str, this.cRR.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && pL(dVar.id)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.pM(dVar.id);
                        Bitmap aIv = ah.aIv();
                        if (aIv != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.y.a.d(dVar.id, aIv)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.y.a.d dVar) {
            if (dVar != null && pL(dVar.ayg())) {
                Bitmap ayj = dVar.ayj();
                com.baidu.swan.apps.core.d.e axP = c.axP();
                AbsoluteLayout pg = com.baidu.swan.apps.v.f.avu().pg(dVar.ayg());
                if (ayj != null && pg != null && axP != null) {
                    Rect a2 = c.a(ayj, axP, pg);
                    this.cRT.jh(c.f(axP));
                    this.cRR.axU();
                    boolean axL = axL();
                    if (c.axS() || this.cRU > 0) {
                        this.cRR.bWo = false;
                    } else {
                        this.cRR.bWo = this.cRT.a(ayj, a2);
                        if (this.cRR.bWo) {
                            if (axL) {
                                this.cRR.p(ayj);
                                this.cRR.bvm = a2;
                            }
                            c.fr(axL);
                            a(this.cRR, 19, false, null);
                        }
                    }
                    this.cRR.axV();
                    if (axL) {
                        double c = this.cRW.c(ayj, a2);
                        if (c >= 0.5d) {
                            a(this.cRR, 28, axN(), ayj);
                        }
                        if (!this.cRR.bWo) {
                            if (c.abA()) {
                                if (c >= f.a.ctE) {
                                    c.bV("whiteScreen_L3", com.baidu.swan.apps.core.a.ctq);
                                }
                            } else if (this.cRU == 0 && c >= f.a.ctF) {
                                c.bV("whiteScreen_L2", com.baidu.swan.apps.core.a.ctp);
                            }
                        }
                    }
                }
            }
        }

        private boolean axL() {
            return this.cRR != null && this.cRR.cSk;
        }

        private void onBackground() {
            this.mIsBackground = true;
            if (this.cRR != null) {
                if (!this.cRR.isChecked()) {
                    if (b.this.cRQ != null) {
                        b.this.cRQ.removeMessages(2);
                    }
                    this.cRR.pause();
                } else if (this.cRR.bWo && axL()) {
                    axM();
                }
            }
        }

        private void onForeground() {
            this.mIsBackground = false;
            if (this.cRR != null && !this.cRR.isChecked()) {
                this.cRR.resume();
                long axT = this.cRR.axT();
                if (axT >= 0) {
                    b.this.cRQ.sendMessageDelayed(Message.obtain(b.this.cRQ, 2, this.cRR), axT);
                }
            }
        }

        private void a(com.baidu.swan.apps.y.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String ayg = eVar.ayg();
                Iterator<d> it = this.cRS.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, ayg)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.cSi++;
                        return;
                    }
                    if (this.cRV == null) {
                        this.cRV = new HashMap<>();
                    }
                    Integer num2 = this.cRV.get(ayg);
                    this.cRV.put(ayg, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.cSi--;
                } else if (this.cRV != null && (num = this.cRV.get(ayg)) != null && num.intValue() > 0) {
                    this.cRV.put(ayg, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pM(String str) {
            if (axL()) {
                com.baidu.swan.apps.v.f.avu().b(com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                com.baidu.swan.apps.v.f.avu().a(str, com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void axM() {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity ave = com.baidu.swan.apps.v.f.avu().ave();
                    if (ave != null && !ave.isFinishing() && !ave.isDestroyed() && a.this.cRR != null) {
                        final Bitmap aIv = ah.aIv();
                        p.aIg().execute(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cRT.a(aIv, a.this.cRR.bvm)) {
                                    a.this.a(a.this.cRR, 33, false, null);
                                    ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                                            }
                                            ave.finish();
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
            JSONObject axQ = c.axQ();
            try {
                axQ.put("page", dVar.url);
                axQ.put("firstPage", axL());
                if (z && bitmap != null) {
                    axQ.put("image", c.o(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(5L).bY(i).tt(axQ.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.aDa() != null) {
                aVar = com.baidu.swan.apps.runtime.e.aDa().abu();
            }
            com.baidu.swan.apps.statistic.a.d go = new com.baidu.swan.apps.statistic.a.d().i(tt).a(aVar).sB(h.kd(com.baidu.swan.apps.runtime.d.aCW().abk())).sC(com.baidu.swan.apps.runtime.e.aDc()).sE(String.valueOf(this.cRS.size())).go(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.cSi == 0 ? "0" : "1");
                go.bX(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (axL()) {
                go.bX(com.baidu.swan.apps.ak.a.aFy().aFz());
                go.bX(com.baidu.swan.apps.ak.a.aFy().aFA());
            }
            h.b(go);
        }

        private boolean axN() {
            String string = com.baidu.swan.apps.storage.c.h.aGy().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.y.a.c cVar) {
            if (cVar.ayh() >= 0) {
                com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
                if (abs == null || abs.akK() <= 0) {
                    if (b.DEBUG) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.ayh());
                    }
                    b.this.cRQ.sendMessageDelayed(Message.obtain(b.this.cRQ, 10, cVar), cVar.ayh());
                }
            }
        }

        private void axO() {
            boolean z;
            SwanAppActivity ave = com.baidu.swan.apps.v.f.avu().ave();
            if (ave != null && !ave.isFinishing() && !ave.isDestroyed() && ave.abo() != null && ave.abo().drK != null) {
                com.baidu.swan.apps.view.c abo = ave.abo();
                if (abo == null || abo.drK == null) {
                    z = false;
                } else {
                    z = abo.drK.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(5L).bY(19L).tt("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.aDa() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.aDa().abu();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().i(tt).a(aVar).sB(h.kd(com.baidu.swan.apps.runtime.d.aCW().abk())).sC(com.baidu.swan.apps.runtime.d.aCW().getAppId()).sE(String.valueOf(this.cRS.size())).go(false));
                }
            }
        }
    }
}
