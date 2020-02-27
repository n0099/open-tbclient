package com.baidu.swan.apps.ac;

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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ac.b.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.x.b.b;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends HandlerThread implements com.baidu.swan.apps.ac.a {
    private a bFq;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super(TAG);
        init();
    }

    private void init() {
        start();
        this.bFq = new a(getLooper());
    }

    @Override // com.baidu.swan.apps.ac.a
    public void a(com.baidu.swan.apps.ac.a.c cVar) {
        if (!isAlive()) {
            if (DEBUG) {
                Log.d(TAG, "thread is not alive");
            }
            try {
                init();
            } catch (Error | Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (cVar != null) {
            Message.obtain(this.bFq, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        private d bFr;
        private Deque<d> bFs;
        private com.baidu.swan.apps.ac.b.a bFt;
        private int bFu;
        private HashMap<String, Integer> bFv;
        private com.baidu.swan.apps.ac.b.a bFw;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.bFs = new ArrayDeque();
            this.mIsBackground = true;
            this.bFu = 0;
            this.bFt = a.C0200a.jE("simple_parser");
            this.bFw = a.C0200a.jE("hsv_parser");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.DEBUG) {
                Log.d(b.TAG, "get message " + message.what);
            }
            switch (message.what) {
                case 1:
                    removeMessages(9);
                    removeMessages(10);
                    b((com.baidu.swan.apps.ac.a.c) message.obj);
                    return;
                case 2:
                    a((d) message.obj);
                    return;
                case 3:
                    removeMessages(2);
                    removeMessages(8);
                    return;
                case 4:
                    if (((com.baidu.swan.apps.ac.a.b) message.obj).isBackground()) {
                        HP();
                        return;
                    } else {
                        HN();
                        return;
                    }
                case 5:
                    com.baidu.swan.apps.ac.a.a aVar = (com.baidu.swan.apps.ac.a.a) message.obj;
                    if (aVar != null) {
                        if (aVar.isShow()) {
                            this.bFu++;
                            return;
                        } else {
                            this.bFu--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.ac.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.bFs.clear();
                    this.bFr = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.ac.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.ac.a.c) message.obj);
                    return;
                case 10:
                    Yy();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.ac.a.c cVar) {
            com.baidu.swan.apps.core.d.d Yz = c.Yz();
            if (Yz != null) {
                String NX = Yz.NX();
                com.baidu.swan.apps.adaptation.b.c Ob = Yz.Ob();
                if (b.DEBUG && Ob == null) {
                    Log.d(b.TAG, "webview manager is null for id " + NX);
                }
                if (Ob != null && !jA(NX)) {
                    d dVar = new d(NX, Yz.Oa().mPage, cVar.YQ(), cVar.YR());
                    this.bFs.addLast(dVar);
                    this.bFr = dVar;
                    Ob.a((com.baidu.swan.apps.core.f.c) f.YM());
                    if (this.bFv != null && this.bFv.containsKey(NX)) {
                        this.bFr.bFH = this.bFv.remove(NX).intValue();
                    }
                    if (!this.mIsBackground && dVar.YD() >= 0) {
                        b.this.bFq.sendMessageDelayed(Message.obtain(b.this.bFq, 2, dVar), this.bFr.YD());
                    }
                }
            }
        }

        private boolean jA(String str) {
            return (this.bFr == null || str == null || !TextUtils.equals(str, this.bFr.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && jA(dVar.id)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jB(dVar.id);
                        Bitmap agV = af.agV();
                        if (agV != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.ac.a.d(dVar.id, agV)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.ac.a.d dVar) {
            if (dVar != null && jA(dVar.YP())) {
                Bitmap YS = dVar.YS();
                com.baidu.swan.apps.core.d.d Yz = c.Yz();
                AbsoluteLayout iT = com.baidu.swan.apps.y.f.WQ().iT(dVar.YP());
                if (YS != null && iT != null && Yz != null) {
                    Rect a = c.a(YS, Yz, iT);
                    this.bFt.fB(c.e(Yz));
                    this.bFr.YE();
                    if (c.YC() || this.bFu > 0) {
                        this.bFr.bFF = false;
                    } else if (this.bFt.a(YS, a)) {
                        this.bFr.bFF = true;
                        if (Yv()) {
                            this.bFr.k(YS);
                            this.bFr.rect = a;
                        }
                        c.fA(a.h.aiapps_swan_app_error_page_hint);
                        a(this.bFr, 19, false, null);
                    } else {
                        this.bFr.bFF = false;
                    }
                    this.bFr.YF();
                    if (Yv() && this.bFw.a(YS, a)) {
                        a(this.bFr, 28, Yx(), YS);
                    }
                }
            }
        }

        private boolean Yv() {
            return this.bFr != null && this.bFr.isFirstPage;
        }

        private void HP() {
            this.mIsBackground = true;
            if (this.bFr != null) {
                if (!this.bFr.isChecked()) {
                    if (b.this.bFq != null) {
                        b.this.bFq.removeMessages(2);
                    }
                    this.bFr.pause();
                } else if (this.bFr.bFF && Yv()) {
                    Yw();
                }
            }
        }

        private void HN() {
            this.mIsBackground = false;
            if (this.bFr != null && !this.bFr.isChecked()) {
                this.bFr.resume();
                long YD = this.bFr.YD();
                if (YD >= 0) {
                    b.this.bFq.sendMessageDelayed(Message.obtain(b.this.bFq, 2, this.bFr), YD);
                }
            }
        }

        private void a(com.baidu.swan.apps.ac.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String YP = eVar.YP();
                Iterator<d> it = this.bFs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, YP)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.bFH++;
                        return;
                    }
                    if (this.bFv == null) {
                        this.bFv = new HashMap<>();
                    }
                    Integer num2 = this.bFv.get(YP);
                    this.bFv.put(YP, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.bFH--;
                } else if (this.bFv != null && (num = this.bFv.get(YP)) != null && num.intValue() > 0) {
                    this.bFv.put(YP, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jB(String str) {
            if (Yv()) {
                com.baidu.swan.apps.y.f.WQ().a(com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                com.baidu.swan.apps.y.f.WQ().a(str, com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                if (b.DEBUG) {
                    Log.d(b.TAG, "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void Yw() {
            if (b.DEBUG) {
                Log.d(b.TAG, "recheckAndExit");
            }
            ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity WB = com.baidu.swan.apps.y.f.WQ().WB();
                    if (WB != null && !WB.isFinishing() && !WB.isDestroyed() && a.this.bFr != null) {
                        final Bitmap agV = af.agV();
                        m.agK().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.bFt.a(agV, a.this.bFr.rect)) {
                                    a.this.a(a.this.bFr, 33, false, null);
                                    ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d(b.TAG, "recheckAndExit call activity finish.");
                                            }
                                            WB.finish();
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
            JSONObject YA = c.YA();
            try {
                YA.put("page", dVar.url);
                YA.put("firstPage", Yv());
                if (z && bitmap != null) {
                    YA.put("image", c.j(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(i).mz(YA.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.acD() != null) {
                aVar = com.baidu.swan.apps.runtime.e.acD().GC();
            }
            com.baidu.swan.apps.statistic.a.d dV = new com.baidu.swan.apps.statistic.a.d().e(mz).a(aVar).lN(com.baidu.swan.apps.statistic.f.gs(com.baidu.swan.apps.runtime.d.acA().Gs())).lO(com.baidu.swan.apps.runtime.e.acF()).lQ(String.valueOf(this.bFs.size())).dV(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.bFH == 0 ? "0" : "1");
                dV.aZ(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (Yv()) {
                dV.aZ(com.baidu.swan.apps.an.a.aeF().aeG());
                dV.aZ(com.baidu.swan.apps.an.a.aeF().aeH());
            }
            com.baidu.swan.apps.statistic.f.b(dV);
        }

        private boolean Yx() {
            String string = h.afp().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d(b.TAG, "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.ac.a.c cVar) {
            if (cVar.YQ() >= 0) {
                com.baidu.swan.apps.core.d.e GA = com.baidu.swan.apps.y.f.WQ().GA();
                if (GA == null || GA.Oo() <= 0) {
                    if (b.DEBUG) {
                        Log.d(b.TAG, "start loading check: remainTime=" + cVar.YQ());
                    }
                    b.this.bFq.sendMessageDelayed(Message.obtain(b.this.bFq, 10, cVar), cVar.YQ());
                }
            }
        }

        private void Yy() {
            SwanAppActivity WB = com.baidu.swan.apps.y.f.WQ().WB();
            if (WB != null && !WB.isFinishing() && !WB.isDestroyed()) {
                boolean z = WB.Gw().bZW.getVisibility() == 0;
                if (b.DEBUG) {
                    Log.d(b.TAG, "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(19L).mz("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.acD() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.acD().GC();
                    }
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().e(mz).a(aVar).lN(com.baidu.swan.apps.statistic.f.gs(com.baidu.swan.apps.runtime.d.acA().Gs())).lO(com.baidu.swan.apps.runtime.d.acA().getAppId()).lQ(String.valueOf(this.bFs.size())).dV(false));
                }
            }
        }
    }
}
