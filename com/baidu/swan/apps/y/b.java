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
                    aGe();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.y.a.c cVar) {
            com.baidu.swan.apps.core.d.e aGf = c.aGf();
            if (aGf != null) {
                String asE = aGf.asE();
                com.baidu.swan.apps.adaptation.b.c asJ = aGf.asJ();
                if (b.DEBUG && asJ == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + asE);
                }
                if (asJ != null && !qN(asE)) {
                    d dVar = new d(asE, aGf.asI().mPage, cVar.aGx(), cVar.aGy());
                    this.dqB.addLast(dVar);
                    this.dqA = dVar;
                    asJ.a((com.baidu.swan.apps.core.f.c) f.aGs());
                    if (this.dqE != null && this.dqE.containsKey(asE)) {
                        this.dqA.dqS = this.dqE.remove(asE).intValue();
                    }
                    if (!this.mIsBackground && dVar.aGj() >= 0) {
                        b.this.dqz.sendMessageDelayed(Message.obtain(b.this.dqz, 2, dVar), this.dqA.aGj());
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
                        Bitmap aRG = ah.aRG();
                        if (aRG != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.y.a.d(dVar.id, aRG)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.y.a.d dVar) {
            if (dVar != null && qN(dVar.aGw())) {
                Bitmap aGz = dVar.aGz();
                com.baidu.swan.apps.core.d.e aGf = c.aGf();
                AbsoluteLayout qh = com.baidu.swan.apps.v.f.aDH().qh(dVar.aGw());
                if (aGz != null && qh != null && aGf != null) {
                    Rect a2 = c.a(aGz, aGf, qh);
                    this.dqC.jR(c.f(aGf));
                    this.dqA.aGk();
                    boolean aGb = aGb();
                    if (c.aGi() || this.dqD > 0) {
                        this.dqA.cwE = false;
                    } else {
                        this.dqA.cwE = this.dqC.a(aGz, a2);
                        if (this.dqA.cwE) {
                            if (aGb) {
                                this.dqA.q(aGz);
                                this.dqA.rect = a2;
                            }
                            c.go(aGb);
                            a(this.dqA, 19, false, null);
                        }
                    }
                    this.dqA.aGl();
                    if (aGb) {
                        double c = this.dqF.c(aGz, a2);
                        if (c >= 0.5d) {
                            a(this.dqA, 28, aGd(), aGz);
                        }
                        if (!this.dqA.cwE) {
                            if (c.ajB()) {
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

        private boolean aGb() {
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
                } else if (this.dqA.cwE && aGb()) {
                    aGc();
                }
            }
        }

        private void onForeground() {
            this.mIsBackground = false;
            if (this.dqA != null && !this.dqA.isChecked()) {
                this.dqA.resume();
                long aGj = this.dqA.aGj();
                if (aGj >= 0) {
                    b.this.dqz.sendMessageDelayed(Message.obtain(b.this.dqz, 2, this.dqA), aGj);
                }
            }
        }

        private void a(com.baidu.swan.apps.y.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String aGw = eVar.aGw();
                Iterator<d> it = this.dqB.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, aGw)) {
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
                    Integer num2 = this.dqE.get(aGw);
                    this.dqE.put(aGw, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.dqS--;
                } else if (this.dqE != null && (num = this.dqE.get(aGw)) != null && num.intValue() > 0) {
                    this.dqE.put(aGw, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void qO(String str) {
            if (aGb()) {
                com.baidu.swan.apps.v.f.aDH().b(com.baidu.swan.apps.aj.b.a(new com.baidu.swan.apps.aj.b()));
                com.baidu.swan.apps.v.f.aDH().a(str, com.baidu.swan.apps.aj.b.a(new com.baidu.swan.apps.aj.b()));
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void aGc() {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            ak.l(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity aDr = com.baidu.swan.apps.v.f.aDH().aDr();
                    if (aDr != null && !aDr.isFinishing() && !aDr.isDestroyed() && a.this.dqA != null) {
                        final Bitmap aRG = ah.aRG();
                        p.aRr().execute(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.dqC.a(aRG, a.this.dqA.rect)) {
                                    a.this.a(a.this.dqA, 33, false, null);
                                    ak.l(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                                            }
                                            aDr.finish();
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
            JSONObject aGg = c.aGg();
            try {
                aGg.put("page", dVar.url);
                aGg.put("firstPage", aGb());
                if (z && bitmap != null) {
                    aGg.put("image", c.p(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(i).uz(aGg.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.aMl() != null) {
                aVar = com.baidu.swan.apps.runtime.e.aMl().ajv();
            }
            com.baidu.swan.apps.statistic.a.d hu = new com.baidu.swan.apps.statistic.a.d().i(uz).a(aVar).tH(h.kX(com.baidu.swan.apps.runtime.d.aMh().ajl())).tI(com.baidu.swan.apps.runtime.e.aMn()).tK(String.valueOf(this.dqB.size())).hu(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.dqS == 0 ? "0" : "1");
                hu.ck(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (aGb()) {
                hu.ck(com.baidu.swan.apps.aj.a.aOJ().aOK());
                hu.ck(com.baidu.swan.apps.aj.a.aOJ().aOL());
            }
            h.b(hu);
        }

        private boolean aGd() {
            String string = com.baidu.swan.apps.storage.c.h.aPI().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.y.a.c cVar) {
            if (cVar.aGx() >= 0) {
                com.baidu.swan.apps.core.d.f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
                if (ajt == null || ajt.asX() <= 0) {
                    if (b.DEBUG) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.aGx());
                    }
                    b.this.dqz.sendMessageDelayed(Message.obtain(b.this.dqz, 10, cVar), cVar.aGx());
                }
            }
        }

        private void aGe() {
            boolean z;
            SwanAppActivity aDr = com.baidu.swan.apps.v.f.aDH().aDr();
            if (aDr != null && !aDr.isFinishing() && !aDr.isDestroyed() && aDr.ajp() != null && aDr.ajp().dUk != null) {
                com.baidu.swan.apps.view.c ajp = aDr.ajp();
                if (ajp == null || ajp.dUk == null) {
                    z = false;
                } else {
                    z = ajp.dUk.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(19L).uz("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.aMl() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.aMl().ajv();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().i(uz).a(aVar).tH(h.kX(com.baidu.swan.apps.runtime.d.aMh().ajl())).tI(com.baidu.swan.apps.runtime.d.aMh().getAppId()).tK(String.valueOf(this.dqB.size())).hu(false));
                }
            }
        }
    }
}
