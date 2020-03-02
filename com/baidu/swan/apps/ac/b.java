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
    private a bFr;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super(TAG);
        init();
    }

    private void init() {
        start();
        this.bFr = new a(getLooper());
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
            Message.obtain(this.bFr, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        private d bFs;
        private Deque<d> bFt;
        private com.baidu.swan.apps.ac.b.a bFu;
        private int bFv;
        private HashMap<String, Integer> bFw;
        private com.baidu.swan.apps.ac.b.a bFx;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.bFt = new ArrayDeque();
            this.mIsBackground = true;
            this.bFv = 0;
            this.bFu = a.C0200a.jE("simple_parser");
            this.bFx = a.C0200a.jE("hsv_parser");
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
                        HR();
                        return;
                    } else {
                        HP();
                        return;
                    }
                case 5:
                    com.baidu.swan.apps.ac.a.a aVar = (com.baidu.swan.apps.ac.a.a) message.obj;
                    if (aVar != null) {
                        if (aVar.isShow()) {
                            this.bFv++;
                            return;
                        } else {
                            this.bFv--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.ac.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.bFt.clear();
                    this.bFs = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.ac.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.ac.a.c) message.obj);
                    return;
                case 10:
                    YA();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.ac.a.c cVar) {
            com.baidu.swan.apps.core.d.d YB = c.YB();
            if (YB != null) {
                String NZ = YB.NZ();
                com.baidu.swan.apps.adaptation.b.c Od = YB.Od();
                if (b.DEBUG && Od == null) {
                    Log.d(b.TAG, "webview manager is null for id " + NZ);
                }
                if (Od != null && !jA(NZ)) {
                    d dVar = new d(NZ, YB.Oc().mPage, cVar.YS(), cVar.YT());
                    this.bFt.addLast(dVar);
                    this.bFs = dVar;
                    Od.a((com.baidu.swan.apps.core.f.c) f.YO());
                    if (this.bFw != null && this.bFw.containsKey(NZ)) {
                        this.bFs.bFI = this.bFw.remove(NZ).intValue();
                    }
                    if (!this.mIsBackground && dVar.YF() >= 0) {
                        b.this.bFr.sendMessageDelayed(Message.obtain(b.this.bFr, 2, dVar), this.bFs.YF());
                    }
                }
            }
        }

        private boolean jA(String str) {
            return (this.bFs == null || str == null || !TextUtils.equals(str, this.bFs.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && jA(dVar.id)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jB(dVar.id);
                        Bitmap agX = af.agX();
                        if (agX != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.ac.a.d(dVar.id, agX)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.ac.a.d dVar) {
            if (dVar != null && jA(dVar.YR())) {
                Bitmap YU = dVar.YU();
                com.baidu.swan.apps.core.d.d YB = c.YB();
                AbsoluteLayout iT = com.baidu.swan.apps.y.f.WS().iT(dVar.YR());
                if (YU != null && iT != null && YB != null) {
                    Rect a = c.a(YU, YB, iT);
                    this.bFu.fB(c.e(YB));
                    this.bFs.YG();
                    if (c.YE() || this.bFv > 0) {
                        this.bFs.bFG = false;
                    } else if (this.bFu.a(YU, a)) {
                        this.bFs.bFG = true;
                        if (Yx()) {
                            this.bFs.k(YU);
                            this.bFs.rect = a;
                        }
                        c.fA(a.h.aiapps_swan_app_error_page_hint);
                        a(this.bFs, 19, false, null);
                    } else {
                        this.bFs.bFG = false;
                    }
                    this.bFs.YH();
                    if (Yx() && this.bFx.a(YU, a)) {
                        a(this.bFs, 28, Yz(), YU);
                    }
                }
            }
        }

        private boolean Yx() {
            return this.bFs != null && this.bFs.isFirstPage;
        }

        private void HR() {
            this.mIsBackground = true;
            if (this.bFs != null) {
                if (!this.bFs.isChecked()) {
                    if (b.this.bFr != null) {
                        b.this.bFr.removeMessages(2);
                    }
                    this.bFs.pause();
                } else if (this.bFs.bFG && Yx()) {
                    Yy();
                }
            }
        }

        private void HP() {
            this.mIsBackground = false;
            if (this.bFs != null && !this.bFs.isChecked()) {
                this.bFs.resume();
                long YF = this.bFs.YF();
                if (YF >= 0) {
                    b.this.bFr.sendMessageDelayed(Message.obtain(b.this.bFr, 2, this.bFs), YF);
                }
            }
        }

        private void a(com.baidu.swan.apps.ac.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String YR = eVar.YR();
                Iterator<d> it = this.bFt.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, YR)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.bFI++;
                        return;
                    }
                    if (this.bFw == null) {
                        this.bFw = new HashMap<>();
                    }
                    Integer num2 = this.bFw.get(YR);
                    this.bFw.put(YR, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.bFI--;
                } else if (this.bFw != null && (num = this.bFw.get(YR)) != null && num.intValue() > 0) {
                    this.bFw.put(YR, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jB(String str) {
            if (Yx()) {
                com.baidu.swan.apps.y.f.WS().a(com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                com.baidu.swan.apps.y.f.WS().a(str, com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                if (b.DEBUG) {
                    Log.d(b.TAG, "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void Yy() {
            if (b.DEBUG) {
                Log.d(b.TAG, "recheckAndExit");
            }
            ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity WD = com.baidu.swan.apps.y.f.WS().WD();
                    if (WD != null && !WD.isFinishing() && !WD.isDestroyed() && a.this.bFs != null) {
                        final Bitmap agX = af.agX();
                        m.agM().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.bFu.a(agX, a.this.bFs.rect)) {
                                    a.this.a(a.this.bFs, 33, false, null);
                                    ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d(b.TAG, "recheckAndExit call activity finish.");
                                            }
                                            WD.finish();
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
            JSONObject YC = c.YC();
            try {
                YC.put("page", dVar.url);
                YC.put("firstPage", Yx());
                if (z && bitmap != null) {
                    YC.put("image", c.j(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(i).mz(YC.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.acF() != null) {
                aVar = com.baidu.swan.apps.runtime.e.acF().GE();
            }
            com.baidu.swan.apps.statistic.a.d dV = new com.baidu.swan.apps.statistic.a.d().e(mz).a(aVar).lN(com.baidu.swan.apps.statistic.f.gs(com.baidu.swan.apps.runtime.d.acC().Gu())).lO(com.baidu.swan.apps.runtime.e.acH()).lQ(String.valueOf(this.bFt.size())).dV(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.bFI == 0 ? "0" : "1");
                dV.aZ(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (Yx()) {
                dV.aZ(com.baidu.swan.apps.an.a.aeH().aeI());
                dV.aZ(com.baidu.swan.apps.an.a.aeH().aeJ());
            }
            com.baidu.swan.apps.statistic.f.b(dV);
        }

        private boolean Yz() {
            String string = h.afr().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d(b.TAG, "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.ac.a.c cVar) {
            if (cVar.YS() >= 0) {
                com.baidu.swan.apps.core.d.e GC = com.baidu.swan.apps.y.f.WS().GC();
                if (GC == null || GC.Oq() <= 0) {
                    if (b.DEBUG) {
                        Log.d(b.TAG, "start loading check: remainTime=" + cVar.YS());
                    }
                    b.this.bFr.sendMessageDelayed(Message.obtain(b.this.bFr, 10, cVar), cVar.YS());
                }
            }
        }

        private void YA() {
            SwanAppActivity WD = com.baidu.swan.apps.y.f.WS().WD();
            if (WD != null && !WD.isFinishing() && !WD.isDestroyed()) {
                boolean z = WD.Gy().bZX.getVisibility() == 0;
                if (b.DEBUG) {
                    Log.d(b.TAG, "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(19L).mz("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.acF() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.acF().GE();
                    }
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().e(mz).a(aVar).lN(com.baidu.swan.apps.statistic.f.gs(com.baidu.swan.apps.runtime.d.acC().Gu())).lO(com.baidu.swan.apps.runtime.d.acC().getAppId()).lQ(String.valueOf(this.bFt.size())).dV(false));
                }
            }
        }
    }
}
