package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
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
/* loaded from: classes9.dex */
public class b extends HandlerThread implements com.baidu.swan.apps.y.a {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private a dnU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super("SwanAppPageMonitor");
        init();
    }

    private void init() {
        start();
        this.dnU = new a(getLooper());
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
            Message.obtain(this.dnU, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends Handler {
        private d dnV;
        private Deque<d> dnW;
        private com.baidu.swan.apps.y.b.a dnX;
        private int dnY;
        private HashMap<String, Integer> dnZ;
        private com.baidu.swan.apps.y.b.b doa;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.dnW = new ArrayDeque();
            this.mIsBackground = true;
            this.dnY = 0;
            this.dnX = a.C0482a.pY("simple_parser");
            this.doa = (com.baidu.swan.apps.y.b.b) a.C0482a.pY("hsv_parser");
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
                            this.dnY++;
                            return;
                        } else {
                            this.dnY--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.y.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.dnW.clear();
                    this.dnV = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.y.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.y.a.c) message.obj);
                    return;
                case 10:
                    aCG();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.y.a.c cVar) {
            com.baidu.swan.apps.core.d.e aCH = c.aCH();
            if (aCH != null) {
                String apg = aCH.apg();
                com.baidu.swan.apps.adaptation.b.c apm = aCH.apm();
                if (b.DEBUG && apm == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + apg);
                }
                if (apm != null && !pU(apg)) {
                    d dVar = new d(apg, aCH.apl().mPage, cVar.aCZ(), cVar.aDa());
                    this.dnW.addLast(dVar);
                    this.dnV = dVar;
                    apm.a((com.baidu.swan.apps.core.f.c) f.aCU());
                    if (this.dnZ != null && this.dnZ.containsKey(apg)) {
                        this.dnV.doo = this.dnZ.remove(apg).intValue();
                    }
                    if (!this.mIsBackground && dVar.aCL() >= 0) {
                        b.this.dnU.sendMessageDelayed(Message.obtain(b.this.dnU, 2, dVar), this.dnV.aCL());
                    }
                }
            }
        }

        private boolean pU(String str) {
            return (this.dnV == null || str == null || !TextUtils.equals(str, this.dnV.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && pU(dVar.id)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.pV(dVar.id);
                        Bitmap aOf = ah.aOf();
                        if (aOf != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.y.a.d(dVar.id, aOf)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.y.a.d dVar) {
            if (dVar != null && pU(dVar.aCY())) {
                Bitmap aDb = dVar.aDb();
                com.baidu.swan.apps.core.d.e aCH = c.aCH();
                AbsoluteLayout po = com.baidu.swan.apps.v.f.aAl().po(dVar.aCY());
                if (aDb != null && po != null && aCH != null) {
                    Rect a2 = c.a(aDb, aCH, po);
                    this.dnX.io(c.f(aCH));
                    this.dnV.aCM();
                    boolean aCD = aCD();
                    if (c.aCK() || this.dnY > 0) {
                        this.dnV.ctE = false;
                    } else {
                        this.dnV.ctE = this.dnX.a(aDb, a2);
                        if (this.dnV.ctE) {
                            if (aCD) {
                                this.dnV.p(aDb);
                                this.dnV.rect = a2;
                            }
                            c.gm(aCD);
                            a(this.dnV, 19, false, null);
                        }
                    }
                    this.dnV.aCN();
                    if (aCD) {
                        double c = this.doa.c(aDb, a2);
                        if (c >= 0.5d) {
                            a(this.dnV, 28, aCF(), aDb);
                        }
                        if (!this.dnV.ctE) {
                            if (c.agf()) {
                                if (c >= f.a.cPC) {
                                    c.ca("whiteScreen_L3", com.baidu.swan.apps.core.a.cPq);
                                }
                            } else if (this.dnY == 0 && c >= f.a.cPD) {
                                c.ca("whiteScreen_L2", com.baidu.swan.apps.core.a.cPp);
                            }
                        }
                    }
                }
            }
        }

        private boolean aCD() {
            return this.dnV != null && this.dnV.doq;
        }

        private void onBackground() {
            this.mIsBackground = true;
            if (this.dnV != null) {
                if (!this.dnV.isChecked()) {
                    if (b.this.dnU != null) {
                        b.this.dnU.removeMessages(2);
                    }
                    this.dnV.pause();
                } else if (this.dnV.ctE && aCD()) {
                    aCE();
                }
            }
        }

        private void onForeground() {
            this.mIsBackground = false;
            if (this.dnV != null && !this.dnV.isChecked()) {
                this.dnV.resume();
                long aCL = this.dnV.aCL();
                if (aCL >= 0) {
                    b.this.dnU.sendMessageDelayed(Message.obtain(b.this.dnU, 2, this.dnV), aCL);
                }
            }
        }

        private void a(com.baidu.swan.apps.y.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String aCY = eVar.aCY();
                Iterator<d> it = this.dnW.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, aCY)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.doo++;
                        return;
                    }
                    if (this.dnZ == null) {
                        this.dnZ = new HashMap<>();
                    }
                    Integer num2 = this.dnZ.get(aCY);
                    this.dnZ.put(aCY, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.doo--;
                } else if (this.dnZ != null && (num = this.dnZ.get(aCY)) != null && num.intValue() > 0) {
                    this.dnZ.put(aCY, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pV(String str) {
            if (aCD()) {
                com.baidu.swan.apps.v.f.aAl().b(com.baidu.swan.apps.aj.b.a(new com.baidu.swan.apps.aj.b()));
                com.baidu.swan.apps.v.f.aAl().a(str, com.baidu.swan.apps.aj.b.a(new com.baidu.swan.apps.aj.b()));
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void aCE() {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            ak.k(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity azV = com.baidu.swan.apps.v.f.aAl().azV();
                    if (azV != null && !azV.isFinishing() && !azV.isDestroyed() && a.this.dnV != null) {
                        final Bitmap aOf = ah.aOf();
                        p.aNQ().execute(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.dnX.a(aOf, a.this.dnV.rect)) {
                                    a.this.a(a.this.dnV, 33, false, null);
                                    ak.k(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                                            }
                                            azV.finish();
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
            JSONObject aCI = c.aCI();
            try {
                aCI.put("page", dVar.url);
                aCI.put("firstPage", aCD());
                if (z && bitmap != null) {
                    aCI.put("image", c.o(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(5L).dc(i).tH(aCI.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.aIK() != null) {
                aVar = com.baidu.swan.apps.runtime.e.aIK().afZ();
            }
            com.baidu.swan.apps.statistic.a.d hs = new com.baidu.swan.apps.statistic.a.d().i(tH).a(aVar).sP(h.ju(com.baidu.swan.apps.runtime.d.aIG().getFrameType())).sQ(com.baidu.swan.apps.runtime.e.aIM()).sS(String.valueOf(this.dnW.size())).hs(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.doo == 0 ? "0" : "1");
                hs.ch(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (aCD()) {
                hs.ch(com.baidu.swan.apps.aj.a.aLi().aLj());
                hs.ch(com.baidu.swan.apps.aj.a.aLi().aLk());
            }
            h.b(hs);
        }

        private boolean aCF() {
            String string = com.baidu.swan.apps.storage.c.h.aMh().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.y.a.c cVar) {
            if (cVar.aCZ() >= 0) {
                com.baidu.swan.apps.core.d.f afX = com.baidu.swan.apps.v.f.aAl().afX();
                if (afX == null || afX.apA() <= 0) {
                    if (b.DEBUG) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.aCZ());
                    }
                    b.this.dnU.sendMessageDelayed(Message.obtain(b.this.dnU, 10, cVar), cVar.aCZ());
                }
            }
        }

        private void aCG() {
            boolean z;
            SwanAppActivity azV = com.baidu.swan.apps.v.f.aAl().azV();
            if (azV != null && !azV.isFinishing() && !azV.isDestroyed() && azV.afT() != null && azV.afT().dRE != null) {
                com.baidu.swan.apps.view.c afT = azV.afT();
                if (afT == null || afT.dRE == null) {
                    z = false;
                } else {
                    z = afT.dRE.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(5L).dc(19L).tH("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.aIK() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.aIK().afZ();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().i(tH).a(aVar).sP(h.ju(com.baidu.swan.apps.runtime.d.aIG().getFrameType())).sQ(com.baidu.swan.apps.runtime.d.aIG().getAppId()).sS(String.valueOf(this.dnW.size())).hs(false));
                }
            }
        }
    }
}
