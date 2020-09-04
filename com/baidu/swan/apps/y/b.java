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
/* loaded from: classes8.dex */
public class b extends HandlerThread implements com.baidu.swan.apps.y.a {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private a cDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super("SwanAppPageMonitor");
        init();
    }

    private void init() {
        start();
        this.cDM = new a(getLooper());
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
            Message.obtain(this.cDM, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends Handler {
        private d cDN;
        private Deque<d> cDO;
        private com.baidu.swan.apps.y.b.a cDP;
        private int cDQ;
        private HashMap<String, Integer> cDR;
        private com.baidu.swan.apps.y.b.b cDS;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.cDO = new ArrayDeque();
            this.mIsBackground = true;
            this.cDQ = 0;
            this.cDP = a.C0461a.oK("simple_parser");
            this.cDS = (com.baidu.swan.apps.y.b.b) a.C0461a.oK("hsv_parser");
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
                            this.cDQ++;
                            return;
                        } else {
                            this.cDQ--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.y.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.cDO.clear();
                    this.cDN = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.y.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.y.a.c) message.obj);
                    return;
                case 10:
                    auu();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.y.a.c cVar) {
            com.baidu.swan.apps.core.d.e auv = c.auv();
            if (auv != null) {
                String agW = auv.agW();
                com.baidu.swan.apps.adaptation.b.c ahb = auv.ahb();
                if (b.DEBUG && ahb == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + agW);
                }
                if (ahb != null && !oG(agW)) {
                    d dVar = new d(agW, auv.aha().mPage, cVar.auN(), cVar.auO());
                    this.cDO.addLast(dVar);
                    this.cDN = dVar;
                    ahb.a((com.baidu.swan.apps.core.f.c) f.auI());
                    if (this.cDR != null && this.cDR.containsKey(agW)) {
                        this.cDN.cEf = this.cDR.remove(agW).intValue();
                    }
                    if (!this.mIsBackground && dVar.auz() >= 0) {
                        b.this.cDM.sendMessageDelayed(Message.obtain(b.this.cDM, 2, dVar), this.cDN.auz());
                    }
                }
            }
        }

        private boolean oG(String str) {
            return (this.cDN == null || str == null || !TextUtils.equals(str, this.cDN.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && oG(dVar.id)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.oH(dVar.id);
                        Bitmap aFc = ah.aFc();
                        if (aFc != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.y.a.d(dVar.id, aFc)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.y.a.d dVar) {
            if (dVar != null && oG(dVar.auM())) {
                Bitmap auP = dVar.auP();
                com.baidu.swan.apps.core.d.e auv = c.auv();
                AbsoluteLayout nZ = com.baidu.swan.apps.v.f.arY().nZ(dVar.auM());
                if (auP != null && nZ != null && auv != null) {
                    Rect a = c.a(auP, auv, nZ);
                    this.cDP.iA(c.f(auv));
                    this.cDN.auA();
                    boolean aur = aur();
                    if (c.auy() || this.cDQ > 0) {
                        this.cDN.cEd = false;
                    } else {
                        this.cDN.cEd = this.cDP.a(auP, a);
                        if (this.cDN.cEd) {
                            if (aur) {
                                this.cDN.p(auP);
                                this.cDN.rect = a;
                            }
                            c.eX(aur);
                            a(this.cDN, 19, false, null);
                        }
                    }
                    this.cDN.auB();
                    if (aur) {
                        double c = this.cDS.c(auP, a);
                        if (c >= 0.5d) {
                            a(this.cDN, 28, aut(), auP);
                        }
                        if (!this.cDN.cEd) {
                            if (c.Yf()) {
                                if (c >= f.a.cfl) {
                                    c.bQ("whiteScreen_L3", com.baidu.swan.apps.core.a.ceY);
                                }
                            } else if (this.cDQ == 0 && c >= f.a.cfm) {
                                c.bQ("whiteScreen_L2", com.baidu.swan.apps.core.a.ceX);
                            }
                        }
                    }
                }
            }
        }

        private boolean aur() {
            return this.cDN != null && this.cDN.cEh;
        }

        private void onBackground() {
            this.mIsBackground = true;
            if (this.cDN != null) {
                if (!this.cDN.isChecked()) {
                    if (b.this.cDM != null) {
                        b.this.cDM.removeMessages(2);
                    }
                    this.cDN.pause();
                } else if (this.cDN.cEd && aur()) {
                    aus();
                }
            }
        }

        private void onForeground() {
            this.mIsBackground = false;
            if (this.cDN != null && !this.cDN.isChecked()) {
                this.cDN.resume();
                long auz = this.cDN.auz();
                if (auz >= 0) {
                    b.this.cDM.sendMessageDelayed(Message.obtain(b.this.cDM, 2, this.cDN), auz);
                }
            }
        }

        private void a(com.baidu.swan.apps.y.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String auM = eVar.auM();
                Iterator<d> it = this.cDO.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, auM)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.cEf++;
                        return;
                    }
                    if (this.cDR == null) {
                        this.cDR = new HashMap<>();
                    }
                    Integer num2 = this.cDR.get(auM);
                    this.cDR.put(auM, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.cEf--;
                } else if (this.cDR != null && (num = this.cDR.get(auM)) != null && num.intValue() > 0) {
                    this.cDR.put(auM, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void oH(String str) {
            if (aur()) {
                com.baidu.swan.apps.v.f.arY().b(com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                com.baidu.swan.apps.v.f.arY().a(str, com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void aus() {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
                    if (arI != null && !arI.isFinishing() && !arI.isDestroyed() && a.this.cDN != null) {
                        final Bitmap aFc = ah.aFc();
                        p.aEN().execute(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cDP.a(aFc, a.this.cDN.rect)) {
                                    a.this.a(a.this.cDN, 33, false, null);
                                    ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                                            }
                                            arI.finish();
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
            JSONObject auw = c.auw();
            try {
                auw.put("page", dVar.url);
                auw.put("firstPage", aur());
                if (z && bitmap != null) {
                    auw.put("image", c.o(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.am.a sn = new com.baidu.swan.apps.am.a().bO(5L).bP(i).sn(auw.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.azI() != null) {
                aVar = com.baidu.swan.apps.runtime.e.azI().XZ();
            }
            com.baidu.swan.apps.statistic.a.d fU = new com.baidu.swan.apps.statistic.a.d().i(sn).a(aVar).rv(h.jv(com.baidu.swan.apps.runtime.d.azE().XP())).rw(com.baidu.swan.apps.runtime.e.azK()).ry(String.valueOf(this.cDO.size())).fU(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.cEf == 0 ? "0" : "1");
                fU.bN(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (aur()) {
                fU.bN(com.baidu.swan.apps.ak.a.aCf().aCg());
                fU.bN(com.baidu.swan.apps.ak.a.aCf().aCh());
            }
            h.b(fU);
        }

        private boolean aut() {
            String string = com.baidu.swan.apps.storage.c.h.aDf().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.y.a.c cVar) {
            if (cVar.auN() >= 0) {
                com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
                if (XX == null || XX.ahp() <= 0) {
                    if (b.DEBUG) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.auN());
                    }
                    b.this.cDM.sendMessageDelayed(Message.obtain(b.this.cDM, 10, cVar), cVar.auN());
                }
            }
        }

        private void auu() {
            boolean z;
            SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
            if (arI != null && !arI.isFinishing() && !arI.isDestroyed() && arI.XT() != null && arI.XT().ddC != null) {
                com.baidu.swan.apps.view.c XT = arI.XT();
                if (XT == null || XT.ddC == null) {
                    z = false;
                } else {
                    z = XT.ddC.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.am.a sn = new com.baidu.swan.apps.am.a().bO(5L).bP(19L).sn("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.azI() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.azI().XZ();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().i(sn).a(aVar).rv(h.jv(com.baidu.swan.apps.runtime.d.azE().XP())).rw(com.baidu.swan.apps.runtime.d.azE().getAppId()).ry(String.valueOf(this.cDO.size())).fU(false));
                }
            }
        }
    }
}
