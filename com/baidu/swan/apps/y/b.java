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
    private a dam;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super("SwanAppPageMonitor");
        init();
    }

    private void init() {
        start();
        this.dam = new a(getLooper());
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
            Message.obtain(this.dam, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends Handler {
        private d dan;
        private Deque<d> dao;
        private com.baidu.swan.apps.y.b.a dap;
        private int daq;
        private HashMap<String, Integer> dar;
        private com.baidu.swan.apps.y.b.b das;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.dao = new ArrayDeque();
            this.mIsBackground = true;
            this.daq = 0;
            this.dap = a.C0487a.qi("simple_parser");
            this.das = (com.baidu.swan.apps.y.b.b) a.C0487a.qi("hsv_parser");
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
                            this.daq++;
                            return;
                        } else {
                            this.daq--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.y.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.dao.clear();
                    this.dan = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.y.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.y.a.c) message.obj);
                    return;
                case 10:
                    azI();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.y.a.c cVar) {
            com.baidu.swan.apps.core.d.e azJ = c.azJ();
            if (azJ != null) {
                String aml = azJ.aml();
                com.baidu.swan.apps.adaptation.b.c amq = azJ.amq();
                if (b.DEBUG && amq == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + aml);
                }
                if (amq != null && !qe(aml)) {
                    d dVar = new d(aml, azJ.amp().mPage, cVar.aAb(), cVar.aAc());
                    this.dao.addLast(dVar);
                    this.dan = dVar;
                    amq.a((com.baidu.swan.apps.core.f.c) f.azW());
                    if (this.dar != null && this.dar.containsKey(aml)) {
                        this.dan.daG = this.dar.remove(aml).intValue();
                    }
                    if (!this.mIsBackground && dVar.azN() >= 0) {
                        b.this.dam.sendMessageDelayed(Message.obtain(b.this.dam, 2, dVar), this.dan.azN());
                    }
                }
            }
        }

        private boolean qe(String str) {
            return (this.dan == null || str == null || !TextUtils.equals(str, this.dan.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && qe(dVar.id)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.qf(dVar.id);
                        Bitmap aKp = ah.aKp();
                        if (aKp != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.y.a.d(dVar.id, aKp)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.y.a.d dVar) {
            if (dVar != null && qe(dVar.aAa())) {
                Bitmap aAd = dVar.aAd();
                com.baidu.swan.apps.core.d.e azJ = c.azJ();
                AbsoluteLayout pz = com.baidu.swan.apps.v.f.axo().pz(dVar.aAa());
                if (aAd != null && pz != null && azJ != null) {
                    Rect a2 = c.a(aAd, azJ, pz);
                    this.dap.js(c.f(azJ));
                    this.dan.azO();
                    boolean azF = azF();
                    if (c.azM() || this.daq > 0) {
                        this.dan.ceN = false;
                    } else {
                        this.dan.ceN = this.dap.a(aAd, a2);
                        if (this.dan.ceN) {
                            if (azF) {
                                this.dan.p(aAd);
                                this.dan.bxA = a2;
                            }
                            c.fE(azF);
                            a(this.dan, 19, false, null);
                        }
                    }
                    this.dan.azP();
                    if (azF) {
                        double c = this.das.c(aAd, a2);
                        if (c >= 0.5d) {
                            a(this.dan, 28, azH(), aAd);
                        }
                        if (!this.dan.ceN) {
                            if (c.adu()) {
                                if (c >= f.a.cCc) {
                                    c.cc("whiteScreen_L3", com.baidu.swan.apps.core.a.cBQ);
                                }
                            } else if (this.daq == 0 && c >= f.a.cCd) {
                                c.cc("whiteScreen_L2", com.baidu.swan.apps.core.a.cBP);
                            }
                        }
                    }
                }
            }
        }

        private boolean azF() {
            return this.dan != null && this.dan.daI;
        }

        private void onBackground() {
            this.mIsBackground = true;
            if (this.dan != null) {
                if (!this.dan.isChecked()) {
                    if (b.this.dam != null) {
                        b.this.dam.removeMessages(2);
                    }
                    this.dan.pause();
                } else if (this.dan.ceN && azF()) {
                    azG();
                }
            }
        }

        private void onForeground() {
            this.mIsBackground = false;
            if (this.dan != null && !this.dan.isChecked()) {
                this.dan.resume();
                long azN = this.dan.azN();
                if (azN >= 0) {
                    b.this.dam.sendMessageDelayed(Message.obtain(b.this.dam, 2, this.dan), azN);
                }
            }
        }

        private void a(com.baidu.swan.apps.y.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String aAa = eVar.aAa();
                Iterator<d> it = this.dao.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, aAa)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.daG++;
                        return;
                    }
                    if (this.dar == null) {
                        this.dar = new HashMap<>();
                    }
                    Integer num2 = this.dar.get(aAa);
                    this.dar.put(aAa, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.daG--;
                } else if (this.dar != null && (num = this.dar.get(aAa)) != null && num.intValue() > 0) {
                    this.dar.put(aAa, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void qf(String str) {
            if (azF()) {
                com.baidu.swan.apps.v.f.axo().b(com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                com.baidu.swan.apps.v.f.axo().a(str, com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void azG() {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity awY = com.baidu.swan.apps.v.f.axo().awY();
                    if (awY != null && !awY.isFinishing() && !awY.isDestroyed() && a.this.dan != null) {
                        final Bitmap aKp = ah.aKp();
                        p.aKa().execute(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.dap.a(aKp, a.this.dan.bxA)) {
                                    a.this.a(a.this.dan, 33, false, null);
                                    ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                                            }
                                            awY.finish();
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
            JSONObject azK = c.azK();
            try {
                azK.put("page", dVar.url);
                azK.put("firstPage", azF());
                if (z && bitmap != null) {
                    azK.put("image", c.o(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(i).tM(azK.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.aEU() != null) {
                aVar = com.baidu.swan.apps.runtime.e.aEU().ado();
            }
            com.baidu.swan.apps.statistic.a.d gB = new com.baidu.swan.apps.statistic.a.d().i(tM).a(aVar).sU(h.ko(com.baidu.swan.apps.runtime.d.aEQ().ade())).sV(com.baidu.swan.apps.runtime.e.aEW()).sX(String.valueOf(this.dao.size())).gB(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.daG == 0 ? "0" : "1");
                gB.ca(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (azF()) {
                gB.ca(com.baidu.swan.apps.ak.a.aHs().aHt());
                gB.ca(com.baidu.swan.apps.ak.a.aHs().aHu());
            }
            h.b(gB);
        }

        private boolean azH() {
            String string = com.baidu.swan.apps.storage.c.h.aIs().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.y.a.c cVar) {
            if (cVar.aAb() >= 0) {
                com.baidu.swan.apps.core.d.f adm = com.baidu.swan.apps.v.f.axo().adm();
                if (adm == null || adm.amE() <= 0) {
                    if (b.DEBUG) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.aAb());
                    }
                    b.this.dam.sendMessageDelayed(Message.obtain(b.this.dam, 10, cVar), cVar.aAb());
                }
            }
        }

        private void azI() {
            boolean z;
            SwanAppActivity awY = com.baidu.swan.apps.v.f.axo().awY();
            if (awY != null && !awY.isFinishing() && !awY.isDestroyed() && awY.adi() != null && awY.adi().dAj != null) {
                com.baidu.swan.apps.view.c adi = awY.adi();
                if (adi == null || adi.dAj == null) {
                    z = false;
                } else {
                    z = adi.dAj.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(19L).tM("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.aEU() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.aEU().ado();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().i(tM).a(aVar).sU(h.ko(com.baidu.swan.apps.runtime.d.aEQ().ade())).sV(com.baidu.swan.apps.runtime.d.aEQ().getAppId()).sX(String.valueOf(this.dao.size())).gB(false));
                }
            }
        }
    }
}
