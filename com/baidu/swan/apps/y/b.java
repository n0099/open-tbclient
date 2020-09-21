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
/* loaded from: classes3.dex */
public class b extends HandlerThread implements com.baidu.swan.apps.y.a {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private a cFM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super("SwanAppPageMonitor");
        init();
    }

    private void init() {
        start();
        this.cFM = new a(getLooper());
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
            Message.obtain(this.cFM, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        private d cFN;
        private Deque<d> cFO;
        private com.baidu.swan.apps.y.b.a cFP;
        private int cFQ;
        private HashMap<String, Integer> cFR;
        private com.baidu.swan.apps.y.b.b cFS;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.cFO = new ArrayDeque();
            this.mIsBackground = true;
            this.cFQ = 0;
            this.cFP = a.C0456a.pd("simple_parser");
            this.cFS = (com.baidu.swan.apps.y.b.b) a.C0456a.pd("hsv_parser");
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
                            this.cFQ++;
                            return;
                        } else {
                            this.cFQ--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.y.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.cFO.clear();
                    this.cFN = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.y.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.y.a.c) message.obj);
                    return;
                case 10:
                    avd();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.y.a.c cVar) {
            com.baidu.swan.apps.core.d.e ave = c.ave();
            if (ave != null) {
                String ahG = ave.ahG();
                com.baidu.swan.apps.adaptation.b.c ahL = ave.ahL();
                if (b.DEBUG && ahL == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + ahG);
                }
                if (ahL != null && !oZ(ahG)) {
                    d dVar = new d(ahG, ave.ahK().mPage, cVar.avw(), cVar.avx());
                    this.cFO.addLast(dVar);
                    this.cFN = dVar;
                    ahL.a((com.baidu.swan.apps.core.f.c) f.avr());
                    if (this.cFR != null && this.cFR.containsKey(ahG)) {
                        this.cFN.cGf = this.cFR.remove(ahG).intValue();
                    }
                    if (!this.mIsBackground && dVar.avi() >= 0) {
                        b.this.cFM.sendMessageDelayed(Message.obtain(b.this.cFM, 2, dVar), this.cFN.avi());
                    }
                }
            }
        }

        private boolean oZ(String str) {
            return (this.cFN == null || str == null || !TextUtils.equals(str, this.cFN.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && oZ(dVar.id)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.pa(dVar.id);
                        Bitmap aFM = ah.aFM();
                        if (aFM != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.y.a.d(dVar.id, aFM)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.y.a.d dVar) {
            if (dVar != null && oZ(dVar.avv())) {
                Bitmap avy = dVar.avy();
                com.baidu.swan.apps.core.d.e ave = c.ave();
                AbsoluteLayout ou = com.baidu.swan.apps.v.f.asJ().ou(dVar.avv());
                if (avy != null && ou != null && ave != null) {
                    Rect a = c.a(avy, ave, ou);
                    this.cFP.iK(c.f(ave));
                    this.cFN.avj();
                    boolean ava = ava();
                    if (c.avh() || this.cFQ > 0) {
                        this.cFN.cGd = false;
                    } else {
                        this.cFN.cGd = this.cFP.a(avy, a);
                        if (this.cFN.cGd) {
                            if (ava) {
                                this.cFN.p(avy);
                                this.cFN.bry = a;
                            }
                            c.eV(ava);
                            a(this.cFN, 19, false, null);
                        }
                    }
                    this.cFN.avk();
                    if (ava) {
                        double c = this.cFS.c(avy, a);
                        if (c >= 0.5d) {
                            a(this.cFN, 28, avc(), avy);
                        }
                        if (!this.cFN.cGd) {
                            if (c.YO()) {
                                if (c >= f.a.chm) {
                                    c.bQ("whiteScreen_L3", com.baidu.swan.apps.core.a.cgZ);
                                }
                            } else if (this.cFQ == 0 && c >= f.a.chn) {
                                c.bQ("whiteScreen_L2", com.baidu.swan.apps.core.a.cgY);
                            }
                        }
                    }
                }
            }
        }

        private boolean ava() {
            return this.cFN != null && this.cFN.cGh;
        }

        private void onBackground() {
            this.mIsBackground = true;
            if (this.cFN != null) {
                if (!this.cFN.isChecked()) {
                    if (b.this.cFM != null) {
                        b.this.cFM.removeMessages(2);
                    }
                    this.cFN.pause();
                } else if (this.cFN.cGd && ava()) {
                    avb();
                }
            }
        }

        private void onForeground() {
            this.mIsBackground = false;
            if (this.cFN != null && !this.cFN.isChecked()) {
                this.cFN.resume();
                long avi = this.cFN.avi();
                if (avi >= 0) {
                    b.this.cFM.sendMessageDelayed(Message.obtain(b.this.cFM, 2, this.cFN), avi);
                }
            }
        }

        private void a(com.baidu.swan.apps.y.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String avv = eVar.avv();
                Iterator<d> it = this.cFO.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, avv)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.cGf++;
                        return;
                    }
                    if (this.cFR == null) {
                        this.cFR = new HashMap<>();
                    }
                    Integer num2 = this.cFR.get(avv);
                    this.cFR.put(avv, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.cGf--;
                } else if (this.cFR != null && (num = this.cFR.get(avv)) != null && num.intValue() > 0) {
                    this.cFR.put(avv, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pa(String str) {
            if (ava()) {
                com.baidu.swan.apps.v.f.asJ().b(com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                com.baidu.swan.apps.v.f.asJ().a(str, com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void avb() {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity ast = com.baidu.swan.apps.v.f.asJ().ast();
                    if (ast != null && !ast.isFinishing() && !ast.isDestroyed() && a.this.cFN != null) {
                        final Bitmap aFM = ah.aFM();
                        p.aFx().execute(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cFP.a(aFM, a.this.cFN.bry)) {
                                    a.this.a(a.this.cFN, 33, false, null);
                                    ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                                            }
                                            ast.finish();
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
            JSONObject avf = c.avf();
            try {
                avf.put("page", dVar.url);
                avf.put("firstPage", ava());
                if (z && bitmap != null) {
                    avf.put("image", c.o(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(i).sH(avf.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.aAr() != null) {
                aVar = com.baidu.swan.apps.runtime.e.aAr().YI();
            }
            com.baidu.swan.apps.statistic.a.d fS = new com.baidu.swan.apps.statistic.a.d().i(sH).a(aVar).rO(h.jG(com.baidu.swan.apps.runtime.d.aAn().Yy())).rP(com.baidu.swan.apps.runtime.e.aAt()).rR(String.valueOf(this.cFO.size())).fS(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.cGf == 0 ? "0" : "1");
                fS.bQ(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (ava()) {
                fS.bQ(com.baidu.swan.apps.ak.a.aCP().aCQ());
                fS.bQ(com.baidu.swan.apps.ak.a.aCP().aCR());
            }
            h.b(fS);
        }

        private boolean avc() {
            String string = com.baidu.swan.apps.storage.c.h.aDP().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.y.a.c cVar) {
            if (cVar.avw() >= 0) {
                com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
                if (YG == null || YG.ahZ() <= 0) {
                    if (b.DEBUG) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.avw());
                    }
                    b.this.cFM.sendMessageDelayed(Message.obtain(b.this.cFM, 10, cVar), cVar.avw());
                }
            }
        }

        private void avd() {
            boolean z;
            SwanAppActivity ast = com.baidu.swan.apps.v.f.asJ().ast();
            if (ast != null && !ast.isFinishing() && !ast.isDestroyed() && ast.YC() != null && ast.YC().dfD != null) {
                com.baidu.swan.apps.view.c YC = ast.YC();
                if (YC == null || YC.dfD == null) {
                    z = false;
                } else {
                    z = YC.dfD.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(19L).sH("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.aAr() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.aAr().YI();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().i(sH).a(aVar).rO(h.jG(com.baidu.swan.apps.runtime.d.aAn().Yy())).rP(com.baidu.swan.apps.runtime.d.aAn().getAppId()).rR(String.valueOf(this.cFO.size())).fS(false));
                }
            }
        }
    }
}
