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
    private a dpy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super("SwanAppPageMonitor");
        init();
    }

    private void init() {
        start();
        this.dpy = new a(getLooper());
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
            Message.obtain(this.dpy, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends Handler {
        private Deque<d> dpA;
        private com.baidu.swan.apps.y.b.a dpB;
        private int dpC;
        private HashMap<String, Integer> dpD;
        private com.baidu.swan.apps.y.b.b dpE;
        private d dpz;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.dpA = new ArrayDeque();
            this.mIsBackground = true;
            this.dpC = 0;
            this.dpB = a.C0488a.qf("simple_parser");
            this.dpE = (com.baidu.swan.apps.y.b.b) a.C0488a.qf("hsv_parser");
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
                            this.dpC++;
                            return;
                        } else {
                            this.dpC--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.y.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.dpA.clear();
                    this.dpz = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.y.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.y.a.c) message.obj);
                    return;
                case 10:
                    aCJ();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.y.a.c cVar) {
            com.baidu.swan.apps.core.d.e aCK = c.aCK();
            if (aCK != null) {
                String apk = aCK.apk();
                com.baidu.swan.apps.adaptation.b.c app = aCK.app();
                if (b.DEBUG && app == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + apk);
                }
                if (app != null && !qb(apk)) {
                    d dVar = new d(apk, aCK.apo().mPage, cVar.aDc(), cVar.aDd());
                    this.dpA.addLast(dVar);
                    this.dpz = dVar;
                    app.a((com.baidu.swan.apps.core.f.c) f.aCX());
                    if (this.dpD != null && this.dpD.containsKey(apk)) {
                        this.dpz.dpR = this.dpD.remove(apk).intValue();
                    }
                    if (!this.mIsBackground && dVar.aCO() >= 0) {
                        b.this.dpy.sendMessageDelayed(Message.obtain(b.this.dpy, 2, dVar), this.dpz.aCO());
                    }
                }
            }
        }

        private boolean qb(String str) {
            return (this.dpz == null || str == null || !TextUtils.equals(str, this.dpz.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && qb(dVar.id)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.qc(dVar.id);
                        Bitmap aOi = ah.aOi();
                        if (aOi != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.y.a.d(dVar.id, aOi)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.y.a.d dVar) {
            if (dVar != null && qb(dVar.aDb())) {
                Bitmap aDe = dVar.aDe();
                com.baidu.swan.apps.core.d.e aCK = c.aCK();
                AbsoluteLayout pv = com.baidu.swan.apps.v.f.aAo().pv(dVar.aDb());
                if (aDe != null && pv != null && aCK != null) {
                    Rect a2 = c.a(aDe, aCK, pv);
                    this.dpB.ip(c.f(aCK));
                    this.dpz.aCP();
                    boolean aCG = aCG();
                    if (c.aCN() || this.dpC > 0) {
                        this.dpz.cvg = false;
                    } else {
                        this.dpz.cvg = this.dpB.a(aDe, a2);
                        if (this.dpz.cvg) {
                            if (aCG) {
                                this.dpz.p(aDe);
                                this.dpz.rect = a2;
                            }
                            c.gm(aCG);
                            a(this.dpz, 19, false, null);
                        }
                    }
                    this.dpz.aCQ();
                    if (aCG) {
                        double c = this.dpE.c(aDe, a2);
                        if (c >= 0.5d) {
                            a(this.dpz, 28, aCI(), aDe);
                        }
                        if (!this.dpz.cvg) {
                            if (c.agi()) {
                                if (c >= f.a.cRc) {
                                    c.ca("whiteScreen_L3", com.baidu.swan.apps.core.a.cQQ);
                                }
                            } else if (this.dpC == 0 && c >= f.a.cRd) {
                                c.ca("whiteScreen_L2", com.baidu.swan.apps.core.a.cQP);
                            }
                        }
                    }
                }
            }
        }

        private boolean aCG() {
            return this.dpz != null && this.dpz.dpT;
        }

        private void onBackground() {
            this.mIsBackground = true;
            if (this.dpz != null) {
                if (!this.dpz.isChecked()) {
                    if (b.this.dpy != null) {
                        b.this.dpy.removeMessages(2);
                    }
                    this.dpz.pause();
                } else if (this.dpz.cvg && aCG()) {
                    aCH();
                }
            }
        }

        private void onForeground() {
            this.mIsBackground = false;
            if (this.dpz != null && !this.dpz.isChecked()) {
                this.dpz.resume();
                long aCO = this.dpz.aCO();
                if (aCO >= 0) {
                    b.this.dpy.sendMessageDelayed(Message.obtain(b.this.dpy, 2, this.dpz), aCO);
                }
            }
        }

        private void a(com.baidu.swan.apps.y.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String aDb = eVar.aDb();
                Iterator<d> it = this.dpA.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, aDb)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.dpR++;
                        return;
                    }
                    if (this.dpD == null) {
                        this.dpD = new HashMap<>();
                    }
                    Integer num2 = this.dpD.get(aDb);
                    this.dpD.put(aDb, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.dpR--;
                } else if (this.dpD != null && (num = this.dpD.get(aDb)) != null && num.intValue() > 0) {
                    this.dpD.put(aDb, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void qc(String str) {
            if (aCG()) {
                com.baidu.swan.apps.v.f.aAo().b(com.baidu.swan.apps.aj.b.a(new com.baidu.swan.apps.aj.b()));
                com.baidu.swan.apps.v.f.aAo().a(str, com.baidu.swan.apps.aj.b.a(new com.baidu.swan.apps.aj.b()));
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void aCH() {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            ak.j(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity azY = com.baidu.swan.apps.v.f.aAo().azY();
                    if (azY != null && !azY.isFinishing() && !azY.isDestroyed() && a.this.dpz != null) {
                        final Bitmap aOi = ah.aOi();
                        p.aNT().execute(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.dpB.a(aOi, a.this.dpz.rect)) {
                                    a.this.a(a.this.dpz, 33, false, null);
                                    ak.j(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                                            }
                                            azY.finish();
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
            JSONObject aCL = c.aCL();
            try {
                aCL.put("page", dVar.url);
                aCL.put("firstPage", aCG());
                if (z && bitmap != null) {
                    aCL.put("image", c.o(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(i).tO(aCL.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.aIN() != null) {
                aVar = com.baidu.swan.apps.runtime.e.aIN().agc();
            }
            com.baidu.swan.apps.statistic.a.d hs = new com.baidu.swan.apps.statistic.a.d().i(tO).a(aVar).sW(h.jv(com.baidu.swan.apps.runtime.d.aIJ().getFrameType())).sX(com.baidu.swan.apps.runtime.e.aIP()).sZ(String.valueOf(this.dpA.size())).hs(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.dpR == 0 ? "0" : "1");
                hs.cj(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (aCG()) {
                hs.cj(com.baidu.swan.apps.aj.a.aLl().aLm());
                hs.cj(com.baidu.swan.apps.aj.a.aLl().aLn());
            }
            h.b(hs);
        }

        private boolean aCI() {
            String string = com.baidu.swan.apps.storage.c.h.aMk().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.y.a.c cVar) {
            if (cVar.aDc() >= 0) {
                com.baidu.swan.apps.core.d.f aga = com.baidu.swan.apps.v.f.aAo().aga();
                if (aga == null || aga.apD() <= 0) {
                    if (b.DEBUG) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.aDc());
                    }
                    b.this.dpy.sendMessageDelayed(Message.obtain(b.this.dpy, 10, cVar), cVar.aDc());
                }
            }
        }

        private void aCJ() {
            boolean z;
            SwanAppActivity azY = com.baidu.swan.apps.v.f.aAo().azY();
            if (azY != null && !azY.isFinishing() && !azY.isDestroyed() && azY.afW() != null && azY.afW().dTf != null) {
                com.baidu.swan.apps.view.c afW = azY.afW();
                if (afW == null || afW.dTf == null) {
                    z = false;
                } else {
                    z = afW.dTf.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(19L).tO("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.aIN() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.aIN().agc();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().i(tO).a(aVar).sW(h.jv(com.baidu.swan.apps.runtime.d.aIJ().getFrameType())).sX(com.baidu.swan.apps.runtime.d.aIJ().getAppId()).sZ(String.valueOf(this.dpA.size())).hs(false));
                }
            }
        }
    }
}
