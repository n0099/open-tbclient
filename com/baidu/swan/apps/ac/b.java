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
    private a cem;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super(TAG);
        init();
    }

    private void init() {
        start();
        this.cem = new a(getLooper());
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
            Message.obtain(this.cem, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        private d cen;
        private Deque<d> ceo;
        private com.baidu.swan.apps.ac.b.a cep;
        private int ceq;
        private HashMap<String, Integer> cer;
        private com.baidu.swan.apps.ac.b.a ces;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.ceo = new ArrayDeque();
            this.mIsBackground = true;
            this.ceq = 0;
            this.cep = a.C0230a.kQ("simple_parser");
            this.ces = a.C0230a.kQ("hsv_parser");
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
                        PG();
                        return;
                    } else {
                        PE();
                        return;
                    }
                case 5:
                    com.baidu.swan.apps.ac.a.a aVar = (com.baidu.swan.apps.ac.a.a) message.obj;
                    if (aVar != null) {
                        if (aVar.isShow()) {
                            this.ceq++;
                            return;
                        } else {
                            this.ceq--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.ac.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.ceo.clear();
                    this.cen = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.ac.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.ac.a.c) message.obj);
                    return;
                case 10:
                    agJ();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.ac.a.c cVar) {
            com.baidu.swan.apps.core.d.d agK = c.agK();
            if (agK != null) {
                String VQ = agK.VQ();
                com.baidu.swan.apps.adaptation.b.c VU = agK.VU();
                if (b.DEBUG && VU == null) {
                    Log.d(b.TAG, "webview manager is null for id " + VQ);
                }
                if (VU != null && !kM(VQ)) {
                    d dVar = new d(VQ, agK.VT().mPage, cVar.ahb(), cVar.ahc());
                    this.ceo.addLast(dVar);
                    this.cen = dVar;
                    VU.a((com.baidu.swan.apps.core.f.c) f.agX());
                    if (this.cer != null && this.cer.containsKey(VQ)) {
                        this.cen.ceD = this.cer.remove(VQ).intValue();
                    }
                    if (!this.mIsBackground && dVar.agO() >= 0) {
                        b.this.cem.sendMessageDelayed(Message.obtain(b.this.cem, 2, dVar), this.cen.agO());
                    }
                }
            }
        }

        private boolean kM(String str) {
            return (this.cen == null || str == null || !TextUtils.equals(str, this.cen.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && kM(dVar.id)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.kN(dVar.id);
                        Bitmap aph = af.aph();
                        if (aph != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.ac.a.d(dVar.id, aph)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.ac.a.d dVar) {
            if (dVar != null && kM(dVar.aha())) {
                Bitmap ahd = dVar.ahd();
                com.baidu.swan.apps.core.d.d agK = c.agK();
                AbsoluteLayout kf = com.baidu.swan.apps.y.f.aeK().kf(dVar.aha());
                if (ahd != null && kf != null && agK != null) {
                    Rect a = c.a(ahd, agK, kf);
                    this.cep.fI(c.e(agK));
                    this.cen.agP();
                    if (c.agN() || this.ceq > 0) {
                        this.cen.ceB = false;
                    } else if (this.cep.a(ahd, a)) {
                        this.cen.ceB = true;
                        if (agG()) {
                            this.cen.m(ahd);
                            this.cen.rect = a;
                        }
                        c.fH(a.h.aiapps_swan_app_error_page_hint);
                        a(this.cen, 19, false, null);
                    } else {
                        this.cen.ceB = false;
                    }
                    this.cen.agQ();
                    if (agG() && this.ces.a(ahd, a)) {
                        a(this.cen, 28, agI(), ahd);
                    }
                }
            }
        }

        private boolean agG() {
            return this.cen != null && this.cen.ceF;
        }

        private void PG() {
            this.mIsBackground = true;
            if (this.cen != null) {
                if (!this.cen.isChecked()) {
                    if (b.this.cem != null) {
                        b.this.cem.removeMessages(2);
                    }
                    this.cen.pause();
                } else if (this.cen.ceB && agG()) {
                    agH();
                }
            }
        }

        private void PE() {
            this.mIsBackground = false;
            if (this.cen != null && !this.cen.isChecked()) {
                this.cen.resume();
                long agO = this.cen.agO();
                if (agO >= 0) {
                    b.this.cem.sendMessageDelayed(Message.obtain(b.this.cem, 2, this.cen), agO);
                }
            }
        }

        private void a(com.baidu.swan.apps.ac.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String aha = eVar.aha();
                Iterator<d> it = this.ceo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, aha)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.ceD++;
                        return;
                    }
                    if (this.cer == null) {
                        this.cer = new HashMap<>();
                    }
                    Integer num2 = this.cer.get(aha);
                    this.cer.put(aha, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.ceD--;
                } else if (this.cer != null && (num = this.cer.get(aha)) != null && num.intValue() > 0) {
                    this.cer.put(aha, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kN(String str) {
            if (agG()) {
                com.baidu.swan.apps.y.f.aeK().a(com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                com.baidu.swan.apps.y.f.aeK().a(str, com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                if (b.DEBUG) {
                    Log.d(b.TAG, "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void agH() {
            if (b.DEBUG) {
                Log.d(b.TAG, "recheckAndExit");
            }
            ai.o(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity aev = com.baidu.swan.apps.y.f.aeK().aev();
                    if (aev != null && !aev.isFinishing() && !aev.isDestroyed() && a.this.cen != null) {
                        final Bitmap aph = af.aph();
                        m.aoV().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cep.a(aph, a.this.cen.rect)) {
                                    a.this.a(a.this.cen, 33, false, null);
                                    ai.o(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d(b.TAG, "recheckAndExit call activity finish.");
                                            }
                                            aev.finish();
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
            JSONObject agL = c.agL();
            try {
                agL.put("page", dVar.url);
                agL.put("firstPage", agG());
                if (z && bitmap != null) {
                    agL.put("image", c.l(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(i).nL(agL.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.akN() != null) {
                aVar = com.baidu.swan.apps.runtime.e.akN().Ow();
            }
            com.baidu.swan.apps.statistic.a.d eS = new com.baidu.swan.apps.statistic.a.d().e(nL).a(aVar).mZ(com.baidu.swan.apps.statistic.f.gz(com.baidu.swan.apps.runtime.d.akK().Om())).na(com.baidu.swan.apps.runtime.e.akP()).nc(String.valueOf(this.ceo.size())).eS(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.ceD == 0 ? "0" : "1");
                eS.bk(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (agG()) {
                eS.bk(com.baidu.swan.apps.an.a.amP().amQ());
                eS.bk(com.baidu.swan.apps.an.a.amP().amR());
            }
            com.baidu.swan.apps.statistic.f.b(eS);
        }

        private boolean agI() {
            String string = h.anz().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d(b.TAG, "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.ac.a.c cVar) {
            if (cVar.ahb() >= 0) {
                com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
                if (Ou == null || Ou.Wh() <= 0) {
                    if (b.DEBUG) {
                        Log.d(b.TAG, "start loading check: remainTime=" + cVar.ahb());
                    }
                    b.this.cem.sendMessageDelayed(Message.obtain(b.this.cem, 10, cVar), cVar.ahb());
                }
            }
        }

        private void agJ() {
            SwanAppActivity aev = com.baidu.swan.apps.y.f.aeK().aev();
            if (aev != null && !aev.isFinishing() && !aev.isDestroyed() && aev.Oq() != null && aev.Oq().czk != null) {
                boolean z = aev.Oq().czk.getVisibility() == 0;
                if (b.DEBUG) {
                    Log.d(b.TAG, "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(19L).nL("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.akN() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.akN().Ow();
                    }
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().e(nL).a(aVar).mZ(com.baidu.swan.apps.statistic.f.gz(com.baidu.swan.apps.runtime.d.akK().Om())).na(com.baidu.swan.apps.runtime.d.akK().getAppId()).nc(String.valueOf(this.ceo.size())).eS(false));
                }
            }
        }
    }
}
