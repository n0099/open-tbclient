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
/* loaded from: classes7.dex */
public class b extends HandlerThread implements com.baidu.swan.apps.y.a {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private a deC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super("SwanAppPageMonitor");
        init();
    }

    private void init() {
        start();
        this.deC = new a(getLooper());
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
            Message.obtain(this.deC, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends Handler {
        private d deD;
        private Deque<d> deE;
        private com.baidu.swan.apps.y.b.a deF;
        private int deG;
        private HashMap<String, Integer> deH;
        private com.baidu.swan.apps.y.b.b deI;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.deE = new ArrayDeque();
            this.mIsBackground = true;
            this.deG = 0;
            this.deF = a.C0497a.qq("simple_parser");
            this.deI = (com.baidu.swan.apps.y.b.b) a.C0497a.qq("hsv_parser");
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
                            this.deG++;
                            return;
                        } else {
                            this.deG--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.y.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.deE.clear();
                    this.deD = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.y.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.y.a.c) message.obj);
                    return;
                case 10:
                    aBA();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.y.a.c cVar) {
            com.baidu.swan.apps.core.d.e aBB = c.aBB();
            if (aBB != null) {
                String aod = aBB.aod();
                com.baidu.swan.apps.adaptation.b.c aoi = aBB.aoi();
                if (b.DEBUG && aoi == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + aod);
                }
                if (aoi != null && !qm(aod)) {
                    d dVar = new d(aod, aBB.aoh().mPage, cVar.aBT(), cVar.aBU());
                    this.deE.addLast(dVar);
                    this.deD = dVar;
                    aoi.a((com.baidu.swan.apps.core.f.c) f.aBO());
                    if (this.deH != null && this.deH.containsKey(aod)) {
                        this.deD.deU = this.deH.remove(aod).intValue();
                    }
                    if (!this.mIsBackground && dVar.aBF() >= 0) {
                        b.this.deC.sendMessageDelayed(Message.obtain(b.this.deC, 2, dVar), this.deD.aBF());
                    }
                }
            }
        }

        private boolean qm(String str) {
            return (this.deD == null || str == null || !TextUtils.equals(str, this.deD.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && qm(dVar.id)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.qn(dVar.id);
                        Bitmap aMh = ah.aMh();
                        if (aMh != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.y.a.d(dVar.id, aMh)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.y.a.d dVar) {
            if (dVar != null && qm(dVar.aBS())) {
                Bitmap aBV = dVar.aBV();
                com.baidu.swan.apps.core.d.e aBB = c.aBB();
                AbsoluteLayout pH = com.baidu.swan.apps.v.f.azg().pH(dVar.aBS());
                if (aBV != null && pH != null && aBB != null) {
                    Rect a2 = c.a(aBV, aBB, pH);
                    this.deF.jy(c.f(aBB));
                    this.deD.aBG();
                    boolean aBx = aBx();
                    if (c.aBE() || this.deG > 0) {
                        this.deD.ciQ = false;
                    } else {
                        this.deD.ciQ = this.deF.a(aBV, a2);
                        if (this.deD.ciQ) {
                            if (aBx) {
                                this.deD.p(aBV);
                                this.deD.bCa = a2;
                            }
                            c.fQ(aBx);
                            a(this.deD, 19, false, null);
                        }
                    }
                    this.deD.aBH();
                    if (aBx) {
                        double c = this.deI.c(aBV, a2);
                        if (c >= 0.5d) {
                            a(this.deD, 28, aBz(), aBV);
                        }
                        if (!this.deD.ciQ) {
                            if (c.afm()) {
                                if (c >= f.a.cGl) {
                                    c.cb("whiteScreen_L3", com.baidu.swan.apps.core.a.cFZ);
                                }
                            } else if (this.deG == 0 && c >= f.a.cGm) {
                                c.cb("whiteScreen_L2", com.baidu.swan.apps.core.a.cFY);
                            }
                        }
                    }
                }
            }
        }

        private boolean aBx() {
            return this.deD != null && this.deD.deW;
        }

        private void onBackground() {
            this.mIsBackground = true;
            if (this.deD != null) {
                if (!this.deD.isChecked()) {
                    if (b.this.deC != null) {
                        b.this.deC.removeMessages(2);
                    }
                    this.deD.pause();
                } else if (this.deD.ciQ && aBx()) {
                    aBy();
                }
            }
        }

        private void onForeground() {
            this.mIsBackground = false;
            if (this.deD != null && !this.deD.isChecked()) {
                this.deD.resume();
                long aBF = this.deD.aBF();
                if (aBF >= 0) {
                    b.this.deC.sendMessageDelayed(Message.obtain(b.this.deC, 2, this.deD), aBF);
                }
            }
        }

        private void a(com.baidu.swan.apps.y.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String aBS = eVar.aBS();
                Iterator<d> it = this.deE.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, aBS)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.deU++;
                        return;
                    }
                    if (this.deH == null) {
                        this.deH = new HashMap<>();
                    }
                    Integer num2 = this.deH.get(aBS);
                    this.deH.put(aBS, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.deU--;
                } else if (this.deH != null && (num = this.deH.get(aBS)) != null && num.intValue() > 0) {
                    this.deH.put(aBS, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void qn(String str) {
            if (aBx()) {
                com.baidu.swan.apps.v.f.azg().b(com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                com.baidu.swan.apps.v.f.azg().a(str, com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void aBy() {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity ayQ = com.baidu.swan.apps.v.f.azg().ayQ();
                    if (ayQ != null && !ayQ.isFinishing() && !ayQ.isDestroyed() && a.this.deD != null) {
                        final Bitmap aMh = ah.aMh();
                        p.aLS().execute(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.deF.a(aMh, a.this.deD.bCa)) {
                                    a.this.a(a.this.deD, 33, false, null);
                                    ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                                            }
                                            ayQ.finish();
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
            JSONObject aBC = c.aBC();
            try {
                aBC.put("page", dVar.url);
                aBC.put("firstPage", aBx());
                if (z && bitmap != null) {
                    aBC.put("image", c.o(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(5L).cw(i).tV(aBC.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.aGM() != null) {
                aVar = com.baidu.swan.apps.runtime.e.aGM().afg();
            }
            com.baidu.swan.apps.statistic.a.d gN = new com.baidu.swan.apps.statistic.a.d().i(tV).a(aVar).td(h.ku(com.baidu.swan.apps.runtime.d.aGI().aeW())).te(com.baidu.swan.apps.runtime.e.aGO()).tg(String.valueOf(this.deE.size())).gN(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.deU == 0 ? "0" : "1");
                gN.ca(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (aBx()) {
                gN.ca(com.baidu.swan.apps.ak.a.aJk().aJl());
                gN.ca(com.baidu.swan.apps.ak.a.aJk().aJm());
            }
            h.b(gN);
        }

        private boolean aBz() {
            String string = com.baidu.swan.apps.storage.c.h.aKk().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.y.a.c cVar) {
            if (cVar.aBT() >= 0) {
                com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
                if (afe == null || afe.aow() <= 0) {
                    if (b.DEBUG) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.aBT());
                    }
                    b.this.deC.sendMessageDelayed(Message.obtain(b.this.deC, 10, cVar), cVar.aBT());
                }
            }
        }

        private void aBA() {
            boolean z;
            SwanAppActivity ayQ = com.baidu.swan.apps.v.f.azg().ayQ();
            if (ayQ != null && !ayQ.isFinishing() && !ayQ.isDestroyed() && ayQ.afa() != null && ayQ.afa().dEu != null) {
                com.baidu.swan.apps.view.c afa = ayQ.afa();
                if (afa == null || afa.dEu == null) {
                    z = false;
                } else {
                    z = afa.dEu.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(5L).cw(19L).tV("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.aGM() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.aGM().afg();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().i(tV).a(aVar).td(h.ku(com.baidu.swan.apps.runtime.d.aGI().aeW())).te(com.baidu.swan.apps.runtime.d.aGI().getAppId()).tg(String.valueOf(this.deE.size())).gN(false));
                }
            }
        }
    }
}
