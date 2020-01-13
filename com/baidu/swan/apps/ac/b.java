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
/* loaded from: classes10.dex */
public class b extends HandlerThread implements com.baidu.swan.apps.ac.a {
    private a bBk;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super(TAG);
        init();
    }

    private void init() {
        start();
        this.bBk = new a(getLooper());
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
            Message.obtain(this.bBk, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends Handler {
        private d bBl;
        private Deque<d> bBm;
        private com.baidu.swan.apps.ac.b.a bBn;
        private int bBo;
        private HashMap<String, Integer> bBp;
        private com.baidu.swan.apps.ac.b.a bBq;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.bBm = new ArrayDeque();
            this.mIsBackground = true;
            this.bBo = 0;
            this.bBn = a.C0190a.jp("simple_parser");
            this.bBq = a.C0190a.jp("hsv_parser");
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
                        FA();
                        return;
                    } else {
                        Fy();
                        return;
                    }
                case 5:
                    com.baidu.swan.apps.ac.a.a aVar = (com.baidu.swan.apps.ac.a.a) message.obj;
                    if (aVar != null) {
                        if (aVar.isShow()) {
                            this.bBo++;
                            return;
                        } else {
                            this.bBo--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.ac.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.bBm.clear();
                    this.bBl = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.ac.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.ac.a.c) message.obj);
                    return;
                case 10:
                    Wk();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.ac.a.c cVar) {
            com.baidu.swan.apps.core.d.d Wl = c.Wl();
            if (Wl != null) {
                String LJ = Wl.LJ();
                com.baidu.swan.apps.adaptation.b.c LN = Wl.LN();
                if (b.DEBUG && LN == null) {
                    Log.d(b.TAG, "webview manager is null for id " + LJ);
                }
                if (LN != null && !jl(LJ)) {
                    d dVar = new d(LJ, Wl.LM().mPage, cVar.WC(), cVar.WD());
                    this.bBm.addLast(dVar);
                    this.bBl = dVar;
                    LN.a((com.baidu.swan.apps.core.f.c) f.Wy());
                    if (this.bBp != null && this.bBp.containsKey(LJ)) {
                        this.bBl.bBB = this.bBp.remove(LJ).intValue();
                    }
                    if (!this.mIsBackground && dVar.Wp() >= 0) {
                        b.this.bBk.sendMessageDelayed(Message.obtain(b.this.bBk, 2, dVar), this.bBl.Wp());
                    }
                }
            }
        }

        private boolean jl(String str) {
            return (this.bBl == null || str == null || !TextUtils.equals(str, this.bBl.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && jl(dVar.id)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jm(dVar.id);
                        Bitmap aeH = af.aeH();
                        if (aeH != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.ac.a.d(dVar.id, aeH)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.ac.a.d dVar) {
            if (dVar != null && jl(dVar.WB())) {
                Bitmap WE = dVar.WE();
                com.baidu.swan.apps.core.d.d Wl = c.Wl();
                AbsoluteLayout iE = com.baidu.swan.apps.y.f.UC().iE(dVar.WB());
                if (WE != null && iE != null && Wl != null) {
                    Rect a = c.a(WE, Wl, iE);
                    this.bBn.fl(c.e(Wl));
                    this.bBl.Wq();
                    if (c.Wo() || this.bBo > 0) {
                        this.bBl.bBz = false;
                    } else if (this.bBn.a(WE, a)) {
                        this.bBl.bBz = true;
                        if (Wh()) {
                            this.bBl.k(WE);
                            this.bBl.rect = a;
                        }
                        c.fk(a.h.aiapps_swan_app_error_page_hint);
                        a(this.bBl, 19, false, null);
                    } else {
                        this.bBl.bBz = false;
                    }
                    this.bBl.Wr();
                    if (Wh() && this.bBq.a(WE, a)) {
                        a(this.bBl, 28, Wj(), WE);
                    }
                }
            }
        }

        private boolean Wh() {
            return this.bBl != null && this.bBl.isFirstPage;
        }

        private void FA() {
            this.mIsBackground = true;
            if (this.bBl != null) {
                if (!this.bBl.isChecked()) {
                    if (b.this.bBk != null) {
                        b.this.bBk.removeMessages(2);
                    }
                    this.bBl.pause();
                } else if (this.bBl.bBz && Wh()) {
                    Wi();
                }
            }
        }

        private void Fy() {
            this.mIsBackground = false;
            if (this.bBl != null && !this.bBl.isChecked()) {
                this.bBl.resume();
                long Wp = this.bBl.Wp();
                if (Wp >= 0) {
                    b.this.bBk.sendMessageDelayed(Message.obtain(b.this.bBk, 2, this.bBl), Wp);
                }
            }
        }

        private void a(com.baidu.swan.apps.ac.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String WB = eVar.WB();
                Iterator<d> it = this.bBm.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, WB)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.bBB++;
                        return;
                    }
                    if (this.bBp == null) {
                        this.bBp = new HashMap<>();
                    }
                    Integer num2 = this.bBp.get(WB);
                    this.bBp.put(WB, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.bBB--;
                } else if (this.bBp != null && (num = this.bBp.get(WB)) != null && num.intValue() > 0) {
                    this.bBp.put(WB, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jm(String str) {
            if (Wh()) {
                com.baidu.swan.apps.y.f.UC().a(com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                com.baidu.swan.apps.y.f.UC().a(str, com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                if (b.DEBUG) {
                    Log.d(b.TAG, "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void Wi() {
            if (b.DEBUG) {
                Log.d(b.TAG, "recheckAndExit");
            }
            ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity Un = com.baidu.swan.apps.y.f.UC().Un();
                    if (Un != null && !Un.isFinishing() && !Un.isDestroyed() && a.this.bBl != null) {
                        final Bitmap aeH = af.aeH();
                        m.aew().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.bBn.a(aeH, a.this.bBl.rect)) {
                                    a.this.a(a.this.bBl, 33, false, null);
                                    ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d(b.TAG, "recheckAndExit call activity finish.");
                                            }
                                            Un.finish();
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
            JSONObject Wm = c.Wm();
            try {
                Wm.put("page", dVar.url);
                Wm.put("firstPage", Wh());
                if (z && bitmap != null) {
                    Wm.put("image", c.j(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(5L).aF(i).mk(Wm.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.aap() != null) {
                aVar = com.baidu.swan.apps.runtime.e.aap().En();
            }
            com.baidu.swan.apps.statistic.a.d dO = new com.baidu.swan.apps.statistic.a.d().e(mk).a(aVar).ly(com.baidu.swan.apps.statistic.f.gb(com.baidu.swan.apps.runtime.d.aam().Ed())).lz(com.baidu.swan.apps.runtime.e.aar()).lB(String.valueOf(this.bBm.size())).dO(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.bBB == 0 ? "0" : "1");
                dO.aZ(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (Wh()) {
                dO.aZ(com.baidu.swan.apps.an.a.acr().acs());
                dO.aZ(com.baidu.swan.apps.an.a.acr().act());
            }
            com.baidu.swan.apps.statistic.f.b(dO);
        }

        private boolean Wj() {
            String string = h.adb().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d(b.TAG, "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.ac.a.c cVar) {
            if (cVar.WC() >= 0) {
                com.baidu.swan.apps.core.d.e El = com.baidu.swan.apps.y.f.UC().El();
                if (El == null || El.Ma() <= 0) {
                    if (b.DEBUG) {
                        Log.d(b.TAG, "start loading check: remainTime=" + cVar.WC());
                    }
                    b.this.bBk.sendMessageDelayed(Message.obtain(b.this.bBk, 10, cVar), cVar.WC());
                }
            }
        }

        private void Wk() {
            SwanAppActivity Un = com.baidu.swan.apps.y.f.UC().Un();
            if (Un != null && !Un.isFinishing() && !Un.isDestroyed() && Un.Eh() != null && Un.Eh().bVS != null) {
                boolean z = Un.Eh().bVS.getVisibility() == 0;
                if (b.DEBUG) {
                    Log.d(b.TAG, "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(5L).aF(19L).mk("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.aap() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.aap().En();
                    }
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().e(mk).a(aVar).ly(com.baidu.swan.apps.statistic.f.gb(com.baidu.swan.apps.runtime.d.aam().Ed())).lz(com.baidu.swan.apps.runtime.d.aam().getAppId()).lB(String.valueOf(this.bBm.size())).dO(false));
                }
            }
        }
    }
}
