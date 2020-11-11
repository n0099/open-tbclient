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
    private a dgj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super("SwanAppPageMonitor");
        init();
    }

    private void init() {
        start();
        this.dgj = new a(getLooper());
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
            Message.obtain(this.dgj, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends Handler {
        private d dgk;
        private Deque<d> dgl;
        private com.baidu.swan.apps.y.b.a dgm;
        private int dgn;
        private HashMap<String, Integer> dgo;
        private com.baidu.swan.apps.y.b.b dgp;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.dgl = new ArrayDeque();
            this.mIsBackground = true;
            this.dgn = 0;
            this.dgm = a.C0499a.qw("simple_parser");
            this.dgp = (com.baidu.swan.apps.y.b.b) a.C0499a.qw("hsv_parser");
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
                            this.dgn++;
                            return;
                        } else {
                            this.dgn--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.y.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.dgl.clear();
                    this.dgk = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.y.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.y.a.c) message.obj);
                    return;
                case 10:
                    aCi();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.y.a.c cVar) {
            com.baidu.swan.apps.core.d.e aCj = c.aCj();
            if (aCj != null) {
                String aoL = aCj.aoL();
                com.baidu.swan.apps.adaptation.b.c aoQ = aCj.aoQ();
                if (b.DEBUG && aoQ == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + aoL);
                }
                if (aoQ != null && !qs(aoL)) {
                    d dVar = new d(aoL, aCj.aoP().mPage, cVar.aCB(), cVar.aCC());
                    this.dgl.addLast(dVar);
                    this.dgk = dVar;
                    aoQ.a((com.baidu.swan.apps.core.f.c) f.aCw());
                    if (this.dgo != null && this.dgo.containsKey(aoL)) {
                        this.dgk.dgB = this.dgo.remove(aoL).intValue();
                    }
                    if (!this.mIsBackground && dVar.aCn() >= 0) {
                        b.this.dgj.sendMessageDelayed(Message.obtain(b.this.dgj, 2, dVar), this.dgk.aCn());
                    }
                }
            }
        }

        private boolean qs(String str) {
            return (this.dgk == null || str == null || !TextUtils.equals(str, this.dgk.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && qs(dVar.id)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.qt(dVar.id);
                        Bitmap aMP = ah.aMP();
                        if (aMP != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.y.a.d(dVar.id, aMP)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.y.a.d dVar) {
            if (dVar != null && qs(dVar.aCA())) {
                Bitmap aCD = dVar.aCD();
                com.baidu.swan.apps.core.d.e aCj = c.aCj();
                AbsoluteLayout pN = com.baidu.swan.apps.v.f.azO().pN(dVar.aCA());
                if (aCD != null && pN != null && aCj != null) {
                    Rect a2 = c.a(aCD, aCj, pN);
                    this.dgm.jC(c.f(aCj));
                    this.dgk.aCo();
                    boolean aCf = aCf();
                    if (c.aCm() || this.dgn > 0) {
                        this.dgk.ckA = false;
                    } else {
                        this.dgk.ckA = this.dgm.a(aCD, a2);
                        if (this.dgk.ckA) {
                            if (aCf) {
                                this.dgk.p(aCD);
                                this.dgk.bDL = a2;
                            }
                            c.fN(aCf);
                            a(this.dgk, 19, false, null);
                        }
                    }
                    this.dgk.aCp();
                    if (aCf) {
                        double c = this.dgp.c(aCD, a2);
                        if (c >= 0.5d) {
                            a(this.dgk, 28, aCh(), aCD);
                        }
                        if (!this.dgk.ckA) {
                            if (c.afU()) {
                                if (c >= f.a.cHV) {
                                    c.cc("whiteScreen_L3", com.baidu.swan.apps.core.a.cHJ);
                                }
                            } else if (this.dgn == 0 && c >= f.a.cHW) {
                                c.cc("whiteScreen_L2", com.baidu.swan.apps.core.a.cHI);
                            }
                        }
                    }
                }
            }
        }

        private boolean aCf() {
            return this.dgk != null && this.dgk.dgD;
        }

        private void onBackground() {
            this.mIsBackground = true;
            if (this.dgk != null) {
                if (!this.dgk.isChecked()) {
                    if (b.this.dgj != null) {
                        b.this.dgj.removeMessages(2);
                    }
                    this.dgk.pause();
                } else if (this.dgk.ckA && aCf()) {
                    aCg();
                }
            }
        }

        private void onForeground() {
            this.mIsBackground = false;
            if (this.dgk != null && !this.dgk.isChecked()) {
                this.dgk.resume();
                long aCn = this.dgk.aCn();
                if (aCn >= 0) {
                    b.this.dgj.sendMessageDelayed(Message.obtain(b.this.dgj, 2, this.dgk), aCn);
                }
            }
        }

        private void a(com.baidu.swan.apps.y.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String aCA = eVar.aCA();
                Iterator<d> it = this.dgl.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, aCA)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.dgB++;
                        return;
                    }
                    if (this.dgo == null) {
                        this.dgo = new HashMap<>();
                    }
                    Integer num2 = this.dgo.get(aCA);
                    this.dgo.put(aCA, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.dgB--;
                } else if (this.dgo != null && (num = this.dgo.get(aCA)) != null && num.intValue() > 0) {
                    this.dgo.put(aCA, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void qt(String str) {
            if (aCf()) {
                com.baidu.swan.apps.v.f.azO().b(com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                com.baidu.swan.apps.v.f.azO().a(str, com.baidu.swan.apps.ak.b.a(new com.baidu.swan.apps.ak.b()));
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void aCg() {
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity azy = com.baidu.swan.apps.v.f.azO().azy();
                    if (azy != null && !azy.isFinishing() && !azy.isDestroyed() && a.this.dgk != null) {
                        final Bitmap aMP = ah.aMP();
                        p.aMA().execute(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.dgm.a(aMP, a.this.dgk.bDL)) {
                                    a.this.a(a.this.dgk, 33, false, null);
                                    ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                                            }
                                            azy.finish();
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
            JSONObject aCk = c.aCk();
            try {
                aCk.put("page", dVar.url);
                aCk.put("firstPage", aCf());
                if (z && bitmap != null) {
                    aCk.put("image", c.o(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(5L).cw(i).ua(aCk.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.aHu() != null) {
                aVar = com.baidu.swan.apps.runtime.e.aHu().afO();
            }
            com.baidu.swan.apps.statistic.a.d gK = new com.baidu.swan.apps.statistic.a.d().i(ua).a(aVar).ti(h.ky(com.baidu.swan.apps.runtime.d.aHq().afE())).tj(com.baidu.swan.apps.runtime.e.aHw()).tl(String.valueOf(this.dgl.size())).gK(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.dgB == 0 ? "0" : "1");
                gK.cg(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (aCf()) {
                gK.cg(com.baidu.swan.apps.ak.a.aJS().aJT());
                gK.cg(com.baidu.swan.apps.ak.a.aJS().aJU());
            }
            h.b(gK);
        }

        private boolean aCh() {
            String string = com.baidu.swan.apps.storage.c.h.aKS().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.y.a.c cVar) {
            if (cVar.aCB() >= 0) {
                com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
                if (afM == null || afM.ape() <= 0) {
                    if (b.DEBUG) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.aCB());
                    }
                    b.this.dgj.sendMessageDelayed(Message.obtain(b.this.dgj, 10, cVar), cVar.aCB());
                }
            }
        }

        private void aCi() {
            boolean z;
            SwanAppActivity azy = com.baidu.swan.apps.v.f.azO().azy();
            if (azy != null && !azy.isFinishing() && !azy.isDestroyed() && azy.afI() != null && azy.afI().dGb != null) {
                com.baidu.swan.apps.view.c afI = azy.afI();
                if (afI == null || afI.dGb == null) {
                    z = false;
                } else {
                    z = afI.dGb.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(5L).cw(19L).ua("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.aHu() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.aHu().afO();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().i(ua).a(aVar).ti(h.ky(com.baidu.swan.apps.runtime.d.aHq().afE())).tj(com.baidu.swan.apps.runtime.d.aHq().getAppId()).tl(String.valueOf(this.dgl.size())).gK(false));
                }
            }
        }
    }
}
