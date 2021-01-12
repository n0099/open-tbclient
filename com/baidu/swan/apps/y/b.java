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
/* loaded from: classes8.dex */
public class b extends HandlerThread implements com.baidu.swan.apps.y.a {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private a dlJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super("SwanAppPageMonitor");
        init();
    }

    private void init() {
        start();
        this.dlJ = new a(getLooper());
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
            Message.obtain(this.dlJ, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends Handler {
        private d dlK;
        private Deque<d> dlL;
        private com.baidu.swan.apps.y.b.a dlM;
        private int dlN;
        private HashMap<String, Integer> dlO;
        private com.baidu.swan.apps.y.b.b dlP;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.dlL = new ArrayDeque();
            this.mIsBackground = true;
            this.dlN = 0;
            this.dlM = a.C0485a.pG("simple_parser");
            this.dlP = (com.baidu.swan.apps.y.b.b) a.C0485a.pG("hsv_parser");
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
                        Re();
                        return;
                    } else {
                        Rf();
                        return;
                    }
                case 5:
                    com.baidu.swan.apps.y.a.a aVar = (com.baidu.swan.apps.y.a.a) message.obj;
                    if (aVar != null) {
                        if (aVar.isShow()) {
                            this.dlN++;
                            return;
                        } else {
                            this.dlN--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.y.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.dlL.clear();
                    this.dlK = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.y.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.y.a.c) message.obj);
                    return;
                case 10:
                    aCk();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.y.a.c cVar) {
            com.baidu.swan.apps.core.d.e aCl = c.aCl();
            if (aCl != null) {
                String aoI = aCl.aoI();
                com.baidu.swan.apps.adaptation.b.c aoN = aCl.aoN();
                if (b.DEBUG && aoN == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + aoI);
                }
                if (aoN != null && !pC(aoI)) {
                    d dVar = new d(aoI, aCl.aoM().mPage, cVar.aCD(), cVar.aCE());
                    this.dlL.addLast(dVar);
                    this.dlK = dVar;
                    aoN.a((com.baidu.swan.apps.core.f.c) f.aCy());
                    if (this.dlO != null && this.dlO.containsKey(aoI)) {
                        this.dlK.dmc = this.dlO.remove(aoI).intValue();
                    }
                    if (!this.mIsBackground && dVar.aCp() >= 0) {
                        b.this.dlJ.sendMessageDelayed(Message.obtain(b.this.dlJ, 2, dVar), this.dlK.aCp());
                    }
                }
            }
        }

        private boolean pC(String str) {
            return (this.dlK == null || str == null || !TextUtils.equals(str, this.dlK.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && pC(dVar.id)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.pD(dVar.id);
                        Bitmap aNM = ah.aNM();
                        if (aNM != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.y.a.d(dVar.id, aNM)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.y.a.d dVar) {
            if (dVar != null && pC(dVar.aCC())) {
                Bitmap aCF = dVar.aCF();
                com.baidu.swan.apps.core.d.e aCl = c.aCl();
                AbsoluteLayout oW = com.baidu.swan.apps.v.f.azN().oW(dVar.aCC());
                if (aCF != null && oW != null && aCl != null) {
                    Rect a2 = c.a(aCF, aCl, oW);
                    this.dlM.il(c.f(aCl));
                    this.dlK.aCq();
                    boolean aCh = aCh();
                    if (c.aCo() || this.dlN > 0) {
                        this.dlK.crN = false;
                    } else {
                        this.dlK.crN = this.dlM.a(aCF, a2);
                        if (this.dlK.crN) {
                            if (aCh) {
                                this.dlK.q(aCF);
                                this.dlK.rect = a2;
                            }
                            c.gk(aCh);
                            a(this.dlK, 19, false, null);
                        }
                    }
                    this.dlK.aCr();
                    if (aCh) {
                        double c = this.dlP.c(aCF, a2);
                        if (c >= 0.5d) {
                            a(this.dlK, 28, aCj(), aCF);
                        }
                        if (!this.dlK.crN) {
                            if (c.afH()) {
                                if (c >= f.a.cNo) {
                                    c.cg("whiteScreen_L3", com.baidu.swan.apps.core.a.cNc);
                                }
                            } else if (this.dlN == 0 && c >= f.a.cNp) {
                                c.cg("whiteScreen_L2", com.baidu.swan.apps.core.a.cNb);
                            }
                        }
                    }
                }
            }
        }

        private boolean aCh() {
            return this.dlK != null && this.dlK.dme;
        }

        private void Re() {
            this.mIsBackground = true;
            if (this.dlK != null) {
                if (!this.dlK.isChecked()) {
                    if (b.this.dlJ != null) {
                        b.this.dlJ.removeMessages(2);
                    }
                    this.dlK.pause();
                } else if (this.dlK.crN && aCh()) {
                    aCi();
                }
            }
        }

        private void Rf() {
            this.mIsBackground = false;
            if (this.dlK != null && !this.dlK.isChecked()) {
                this.dlK.resume();
                long aCp = this.dlK.aCp();
                if (aCp >= 0) {
                    b.this.dlJ.sendMessageDelayed(Message.obtain(b.this.dlJ, 2, this.dlK), aCp);
                }
            }
        }

        private void a(com.baidu.swan.apps.y.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String aCC = eVar.aCC();
                Iterator<d> it = this.dlL.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, aCC)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.dmc++;
                        return;
                    }
                    if (this.dlO == null) {
                        this.dlO = new HashMap<>();
                    }
                    Integer num2 = this.dlO.get(aCC);
                    this.dlO.put(aCC, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.dmc--;
                } else if (this.dlO != null && (num = this.dlO.get(aCC)) != null && num.intValue() > 0) {
                    this.dlO.put(aCC, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pD(String str) {
            if (aCh()) {
                com.baidu.swan.apps.v.f.azN().b(com.baidu.swan.apps.aj.b.a(new com.baidu.swan.apps.aj.b()));
                com.baidu.swan.apps.v.f.azN().a(str, com.baidu.swan.apps.aj.b.a(new com.baidu.swan.apps.aj.b()));
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void aCi() {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            ak.l(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
                    if (azx != null && !azx.isFinishing() && !azx.isDestroyed() && a.this.dlK != null) {
                        final Bitmap aNM = ah.aNM();
                        p.aNx().execute(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.dlM.a(aNM, a.this.dlK.rect)) {
                                    a.this.a(a.this.dlK, 33, false, null);
                                    ak.l(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                                            }
                                            azx.finish();
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
            JSONObject aCm = c.aCm();
            try {
                aCm.put("page", dVar.url);
                aCm.put("firstPage", aCh());
                if (z && bitmap != null) {
                    aCm.put("image", c.p(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(5L).cW(i).to(aCm.toString());
            b.a aVar2 = null;
            if (com.baidu.swan.apps.runtime.e.aIr() != null) {
                aVar2 = com.baidu.swan.apps.runtime.e.aIr().afB();
            }
            com.baidu.swan.apps.statistic.a.d hq = new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aVar2).sw(h.jr(com.baidu.swan.apps.runtime.d.aIn().afr())).sx(com.baidu.swan.apps.runtime.e.aIt()).sz(String.valueOf(this.dlL.size())).hq(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.dmc == 0 ? "0" : "1");
                hq.ck(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (aCh()) {
                hq.ck(com.baidu.swan.apps.aj.a.aKP().aKQ());
                hq.ck(com.baidu.swan.apps.aj.a.aKP().aKR());
            }
            h.b(hq);
        }

        private boolean aCj() {
            String string = com.baidu.swan.apps.storage.c.h.aLO().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.y.a.c cVar) {
            if (cVar.aCD() >= 0) {
                com.baidu.swan.apps.core.d.f afz = com.baidu.swan.apps.v.f.azN().afz();
                if (afz == null || afz.apb() <= 0) {
                    if (b.DEBUG) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.aCD());
                    }
                    b.this.dlJ.sendMessageDelayed(Message.obtain(b.this.dlJ, 10, cVar), cVar.aCD());
                }
            }
        }

        private void aCk() {
            boolean z;
            SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
            if (azx != null && !azx.isFinishing() && !azx.isDestroyed() && azx.afv() != null && azx.afv().dPy != null) {
                com.baidu.swan.apps.view.c afv = azx.afv();
                if (afv == null || afv.dPy == null) {
                    z = false;
                } else {
                    z = afv.dPy.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(5L).cW(19L).to("loading=true");
                    b.a aVar2 = null;
                    if (com.baidu.swan.apps.runtime.e.aIr() != null) {
                        aVar2 = com.baidu.swan.apps.runtime.e.aIr().afB();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aVar2).sw(h.jr(com.baidu.swan.apps.runtime.d.aIn().afr())).sx(com.baidu.swan.apps.runtime.d.aIn().getAppId()).sz(String.valueOf(this.dlL.size())).hq(false));
                }
            }
        }
    }
}
