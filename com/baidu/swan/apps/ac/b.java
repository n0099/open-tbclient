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
    private a bFD;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super(TAG);
        init();
    }

    private void init() {
        start();
        this.bFD = new a(getLooper());
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
            Message.obtain(this.bFD, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        private d bFE;
        private Deque<d> bFF;
        private com.baidu.swan.apps.ac.b.a bFG;
        private int bFH;
        private HashMap<String, Integer> bFI;
        private com.baidu.swan.apps.ac.b.a bFJ;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.bFF = new ArrayDeque();
            this.mIsBackground = true;
            this.bFH = 0;
            this.bFG = a.C0200a.jD("simple_parser");
            this.bFJ = a.C0200a.jD("hsv_parser");
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
                        HU();
                        return;
                    } else {
                        HS();
                        return;
                    }
                case 5:
                    com.baidu.swan.apps.ac.a.a aVar = (com.baidu.swan.apps.ac.a.a) message.obj;
                    if (aVar != null) {
                        if (aVar.isShow()) {
                            this.bFH++;
                            return;
                        } else {
                            this.bFH--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.ac.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.bFF.clear();
                    this.bFE = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.ac.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.ac.a.c) message.obj);
                    return;
                case 10:
                    YD();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.ac.a.c cVar) {
            com.baidu.swan.apps.core.d.d YE = c.YE();
            if (YE != null) {
                String Oc = YE.Oc();
                com.baidu.swan.apps.adaptation.b.c Og = YE.Og();
                if (b.DEBUG && Og == null) {
                    Log.d(b.TAG, "webview manager is null for id " + Oc);
                }
                if (Og != null && !jz(Oc)) {
                    d dVar = new d(Oc, YE.Of().mPage, cVar.YV(), cVar.YW());
                    this.bFF.addLast(dVar);
                    this.bFE = dVar;
                    Og.a((com.baidu.swan.apps.core.f.c) f.YR());
                    if (this.bFI != null && this.bFI.containsKey(Oc)) {
                        this.bFE.bFU = this.bFI.remove(Oc).intValue();
                    }
                    if (!this.mIsBackground && dVar.YI() >= 0) {
                        b.this.bFD.sendMessageDelayed(Message.obtain(b.this.bFD, 2, dVar), this.bFE.YI());
                    }
                }
            }
        }

        private boolean jz(String str) {
            return (this.bFE == null || str == null || !TextUtils.equals(str, this.bFE.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && jz(dVar.id)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jA(dVar.id);
                        Bitmap aha = af.aha();
                        if (aha != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.ac.a.d(dVar.id, aha)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.ac.a.d dVar) {
            if (dVar != null && jz(dVar.YU())) {
                Bitmap YX = dVar.YX();
                com.baidu.swan.apps.core.d.d YE = c.YE();
                AbsoluteLayout iS = com.baidu.swan.apps.y.f.WV().iS(dVar.YU());
                if (YX != null && iS != null && YE != null) {
                    Rect a = c.a(YX, YE, iS);
                    this.bFG.fB(c.e(YE));
                    this.bFE.YJ();
                    if (c.YH() || this.bFH > 0) {
                        this.bFE.bFS = false;
                    } else if (this.bFG.a(YX, a)) {
                        this.bFE.bFS = true;
                        if (YA()) {
                            this.bFE.k(YX);
                            this.bFE.rect = a;
                        }
                        c.fA(a.h.aiapps_swan_app_error_page_hint);
                        a(this.bFE, 19, false, null);
                    } else {
                        this.bFE.bFS = false;
                    }
                    this.bFE.YK();
                    if (YA() && this.bFJ.a(YX, a)) {
                        a(this.bFE, 28, YC(), YX);
                    }
                }
            }
        }

        private boolean YA() {
            return this.bFE != null && this.bFE.isFirstPage;
        }

        private void HU() {
            this.mIsBackground = true;
            if (this.bFE != null) {
                if (!this.bFE.isChecked()) {
                    if (b.this.bFD != null) {
                        b.this.bFD.removeMessages(2);
                    }
                    this.bFE.pause();
                } else if (this.bFE.bFS && YA()) {
                    YB();
                }
            }
        }

        private void HS() {
            this.mIsBackground = false;
            if (this.bFE != null && !this.bFE.isChecked()) {
                this.bFE.resume();
                long YI = this.bFE.YI();
                if (YI >= 0) {
                    b.this.bFD.sendMessageDelayed(Message.obtain(b.this.bFD, 2, this.bFE), YI);
                }
            }
        }

        private void a(com.baidu.swan.apps.ac.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String YU = eVar.YU();
                Iterator<d> it = this.bFF.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, YU)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.bFU++;
                        return;
                    }
                    if (this.bFI == null) {
                        this.bFI = new HashMap<>();
                    }
                    Integer num2 = this.bFI.get(YU);
                    this.bFI.put(YU, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.bFU--;
                } else if (this.bFI != null && (num = this.bFI.get(YU)) != null && num.intValue() > 0) {
                    this.bFI.put(YU, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jA(String str) {
            if (YA()) {
                com.baidu.swan.apps.y.f.WV().a(com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                com.baidu.swan.apps.y.f.WV().a(str, com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                if (b.DEBUG) {
                    Log.d(b.TAG, "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void YB() {
            if (b.DEBUG) {
                Log.d(b.TAG, "recheckAndExit");
            }
            ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity WG = com.baidu.swan.apps.y.f.WV().WG();
                    if (WG != null && !WG.isFinishing() && !WG.isDestroyed() && a.this.bFE != null) {
                        final Bitmap aha = af.aha();
                        m.agP().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.bFG.a(aha, a.this.bFE.rect)) {
                                    a.this.a(a.this.bFE, 33, false, null);
                                    ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d(b.TAG, "recheckAndExit call activity finish.");
                                            }
                                            WG.finish();
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
            JSONObject YF = c.YF();
            try {
                YF.put("page", dVar.url);
                YF.put("firstPage", YA());
                if (z && bitmap != null) {
                    YF.put("image", c.j(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(5L).aJ(i).my(YF.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.acI() != null) {
                aVar = com.baidu.swan.apps.runtime.e.acI().GJ();
            }
            com.baidu.swan.apps.statistic.a.d dW = new com.baidu.swan.apps.statistic.a.d().e(my).a(aVar).lM(com.baidu.swan.apps.statistic.f.gs(com.baidu.swan.apps.runtime.d.acF().Gz())).lN(com.baidu.swan.apps.runtime.e.acK()).lP(String.valueOf(this.bFF.size())).dW(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.bFU == 0 ? "0" : "1");
                dW.aZ(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (YA()) {
                dW.aZ(com.baidu.swan.apps.an.a.aeK().aeL());
                dW.aZ(com.baidu.swan.apps.an.a.aeK().aeM());
            }
            com.baidu.swan.apps.statistic.f.b(dW);
        }

        private boolean YC() {
            String string = h.afu().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d(b.TAG, "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.ac.a.c cVar) {
            if (cVar.YV() >= 0) {
                com.baidu.swan.apps.core.d.e GH = com.baidu.swan.apps.y.f.WV().GH();
                if (GH == null || GH.Ot() <= 0) {
                    if (b.DEBUG) {
                        Log.d(b.TAG, "start loading check: remainTime=" + cVar.YV());
                    }
                    b.this.bFD.sendMessageDelayed(Message.obtain(b.this.bFD, 10, cVar), cVar.YV());
                }
            }
        }

        private void YD() {
            SwanAppActivity WG = com.baidu.swan.apps.y.f.WV().WG();
            if (WG != null && !WG.isFinishing() && !WG.isDestroyed()) {
                boolean z = WG.GD().caj.getVisibility() == 0;
                if (b.DEBUG) {
                    Log.d(b.TAG, "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(5L).aJ(19L).my("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.acI() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.acI().GJ();
                    }
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().e(my).a(aVar).lM(com.baidu.swan.apps.statistic.f.gs(com.baidu.swan.apps.runtime.d.acF().Gz())).lN(com.baidu.swan.apps.runtime.d.acF().getAppId()).lP(String.valueOf(this.bFF.size())).dW(false));
                }
            }
        }
    }
}
