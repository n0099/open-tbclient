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
    private a dqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super("SwanAppPageMonitor");
        init();
    }

    private void init() {
        start();
        this.dqz = new a(getLooper());
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
            Message.obtain(this.dqz, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends Handler {
        private d dqA;
        private Deque<d> dqB;
        private com.baidu.swan.apps.y.b.a dqC;
        private int dqD;
        private HashMap<String, Integer> dqE;
        private com.baidu.swan.apps.y.b.b dqF;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.dqB = new ArrayDeque();
            this.mIsBackground = true;
            this.dqD = 0;
            this.dqC = a.C0502a.qR("simple_parser");
            this.dqF = (com.baidu.swan.apps.y.b.b) a.C0502a.qR("hsv_parser");
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
                            this.dqD++;
                            return;
                        } else {
                            this.dqD--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.y.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.dqB.clear();
                    this.dqA = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.y.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.y.a.c) message.obj);
                    return;
                case 10:
                    aGd();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.y.a.c cVar) {
            com.baidu.swan.apps.core.d.e aGe = c.aGe();
            if (aGe != null) {
                String asD = aGe.asD();
                com.baidu.swan.apps.adaptation.b.c asI = aGe.asI();
                if (b.DEBUG && asI == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + asD);
                }
                if (asI != null && !qN(asD)) {
                    d dVar = new d(asD, aGe.asH().mPage, cVar.aGw(), cVar.aGx());
                    this.dqB.addLast(dVar);
                    this.dqA = dVar;
                    asI.a((com.baidu.swan.apps.core.f.c) f.aGr());
                    if (this.dqE != null && this.dqE.containsKey(asD)) {
                        this.dqA.dqS = this.dqE.remove(asD).intValue();
                    }
                    if (!this.mIsBackground && dVar.aGi() >= 0) {
                        b.this.dqz.sendMessageDelayed(Message.obtain(b.this.dqz, 2, dVar), this.dqA.aGi());
                    }
                }
            }
        }

        private boolean qN(String str) {
            return (this.dqA == null || str == null || !TextUtils.equals(str, this.dqA.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && qN(dVar.id)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.qO(dVar.id);
                        Bitmap aRF = ah.aRF();
                        if (aRF != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.y.a.d(dVar.id, aRF)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.y.a.d dVar) {
            if (dVar != null && qN(dVar.aGv())) {
                Bitmap aGy = dVar.aGy();
                com.baidu.swan.apps.core.d.e aGe = c.aGe();
                AbsoluteLayout qh = com.baidu.swan.apps.v.f.aDG().qh(dVar.aGv());
                if (aGy != null && qh != null && aGe != null) {
                    Rect a2 = c.a(aGy, aGe, qh);
                    this.dqC.jR(c.f(aGe));
                    this.dqA.aGj();
                    boolean aGa = aGa();
                    if (c.aGh() || this.dqD > 0) {
                        this.dqA.cwE = false;
                    } else {
                        this.dqA.cwE = this.dqC.a(aGy, a2);
                        if (this.dqA.cwE) {
                            if (aGa) {
                                this.dqA.q(aGy);
                                this.dqA.rect = a2;
                            }
                            c.go(aGa);
                            a(this.dqA, 19, false, null);
                        }
                    }
                    this.dqA.aGk();
                    if (aGa) {
                        double c = this.dqF.c(aGy, a2);
                        if (c >= 0.5d) {
                            a(this.dqA, 28, aGc(), aGy);
                        }
                        if (!this.dqA.cwE) {
                            if (c.ajA()) {
                                if (c >= f.a.cSa) {
                                    c.ch("whiteScreen_L3", com.baidu.swan.apps.core.a.cRO);
                                }
                            } else if (this.dqD == 0 && c >= f.a.cSb) {
                                c.ch("whiteScreen_L2", com.baidu.swan.apps.core.a.cRN);
                            }
                        }
                    }
                }
            }
        }

        private boolean aGa() {
            return this.dqA != null && this.dqA.dqU;
        }

        private void onBackground() {
            this.mIsBackground = true;
            if (this.dqA != null) {
                if (!this.dqA.isChecked()) {
                    if (b.this.dqz != null) {
                        b.this.dqz.removeMessages(2);
                    }
                    this.dqA.pause();
                } else if (this.dqA.cwE && aGa()) {
                    aGb();
                }
            }
        }

        private void onForeground() {
            this.mIsBackground = false;
            if (this.dqA != null && !this.dqA.isChecked()) {
                this.dqA.resume();
                long aGi = this.dqA.aGi();
                if (aGi >= 0) {
                    b.this.dqz.sendMessageDelayed(Message.obtain(b.this.dqz, 2, this.dqA), aGi);
                }
            }
        }

        private void a(com.baidu.swan.apps.y.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String aGv = eVar.aGv();
                Iterator<d> it = this.dqB.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, aGv)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.dqS++;
                        return;
                    }
                    if (this.dqE == null) {
                        this.dqE = new HashMap<>();
                    }
                    Integer num2 = this.dqE.get(aGv);
                    this.dqE.put(aGv, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.dqS--;
                } else if (this.dqE != null && (num = this.dqE.get(aGv)) != null && num.intValue() > 0) {
                    this.dqE.put(aGv, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void qO(String str) {
            if (aGa()) {
                com.baidu.swan.apps.v.f.aDG().b(com.baidu.swan.apps.aj.b.a(new com.baidu.swan.apps.aj.b()));
                com.baidu.swan.apps.v.f.aDG().a(str, com.baidu.swan.apps.aj.b.a(new com.baidu.swan.apps.aj.b()));
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void aGb() {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            ak.l(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity aDq = com.baidu.swan.apps.v.f.aDG().aDq();
                    if (aDq != null && !aDq.isFinishing() && !aDq.isDestroyed() && a.this.dqA != null) {
                        final Bitmap aRF = ah.aRF();
                        p.aRq().execute(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.dqC.a(aRF, a.this.dqA.rect)) {
                                    a.this.a(a.this.dqA, 33, false, null);
                                    ak.l(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                                            }
                                            aDq.finish();
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
            JSONObject aGf = c.aGf();
            try {
                aGf.put("page", dVar.url);
                aGf.put("firstPage", aGa());
                if (z && bitmap != null) {
                    aGf.put("image", c.p(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(i).uz(aGf.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.aMk() != null) {
                aVar = com.baidu.swan.apps.runtime.e.aMk().aju();
            }
            com.baidu.swan.apps.statistic.a.d hu = new com.baidu.swan.apps.statistic.a.d().i(uz).a(aVar).tH(h.kX(com.baidu.swan.apps.runtime.d.aMg().ajk())).tI(com.baidu.swan.apps.runtime.e.aMm()).tK(String.valueOf(this.dqB.size())).hu(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.dqS == 0 ? "0" : "1");
                hu.ck(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (aGa()) {
                hu.ck(com.baidu.swan.apps.aj.a.aOI().aOJ());
                hu.ck(com.baidu.swan.apps.aj.a.aOI().aOK());
            }
            h.b(hu);
        }

        private boolean aGc() {
            String string = com.baidu.swan.apps.storage.c.h.aPH().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.y.a.c cVar) {
            if (cVar.aGw() >= 0) {
                com.baidu.swan.apps.core.d.f ajs = com.baidu.swan.apps.v.f.aDG().ajs();
                if (ajs == null || ajs.asW() <= 0) {
                    if (b.DEBUG) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.aGw());
                    }
                    b.this.dqz.sendMessageDelayed(Message.obtain(b.this.dqz, 10, cVar), cVar.aGw());
                }
            }
        }

        private void aGd() {
            boolean z;
            SwanAppActivity aDq = com.baidu.swan.apps.v.f.aDG().aDq();
            if (aDq != null && !aDq.isFinishing() && !aDq.isDestroyed() && aDq.ajo() != null && aDq.ajo().dUk != null) {
                com.baidu.swan.apps.view.c ajo = aDq.ajo();
                if (ajo == null || ajo.dUk == null) {
                    z = false;
                } else {
                    z = ajo.dUk.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(19L).uz("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.aMk() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.aMk().aju();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().i(uz).a(aVar).tH(h.kX(com.baidu.swan.apps.runtime.d.aMg().ajk())).tI(com.baidu.swan.apps.runtime.d.aMg().getAppId()).tK(String.valueOf(this.dqB.size())).hu(false));
                }
            }
        }
    }
}
