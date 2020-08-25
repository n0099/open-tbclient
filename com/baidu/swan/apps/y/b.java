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
    private a cDI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super("SwanAppPageMonitor");
        init();
    }

    private void init() {
        start();
        this.cDI = new a(getLooper());
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
            Message.obtain(this.cDI, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends Handler {
        private d cDJ;
        private Deque<d> cDK;
        private com.baidu.swan.apps.y.b.a cDL;
        private int cDM;
        private HashMap<String, Integer> cDN;
        private com.baidu.swan.apps.y.b.b cDO;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.cDK = new ArrayDeque();
            this.mIsBackground = true;
            this.cDM = 0;
            this.cDL = a.C0461a.oJ("simple_parser");
            this.cDO = (com.baidu.swan.apps.y.b.b) a.C0461a.oJ("hsv_parser");
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
                            this.cDM++;
                            return;
                        } else {
                            this.cDM--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.y.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.cDK.clear();
                    this.cDJ = null;
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
                if (ahb != null && !oF(agW)) {
                    d dVar = new d(agW, auv.aha().mPage, cVar.auN(), cVar.auO());
                    this.cDK.addLast(dVar);
                    this.cDJ = dVar;
                    ahb.a((com.baidu.swan.apps.core.f.c) f.auI());
                    if (this.cDN != null && this.cDN.containsKey(agW)) {
                        this.cDJ.cEb = this.cDN.remove(agW).intValue();
                    }
                    if (!this.mIsBackground && dVar.auz() >= 0) {
                        b.this.cDI.sendMessageDelayed(Message.obtain(b.this.cDI, 2, dVar), this.cDJ.auz());
                    }
                }
            }
        }

        private boolean oF(String str) {
            return (this.cDJ == null || str == null || !TextUtils.equals(str, this.cDJ.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && oF(dVar.id)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.oG(dVar.id);
                        Bitmap aFc = ah.aFc();
                        if (aFc != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.y.a.d(dVar.id, aFc)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.y.a.d dVar) {
            if (dVar != null && oF(dVar.auM())) {
                Bitmap auP = dVar.auP();
                com.baidu.swan.apps.core.d.e auv = c.auv();
                AbsoluteLayout nY = com.baidu.swan.apps.v.f.arY().nY(dVar.auM());
                if (auP != null && nY != null && auv != null) {
                    Rect a = c.a(auP, auv, nY);
                    this.cDL.iA(c.f(auv));
                    this.cDJ.auA();
                    boolean aur = aur();
                    if (c.auy() || this.cDM > 0) {
                        this.cDJ.cDZ = false;
                    } else {
                        this.cDJ.cDZ = this.cDL.a(auP, a);
                        if (this.cDJ.cDZ) {
                            if (aur) {
                                this.cDJ.p(auP);
                                this.cDJ.rect = a;
                            }
                            c.eW(aur);
                            a(this.cDJ, 19, false, null);
                        }
                    }
                    this.cDJ.auB();
                    if (aur) {
                        double c = this.cDO.c(auP, a);
                        if (c >= 0.5d) {
                            a(this.cDJ, 28, aut(), auP);
                        }
                        if (!this.cDJ.cDZ) {
                            if (c.Yf()) {
                                if (c >= f.a.cfh) {
                                    c.bQ("whiteScreen_L3", com.baidu.swan.apps.core.a.ceU);
                                }
                            } else if (this.cDM == 0 && c >= f.a.cfi) {
                                c.bQ("whiteScreen_L2", com.baidu.swan.apps.core.a.ceT);
                            }
                        }
                    }
                }
            }
        }

        private boolean aur() {
            return this.cDJ != null && this.cDJ.cEd;
        }

        private void onBackground() {
            this.mIsBackground = true;
            if (this.cDJ != null) {
                if (!this.cDJ.isChecked()) {
                    if (b.this.cDI != null) {
                        b.this.cDI.removeMessages(2);
                    }
                    this.cDJ.pause();
                } else if (this.cDJ.cDZ && aur()) {
                    aus();
                }
            }
        }

        private void onForeground() {
            this.mIsBackground = false;
            if (this.cDJ != null && !this.cDJ.isChecked()) {
                this.cDJ.resume();
                long auz = this.cDJ.auz();
                if (auz >= 0) {
                    b.this.cDI.sendMessageDelayed(Message.obtain(b.this.cDI, 2, this.cDJ), auz);
                }
            }
        }

        private void a(com.baidu.swan.apps.y.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String auM = eVar.auM();
                Iterator<d> it = this.cDK.iterator();
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
                        dVar.cEb++;
                        return;
                    }
                    if (this.cDN == null) {
                        this.cDN = new HashMap<>();
                    }
                    Integer num2 = this.cDN.get(auM);
                    this.cDN.put(auM, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.cEb--;
                } else if (this.cDN != null && (num = this.cDN.get(auM)) != null && num.intValue() > 0) {
                    this.cDN.put(auM, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void oG(String str) {
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
                    if (arI != null && !arI.isFinishing() && !arI.isDestroyed() && a.this.cDJ != null) {
                        final Bitmap aFc = ah.aFc();
                        p.aEN().execute(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cDL.a(aFc, a.this.cDJ.rect)) {
                                    a.this.a(a.this.cDJ, 33, false, null);
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
            com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(5L).bP(i).sm(auw.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.azI() != null) {
                aVar = com.baidu.swan.apps.runtime.e.azI().XZ();
            }
            com.baidu.swan.apps.statistic.a.d fT = new com.baidu.swan.apps.statistic.a.d().i(sm).a(aVar).ru(h.jv(com.baidu.swan.apps.runtime.d.azE().XP())).rv(com.baidu.swan.apps.runtime.e.azK()).rx(String.valueOf(this.cDK.size())).fT(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.cEb == 0 ? "0" : "1");
                fT.bN(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (aur()) {
                fT.bN(com.baidu.swan.apps.ak.a.aCf().aCg());
                fT.bN(com.baidu.swan.apps.ak.a.aCf().aCh());
            }
            h.b(fT);
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
                    b.this.cDI.sendMessageDelayed(Message.obtain(b.this.cDI, 10, cVar), cVar.auN());
                }
            }
        }

        private void auu() {
            boolean z;
            SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
            if (arI != null && !arI.isFinishing() && !arI.isDestroyed() && arI.XT() != null && arI.XT().ddy != null) {
                com.baidu.swan.apps.view.c XT = arI.XT();
                if (XT == null || XT.ddy == null) {
                    z = false;
                } else {
                    z = XT.ddy.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(5L).bP(19L).sm("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.azI() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.azI().XZ();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().i(sm).a(aVar).ru(h.jv(com.baidu.swan.apps.runtime.d.azE().XP())).rv(com.baidu.swan.apps.runtime.d.azE().getAppId()).rx(String.valueOf(this.cDK.size())).fT(false));
                }
            }
        }
    }
}
